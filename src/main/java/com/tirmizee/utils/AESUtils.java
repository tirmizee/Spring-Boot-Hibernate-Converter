package com.tirmizee.utils;

import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AESUtils {

    public static final String ALG = "AES";
    public static final String ALG_MODE = "AES/CBC/PKCS5Padding";
    public static final String ALG_HASH = "SHA-256";
    private static final String SECRET_KEY = "xxxxxxxxxxxxx";

    private static byte[] secretKeyBytes;
    private static MessageDigest messageDigest;
    private static SecretKeySpec secretKeySpec;

    static {
        try {
            messageDigest = MessageDigest.getInstance(ALG_HASH);
            secretKeyBytes = messageDigest.digest(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
            secretKeySpec = new SecretKeySpec(secretKeyBytes, ALG);

        } catch (NoSuchAlgorithmException e) {
        }
    }

    public static String encrypt(String strToEncrypt) {
        try {
            Cipher cipher = Cipher.getInstance(ALG);
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            byte[] bytes = strToEncrypt.getBytes(StandardCharsets.UTF_8);
            return Base64.encodeBase64String((cipher.doFinal(bytes)));
        } catch (Exception exception) {
            return strToEncrypt;
        }
    }

    public static String decrypt(String strToDecrypt) {
        try {
            Cipher cipher = Cipher.getInstance(ALG);
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            byte[] bytes = Base64.decodeBase64(strToDecrypt);
            return new String(cipher.doFinal(bytes), StandardCharsets.UTF_8);
        } catch (Exception exception) {
            return strToDecrypt;
        }
    }

}
