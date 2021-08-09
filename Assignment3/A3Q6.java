import java.util.Scanner;

public class A3Q6 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        //input
        int m=in.nextInt();
        int n=in.nextInt();
        int t;
        int [][]a=new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                t=in.nextInt();
                if(i==0&&j==0) {
                    a[i][j]=t;
                }
                else{
                    if(i==0) {
                        a[i][j]=t+a[i][j-1];
                    }
                    else{
                        if(j==0) {
                            a[i][j]=t+a[i-1][j];
                        }
                        else{
                            a[i][j]=t+Math.min(a[i][j-1],a[i-1][j]);
                        }
                    }
                }
            }
        }
        System.out.println(a[m-1][n-1]);
    }
}
