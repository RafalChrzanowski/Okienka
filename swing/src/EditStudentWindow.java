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

    public EditStudentWindow(Student student) {
        this.student = student;

        setTitle("Edit Student");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create a new JPanel to contain the components
        JPanel contentPane = new JPanel(new BorderLayout());
        setContentPane(contentPane);

        // Create form fields for editing the student data
        firstNameField = new JTextField(student.getFirstName());
        lastNameField = new JTextField(student.getName());
        emailField = new JTextField(student.getEmail());

        // Add form fields to the content pane
        JPanel formPanel = new JPanel(new GridLayout(3, 2));
        formPanel.add(new JLabel("First Name:"));
        formPanel.add(firstNameField);
        formPanel.add(new JLabel("Last Name:"));
        formPanel.add(lastNameField);
        formPanel.add(new JLabel("Email:"));
        formPanel.add(emailField);
        contentPane.add(formPanel, BorderLayout.CENTER);

        // Add a save button to save the edited student data
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> {
            // Save the edited student data
            student.setFirstName(firstNameField.getText());
            student.setLastName(lastNameField.getText());
            student.setEmail(emailField.getText());

            // Update the table to reflect the changes
            ((AbstractTableModel) StudentListTable.studentTable.getModel()).fireTableDataChanged();

            // Close the edit window
            dispose();
        });
        contentPane.add(saveButton, BorderLayout.SOUTH);

        // Set the size of the JFrame and make it visible
        setSize(400, 200);
        setVisible(true);
    }
}