import javax.swing.*;
import java.util.List;

public class ClassInterface extends JFrame {
    private Class classInstance;

    private JPanel contentPane;
    private JList<Student> studentList;

    public ClassInterface(Class classInstance) {
        classInstance = new Class("Group A", 20);
        this.classInstance = classInstance;

        setTitle("Class Interface");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a new JPanel to contain the components
        contentPane = new JPanel();
        setContentPane(contentPane);

        // Create a new JList to display the list of students
        studentList = new JList<>(new DefaultListModel<>());
        contentPane.add(studentList);

        // Populate the JList with the list of students
        updateStudentList();

        // Set the size of the JFrame and make it visible
        setSize(400, 400);
        setVisible(true);
    }

    private void updateStudentList() {
        List<Student> students = classInstance.getStudents();
        DefaultListModel<Student> model = (DefaultListModel<Student>) studentList.getModel();
        model.clear();
        for (Student student : students) {
            model.addElement(student);
        }
    }
}