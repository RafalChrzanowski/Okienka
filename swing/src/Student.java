public class Student implements Printable, Comparable<Student>{
     String firstName;
     String lastName;
     StudentCondition studentCondition;
     Integer yearOfBirth;
     Double points;
     String email;


    public Student(String firstName, String lastName, StudentCondition studentCondition, Integer yearOfBirth, Double points, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentCondition = studentCondition;
        this.yearOfBirth = yearOfBirth;
        this.points = points;
        this.email = email;
    }
    @Override
    public void print(){
        System.out.println("Name " + firstName + " LastName " + lastName + "\n" + "Year of Birth " + yearOfBirth +"\n" + "Student Condition: " + studentCondition + " Points: " + points + "\n" + "Email: " + email);
    }
    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public double getPoints() {
        return points;
    }

    public String getName() {
        return lastName;
    }

    public StudentCondition getCondition() {
        return studentCondition;
    }
    public void setStudentCondition(StudentCondition studentCondition) {
        this.studentCondition = studentCondition;
    }
    public void setPoints(double points) {
        this.points = points;
    }
    @Override
    public  boolean compareTo(Student other){
        if (this.lastName == other.lastName) return true;
        else return false;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}

