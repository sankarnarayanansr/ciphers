import java.util.Scanner;
public class Rail {
    public static void encode(String str,int key){
        String rows[]=new String[key];
        for (int i=0;i<key;i++){
            rows[i]="";
        }
        int c=0;
        int state=+1;
        for (int i=0;i<str.length();i++){
            rows[c]+=str.charAt(i);
            
            
            if(c==key-1){
                state=-1;
                c=key-1;

            }
            else if(c==0){
                c=0;
                state=1;
            }
            c+=state;
        }
        for(int j=0;j<rows.length;j++){
            System.out.print(rows[j]);
          
        }
        System.out.println();
    }
    public static void decode(String str,int key){
        int rows[]=new int[key];
        String rowcont[]=new String[key];
        for (int i=0;i<key;i++){
            rows[i]=0;
        }
        for (int i=0;i<key;i++){
            rowcont[i]="";
        }
        int c=0;
        int state=+1;
        for (int i=0;i<str.length();i++){
            rows[c]+=1;
            
            
            if(c==key-1){
                state=-1;
                c=key-1;

            }
            else if(c==0){
                c=0;
                state=1;
            }
            c+=state;
        }
        int val=0;
        for (int i=0;i<rowcont.length;i++){
            rowcont[i]=str.substring(val, val+rows[i]);
            // System.out.println(rowcont[i]);
            val+=rows[i];
        }
         c=0;
        state=+1;
        for (int i=0;i<str.length();i++){
            System.out.print(rowcont[c].charAt(0));
            rowcont[c]=rowcont[c].substring(1,rowcont[c].length());
            // System.out.println(rowcont[c]);
            if(c==key-1){
                state=-1;
                c=key-1;

            }
            else if(c==0){
                c=0;
                state=1;
            }
            c+=state;
        }
        System.out.println();
        
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Scanner sc1=new Scanner(System.in);
        
       int n,key;
       String str;
        while(true){
            System.out.println("1.encode\n2.decode\n3.exit");
            n=sc.nextInt();
            if (n==3){
                break;
            }
            else if(n==1){
                str=sc1.nextLine();
                key=sc.nextInt();
                encode(str,key);
            }
            else{
                str=sc1.nextLine();
                key=sc.nextInt();
                decode(str,key);
            }

        }
        
                sc.close();
                sc1.close();
    }
}
