package com.ctrip.xpipe.redis.proxy.session.state;

import com.ctrip.xpipe.redis.proxy.session.DefaultSession;
import com.ctrip.xpipe.redis.proxy.session.SessionState;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;

/**
 * @author chen.zhu
 * <p>
 * May 13, 2018
 */
public class SessionClosing extends AbstractSessionState {

    public SessionClosing(DefaultSession session) {
        super(session);
    }

    @Override
    protected SessionState doNextAfterSuccess() {
        return new SessionClosed(session);
    }

    @Override
    protected SessionState doNextAfterFail() {
        return this;
    }

    @Override
    public ChannelFuture tryWrite(ByteBuf byteBuf) {
        throw new UnsupportedOperationException("No write, Session closing");
    }

    @Override
    public ChannelFuture connect() {
        throw new UnsupportedOperationException("No connect, Session closing");
    }

    @Override
    public void disconnect() {
        session.doDisconnect();
    }

    @Override
    public String name() {
        return "Session-Closing";
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}