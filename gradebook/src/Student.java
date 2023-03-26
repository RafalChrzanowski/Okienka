public class Student implements Printable, Comparable<Student>{
    private String firstName;
    private String lastName;
    private StudentCondition studentStatus;
    private Integer yearOfBirth;
    private Double points;
    private String email;


    public Student(String firstName, String lastName, StudentCondition studentStatus,Integer yearOfBirth,Double points,String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentStatus = studentStatus;
        this.yearOfBirth = yearOfBirth;
        this.points = points;
        this.email = email;
    }
    @Override
    public void print(){
        System.out.println("Name " + firstName + " LastName " + lastName + "\n" + "Year of Birth " + yearOfBirth +"\n" + "Student Condition: " + studentStatus + " Points: " + points + "\n" + "Email: " + email);
    }
    @Override
    public  int compareTo(Student other){
        return this.lastName.compareTo(other.lastName);
    }
}
