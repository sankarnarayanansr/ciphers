import java.math.BigInteger;
import java.util.*;
class Deffie {
    public static void main(String[] args) {
         BigInteger ya,yb,xa,xb,q,a,ka,kb,k,in;
         Scanner sc=new Scanner(System.in);
         System.out.println("Enter a prime number and its primitive root");
         q=sc.nextBigInteger();
         a=sc.nextBigInteger();
         System.out.println("Enter the secret key chosen by sender and reciever:");
         xa=sc.nextBigInteger();
         xb=sc.nextBigInteger();
         ya=a.modPow(xa,q);
         yb=a.modPow(xb,q);
         ka=yb.modPow(xa,q);
         kb=ya.modPow(xb,q);
        in=xa.multiply(xb);
        k=a.modPow(in,q);
         System.out.println("Public Key Of Sender:"+ya.toString());
         System.out.println("Public Key Of Receiver:"+yb.toString());
         System.out.println("Secret Key Of Sender:"+ka.toString());
         System.out.println("Secret Key Of Receiver:"+kb.toString());
         System.out.println("Shared Secret Key is: "+k);

    }
}
// Input : 7
// Output : Smallest primitive root = 3
// Explanation: n = 7
// 3^0(mod 7) = 1
// 3^1(mod 7) = 3
// 3^2(mod 7) = 2
// 3^3(mod 7) = 6
// 3^4(mod 7) = 4
// 3^5(mod 7) = 5