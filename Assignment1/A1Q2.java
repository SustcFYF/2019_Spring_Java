public class A1Q2 {
    public static void main(String[] args) {
        double hkd;
        float cny= Float.parseFloat(args[0]);
        if (cny<=50)
            hkd=0;
        else hkd=(cny-50)*1.17;
        System.out.printf("%.2f",hkd);
    }
}
