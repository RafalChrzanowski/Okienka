import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Class classInstance1 = new Class("Group A", 20);
        classInstance1.addStudent(new Student("Tomasz", "Chrzanowski", StudentCondition.SICK, 2001, 4.0, "rafalchrzanowski@gmail.com"));
        classInstance1.addStudent(new Student("Piotr", "Maka", StudentCondition.ABSENT, 2004, 2.0, "Maka@gmail.com"));
        classInstance1.addStudent(new Student("asdwasdasd", "Maka", StudentCondition.ABSENT, 2004, 2.0, "Maka@gmail.com"));

        new ClassInterface(classInstance1);
    }
}