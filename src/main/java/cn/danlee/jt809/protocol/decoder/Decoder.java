package cn.danlee.jt809.protocol.decoder;

import cn.danlee.jt809.packet.JT809BasePacket;

/**
 * @Author: Dan Lee
 * @Date: 2019/9/21 21:12
 * @Version 1.0
 * @Describe:
 */
public interface Decoder {
    /**
     *
     * @param bytes
     * @return
     */
    JT809BasePacket decoder(byte[] bytes) throws Exception;
}
