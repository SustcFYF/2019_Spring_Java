import java.util.Scanner;

public class A3Q1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int num=in.nextInt();
        int [][]result=new int [num][];
        for (int i = 0; i < num; i++) {
            int m=in.nextInt();
            int n=in.nextInt();
            int [][]arr=new int[m][n];
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    arr[j][k]=in.nextInt();
                }
            }
            result[i]=gcdOfAColumn(arr);
        }
        for (int i = 0; i < num; i++) {
            for (int j = 0; j <result[i].length; j++) {
                System.out.printf("%d ",result[i][j]);
            }
            System.out.println();
        }
    }
    //find the gsd of 2 numbers
    static int gcdOfTwoNumbers(int a,int b){
        int t;
        if(a<b) {
            t=a;a=b;b=t;
        }
        int r=a%b;
        while (r!=0){
            a=b;b=r;r=a%b;
        }
        return b;
    }
    //find the gcd of each column
    static int[] gcdOfAColumn(int [][] a){
        int [] ar=new int[a[0].length];
        for (int j = 0; j < a[0].length; j++) {
            ar[j]=a[0][j];
            for (int i = 1; i < a.length; i++) {
                ar[j]=gcdOfTwoNumbers(ar[j],a[i][j]);
            }
        }
        return ar;
    }
}
