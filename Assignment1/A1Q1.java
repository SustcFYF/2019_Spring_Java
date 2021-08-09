public class A1Q1 {
    public static void main(String[] args) {
        double perimeter,area;
        float pi=3.14f;
        float radius= Float.parseFloat(args[0]);
        perimeter=2*pi*radius;
        area=pi*radius*radius;
        System.out.printf("%.2f\n",perimeter);
        System.out.printf("%.2f",area);
    }
}
