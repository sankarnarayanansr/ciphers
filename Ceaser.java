import java.util.*;
import java.lang.Character;
class Ceaser{
    static HashMap<Integer,String> numtoalpha=new HashMap<Integer,String>();
    static HashMap<String,Integer> alphatonum=new HashMap<String,Integer>();
    static Scanner sc=new Scanner(System.in);
    static int attack(String cipher){
        
        String[] reslist=new String[26];
        int c=0;
        int k=0;
        while (true){
            
            String res=decode(cipher,k);
            System.out.println(res);
            System.out.println("is this a meaningful word or sentence?[y/n/q]");
            String op=sc.next();
            if (op.equals("q")){
                break;
            }
            if (op.equals("y")){
                reslist[c]=res;
                c+=1;
            }
            k+=1;
            if (k==26){
                break;
            }
           
        }
        System.out.println();
        System.out.println("List of Results");
         for (int i=0;i<c;i++){
                System.out.println(reslist[i]);

            }
        System.out.println();
       
        return 0;
    }
    
    static String encode(String plain,int depth){
        String encoded="";
        for (int i=0;i<plain.length();i++){
            char c=plain.charAt(i);
            if (Character.isUpperCase(c)){
                c=(char)((int)c+32);
                encoded+=numtoalpha.get((alphatonum.get(Character.toString(c))+depth)%26).toUpperCase();

            }
            else{
            encoded+=numtoalpha.get((alphatonum.get(Character.toString(c))+depth)%26);
            }
        }
      
        return encoded;

    }
    static String decode(String pass,int depth){
        String decoded="";
        for (int i=0;i<pass.length();i++){
            char c=pass.charAt(i);
            char x=c;
            int temp=0;
            if (Character.isUpperCase(c)){
                c=(char)((int)c+32);
                temp=(alphatonum.get(Character.toString(c))-depth);
            }
            else{
                temp=(alphatonum.get(Character.toString(c))-depth);
            }
            if (temp<=0){
                temp+=26;
            }
            if (Character.isUpperCase(x)){
            decoded+=numtoalpha.get(temp).toUpperCase();}
            else{
                decoded+=numtoalpha.get(temp);

            }
        }
     
        return decoded;
    }
    public static void main(String args[])  {
        
       

        int x=97;
        for (int i=1;i<27;i++){
            char c=(char)x;
            numtoalpha.put(i,String.valueOf(c));
            alphatonum.put(String.valueOf(c),i);
            x+=1;
        }
             
        
        while (true ){
            int n=1;
        System.out.println("Menu\n1.Encode with depth\n2.Decode with depth\n3.Attack Using BruteForce\n4.exit");
        if (sc.hasNextInt()){ 
        n=sc.nextInt();
        if (n==4){
            break;
        }
        else if (n==1){
            System.out.println("Enter plaintext and depth\n");
            String plain=sc.next();
            int depth=sc.nextInt();
            String encoded=encode(plain,depth);  
            System.out.println("encoded string "+encoded);
        }
        else if (n==2){
            System.out.println("Enter ciphertext and depth\n");
            String pass=sc.next();
            int depth=sc.nextInt();
            String decoded=decode(pass,depth);  
            System.out.println("decoded string "+decoded);
        }
        else if (n==3){
            System.out.println("Enter ciphertext\n");
            String pass=sc.next();
            int cd=attack(pass);
        }
        else{
            break;
            
        }
    }
    else{
        continue;
    }
        }
        sc.close();
    }
}
