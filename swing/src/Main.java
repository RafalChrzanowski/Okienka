import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!\n");
        Student student = new Student("Rafal", "Chrzanowski1",StudentCondition.DOING,2000,3.0,"rafalchrzanowski00@gmail.com");
        student.print();
        //compare
        System.out.printf("compare\n");
        Student student2 = new Student("Tomasz", "Chrzanowski",StudentCondition.SICK,2001,4.0,"rafalchrzanowski@gmail.com");
        Student student3 = new Student("Piotr", "Maka",StudentCondition.ABSENT,2004,2.0,"Maka@gmail.com");
        if(student2.compareTo(student3)) System.out.printf("Studenci mają takie samo nazwisko\n");
        else System.out.printf("Studenci nie mają takiego samego nazwiska\n");

        //add to class
        System.out.printf("add to class\n");
        List studentsList = new ArrayList<Student>();
        studentsList.add(student);
        studentsList.add(student2);
        studentsList.add(student3);
        Class firstClass = new Class("nazwa",4);
        firstClass.addStudent(student);
        firstClass.addStudent(student2);
        firstClass.addStudent(student3);

        new WindowUI();
    }
}