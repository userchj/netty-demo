package cn.itcast.test;

import cn.itcast.message.LoginRequestMessage;
import cn.itcast.protocol.MessageCodec;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandler;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.logging.LoggingHandler;

public class TestMessageCodec {
    public static void main(String[] args) throws Exception {
        EmbeddedChannel embeddedChannel=new EmbeddedChannel(
                new LoggingHandler(),
                new MessageCodec(),
                new LengthFieldBasedFrameDecoder(
                        1024,12,4,0,0)
        );
        LoginRequestMessage loginRequestMessage=new LoginRequestMessage("zhangsan","123","张三");
        ByteBuf buf= ByteBufAllocator.DEFAULT.buffer();
        new MessageCodec().encode(null,loginRequestMessage,buf);
    }
}
