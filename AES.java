import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
class AES {
    private static SecretKeySpec secretKey;
    private static byte[] keyb;
 
    public static void genkey(String key){
        MessageDigest sha;
        try{
            keyb=key.getBytes();//convert bytes
            sha=MessageDigest.getInstance("SHA-1");//keygen digest
            keyb=sha.digest(keyb);//digest
            keyb=Arrays.copyOf(keyb,16);//copy
            secretKey=new SecretKeySpec(keyb,"AES");//ready

            
        }
        catch(Exception e){
            System.out.print(e.toString());
        }
    }
    public static String encrypt(String plain,String keyed){
        String res=null;
        try{
        genkey(keyed);
        Cipher aes=Cipher.getInstance("AES/ECB/PKCS5Padding"); //cipher
        aes.init(Cipher.ENCRYPT_MODE,secretKey);//init
    
        
        byte[] enc=aes.doFinal(plain.getBytes());
        res=Base64.getEncoder().encodeToString(enc);
        System.out.println("Encrypted is "+res);
        return res;
        
        }
        catch(Exception e){
            System.out.println(e.toString());
        }

return res;


    }
    public static void decrypt(String cipher,String keyed){
        try{
            genkey(keyed);
            Cipher aes=Cipher.getInstance("AES/ECB/PKCS5PADDING"); //cipher
            aes.init(Cipher.DECRYPT_MODE,secretKey);//init
        
            
            byte[] enc=aes.doFinal(Base64.getDecoder().decode(cipher));
            System.out.println("decrypted is "+new String(enc
            ));
            }
            catch(Exception e){
                System.out.println(e.toString());
            }
    
    }
    public static void main(String[] args) {
       String enc=encrypt("howtodoinjava.com","ssshhhhhhhhhhh!!!!");
       System.out.print(enc+"\n");
       decrypt(enc,"ssshhhhhhhhhhh!!!!");
    }
}