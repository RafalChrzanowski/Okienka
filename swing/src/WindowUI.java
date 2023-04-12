import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class WindowUI extends JFrame {
    private ArrayList<Student> students = new ArrayList<>();

    private JPanel mainPanel;
    private JLabel firstName;
    private JTextField firstNameTextField;
    private JLabel lastName;
    private JTextField lastNameTextField;
    private JLabel studentCondition;

    private ButtonGroup group;
    private StudentCondition selectedCondition;
    private JLabel yearOfBirth;
    private JTextField yearOfBirthTextField;
    private JLabel points;
    private JTextField pointsTextField;
    private JLabel email;
    private JTextField emailTextField;
    private JButton addButton;
    private JButton deleteButton;
    private JButton editButton;
    private JList<Student> studentJList;

    public WindowUI() {
        setTitle("Student Manager");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(9, 2));

        firstName = new JLabel("firstName: ");
        firstNameTextField = new JTextField();
        lastName = new JLabel("lastName: ");
        lastNameTextField = new JTextField();
        studentCondition = new JLabel("studentCondition-nie działa: ");
        JRadioButton radio1 = new JRadioButton("DOING");
        JRadioButton radio2 = new JRadioButton("SICK");
        JRadioButton radio3 = new JRadioButton("ABSENT");
        yearOfBirth = new JLabel("yearOfBirth: ");
        yearOfBirthTextField = new JTextField();
        points = new JLabel("points: ");
        pointsTextField = new JTextField();
        email = new JLabel("email: ");
        emailTextField = new JTextField();

        ButtonGroup radiogroup = new ButtonGroup();
        radiogroup.add(radio1);
        radiogroup.add(radio2);
        radiogroup.add(radio3);

        addButton = new JButton("Add");
        //ToDo
        addButton.addActionListener(new ActionListener() {
         @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = firstNameTextField.getText();
                String lastName = lastNameTextField.getText();
                radio1.setSelected(true);
                JRadioButton selectedButton = (JRadioButton) radiogroup.getSelection().getSelectedObjects()[0];
                String Condition = selectedButton.getText();
                int yearOfBirth = Integer.parseInt(yearOfBirthTextField.getText());
                double points = Integer.parseInt(pointsTextField.getText());
                String email = emailTextField.getText();
                Student student = new Student(firstName, lastName,StudentCondition.valueOf(Condition),yearOfBirth,points,email);
                students.add(student);
                updateList();
            }
        });

        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = studentJList.getSelectedIndex();
                if (selectedIndex != -1) {
                    students.remove(selectedIndex);
                    updateList();
                }
            }
        });
/*
        editButton = new JButton("Edit status");
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = studentJList.getSelectedIndex();
                if (selectedIndex != -1) {
                    String name = nameTextField.getText();
                    String id = idTextField.getText();
                    String condi = pointsTextField.getText();
                    Student student = students.get(selectedIndex);
                    student.studentCondition(condi);
                    updateList();
                }
            }
        });
*/
        studentJList = new JList<>();
        studentJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane listScrollPane = new JScrollPane(studentJList);

        mainPanel.add(firstName);
        mainPanel.add(firstNameTextField);
        mainPanel.add(lastName);
        mainPanel.add(lastNameTextField);
        mainPanel.add(studentCondition);
        mainPanel.add(radio1);
        mainPanel.add(radio2);
        mainPanel.add(radio3);
        mainPanel.add(yearOfBirth);
        mainPanel.add(yearOfBirthTextField);
        mainPanel.add(points);
        mainPanel.add(pointsTextField);
        mainPanel.add(email);
        mainPanel.add(emailTextField);
        mainPanel.add(addButton);
        /*
        mainPanel.add(deleteButton);
        mainPanel.add(editButton);

        mainPanel.add(listScrollPane);
        */
        add(mainPanel);

        setVisible(true);
    }

    private void updateList() {
        studentJList.setListData(students.toArray(new Student[0]));
        firstNameTextField.setText("");
        lastNameTextField.setText("");
        yearOfBirthTextField.setText("");
        pointsTextField.setText("");
        emailTextField.setText("");
    }

}