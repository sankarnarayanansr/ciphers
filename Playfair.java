import java.util.Scanner;
class Playfair {
    public static void encode(char a,char b){
        char[][] box={{'M','O','N','A','R'},{'C','H','Y','B','D'},{'E','F','G','I','K'},{'L','P','Q','S','T'},{'U','V','W','X','Z'}};
        
    }
    
    public static void main(String[] args){
        
       
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        if (str.length()%2==0){
            str=str+'x';
        }
        int i=0;
        while (i<str.length()/2){
            encode(str.charAt(i),str.charAt(i+1));
            

        }


        sc.close();

    }
}