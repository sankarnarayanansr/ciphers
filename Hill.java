import java.util.*;


public class Hill {
    static int findinv(int a,int m){
        a=a%m;
        for (int x=1;x<m;x++){
            if ((a*x) % m==1){
                return x;
            }

        }
        return 1;
    }
    static void decode(int plainmat[],int keymat[][],  HashMap<Character,Integer> hs, HashMap<Integer,Character> ds,int n){
        int inmat[][]=new int[n][n];
        int adj[][]=new int[n][n];
        int res[]=new int[n];
        if (n==2){
            int a=keymat[0][0];
            int b=keymat[0][1];
            int c=keymat[1][0];
            int d=keymat[1][1];
            int val=(a*d)-(b*c);
            while (val<26){
                val+=26;
            }
            inmat[0][0]=d;
            inmat[0][1]=-b;
            inmat[1][0]=-c;
            inmat[1][1]=a;
            for(int j=0;j<n;j++){
                for(int q=0;q<n;q++){
                    while(inmat[j][q]<0){
                        inmat[j][q]+=26;
                    }
                }
                }
            int inv=findinv(val,26);
            for (int i=0;i<n;i++){
                res[i]=0;
                for(int j=0;j<n;j++){
                    res[i]+=inmat[i][j]*plainmat[j]*inv;
                }
                res[i]=res[i]%26;
            }
            for(int i:res){
                System.out.print(ds.get(i));
            }
            System.out.println();
        }
        else{
            int a=keymat[0][0];
            int b=keymat[0][1];
            int c=keymat[0][2];
            int d=keymat[1][0];
            int e=keymat[1][1];
            int f=keymat[1][2];
            int g=keymat[2][0];
            int h=keymat[2][1];
            int i=keymat[2][2];
            int det=((a*((e*i)-(h*f)))+(-1*b*((d*i)-(g*f)))+(c*((d*h)-(g*e))));
            while (det<0){
                det+=26;
            }
            inmat[0][0]=((e*i)-(h*f));
            inmat[0][1]=-1*((d*i)-(g*f));
            inmat[0][2]=((d*h)-(g*e));
            inmat[1][0]=-1*((b*i)-(h*c));
            inmat[1][1]=((a*i)-(g*c));
            inmat[1][2]=-1*((a*h)-(g*b));
            inmat[2][0]=((f*b)-(e*c));
            inmat[2][1]=-1*((f*a)-(d*c));
            inmat[2][2]=((e*a)-(b*d));
            for(int j=0;j<n;j++){
            for(int q=0;q<n;q++){
                while(inmat[j][q]<0){
                    inmat[j][q]+=26;
                }
            }
            }
            int inv=findinv(det, 26);



            for(int j=0;j<n;j++){
                for (int k=0;k<n;k++){
                    adj[j][k]=(inmat[k][j]*inv)%26;
                }
            }
            
            for (int k=0;k<n;k++){
                res[k]=0;
                for(int j=0;j<n;j++){
                    res[k]+=(adj[k][j])*plainmat[j];
                }
                
                res[k]=res[k]%26;
               
                
            }
            for(int x:res){
                System.out.print(ds.get(x));
            }
            System.out.println();
   

        }

    }
    static void encode(int plainmat[],int keymat[][],  HashMap<Character,Integer> hs, HashMap<Integer,Character> ds,int n){
        int res[]=new int[n];
        for (int i=0;i<n;i++){
            res[i]=0;
            for(int j=0;j<n;j++){
                res[i]+=keymat[i][j]*plainmat[j];
            }
            res[i]=res[i]%26;
        }
        for(int i:res){
            System.out.print(ds.get(i));
        }
        System.out.println();
    }
public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    Scanner sc1=new Scanner(System.in);
    HashMap<Character,Integer> hs=new HashMap<Character,Integer>();
    HashMap<Integer,Character> ds=new HashMap<Integer,Character>();
    int num=0;
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
        
        int plainmat[]=new int[plain.length()];
        int keymat[][]=new int[plain.length()][plain.length()];
        for (int i=0;i<plain.length();i++){
            plainmat[i]=hs.get(plain.charAt(i));
        }
        int ind=0;
        for (int i=0;i<keyboard.length()/plain.length();i++){
            for (int j=0;j<plain.length();j++){
                keymat[i][j]=hs.get(keyboard.charAt(ind));
                ind+=1;
            }
        }
       
       
       
        
        if (n==3){
            break;
        }
        else if(n==1){
           
            encode(plainmat,keymat,hs,ds,plain.length());
        }
        else{
            
            decode(plainmat,keymat,hs,ds,plain.length());
        }

    }
    sc.close();
    sc1.close();
}    
}
