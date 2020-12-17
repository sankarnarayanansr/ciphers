import java.util.*;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

class DES {
    public static void main(String[] args) {
        try{
            Scanner sc=new Scanner(System.in);
            KeyGenerator keygen=KeyGenerator.getInstance("DES"); //keygeninstance
            SecretKey seckey=keygen.generateKey();//genkey
            
            Cipher des=Cipher.getInstance("DES/ECB/PKCS5Padding"); //cipher
            des.init(Cipher.ENCRYPT_MODE,seckey);//init
            String txt=sc.next();
            byte[] text=txt.getBytes();
            byte[] enc=des.doFinal(text);//process
            System.out.println("Encrypted is "+enc);
            des.init(Cipher.DECRYPT_MODE,seckey);//init
            byte[] decrypt=des.doFinal(enc);//process
            System.out.println("Decrypted is "+new String(decrypt));



        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }
}