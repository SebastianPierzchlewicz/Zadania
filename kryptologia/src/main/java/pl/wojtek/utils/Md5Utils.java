package pl.wojtek.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Utils
{
        public static String md5(final String in) {
        String md5 = null;

        if(null == in) return null;
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(in.getBytes(), 0, in.length());
            md5 = new BigInteger(1, digest.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return md5;
    }
}
