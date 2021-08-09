public class Customer {
    private String firstName;
    private String lastName;
    private Gender gender;
    private String socialSecurityNumber;
    public void setFirstName(String firstName){
        this.firstName=firstName;
    }
    public void setLastName(String lastName){
        this.lastName=lastName;
    }
    public void setGender(Gender gender){
        this.gender=gender;
    }
    public void setSocialSecurityNumber(String socialSecurityNumber){
        this.socialSecurityNumber=socialSecurityNumber;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public Gender getGender(){
        return gender;
    }
    public String getSocialSecurityNumber(){
        return socialSecurityNumber;
    }
    Customer(String firstName, String lastName, Gender gender, String ssn){
        setFirstName(firstName);
        setLastName(lastName);
        setGender(gender);
        setSocialSecurityNumber(ssn);
    }
    public static boolean checkName(String name){
        boolean bool=true;
        for (int i = 1; i < name.length(); i++) {
            if(!(Character.isLetter(name.charAt(i)))){
                bool=false;
            }
        }
        return bool;
    }
    public static String formatName(String name){
        return name.substring(0,1).toUpperCase()+name.substring(1).toLowerCase();
    }
    public static boolean checkSSN(String ssn){
        boolean bool=true;
        if(ssn.length()!=8){
            return false;
        }
        else{
            if(!('1'<=ssn.charAt(0)&&ssn.charAt(0)<='9')){
                bool=false;
            }
            for (int i = 1; i < 8; i++) {
                if(!('0'<=ssn.charAt(i)&&ssn.charAt(i)<='9')){
                    bool=false;
                }
            }
        }
        return bool;
    }
}
