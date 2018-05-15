package com.ctrip.xpipe.redis.proxy;

import com.ctrip.xpipe.api.lifecycle.Releasable;
import com.ctrip.xpipe.api.observer.Observable;
import com.ctrip.xpipe.redis.core.proxy.endpoint.ProxyEndpoint;
import com.ctrip.xpipe.redis.proxy.model.SessionMeta;
import com.ctrip.xpipe.redis.proxy.session.SESSION_TYPE;
import com.ctrip.xpipe.redis.proxy.session.SessionState;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;

/**
 * @author chen.zhu
 * <p>
 * May 09, 2018
 */
public interface Session extends Releasable, Observable {

    Tunnel tunnel();

    void forward(ByteBuf message);

    void cache(ByteBuf message);

    ChannelFuture connect();

    void disconnect();

    ChannelFuture tryWrite(ByteBuf byteBuf);

    void setEndpoint(ProxyEndpoint endpoint);

    void setChannel(Channel channel);

    Channel getChannel();

    SESSION_TYPE getSessionType();

    SessionMeta getSessionMeta();

    void setSessionState(SessionState sessionState);

}