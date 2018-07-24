package com.dj.Util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by dong_jie on 2018-07-23.
 */
public class MD5 {

    private static String makeMD5(String plainText){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for(int offset = 0; offset < b.length ; offset++){
                i=b[offset];
                if(i < 0)
                    i+=256;
                if(i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            return buf.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean checkPwd(String operPhone, String operPwd, String AfferentPassword){
        String ciphertext = makeMD5(operPhone+operPwd);
        if(ciphertext.equalsIgnoreCase(AfferentPassword)){
            return true;
        }else{
            return false;
        }
    }

}
