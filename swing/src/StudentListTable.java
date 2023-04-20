import javax.swing.table.AbstractTableModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class StudentListTable extends JFrame {
    private List<Student> students;
    private JPanel contentPane;
    public static JTable studentTable;
    private JTextField filterField;

    public StudentListTable(List<Student> students) {
        this.students = students;

        setTitle("Student List Table");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // new JPanel to contain the components
        contentPane = new JPanel(new BorderLayout());
        setContentPane(contentPane);

        // new JTable to display the student data
        StudentTableModel studentTableModel = new StudentTableModel(students);
        studentTable = new JTable(studentTableModel);

        // "Remove" button
        JButton removeButton = new JButton("Remove");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = studentTable.getSelectedRow();
                if (selectedRow != -1) {
                    studentTableModel.removeRow(selectedRow);
                }
            }
        });

        // "Add Student" button
        JButton addStudentButton = new JButton("Add Student");
        addStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = JOptionPane.showInputDialog("Enter first name:");
                String lastName = JOptionPane.showInputDialog("Enter last name:");
                String yearOfBirth = JOptionPane.showInputDialog("Enter year of birth:");
                String points = JOptionPane.showInputDialog("Enter points:");
                String email = JOptionPane.showInputDialog("Enter email:");
                if (firstName != null && lastName != null && email != null) {
                    Student newStudent = new Student(firstName, lastName, StudentCondition.DOING, Integer.parseInt(yearOfBirth),Double.parseDouble(points),email);
                    addStudent(newStudent);
                }
            }

        });

        // "Edit" button
        JButton editButton = new JButton("Edit");
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = studentTable.getSelectedRow();
                if (selectedRow != -1) {
                    Student student = students.get(selectedRow);
                    new EditStudentWindow(student);
                }
            }
        });

        JButton sortButton = new JButton("Sort by Last Name");
        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Collections.sort(students, new Comparator<Student>() {
                    @Override
                    public int compare(Student s1, Student s2) {
                        return s1.getName().compareTo(s2.getName());
                    }
                });
                studentTableModel.fireTableDataChanged();
            }
        });
        JTextField filterField = new JTextField();

        filterField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filterText = filterField.getText();
                List<Student> filteredStudents = new ArrayList<>();
                for (Student student : students) {
                    if (student.getFirstName().toLowerCase().contains(filterText.toLowerCase())) {
                        filteredStudents.add(student);
                    }
                }
                System.out.print(filteredStudents);
                studentTableModel.setStudents(filteredStudents);
            }
        });

        // panel to hold the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(removeButton);
        buttonPanel.add(editButton);
        buttonPanel.add(addStudentButton);
        buttonPanel.add(sortButton);

        // Add the table and button panel to the content pane
        JScrollPane scrollPane = new JScrollPane(studentTable);
        contentPane.add(scrollPane, BorderLayout.CENTER);
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
        contentPane.add(filterField, BorderLayout.NORTH);

        setSize(600, 400);
        setVisible(true);
    }

    public void refreshTable() {
        ((AbstractTableModel) studentTable.getModel()).fireTableDataChanged();
    }
    public void addStudent(Student student) {
        students.add(student);
        refreshTable();
    }
    public void setStudents(List<Student> students) {
        this.students = students;
        StudentTableModel studentTableModel = new StudentTableModel(students);
        studentTableModel.fireTableDataChanged();
    }

}

class StudentTableModel extends AbstractTableModel {
    private static final String[] COLUMN_NAMES = {"Name", "Surname","Year of Birth","Points","Email"};
    private static final int NAME_COL = 0;
    private static final int SURNAME_COL = 1;
    private static final int Year_COL = 2;
    private static final int Points_COL = 3;
    private static final int Email_COL = 4;

    private List<Student> students;

    public StudentTableModel(List<Student> students) {
        this.students = students;
    }

    @Override
    public int getRowCount() {
        return students.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return COLUMN_NAMES[columnIndex];
    }


    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Student student = students.get(rowIndex);

        if (columnIndex == NAME_COL) {
            return student.getFirstName();
        } else if (columnIndex == SURNAME_COL) {
            return student.getName();
        } else if (columnIndex == Year_COL) {
            return student.getYearOfBirth();
        }else if (columnIndex == Points_COL) {
            return student.getPoints();
        }else if (columnIndex == Email_COL) {
            return student.getEmail();
        }
        else {
            return null;
        }
    }

    // Remove a row from the table
    public void removeRow(int rowIndex) {
        students.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }

    public void setStudents(List<Student> filteredStudents) {
        this.students = students;
        StudentTableModel studentTableModel = new StudentTableModel(students);
        studentTableModel.fireTableDataChanged();
    }
}