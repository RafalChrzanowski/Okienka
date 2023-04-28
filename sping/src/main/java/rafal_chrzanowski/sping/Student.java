package rafal_chrzanowski.sping;

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
    public String print(){
        return "Student:\n Imie: %s\n Nazwisko: %s\n Status: %s\n Rok urodzenia: %d\n Punkty: %.2f\n Email: %s\n".formatted(firstName, lastName, studentCondition.toString(), yearOfBirth, points, email);
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", studentCondition=" + studentCondition +
                ", yearOfBirth=" + yearOfBirth +
                ", points=" + points +
                ", email='" + email + '\'' +
                '}';
    }

    public String getName() {
        return lastName;
    }

    public String getFirstName() {
        return lastName;
    }

    public StudentCondition getCondition() {
        return studentCondition;
    }
    @Override
    public  boolean compareTo(Student other){
        if (this.lastName == other.lastName) return true;
        else return false;
    }

    public String getLastname() {
        return lastName;
    }
    public double getPoints() {
        return points;
    }
}

