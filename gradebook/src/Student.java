public class Student implements Printable, Comparable<Student>{
     String firstName;
     String lastName;
     StudentCondition studentCondition;
     Integer yearOfBirth;
     Double points;
     String email;


    public Student(String firstName, String lastName, StudentCondition studentCondition,Integer yearOfBirth,Double points,String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentCondition = studentCondition;
        this.yearOfBirth = yearOfBirth;
        this.points = points;
        this.email = email;
    }
    @Override
    public void print(){
        System.out.println("Name " + firstName + " LastName " + lastName + "\n" + "Year of Birth " + yearOfBirth +"\n" + "Student Condition: " + studentStatus + " Points: " + points + "\n" + "Email: " + email);
    }
    @Override
    public String getName() {
        return lastName;
    }
    @Override
    public String getFirstName() {
        return lastName;
    }
    @Override
    public StudentCondition getCondition() {
        return studentCondition;
    }
    @Override
    public  int compareTo(Student other){
        return this.lastName.compareTo(other.lastName);
    }

    @Override
    public String toString();
}

