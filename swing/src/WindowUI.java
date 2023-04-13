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
    private JComboBox Condition;
    private JLabel yearOfBirth;
    private JTextField yearOfBirthTextField;
    private JLabel points;
    private JTextField pointsTextField;
    private JLabel email;
    private JTextField emailTextField;
    private JButton addButton;
    private JButton deleteButton;
    private JButton editButton;
    private JButton editPointsButton;
    private JList<Student> studentJList;
    private JComboBox<StudentCondition> conditionComboBox = new JComboBox<>(StudentCondition.values());

    public WindowUI() {
        String[] conditions = {"DOING", "SICK", "ABSENT"};
        setTitle("Student Manager");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(9, 2));
        firstName = new JLabel("firstName: ");
        firstNameTextField = new JTextField();
        lastName = new JLabel("lastName: ");
        lastNameTextField = new JTextField();
        studentCondition = new JLabel("studentCondition: ");
        StudentCondition selectedCondition = (StudentCondition) conditionComboBox.getSelectedItem();
        yearOfBirth = new JLabel("yearOfBirth: ");
        yearOfBirthTextField = new JTextField();
        points = new JLabel("points: ");
        pointsTextField = new JTextField();
        email = new JLabel("email: ");
        emailTextField = new JTextField();


        addButton = new JButton("Add");
        //ToDo
        addButton.addActionListener(new ActionListener() {
         @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = firstNameTextField.getText();
                String lastName = lastNameTextField.getText();
                String selectedCondition = (String) conditionComboBox.getSelectedItem();
                int yearOfBirth = Integer.parseInt(yearOfBirthTextField.getText());
                double points = Integer.parseInt(pointsTextField.getText());
                String email = emailTextField.getText();
                Student student = new Student(firstName, lastName,StudentCondition.valueOf(selectedCondition),yearOfBirth,points,email);
                students.add(student);
                updateList();
            }
        });

        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String lastNameToDelete = lastNameTextField.getText();
                for (int i = 0; i < students.size(); i++) {
                    Student student = students.get(i);
                    if (student.getName().equals(lastNameToDelete)) {
                        students.remove(i);
                        updateList();
                        break; // exit the loop after the first match is found
                    }
                }
            }
        });
        editButton = new JButton("Edit condition");
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = studentJList.getSelectedIndex();
                if (selectedIndex != -1) {
                    Student student = students.get(selectedIndex);
                    String selectedCondition = (String) conditionComboBox.getSelectedItem();
                    if (selectedCondition != null) {
                        StudentCondition newCondition = StudentCondition.valueOf(selectedCondition);
                        student.setStudentCondition(newCondition);
                        updateList();
                    }
                }
            }
        });
        editPointsButton = new JButton("Edit Points condition");
        editPointsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = studentJList.getSelectedIndex();
                if (selectedIndex != -1) {
                    Student student = students.get(selectedIndex);
                    String selectedCondition = (String) conditionComboBox.getSelectedItem();
                    if (selectedCondition != null) {
                        StudentCondition newCondition = StudentCondition.valueOf(selectedCondition);
                        student.setStudentCondition(newCondition);
                    }
                    String pointsString = pointsTextField.getText();
                    if (!pointsString.isEmpty()) {
                        double newPoints = Double.parseDouble(pointsString);
                        student.setPoints(newPoints);
                    }
                    updateList();
                }
            }
        });
        new JList<>();
        //studentJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane listScrollPane = new JScrollPane(studentJList);

        mainPanel.add(firstName);
        mainPanel.add(firstNameTextField);
        mainPanel.add(lastName);
        mainPanel.add(lastNameTextField);
        mainPanel.add(studentCondition);
        mainPanel.add(conditionComboBox);
        mainPanel.add(yearOfBirth);
        mainPanel.add(yearOfBirthTextField);
        mainPanel.add(points);
        mainPanel.add(pointsTextField);
        mainPanel.add(email);
        mainPanel.add(emailTextField);
        mainPanel.add(addButton);

        mainPanel.add(deleteButton);

        mainPanel.add(editButton);
        mainPanel.add(editPointsButton);
/*
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