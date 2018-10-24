package com.nine.netty.second;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import java.util.UUID;

/**
 * @author : Rubi
 * @version : 2018-10-24 9:16
 */
public class TestServerHandler  extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
//            ByteBuf content= Unpooled.copiedBuffer("Hello world",CharsetUtil.UTF_8);
//            FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,HttpResponseStatus.OK,content);
//            response.headers().set(HttpHeaderNames.CONTENT_TYPE,"text/plain");
//            response.headers().set(HttpHeaderNames.CONTENT_LENGTH,content.readableBytes());
//            ctx.writeAndFlush(response);
              System.out.println(ctx.channel().remoteAddress()+","+msg);
              ctx.channel().writeAndFlush("from server:"+ UUID.randomUUID());

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
