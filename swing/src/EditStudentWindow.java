import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class EditStudentWindow extends JFrame {
    private Student student;

    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField emailField;
    private JTextField yearOfBirthField;
    private JTextField pointsField;

    public EditStudentWindow(Student student) {
        this.student = student;

        setTitle("Edit Student");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel contentPane = new JPanel(new BorderLayout());
        setContentPane(contentPane);

        firstNameField = new JTextField(student.getFirstName());
        lastNameField = new JTextField(student.getName());
        emailField = new JTextField(student.getEmail());
        yearOfBirthField = new JTextField(String.valueOf(student.getYearOfBirth()));
        pointsField = new JTextField(String.valueOf(student.getPoints()));

        JPanel formPanel = new JPanel(new GridLayout(3, 2));
        formPanel.add(new JLabel("First Name:"));
        formPanel.add(firstNameField);
        formPanel.add(new JLabel("Last Name:"));
        formPanel.add(lastNameField);
        formPanel.add(new JLabel("Email:"));
        formPanel.add(emailField);
        formPanel.add(new JLabel("Year of birth:"));
        formPanel.add(yearOfBirthField);
        formPanel.add(new JLabel("Points:"));
        formPanel.add(pointsField);
        contentPane.add(formPanel, BorderLayout.CENTER);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> {
            student.setFirstName(firstNameField.getText());
            student.setLastName(lastNameField.getText());
            student.setEmail(emailField.getText());
            String yearOfBirthStr = yearOfBirthField.getText();
            int yearOfBirth = Integer.parseInt(yearOfBirthStr);
            student.setYearOfBirth(yearOfBirth);
            String pointsStr = pointsField.getText();
            double points = Double.parseDouble(pointsStr);
            student.setPoints(points);

            ((AbstractTableModel) StudentListTable.studentTable.getModel()).fireTableDataChanged();

            dispose();
        });
        contentPane.add(saveButton, BorderLayout.SOUTH);

        setSize(400, 200);
        setVisible(true);
    }
}