import java.util.Scanner;

public class A3Q5 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int m=in.nextInt();
        int n=in.nextInt();
        int max=0;
        int num;
        int [][]a=new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j]=in.nextInt();
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(a[i][j]==1) {
                    num=depthFirstSearch(a,i,j);
                    if(num>max) {
                        max=num;
                    }
                }
            }
        }
        System.out.print(max);
    }
    //DFS
    static int depthFirstSearch(int [][]a,int i,int j){
        if(i<0||j<0||i>a.length-1||j>a[0].length-1||a[i][j]==0){
            return 0;
        }
        a[i][j]=0;
        return 1+depthFirstSearch(a,i-1,j)+depthFirstSearch(a,i+1,j)+depthFirstSearch(a,i,j-1)+depthFirstSearch(a,i,j+1);
    }
}
