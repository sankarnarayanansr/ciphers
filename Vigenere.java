import java.util.Scanner;


import java.util.HashMap;
public class Vigenere {

    static void decode(String plain,String keyboard,HashMap<Character,Integer> hs, HashMap<Integer,Character>ds){
        String out="";
for (int i=0;i<plain.length();i++){
        int s=hs.get(keyboard.charAt(i));
        int d=hs.get(plain.charAt(i));
        // System.out.println(s+d);
        out+=ds.get((d-s+26)%26);
}
System.out.println(out);
    }


    static void encode(String plain,String keyboard,HashMap<Character,Integer> hs, HashMap<Integer,Character>ds){
        String out="";
for (int i=0;i<plain.length();i++){
        int s=hs.get(keyboard.charAt(i));
        int d=hs.get(plain.charAt(i));
        // System.out.println((s+d)%26);
        out+=ds.get((s+d)%26);
}
System.out.println(out);
    }
    
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        Scanner sc1=new Scanner(System.in);
        int num=0;
        HashMap<Character,Integer> hs=new HashMap<Character,Integer>();
        HashMap<Integer,Character> ds=new HashMap<Integer,Character>();
        for (int i=97;i<123;i++){
            hs.put((char)i,num);
            num+=1;
        }
        num=0;
        for (int i=97;i<123;i++){
            ds.put(num,(char)i);
            num+=1;
        }
       
        while(true){
            System.out.println("1.encode\n2.decode\n3.exit");
            int n=sc.nextInt();
            if (n==3){
                break;
            }
            String plain=sc1.nextLine();
            String keyboard=sc1.nextLine();
           
            while (keyboard.length()<plain.length()){
                keyboard=keyboard+keyboard;
    
            }
            
            if (n==3){
                break;
            }
            else if(n==1){
               
                encode(plain,keyboard,hs,ds);
            }
            else{
                
                decode(plain,keyboard,hs,ds);
            }
    
        }
    
        
       
       
      
        sc.close();
        sc1.close();
    
    }
    
}
