package com.example.springbootdubboserver.utils;


import com.example.springbootdubboserver.system.SysProperties;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;



import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;

/**
 * 加密类，不会生成特殊字符，
 * key和iv进行加密 Encrypt
 * 同时支持解密  Decrypt
 * @author qsnp236
 *
 */
public class AesCBCUtil {
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(AesCBCUtil.class);
	//算法
    private final static String KEY_ALGORITHM = "AES";
    //算法
    private final static String ALGORITHMSTR = "AES/CBC/PKCS7Padding";
    //偏移量
    private final static String IV="NXI5ETSD3ZGYH6DS";

    static {
        java.security.Security.addProvider(new BouncyCastleProvider());
    }
    /**
     * Cipher类为加密和解密提供密码功能
     * @return
     */
    private static Cipher getCipher() {
        Cipher cipher = null;
        try {

            cipher = Cipher.getInstance(ALGORITHMSTR, "BC");
           
        } catch (Exception e) {
            log.error("getCipher异常..." + e);
        }
        return cipher;
    }

    private static java.security.Key getSecretKey(String secret) throws UnsupportedEncodingException {

        byte[] keyBytes = Hex.encode(secret.getBytes("utf-8"));

        if (keyBytes.length > 32) {
            log.info("超过最大长度256bit,请将密匙长度控制在16个字符！");
        }
        /**
         * 补齐16位的整数倍
         */
        if (keyBytes.length % 16 != 0) {
            int groups = keyBytes.length / 16 + (keyBytes.length % 16 != 0 ? 1 : 0);
            byte[] temp = new byte[groups * 16];
            Arrays.fill(temp, (byte) 0);
            System.arraycopy(keyBytes, 0, temp, 0, keyBytes.length);
            keyBytes = temp;
        }
        return new SecretKeySpec(keyBytes, KEY_ALGORITHM);

    }
    
    /**
     * 默认加密方法，采用系统AES_KEY和默认的IV
     * @param s
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String Encrypt(String s) throws UnsupportedEncodingException {
        String keyStr= SysProperties.AES_KEY;
    	return Encrypt(s,keyStr,IV);
    }
    
    /**
     * 默认解密方法，采用系统AES_KEY和默认的IV
     * @param s
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String Decrypt(String s) throws UnsupportedEncodingException {
    	 String keyStr=SysProperties.AES_KEY; 
     	 return Decrypt(s,keyStr,IV);
    }
    
    /**
     * 加密
     *
     * @param s
     * @param keyStr
     * @param iv
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String Encrypt(String s, String keyStr, String iv) throws UnsupportedEncodingException {
        byte[] encryptedText = null;
        Key key = getSecretKey(keyStr);

        Cipher cipher = getCipher();
        try {
            if(cipher!=null) {
            	 cipher.init(Cipher.ENCRYPT_MODE, key, getIV(iv));
            	 encryptedText = cipher.doFinal(s.getBytes("utf-8"));
            }
          
        } catch (Exception e) {
            log.error("加密异常..." + e);
        }
        return new String(Hex.encode(encryptedText), "utf-8");

    }

    /**
     * 解密
     *
     * @param s
     * @param keyStr
     * @param iv
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String Decrypt(String s, String keyStr, String iv) throws UnsupportedEncodingException {
        byte[] encryptedText = null;
        Key key = getSecretKey(keyStr);
        Cipher cipher = getCipher();
        try {
        	if(cipher!=null) {
	            cipher.init(Cipher.DECRYPT_MODE, key, getIV(iv));
	            encryptedText = cipher.doFinal(Hex.decode(s.getBytes("utf-8")));
        	}
        } catch (Exception e) {
            log.error("解密异常..." + e);
        }
        return new String(encryptedText, "utf-8");
    }

    /**
     * 向量设置
     *
     * @return
     */
    public static AlgorithmParameterSpec getIV(String ivStr) throws UnsupportedEncodingException {
        byte[] iv = ivStr.getBytes("utf-8");
        if (iv.length != 16) {
            log.info("IV向量值必须为16位长度字符！");
        }
       
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
        return ivParameterSpec;
    }

//    public static void main(String[] args) {
//    	String keyStr="abcdef0123456789"; 
//        String iv = IV;
//        try {
//        
//        		 String result = Encrypt("testAppId", keyStr, iv);
//        	
//        
//        } catch (UnsupportedEncodingException e) {
//            log.error("程序异常："+e.getMessage());
//        }
//    }

}
