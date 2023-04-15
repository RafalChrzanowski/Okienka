import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!\n");
        Student student = new Student("Rafal", "Chrzanowski1",StudentCondition.DOING,2000,3.0,"rafalchrzanowski00@gmail.com");
        student.print();


        new WindowUI();

        Class classInstance1 = new Class("Group A", 20);
        classInstance1.addStudent(new Student("Tomasz", "Chrzanowski", StudentCondition.SICK, 2001, 4.0, "rafalchrzanowski@gmail.com"));
        classInstance1.addStudent(new Student("Piotr", "Maka", StudentCondition.ABSENT, 2004, 2.0, "Maka@gmail.com"));
        classInstance1.addStudent(new Student("asdwasdasd", "Maka", StudentCondition.ABSENT, 2004, 2.0, "Maka@gmail.com"));

        new ClassInterface(classInstance1);
    }
}