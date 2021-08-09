import java.util.Scanner;

public class A3Q3 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int m=in.nextInt();
        int n=in.nextInt();
        int [][]arr=new int[m][n];
        int t=1;
        //int length=-(int)Math.log10(m*n)-2;
        for (int r = 0; r<min(m,n)-min(m,n)/2; r++) {
            //leftward
            for (int i = n-1; i > -1; i--) {
                if(arr[r][i]==0){
                    arr[r][i]=t;
                    t++;
                }
            }
            //downward
            for (int i = 0; i < m; i++) {
                if(arr[i][r]==0){
                    arr[i][r]=t;
                    t++;
                }
            }
            //rightward
            for (int i = 0; i < n; i++) {
                if(arr[m-r-1][i]==0){
                    arr[m-r-1][i]=t;
                    t++;
                }
            }
            //upward
            for (int i = m-1; i > -1 ; i--) {
                if(arr[i][n-r-1]==0){
                    arr[i][n-r-1]=t;
                    t++;
                }
            }
        }
        //output
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%-3d",arr[i][j]);
            }
            System.out.println();
        }
    }
    static int min(int a,int b){
        if(a<b){
            return a;
        }
        else return b;
    }
}
