import javax.swing.table.AbstractTableModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClassInterface extends JFrame {
    private Class classInstance;
    private JPanel contentPane;
    private JTable classTable;

    public ClassInterface(Class classInstance) {
        this.classInstance = classInstance;

        setTitle("Class Interface");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a new JPanel to contain the components
        contentPane = new JPanel(new BorderLayout());
        setContentPane(contentPane);

        // Create a new JTable to display the class data
        ClassTableModel classTableModel = new ClassTableModel(classInstance);
        classTable = new JTable(classTableModel);

        // Add MouseListener to the JTable
        classTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = classTable.rowAtPoint(e.getPoint());
                int col = classTable.columnAtPoint(e.getPoint());
                System.out.println("Clicked on row " + row + ", column " + col);
                StudentListTable studentListTable = new StudentListTable(classInstance.getStudents());
                studentListTable.setVisible(true);
            }
        });

        JScrollPane scrollPane = new JScrollPane(classTable);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        // Set the size of the JFrame and make it visible
        setSize(400, 400);
        setVisible(true);
    }
}

class ClassTableModel extends AbstractTableModel {
    private static final String[] COLUMN_NAMES = {"Group Name", "Student List", "Max Students"};
    private static final int GROUP_NAME_COL = 0;
    private static final int STUDENT_LIST_COL = 1;
    private static final int MAX_STUDENTS_COL = 2;


    private Class classInstance;

    public ClassTableModel(Class classInstance) {
        this.classInstance = classInstance;
    }

    @Override
    public int getRowCount() {
        return 1;
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
    public java.lang.Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 0) {
            return String.class;
        } else if (columnIndex == 1) {
            return String.class;
        } else {
            return Integer.class;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == GROUP_NAME_COL) {
            return classInstance.getGroupName();
        } else if (columnIndex == STUDENT_LIST_COL) {
            return classInstance.getStudents().size();
        } else if (columnIndex == MAX_STUDENTS_COL) {
            return classInstance.getMaxStudents();
        } else {
            return null;
        }
    }

}