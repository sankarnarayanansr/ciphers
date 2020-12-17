import java.lang.*;
import java.math.*;
import java.util.*;
public class DigitalSignature{
        	public static void main(String args[]){
                    	BigInteger p,q,h,x,sha,k,u1,u2,r,s,v,g,kinv,y,w;
                    	Scanner sc=new Scanner(System.in);
                    	System.out.println("Enter the prime number...");
                    	p=sc.nextBigInteger();
                    	System.out.println("Enter the prime divisor....");
                    	q=sc.nextBigInteger();
                    	System.out.println("Enter a random number less than the prime number...");
                    	h=sc.nextBigInteger();
                    	System.out.println("Enter the private key...");
                    	x=sc.nextBigInteger();
                    	System.out.println("Enter the hash of message to be signed...");
                    	sha=sc.nextBigInteger();
                    	System.out.println("Enter the per message secret number...");
                    	k=sc.nextBigInteger();
                    	System.out.println("----------SIGNATURE GENERATION----------");
                    	g=h.modPow(((p.subtract(BigInteger.ONE)).divide(q)),p);
                    	System.out.println("g = "+g);
                    	y=g.modPow(x,p);
                    	System.out.println("y = "+y);
                    	r=(g.modPow(k,p)).mod(q);
                    	kinv=k.modInverse(q);
        	        	s=(((sha.add(x.multiply(r))).mod(q)).multiply(k.modInverse(q))).mod(q);
                    	System.out.println("Signature (r,s) = ("+r+","+s+")");
                    	System.out.println("----------SIGNATURE VERIFICATION----------");
                    	w=s.modInverse(q);
                    	u1=(sha.multiply(w)).mod(q);
                    	u2=(r.multiply(w)).mod(q);
                    	int iu1 = u1.intValue();
                    	int iu2 = u2.intValue();
                    	v = (((g.pow(iu1)).multiply(y.pow(iu2))).mod(p)).mod(q);
                    	System.out.println("w = "+w);
                    	System.out.println("u1 = "+u1);
                    	System.out.println("u2 = "+u2);
                    	System.out.println("v = "+v);
                    	if(r.equals(v))
                                	System.out.println("SIGNATURE VERIFIED");
                    	else
                                	System.out.println("SIGNATURE MISMATCH");
        	}
}
