import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Class {
    private String groupName;
    private List<Student> students;
    private int maxStudents;

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
        System.out.println("Student: "+ student.firstName + "has a " + student.points);
    }
    public void removePoints(Student student, double point){
        student.points -= point;
        System.out.println("Student: "+ student.firstName + "has a " + student.points);
    }
    public void  getStudent(Student student){
        if(student.points >= 0){
            students.remove(student);
        }
        System.out.println("Student: "+ student.firstName + "has been removed");
    }
    public void changeCondition(Student student, StudentCondition condition){
        student.studentCondition = condition;
        System.out.println("The student's: "+ student.firstName + "status has been changed to" + student.studentCondition);
    }
    public Student search(String lastName){
        for(Student student  : students){
            if (student.getName().equals(lastName)) {
                return student;
            }
        }
        return null;
    }

    public List<Student> searchPartial(String partialName){
        List<Student> matchingStudents = new ArrayList<>();
        for(Student student  : students){
            if( student.getFirstName().toLowerCase().contains(partialName.toLowerCase())|| student.getName().toLowerCase().contains(partialName.toLowerCase())) {
                matchingStudents.add(student);
            }
        }
        return matchingStudents;
    }

    public int countByCondition(StudentCondition condition){
        int count = 0;
        for(Student student  : students){
            if(student.getCondition() == condition){
                count++;
            }
        }
        return count;
    }
    public void summary(){
        for(Student student : students){
            System.out.println(student.toString());
        }
    }
    public List<Student> sortByName() {
        List<Student> sortedStudents = new ArrayList<>(students);
        Collections.sort(sortedStudents);
        return sortedStudents;
    }


}
