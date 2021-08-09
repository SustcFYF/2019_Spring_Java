public class A2Q2 {
    public static void main(String[] args) {
        int n=args.length;
        double a[]=new double[n];
        int count[]=new int[n];
        double num[]=new double[n];
        double average;
        double median;
        double sum=0.0;
        double t;
        int k=0;
        int max=0;
        //input
        for(int i=0;i<n;i++){
            a[i]=Double.parseDouble(args[i]);
            sum+=a[i];
        }
        //avarage
        average=sum/n;
        System.out.printf("%.2f\n",average);
        //sort
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(a[i]>a[j]){
                    t=a[i];
                    a[i]=a[j];
                    a[j]=t;
                }
            }
        }
        //mode
        count[k]=1;
        num[0]=a[0];
        for(int i=1;i<n;i++){
            if(a[i]==a[i-1]){
                count[k]++;
            }
            else{
                k++;
                count[k]=1;
                num[k]=a[i];
            }
        }
        for(int i=0;i<n;i++){
            if(count[i]>max){
                max=count[i];
            }
        }
        for(int i=0;i<n;i++) {
            if (count[i] == max) {
                System.out.printf("%.2f ",num[i]);
            }
        }
        System.out.println();
        //median
        if(n%2==0){
            median=0.5*(a[n/2-1]+a[n/2]);
        }
        else median=a[(n-1)/2];
        System.out.printf("%.2f\n",median);
    }
}
