import java.util.ArrayList;
import java.util.Scanner;

public class CourseTest {
    public static void main(String[] args) {
        ArrayList<Course> list=new ArrayList<>();
        Scanner input=new Scanner(System.in);
        System.out.println("Would you like to create some courses: yes or no ?");
//input course information
        while (input.nextLine().equalsIgnoreCase("yes")) {
            System.out.println("Please input the course name:");
            String name=input.nextLine();
            System.out.println("Please input the course credit:");
            int credit=input.nextInt();
            System.out.println("Please input the course grade:");
            input.nextLine();
            String grade=input.nextLine();
            while ((!grade.equals("freshman"))&&(!grade.equals("sophomore"))&&(!grade.equals("junior"))&&(!grade.equals("senior"))){
                System.out.println("The input course grade is not one of \"freshman\", \"sophomore\", \"junior\" and \"senior\".");
                System.out.println("Please input the course grade again:");
                grade=input.nextLine();
                if(grade.equals("freshman")||grade.equals("sophomore")||grade.equals("junior")||grade.equals("senior")){
                    break;
                }
            }
            System.out.println("Please input the course teacher:");
            String teacher=input.nextLine();
            Course course=new Course(name,credit,grade,teacher);
            list.add(course);
            System.out.println("Would you like to create some courses: yes or no ?");
        }
//obtain course information
        System.out.println("Would you like to obtain course information: yes or no ?");
        while (input.nextLine().equalsIgnoreCase("yes")){
            System.out.printf("There are %d courses in the system, please pick No.",list.size());
            int n=input.nextInt();
            while(n>=list.size()) {
                System.out.printf("There are only %d courses! Please input again:\n",list.size());
                n=input.nextInt();
            }
            System.out.printf("The course level is: %s\n",list.get(n).getCourseLevel());
            System.out.printf("Is this course with lab? %b\n",list.get(n).isWithLab());
            System.out.println("Please enter your grade:");
            input.nextLine();
            String StudentGrade=input.nextLine();
            while ((!StudentGrade.equals("freshman"))&&(!StudentGrade.equals("sophomore"))&&(!StudentGrade.equals("junior"))&&(!StudentGrade.equals("senior"))){
                System.out.println("The input course grade is not one of \"freshman\", \"sophomore\", \"junior\" and \"senior\".");
                System.out.println("Please input the your grade again:");
                StudentGrade=input.nextLine();
                if(StudentGrade.equals("freshman")||StudentGrade.equals("sophomore")||StudentGrade.equals("junior")||StudentGrade.equals("senior")){
                    break;
                }
            }
            System.out.printf("The result for your qualification to enroll in the course is: %s\n",list.get(n).getQualificationForCourse(StudentGrade));
    //input a credit
            System.out.println("Input a course credit:");
            int credit=input.nextInt();
            ArrayList<Course> c=new ArrayList<>();
            for (int i = 0; i <list.size() ; i++) {
                if(list.get(i).getCredit()==credit){
                    c.add(list.get(i));
                }
            }
            System.out.printf("The courses with %d credits are ",credit);
            System.out.println(c);
    //input a teacher
            System.out.println("Input a teacher's name:");
            input.nextLine();
            String teacher=input.nextLine();
            ArrayList<Course> t=new ArrayList<>();
            for (int i = 0; i <list.size(); i++) {
                if(list.get(i).getTeacher().toLowerCase().contains(teacher.toLowerCase())){
                    t.add(list.get(i));
                }
            }
            System.out.printf("The courses taught by %s are ",teacher);
            System.out.println(t);
            System.out.println("Would you like to obtain course information: yes or no ?");
        }
//obtain course information after removing certain course
        System.out.println("Would you like to obtain course information after removing certain course: yes or no ?");
        while (input.nextLine().equalsIgnoreCase("yes")){
            System.out.println("Please pick the index of the course you want to remove:");
            int index=input.nextInt();
            while(index>=list.size()&&list.size()>0) {
                System.out.printf("There are only %d courses! Please input again:\n",list.size());
                index=input.nextInt();
            }
            if (list.size() > 0) {
                list.remove(index);
                System.out.println("The remaining courses are " + list);
            } else {
                System.out.println("There is no remaining course! Please input \"no\".");
            }
            System.out.println("Would you like to obtain course information after removing certain course: yes or no ?");
            input.nextLine();
        }
    }
}
