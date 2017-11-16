package org.miaohong.fishchat.transport.common.state;

/**
 *
 * @author miaohong
 * @date 2017/11/16
 */
public enum ChannelState {
    /** 未初始化状态 **/
    UNINIT(0),
    /** 初始化完成 **/
    INIT(1),
    /** 存活可用状态 **/
    ALIVE(2),
    /** 不存活可用状态 **/
    UNALIVE(3),
    /** 关闭状态 **/
    CLOSE(4);

    public final int value;

    private ChannelState(int value) {
        this.value = value;
    }

    public boolean isAliveState() {
        return this == ALIVE;
    }

    public boolean isUnAliveState() {
        return this == UNALIVE;
    }

    public boolean isCloseState() {
        return this == CLOSE;
    }

    public boolean isInitState() {
        return this == INIT;
    }

    public boolean isUnInitState() {
        return this == UNINIT;
    }
}
