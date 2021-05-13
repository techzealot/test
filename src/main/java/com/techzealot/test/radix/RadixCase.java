package com.techzealot.test.radix;

import java.math.BigInteger;

public class RadixCase {

    public static void main(String[] args) {

        //10=>2,8,16
        System.out.println(Integer.toBinaryString(-1));
        System.out.println(Integer.toBinaryString(1));

        System.out.println(Integer.toOctalString(-1));
        System.out.println(Integer.toOctalString(1));

        System.out.println(Integer.toHexString(-1));
        System.out.println(Integer.toHexString(1));

        //2,8,16=>10 采用BigInteger进行转化，如调用Integer.parseInt("11111111111111111111111111111111",2)会报错，只能解析正数

        System.out.println(new BigInteger("11111111111111111111111111111111",2).intValue());
        System.out.println(new BigInteger("1",2).intValue());

        System.out.println(new BigInteger("37777777777",8).intValue());
        System.out.println(new BigInteger("1",8).intValue());

        System.out.println(new BigInteger("ffffffff",16).intValue());
        System.out.println(new BigInteger("1",16).intValue());

    }
}
