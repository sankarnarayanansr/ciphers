import java.util.*;
public class RowColumn {
    static void decode(String plain,String key ){
        String col[]=new String[key.length()];
        int x=(plain.length()/key.length());
        int start=0;
        for (int i=0;i<key.length();i++){
            col[i]=plain.substring(start, start+x);
            start=start+x;
        }
        // for(String y:col){
        //     System.out.println(y);
        // }
        char chararr[]=key.toCharArray();
        Arrays.sort(chararr);
        HashMap <Character,String> hs=new HashMap<Character,String>();
        for (int i=0;i<key.length();i++){
            hs.put(chararr[i],col[i]);
        }
        for (int i=0;i<plain.length()/key.length();i++){
            for(int j=0;j<key.length();j++){
                String str=hs.get(key.charAt(j));
                System.out.print(str.charAt(i));
            }
        }
        System.out.println();

    }
    static void encode(String plain,String key){
        String col[]=new String[key.length()];
        for (int i=0;i<col.length;i++){
            col[i]="";
            col[i]+=key.charAt(i);
        }
        char chararr[]=key.toCharArray();
        Arrays.sort(chararr);
        HashMap<Character,Integer> hs=new HashMap<Character,Integer>();
        int num=0;
        for(char c:chararr){
            hs.put(c,num);
        }
        int c=0;
        for (int i=0;i<plain.length();i++){
            col[c]+=plain.charAt(i);
            c+=1;
            if (c==key.length()){
                c=0;
            }
        }
        Arrays.sort(col,(str1,str2)->str1.charAt(0)-str2.charAt(0));
        for (String i:col){
            System.out.print(i.substring(1,i.length()));
        }
        System.out.println();

     
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Scanner sc1=new Scanner(System.in);
        while(true){
            System.out.println("1.encode\n2.decode\n3.exit");
            int n=sc.nextInt();
            if (n==3){
                break;
            }
            String plain=sc1.nextLine();
            String key=sc1.nextLine();
            while(plain.length()%key.length()>0){
                plain+=" ";
            }
         
            
            if (n==3){
                break;
            }
            else if(n==1){
               
                encode(plain,key);
            }
            else{
                
                decode(plain,key);
                
            }
    
        }
        sc.close();
    }
    
}
