import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

public class Class {
    private String groupName;
    private List<Student> students;
    private int maxStudents;
    private int capacity =1 ;

    public Class(String groupName, int maxStudents){
        this.groupName = groupName;
        this.maxStudents = maxStudents;
        students = new ArrayList<>();
    }
    public void addStudent(Student student){
        if(students.contains(student)){
            System.out.println("Student already exists in the group");
            return;
        }
        if(students.size() >= maxStudents){
            System.err.println("Group has reached mac capacity");
            return;
        }
        students.add(student);
    }
    public void addPoints(Student student, double point){
        student.points += point;
        System.out.println("Student: "+ student.firstName + " has a " + student.points);
    }
    public void removePoints(Student student, double point){
        student.points -= point;
        System.out.println("Student: "+ student.firstName + " has a " + student.points);
    }
    public void  getStudent(Student student){
        if(student.points >= 0){
            students.remove(student);
        }
        System.out.println("Student: "+ student.firstName + " has been removed");
    }
    public void changeCondition(Student student, StudentCondition condition){
        student.studentCondition = condition;
        System.out.println("The student's: "+ student.firstName + " status has been changed to " + student.studentCondition);
    }
    public Student search(String lastName){
        for(Student student  : students){
            if (student.getName().equals(lastName)) {
                System.out.println("The student's: "+ student.lastName + " was found");
                String name = student.lastName;
                return student;
            }
        }
        return null;
    }

    public List<Student> searchPartial(String partialName){
        List<Student> matchingStudents = new ArrayList<>();
        String xyz = "";
        for(Student student  : students){
            if(student.lastName.toLowerCase().contains(partialName.toLowerCase())) {
                xyz = student.lastName;
                matchingStudents.add(student);
            }
        }
        System.out.println("Searched students with last name: " + xyz);
        return matchingStudents;
    }

    public int countByCondition(StudentCondition condition){
        int count = 0;
        for(Student student  : students){
            if(student.getCondition() == condition){
                count++;
            }
        }
        System.out.println("The number of students is: " + count);
        return count;
    }
    public void summary(){
        for(Student student : students){
            System.out.println(student.lastName.toString());
        }
    }
    public void sortByName() {
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.lastName.compareTo(o2.lastName);
            }
        });
    }

    public void sortByPoints(){
        Collections.sort(students, new pointComparator());
    }

    private class pointComparator implements Comparator<Student>{
        @Override
        public int compare(Student o1, Student o2){
            if(o1.points > o2.points) return 1;
            else return 0;
        }
    }
    void max()
    {
        System.out.println((Collections.max(students, new pointComparator())).lastName);
    }
    public int getPercentageFull() {

        return students.size() / capacity * 100;
    }
    public String getGroupName() {
        return this.groupName;
    }
}
