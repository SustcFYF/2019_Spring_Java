import java.util.Scanner;

public class A3Q2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num=in.nextInt();
        int sum=0;
        int []a=new int [num];
        int []lm=new int [num];
        int []rm=new int [num];
        for (int i = 0; i < num; i++) {
            a[i]=in.nextInt();
        }
        //left maximum
        lm[0]=a[0];
        for (int i = 1; i < num; i++) {
            if(lm[i-1]<a[i]){
                lm[i]=a[i];
            }
            else lm[i]=lm[i-1];
        }
        //right maximum
        rm[num-1]=a[num-1];
        for (int i = num-2; i >-1; i--) {
            if(rm[i+1]<a[i]){
                rm[i]=a[i];
            }
            else rm[i]=rm[i+1];
        }
        //water stored in each column
        for (int i = 0; i < num; i++) {
            if(a[i]<lm[i]&&a[i]<rm[i]){
                if(lm[i]<rm[i]){
                    sum+=lm[i]-a[i];
                }
                else sum+=rm[i]-a[i];
            }
        }
        System.out.print(sum);
    }
}