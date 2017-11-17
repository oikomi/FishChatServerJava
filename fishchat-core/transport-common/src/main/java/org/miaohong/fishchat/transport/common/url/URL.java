package org.miaohong.fishchat.transport.common.url;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;
import org.miaohong.fishchat.transport.common.exception.TransportException;

import java.util.HashMap;
import java.util.Map;

/**
 * @author miaohong
 * @date 2017/11/16
 */
@ToString
public class URL {

	@Getter
	@Setter
	private String protocol;

	@Getter
	@Setter
	private String host;

	@Getter
	@Setter
	private int port;

	@Getter
	@Setter
	private String path;

	private Map<String, String> parameters;

	public URL(String protocol, String host, int port, String path) {
		this(protocol, host, port, path, new HashMap<>());
	}

	public URL(String protocol, String host, int port, String path, Map<String, String> parameters) {
		this.protocol = protocol;
		this.host = host;
		this.port = port;
		this.path = path;
		this.parameters = parameters;
	}


	public static URL valueOf(String url) {
		if (StringUtils.isBlank(url)) {
			throw new TransportException();
		}
		String protocol = null;
		String host = null;
		int port = 0;
		String path = null;
		Map<String, String> parameters = new HashMap<>();
		// seperator between body and parameters
		int i = url.indexOf("?");
		if (i >= 0) {
			String[] parts = url.substring(i + 1).split("\\&");

			for (String part : parts) {
				part = part.trim();
				if (part.length() > 0) {
					int j = part.indexOf('=');
					if (j >= 0) {
						parameters.put(part.substring(0, j), part.substring(j + 1));
					} else {
						parameters.put(part, part);
					}
				}
			}
			url = url.substring(0, i);
		}
		i = url.indexOf("://");
		if (i >= 0) {
			if (i == 0) {
				throw new IllegalStateException("url missing protocol: \"" + url + "\"");
			}
			protocol = url.substring(0, i);
			url = url.substring(i + 3);
		} else {
			i = url.indexOf(":/");
			if (i >= 0) {
				if (i == 0) throw new IllegalStateException("url missing protocol: \"" + url + "\"");
				protocol = url.substring(0, i);
				url = url.substring(i + 1);
			}
		}

		i = url.indexOf("/");
		if (i >= 0) {
			path = url.substring(i + 1);
			url = url.substring(0, i);
		}

		i = url.indexOf(":");
		if (i >= 0 && i < url.length() - 1) {
			port = Integer.parseInt(url.substring(i + 1));
			url = url.substring(0, i);
		}
		if (url.length() > 0) {
			host = url;
		}
		return new URL(protocol, host, port, path, parameters);
	}

}

