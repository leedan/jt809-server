package cn.danlee.jt809.packet;

/**
 * @Author: Dan Lee
 * @Date: 2019/9/22 15:38
 * @Version 1.0
 * @Describe: 心跳应答包 数据体为空
 */
public class JT809HeartbeatResponse extends JT809BasePacket {

    @Override
    public byte[] getMsgBodyByteArr() {
        return new byte[0];
    }
}
