import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.*;
public class SHA1 {
    public static void main(String[] args) {
        try{
        Scanner sc=new Scanner(System.in);
        String msg=sc.next();
        MessageDigest sha=MessageDigest.getInstance("SHA-1");
        byte[] key=sha.digest(msg.getBytes());
    BigInteger num=new BigInteger(1,key);
    String hash=num.toString(16);
    while(hash.length()<32){
        hash+="0";
    }
        System.out.println(hash);
    }
    catch(Exception e){
        System.out.print(e.toString());
    }
}
}
