package com.fh.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Code {

    public static String Md5(String plainText)
    {
        System.out.println("加密前:"+plainText);
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte[] b = md.digest();

            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++)
            {
                i = b[offset];
                if (i<0) i+=256;
                if(i<16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));

            }

            System.out.println("加密后："+buf.toString());
            return buf.toString();
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return plainText;
    }

}
