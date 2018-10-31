package com.nine.netty.third;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author : Rubi
 * @version : 2018-10-31 12:10
 */
public class MyChatClient {
    private static final String HOST1= "120.78.67.68";
    private static final String HOST2= "localhost";
    public static void main(String[] args) {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class)
                    .handler(new MyChatClientInitializer());
            Channel channel = bootstrap.connect(HOST2,9999).sync().channel();
           // channelFuture.channel().closeFuture().sync();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            for (;;){
               channel.writeAndFlush(br.readLine()+"\r\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            eventLoopGroup.shutdownGracefully();


        }
    }
}
