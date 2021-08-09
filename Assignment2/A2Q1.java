public class A2Q1 {
    public static void main(String[] args) {
        int year= Integer.parseInt(args[0]);
        int t,d;
        String animal="";
        String tiangan="";
        String dizhi="";
        switch (year%10) {
            case 0:
                tiangan = "geng";
                break;
            case 1:
                tiangan = "xin";
                break;
            case 2:
                tiangan = "ren";
                break;
            case 3:
                tiangan = "gui";
                break;
            case 4:
                tiangan = "jia";
                break;
            case 5:
                tiangan = "yi";
                break;
            case 6:
                tiangan = "bing";
                break;
            case 7:
                tiangan = "ding";
                break;
            case 8:
                tiangan = "wu";
                break;
            case 9:
                tiangan = "ji";
                break;
        }
        switch (year%12) {
            case 0:
                dizhi = "shen";
                animal = "Monkey";
                break;
            case 1:
                dizhi = "you";
                animal = "Rooster";
                break;
            case 2:
                dizhi = "xu";
                animal = "Dog";
                break;
            case 3:
                dizhi = "hai";
                animal = "Pig";
                break;
            case 4:
                dizhi = "zi";
                animal = "Rat";
                break;
            case 5:
                dizhi = "chou";
                animal = "Ox";
                break;
            case 6:
                dizhi = "yin";
                animal = "Tiger";
                break;
            case 7:
                dizhi = "mao";
                animal = "Rabbit";
                break;
            case 8:
                dizhi = "chen";
                animal = "Dragon";
                break;
            case 9:
                dizhi = "si";
                animal = "Snake";
                break;
            case 10:
                dizhi = "wu";
                animal = "Horse";
                break;
            case 11:
                dizhi = "wei";
                animal = "Sheep";
                break;
        }
        System.out.println(tiangan+"-"+dizhi);
        System.out.println(animal);
    }
}
