public class A1Q3 {
    public static void main(String[] args) {
        int Lecture= Integer.parseInt(args[0]);
        int Lab= Integer.parseInt(args[1]);
        int Assignments= Integer.parseInt(args[2]);
        int Project= Integer.parseInt(args[3]);
        int Exam= Integer.parseInt(args[4]);
        double sum;
        sum=0.1*Lecture+0.1*Lab+0.3*Assignments+0.2*Project+0.3*Exam;
        System.out.printf("%.2f\n",sum);
        if (sum>=80)
            System.out.print("A");
        else
            if (sum>=50)
                System.out.print("B");
            else System.out.print("C");

    }
}
