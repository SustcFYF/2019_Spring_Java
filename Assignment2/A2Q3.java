public class A2Q3 {
    public static void main(String[] args) {
        int n= args.length;
        double score[]=new double[n/2];
        double credit[]=new double[n/2];
        double grade[]=new double[n/2];
        double totalgrade=0;
        double totalcredit=0;
        double gpa;
        if	(n==0||n%2!=0){
            System.out.println("Please input the right format of score and credit hour in pair,eg.95 2 88 3");
            return;
        }
        for(int i=0;i<n;i++){
            if(i%2==0){
                score[i/2]=Math.round(Double.parseDouble(args[i]));
            }
            else{
                credit[(i-1)/2]=Double.parseDouble(args[i]);
                totalcredit+=credit[(i-1)/2];
            }
        }
        for(int i=0;i<n/2;i++){
            if(score[i]>=97){
                grade[i]=4.00;
            } else if (score[i] >= 93) {
                grade[i] = 3.94;
            } else if (score[i] >= 90) {
                grade[i] = 3.85;
            } else if (score[i] >= 87) {
                grade[i] = 3.73;
            } else if (score[i] >= 83) {
                grade[i] = 3.55;
            } else if (score[i] >= 80) {
                grade[i] = 3.32;
            } else if (score[i] >= 77) {
                grade[i] = 3.09;
            } else if (score[i] >= 73) {
                grade[i] = 2.78;
            } else if (score[i] >= 70) {
                grade[i] = 2.42;
            } else if (score[i] >= 67) {
                grade[i] = 2.08;
            } else if (score[i] >= 63) {
                grade[i] = 1.63;
            } else if (score[i] >= 60) {
                grade[i] = 1.15;
            } else grade[i] = 0;
        }
        for(int i=0;i<n/2;i++){
            totalgrade+=credit[i]*grade[i];
        }
        gpa=totalgrade/totalcredit;
        System.out.printf("%.2f",gpa);
    }
}
