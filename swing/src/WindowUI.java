import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class WindowUI {
    private GradebookManager gradebookManager;

    private JList<Student> studentsList;
    private JList<String> gradesList;
    private JTable studentsTable;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField gradeField;
    private JTextField presenceField;

    public GradebookUI() {
        this.gradebookManager = new GradebookManager();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Gradebook");

        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel studentsPanel = new JPanel();
        contentPane.add(studentsPanel, BorderLayout.WEST);
        studentsPanel.setLayout(new BorderLayout(0, 0));

        JLabel studentsLabel = new JLabel("Students");
        studentsPanel.add(studentsLabel, BorderLayout.NORTH);

        studentsList = new JList<>();
        studentsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        studentsList.setModel(new AbstractListModel<Student>() {
            @Override
            public int getSize() {
                return gradebookManager.getStudents().size();
            }

            @Override
            public Student getElementAt(int index) {
                return gradebookManager
    JFrame f;
    WindowUI(){
        f=new JFrame();
        /*String data[][]={ {"101","Amit","670000"},
                {"102","Jai","780000"},
                {"101","Sachin","700000"}};
        String column[]={"ID","NAME","SALARY"};*/
        JTable jt=new JTable(/*data,column*/);
        jt.setBounds(30,40,200,300);
        JScrollPane sp=new JScrollPane(jt);
        f.add(sp);
        f.setSize(300,400);
        f.setVisible(true);
    }
}