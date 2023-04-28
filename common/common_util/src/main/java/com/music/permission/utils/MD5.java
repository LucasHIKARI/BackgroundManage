package com.music.permission.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public final class MD5 {

    private static char[] hex = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

//    public static void main(String[] args) throws Exception {
//        String input = "123456";
//        System.out.println("MD5加密" + "\n"
//                + "明文：" + input + "\n"+"鹽:"+salt()+"\n"
//                + "无盐密文：" + MD5WithoutSalt(input));
//        System.out.println("带盐密文：" + MD5WithSalt(input,0));
//    }

    public static String encrypt(String strSrc) {
        try {
            char hexChars[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
                    '9', 'a', 'b', 'c', 'd', 'e', 'f' };
            byte[] bytes = strSrc.getBytes();
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(bytes);
            bytes = md.digest();
            int j = bytes.length;
            char[] chars = new char[j * 2];
            int k = 0;
            for (int i = 0; i < bytes.length; i++) {
                byte b = bytes[i];
                chars[k++] = hexChars[b >>> 4 & 0xf];
                chars[k++] = hexChars[b & 0xf];
            }
            return new String(chars);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new RuntimeException("MD5加密出错！！+" + e);
        }
    }

    /**
     *@params: [inputStr] 输入明文
     *@Descrption: 不加盐MD5
     */
    public static String MD5WithoutSalt(String inputStr) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");//申明使用MD5算法,更改参数为"SHA"就是SHA算法了
            return byte2HexStr(md.digest(inputStr.getBytes()));//哈希计算,转换输出
        } catch (Exception e) {
            e.printStackTrace();
            return e.toString();
        }

    }


    /**
     *@params: [inputStr, type] inputStr是输入的明文;type是处理类型，0表示注册存hash值到库时，1表示登录验证时
     *@Descrption:  MD5加盐，盐的获取分两种情况;输入明文加盐；输出密文带盐(将salt拆開插入到hash值中)
     *         //从库中查找到的hash值 需要自己寫查詢方法
     */
    public static String MD5WithSalt(String password, int type) {

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");//申明使用MD5算法,更改参数为"SHA"就是SHA算法了

            String salt = null;
            if (type == 0) {//注册或更新密碼，存hash值到库时，new salt
                salt = salt();
            } else if (type == 1) {//登录验证时，使用从库中查找到的hash值提取出的salt,登陸也可以用下面單獨的方法
                String queriedHash=password;//从库中查找到的已加密的密碼hash值
                salt=getSaltFromHash(queriedHash);
            }

            String inputWithSalt = password + salt;//加盐，输入加盐
            String hashResult = byte2HexStr(md.digest(inputWithSalt.getBytes()));//哈希计算,转换输出
            System.out.println("加盐密文："+hashResult);

            /*将salt存储到hash值中，用于登陆验证密码时使用相同的盐*/
            char[] cs = new char[48];
            for (int i = 0; i < 48; i += 3) {
                cs[i] = hashResult.charAt(i / 3 * 2);
                cs[i + 1] = salt.charAt(i / 3);//输出带盐，存储盐到hash值中;每两个hash字符中间插入一个盐字符
                cs[i + 2] = hashResult.charAt(i / 3 * 2 + 1);
            }
            hashResult = new String(cs);
            return hashResult;
        } catch (Exception e) {
            e.printStackTrace();
            return e.toString();
        }
    }


    /**
     *@params: [inputStr, type] inputStr是输入的明文密碼;prePassword是數據庫中原有的密碼
     *@Descrption:  MD5加盐，盐的获取分两种情况;输入明文加盐；输出密文带盐(将salt拆開插入到hash值中)
     *         通過數據庫中原有的密碼獲取原先salt值對新輸入的密碼進行校驗
     */
    public static String MD5WithSaltForLogin(String inputPassword, String prePassword) {

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");//申明使用MD5算法,更改参数为"SHA"就是SHA算法了

            String salt = null;
                String queriedHash=prePassword;
                salt=getSaltFromHash(queriedHash);


            String inputWithSalt = inputPassword + salt;//加盐，输入加盐
            String hashResult = byte2HexStr(md.digest(inputWithSalt.getBytes()));//哈希计算,转换输出
            System.out.println("加盐密文："+hashResult);

            /*将salt存储到hash值中，用于登陆验证密码时使用相同的盐*/
            char[] cs = new char[48];
            for (int i = 0; i < 48; i += 3) {
                cs[i] = hashResult.charAt(i / 3 * 2);
                cs[i + 1] = salt.charAt(i / 3);//输出带盐，存储盐到hash值中;每两个hash字符中间插入一个盐字符
                cs[i + 2] = hashResult.charAt(i / 3 * 2 + 1);
            }
            hashResult = new String(cs);
            return hashResult;
        } catch (Exception e) {
            e.printStackTrace();
            return e.toString();
        }
    }


    /**
     * @return: salt
     * @params:
     * @Descrption: 自定义简单生成盐，是一个随机生成的长度为16的字符串，每一个字符是随机的十六进制字符
     */
    public static String salt() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(16);
        for (int i = 0; i < sb.capacity(); i++) {
            sb.append(hex[random.nextInt(16)]);
        }
        return sb.toString();
    }

    /**
     * @return: 十六进制字符串
     * @params: [bytes]
     * @Descrption: 将字节数组转换成十六进制字符串
     */
    private static String byte2HexStr(byte[] bytes) {
        /**
         *@Author: DavidHuang
         *@Time: 19:41 2018/5/10
         *@return: java.lang.String
         *@params:  * @param bytes
         *@Descrption:
         */
        int len = bytes.length;
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < len; i++) {
            byte byte0 = bytes[i];
            result.append(hex[byte0 >>> 4 & 0xf]);
            result.append(hex[byte0 & 0xf]);
        }
        return result.toString();
    }


    /**
     *@return: 提取的salt
     *@params: [hash] 3i byte带盐的hash值,带盐方法与MD5WithSalt中相同
     *@Descrption:  从库中查找到的hash值提取出的salt
     */
    public static String getSaltFromHash(String hash){
        StringBuilder sb=new StringBuilder();
        char [] h=hash.toCharArray();
        for(int i=0;i<hash.length();i+=3){
            sb.append(h[i+1]);
        }
        return sb.toString();
    }







}
