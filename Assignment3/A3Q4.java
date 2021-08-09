import java.util.Scanner;

public class A3Q4 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int m=in.nextInt();
        int n=in.nextInt();
        int [][]a=new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j]=in.nextInt();
            }
        }
        int t=in.nextInt();
        int [][]queries=new int[t][4];
        for (int i = 0; i < t; i++) {
            for (int j = 0; j < 4; j++) {
                queries[i][j]=in.nextInt();
            }
        }
        for (int i = 0; i < t; i++) {
            System.out.println(sum(a,queries[i][0],queries[i][1],queries[i][2],queries[i][3]));
        }
    }
    static int sum(int [][]a,int x1,int y1,int x2,int y2){
        int sum=0;
        for (int i = x1; i < x2+1; i++) {
            for (int j = y1; j < y2+1; j++) {
                sum+=a[i][j];
            }
        }
        return sum;
    }
}
