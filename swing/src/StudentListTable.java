import javax.swing.table.AbstractTableModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class StudentListTable extends JFrame {
    private List<Student> students;
    private JPanel contentPane;
    public static JTable studentTable;
        public StudentListTable(List<Student> students) {
            this.students = students;

            setTitle("Student List Table");
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            // Create a new JPanel to contain the components
            contentPane = new JPanel(new BorderLayout());
            setContentPane(contentPane);

            // Create a new JTable to display the student data
            StudentTableModel studentTableModel = new StudentTableModel(students);
            studentTable = new JTable(studentTableModel);

            // Add a "Remove" button to delete the selected row
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

            // Add an "Edit" button to edit the selected row
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

            // Create a panel to hold the "Remove" and "Edit" buttons
            JPanel buttonPanel = new JPanel();
            buttonPanel.add(removeButton);
            buttonPanel.add(editButton);

            // Add the table and button panel to the content pane
            JScrollPane scrollPane = new JScrollPane(studentTable);
            contentPane.add(scrollPane, BorderLayout.CENTER);
            contentPane.add(buttonPanel, BorderLayout.SOUTH);

            // Set the size of the JFrame and make it visible
            setSize(400, 400);
            setVisible(true);
        }
    // Call this method to refresh the data in the table
    public void refreshTable() {
        ((AbstractTableModel) studentTable.getModel()).fireTableDataChanged();
    }
}

class StudentTableModel extends AbstractTableModel {
    private static final String[] COLUMN_NAMES = {"Name", "Surname", "Email"};
    private static final int NAME_COL = 0;
    private static final int SURNAME_COL = 1;
    private static final int EMAIL_COL = 2;

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
        } else if (columnIndex == EMAIL_COL) {
            return student.getEmail();
        } else {
            return null;
        }
    }

    // Remove a row from the table
    public void removeRow(int rowIndex) {
        students.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }
}