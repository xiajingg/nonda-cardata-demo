package nonda.cardata.util.cypher;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;
import java.security.spec.ECGenParameterSpec;
import java.util.logging.Level;
import java.util.logging.Logger;

//加密组件
public class CypherHelper {

    //应用sha256算法让一个输入转变成256位的hash值 用于字符hash加密
    public static String applySha256(String input){
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            //Applies sha256 to our input,
            byte[] hash = digest.digest(input.getBytes("UTF-8"));

            StringBuffer hexString = new StringBuffer(); // This will contain hash as hexidecimal
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    //使用椭圆加密机制及私钥进行签名
    public static byte[] applyECDSASig(PrivateKey privateKey, String input) {
        Signature dsa;
        byte[] output = new byte[0];
        try {
            dsa = Signature.getInstance("ECDSA", "BC");
            dsa.initSign(privateKey);
            byte[] strByte = input.getBytes();
            dsa.update(strByte);
            byte[] realSig = dsa.sign();
            output = realSig;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return output;
    }

    //校验签名是否有效
    public static boolean verifyECDSASig(PublicKey publicKey, String data, byte[] signature) {
        try {
            Signature ecdsaVerify = Signature.getInstance("ECDSA", "BC");
            ecdsaVerify.initVerify(publicKey);
            ecdsaVerify.update(data.getBytes());
            return ecdsaVerify.verify(signature);
        }catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    //生成公私钥-密钥对（keypair.getprivate()获取私钥、keypair.getpublic()获取公钥）
    public static KeyPair generateKeyPair() {
        try {
            Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("ECDSA","BC");
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            ECGenParameterSpec ecSpec = new ECGenParameterSpec("prime192v1");
            // Initialize the key generator and generate a KeyPair
            keyGen.initialize(ecSpec, random); //256
            KeyPair keyPair = keyGen.generateKeyPair();
            // Set the public and private keys from the keyPair
            //privateKey = keyPair.getPrivate();
            //publicKey = keyPair.getPublic();
            return keyPair;

        }catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static final String DEFAULT_CIPHER_ALGORITHM = "DES/ECB/PKCS5Padding";//默认的加密算法
    private static final String KEY_ALGORITHM = "DES";
    //des对称加密信息
    public static String desEncrypt(String content,String key) {
        try {
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);//初始化加密模式
            byte[] byteContent = content.getBytes("utf-8");
            cipher.init(Cipher.ENCRYPT_MODE, getSecretKey(key));//初始化为加密模式的密码器
            byte[] result = cipher.doFinal(byteContent);//加密
            return Base64.encodeBase64String(result);//通过Base64转码返回
        } catch (Exception ex) {
            Logger.getLogger(CypherHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    //对称解密数据
    public static String desDecypt(String content,String key){
        try{
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);//实例化
            cipher.init(Cipher.DECRYPT_MODE,getSecretKey(key));//使用密钥初始化，设置为解密模式
            byte[] result = cipher.doFinal(Base64.decodeBase64(content));
            return new String(result,"utf-8");
        }catch (Exception ex) {
            Logger.getLogger(CypherHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }


    //生成加密密钥
    private static SecretKeySpec getSecretKey(final String key){
        KeyGenerator kg = null;
        try {
            kg = KeyGenerator.getInstance(KEY_ALGORITHM);
            //des 要求密钥长度为 56
            kg.init(56,new SecureRandom(key.getBytes()));
            //生成一个密钥
            SecretKey secretKey = kg.generateKey();
            return new SecretKeySpec(secretKey.getEncoded(),KEY_ALGORITHM);
        }catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CypherHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
