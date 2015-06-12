package org.miaohong.fishchat.libnet.protocol;

/**
 * Created by haroldmiao on 2015/6/12.
 */
public class Cmd {
    public static final String REQ_MSG_SERVER_CMD                    = "REQ_MSG_SERVER";
    //SELECT_MSG_SERVER_FOR_CLIENT msg_server_ip
    public static final String SELECT_MSG_SERVER_FOR_CLIENT_CMD      = "SELECT_MSG_SERVER_FOR_CLIENT";

    //SEND_PING
    public static final String SEND_PING_CMD                         = "SEND_PING";
    //SEND_CLIENT_ID CLIENT_ID
    public static final String SEND_CLIENT_ID_CMD                    = "SEND_CLIENT_ID";
    //SEND_CLIENT_ID_FOR_TOPIC ID
    public static final String SEND_CLIENT_ID_FOR_TOPIC_CMD          = "SEND_CLIENT_ID_FOR_TOPIC";
    //SUBSCRIBE_CHANNEL channelName
    public static final String SUBSCRIBE_CHANNEL_CMD                 = "SUBSCRIBE_CHANNEL";
    //SEND_MESSAGE_P2P send2ID send2msg
    public static final String SEND_MESSAGE_P2P_CMD                  = "SEND_MESSAGE_P2P";
    //RESP_MESSAGE_P2P  msg fromID uuid
    public static final String RESP_MESSAGE_P2P_CMD                  = "RESP_MESSAGE_P2P";
    public static final String ROUTE_MESSAGE_P2P_CMD                 = "ROUTE_MESSAGE_P2P";
    public static final String CREATE_TOPIC_CMD                      = "CREATE_TOPIC";
    //JOIN_TOPIC TOPIC_NAME CLIENT_ID
    public static final String JOIN_TOPIC_CMD                        = "JOIN_TOPIC";
    public static final String LOCATE_TOPIC_MSG_ADDR_CMD             = "LOCATE_TOPIC_MSG_ADDR";
    public static final String SEND_MESSAGE_TOPIC_CMD                = "SEND_MESSAGE_TOPIC";
    public static final String RESP_MESSAGE_TOPIC_CMD                = "RESP_MESSAGE_TOPIC";

    //P2P_ACK clientID uuid
    public static final String P2P_ACK_CMD       = "P2P_ACK";

    public static final String CACHE_SESSION_CMD       = "CACHE_SESSION";
    public static final String CACHE_TOPIC_CMD         = "CACHE_TOPIC";

    public static final String STORE_SESSION_CMD       = "STORE_SESSION";
    public static final String STORE_TOPIC_CMD         = "STORE_TOPIC";

    public static final String PING  = "PING";
}
