import java.util.*;
class Playfair {
    static String find(char x,char y,char[][] keymat){
      
        String ret="";
        int x1=0,x2=0,y1=0,y2=0;
        for (int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(keymat[i][j]==x){
                    x1=i;
                    y1=j;
                }
                if(keymat[i][j]==y){
                    x2=i;
                    y2=j;
                }
            }
        }
        
        if(y1==y2){
            if(x1==4){
                x1=-1;

            }
            if(x2==4){
                x2=-1;
            }
            ret+=keymat[x1+1][y1];
            ret+=keymat[x2+1][y1];
        }
        else if(x1==x2){
            if(y1==4){
                y1=-1;

            }
            if(y2==4){
                y2=-1;
            }
            ret+=keymat[x1][y1+1];ret+=keymat[x2][y2+1];
        }
        else{
            ret+=keymat[x1][y2];ret+=keymat[x2][y1];
        }
        // System.out.println(x+" "+y+" "+x1+" "+x2+" "+y1+" "+y2+" "+ret);
        return ret;
    }
    static String refind(char x,char y,char[][] keymat){
      
        String ret="";
        int x1=0,x2=0,y1=0,y2=0;
        for (int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(keymat[i][j]==x){
                    x1=i;
                    y1=j;
                }
                if(keymat[i][j]==y){
                    x2=i;
                    y2=j;
                }
            }
        }
        
        if(y1==y2){
            if(x1==0){
                x1=5;

            }
            if(x2==0){
                x2=5;
            }
            ret+=keymat[x1-1][y1];
            ret+=keymat[x2-1][y1];
        }
        else if(x1==x2){
            if(y1==0){
                y1=5;

            }
            if(y2==0){
                y2=5;
            }
            ret+=keymat[x1][y1-1];ret+=keymat[x2][y2-1];
        }
        else{
            ret+=keymat[x1][y2];ret+=keymat[x2][y1];
        }
        // System.out.println(x+" "+y+" "+x1+" "+x2+" "+y1+" "+y2+" "+ret);
        return ret;
    }
    static char[][] form(String key){
        key=key.toUpperCase();
        HashMap<Character,Integer> is=new HashMap<Character,Integer>();
        for (int i=65;i<65+26;i++){
            is.put((char)i,0);
        }
        char[][] keymat=new char[5][5];
        int row=0,col=0;
        for (int i=0;i<key.length();i++){
            if(col==5){
                row+=1;
                col=0;
            }
          
            if(is.get(key.charAt(i))==0){
            keymat[row][col]=key.charAt(i);
            is.replace(key.charAt(i),1);
                col+=1;
        }
           
        }
        for(int i=65;i<65+26;i++){
            if(col==5){
                row+=1;
                col=0;
            }
           
            if(is.get((char)i)==0){
                if(((char)i=='J' && is.get('I')==1)||((char)i=='J' && is.get('I')==1) ){
                    continue;

                }
                else{
              
            keymat[row][col]=(char)i;
            is.replace((char)i,1);}
        col+=1;}
          
        }

       

        return keymat;

    }
    static void encode(String key,String plain){
        char[][] keymat=form(key);
        // for (int i=0;i<5;i++){
        //     for(int j=0;j<5;j++){
        //     System.out.print(keymat[i][j]+" ");}
        // }
        plain=plain.toUpperCase();
        String encoded="";
        if(plain.length()%2==1){
            plain+="Z";
        }
        for(int i=0;i<plain.length();i+=2){
            encoded+=find(plain.charAt(i),plain.charAt(i+1),keymat);
            // System.out.println(encoded);

        }
        System.out.println(encoded);
    }
    static void decode(String key,String ciph){
        char[][] keymat=form(key);
        // for (int i=0;i<5;i++){
        //     for(int j=0;j<5;j++){
        //     System.out.print(keymat[i][j]+" ");}
        // }
        ciph=ciph.toUpperCase();
        String decoded="";
        
        for(int i=0;i<ciph.length();i+=2){
            decoded+=refind(ciph.charAt(i),ciph.charAt(i+1),keymat);
            // System.out.println(encoded);

        }
        System.out.println(decoded);
        
    }
 public static void main(String[] args) {
     Scanner sc=new Scanner(System.in);
     while(true){
         int n=sc.nextInt();
         if(n==3){
             break;
         }
         else if(n==1){
             String key=sc.next();
             String plain=sc.next();
             encode(key,plain);
         }
         else{
            String key=sc.next();
            String ciph=sc.next();
            decode(key,ciph);
         }

     }
     sc.close();

 }
}