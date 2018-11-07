package com.nine.netty.fifth;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * @author : Rubi
 * @version : 2018-11-07 14:29
 */
public class ServeInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new HttpServerCodec());
        //块 儿读
        pipeline.addLast(new ChunkedWriteHandler());
        //对 消息进行聚合 成full HttpRequest or Full HttpResponse
        //如果超过长度 调用 handleOverSize
        pipeline.addLast(new HttpObjectAggregator(8192));
        pipeline.addLast(new WebSocketServerProtocolHandler("/test"));
        pipeline.addLast(new TestWebSocketFrameHandler());

    }
}
