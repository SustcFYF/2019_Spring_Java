public class A1Q4 {
    public static void main(String[] args) {
        int sum=0;
        int i=0;
        int n= Integer.parseInt(args[0]);
        while (i<n) {
            i=i+1;
            sum=sum+i;
        }
        System.out.print(sum);
    }
}
