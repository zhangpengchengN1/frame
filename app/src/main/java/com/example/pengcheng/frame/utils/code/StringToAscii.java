package com.example.pengcheng.frame.utils.code;

import java.nio.ByteOrder;

/**
 * Created by PengchengZhang on 2017/10/27.
 * 一般 是用encode(string); 将字符串转化成二进制字符串
 * 然后 把二进制字符串 转化为byte 数组
 */

public class StringToAscii {


    public static byte[] intToBytes(int value, ByteOrder mode) {
        byte[] src = new byte[4];
        if (mode == ByteOrder.LITTLE_ENDIAN) {
            src[3] = (byte) ((value >> 24) & 0xFF);
            src[2] = (byte) ((value >> 16) & 0xFF);
            src[1] = (byte) ((value >> 8) & 0xFF);
            src[0] = (byte) (value & 0xFF);
        } else {
            src[0] = (byte) ((value >> 24) & 0xFF);
            src[1] = (byte) ((value >> 16) & 0xFF);
            src[2] = (byte) ((value >> 8) & 0xFF);
            src[3] = (byte) (value & 0xFF);
        }
        return src;
    }

    //合并数组
    public static byte[][] createSubArrays(int arrays,int aryLength) {
        byte bt = 0;
        byte[][] subarrays = new byte[arrays][];
        for (int i=0;i<arrays;i++) {
            subarrays[i] = new byte[aryLength];
            for(int j=0;j<aryLength;j++) {
                subarrays[i][j] = bt;
                bt++;
            }
        }
        return subarrays;
    }

    private static String hexString = "0123456789ABCDEF";
    /*
    * 将字符串编码成16进制数字,适用于所有字符（包括中文）
    */
    public static String encode(String str) {
        // 根据默认编码获取字节数组
        byte[] bytes = str.getBytes();
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        // 将字节数组中每个字节拆解成2位16进制整数
        for (int i = 0; i < bytes.length; i++) {
            sb.append(hexString.charAt((bytes[i] & 0xf0) >> 4));
            sb.append(hexString.charAt((bytes[i] & 0x0f) >> 0));
        }
        return sb.toString();
    }


    private static byte uniteBytes(byte src0, byte src1) {
        byte _b0 = Byte.decode("0x" + new String(new byte[] { src0 }))
                .byteValue();
        _b0 = (byte) (_b0 << 4);
        byte _b1 = Byte.decode("0x" + new String(new byte[] { src1 }))
                .byteValue();
        byte ret = (byte) (_b0 | _b1);
        return ret;
    }

    /**
     *
     * @param src  要转化为byte数组的 string
     * @param length  为要转化的string 的长度的一半
     * @return
     */
    public static byte[] HexString2Bytes(String src, int length) {
        byte[] ret = new byte[length];
        byte[] tmp = src.getBytes();
        for (int i = 0; i < length; ++i) {
            ret[i] = uniteBytes(tmp[i * 2], tmp[i * 2 + 1]);
        }
        return ret;
    }

}
