public class Course {
    private String name;
    private int credit;
    private String grade;
    private String teacher;
    public Course(String name,int credit,String grade,String teacher){
        setName(name);
        setCredit(credit);
        setGrade(grade);
        setTeacher(teacher);
    }
    public Course(String name){
        setName(name);
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setCredit(int credit){
        this.credit=credit;
    }
    public int getCredit(){
        return credit;
    }
    public void setGrade(String grade){
        this.grade=grade;
    }
    public String getGrade(){
        return grade;
    }
    public void setTeacher(String teacher) {
        this.teacher=teacher;
    }
    public String getTeacher(){
        return teacher;
    }
    public String toString(){
        return name;
    }
    public String getCourseLevel(){
        if(grade.equals("junior")||grade.equals("senior")){
            return "major course";
        } else if(grade.equals("freshman")||grade.equals("sophomore")){
            return "common course";
        } else return "not valid query";
    }
    public String getQualificationForCourse(String StudentGrade){
        String StudentLevel;
        if(StudentGrade.equals("junior")||StudentGrade.equals("senior")){
            StudentLevel="major course";
        } else if(StudentGrade.equals("freshman")||StudentGrade.equals("sophomore")){
            StudentLevel="common course";
        } else StudentLevel="not valid query";
        if(StudentLevel.equals(getCourseLevel())) {
            return "You are qualified for the course";
        } else if(!StudentLevel.equals(getCourseLevel())){
            return "You are not qualified for the course";
        } else return "not valid query";
    }
    public boolean isWithLab(){
        return (credit==3);
    }
}
