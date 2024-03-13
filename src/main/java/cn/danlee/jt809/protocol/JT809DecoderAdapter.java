package cn.danlee.jt809.protocol;

import cn.danlee.jt809.common.util.CommonUtils;
import cn.danlee.jt809.common.util.CrcUtil;
import cn.danlee.jt809.common.util.PacketDecoderUtils;
import cn.danlee.jt809.packet.JT809BasePacket;
import cn.danlee.jt809.protocol.decoder.DecoderFactory;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @Author: Dan Lee
 * @Date: 2019/9/21 20:34
 * @Version 1.0
 * @Describe: 解码器
 */
public class JT809DecoderAdapter extends ByteToMessageDecoder {
    private static Logger log = LoggerFactory.getLogger(JT809DecoderAdapter.class);
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        log.info("JT809DecoderAdapter ctx:{},ByteBuf :{}", ctx, in.readableBytes());
        //判断是否有可读的字节
        if (in.readableBytes() <= 0) {
            return;
        }
        // 1、进行转义
        byte[] bytes = PacketDecoderUtils.decoderEscape(in);
        log.info("bytes:{}", CommonUtils.bytes2bitStr(bytes));
        // 2、校验crc
        if (!CrcUtil.checkCRC(bytes)) {
            return;
        }
        // 3、判断是那种类型的数据，交给具体的解码器类完成。
        ByteBuf byteBuf = CommonUtils.getByteBuf(bytes);
        byteBuf.skipBytes(9);
        // 获取业务标志
        short msgId = byteBuf.readShort();
        String s = Integer.toHexString(msgId);
        log.info("msgId:{}-msgIds:{}", msgId, s);
        // 交给具体的解码器
        JT809BasePacket packet = null;
        try {
            packet = DecoderFactory.getDecoder(msgId).decoder(bytes);
            log.info("packet:{}", packet);
        } catch (Exception e) {
            if (e instanceof NullPointerException) {
                // log.info("没有可用的解析器，忽略这条信息！此信息不在业务范围内。");
                // 没有可用的解析器，忽略这条信息！此信息不在业务范围内。
            } else {
                log.error("报文解析出错！错误信息：{}；报文信息：{}；",e.getMessage(), CommonUtils.PACKET_CACHE.get(Thread.currentThread().getName()));
            }
            return;
        }
        out.add(packet);
    }
}
