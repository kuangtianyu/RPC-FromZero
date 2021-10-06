package com.kty.codec;

import com.kty.serializer.KryoUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * 自定义编码器
 * @author kty
 * @date 2021/9/17 12:56
 */
public class RpcEncoder extends MessageToByteEncoder {

    // 待编码的对象类型
    private Class<?> genericClass;

    public RpcEncoder(Class<?> genericClass) {
        this.genericClass = genericClass;
    }

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Object in, ByteBuf out) throws Exception {
        if (genericClass.isInstance(in)) {
            // 将对象序列化为字节数组
            byte[] data = KryoUtil.serialize(in);
            // 将消息体长度写入消息头
            out.writeInt(data.length);
            out.writeBytes(data);
        }
    }
}
