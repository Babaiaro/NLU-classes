
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * STUDENT CLASS
 * Represents the data model for our application.
 */
class Student {
    String id, firstName, lastName;
    Student(String id, String fn, String ln) {
        this.id = id; this.firstName = fn; this.lastName = ln;
    }
}

/**
 * MAIN GUI CLASS
 * Extends JFrame to create the window and implements the Student Management logic.
 */
public class StudentManagementGUI extends JFrame {
    private ArrayList<Student> studentList = new ArrayList<>();
    private DefaultTableModel tableModel;
    private JTable studentTable;
    private JTextField txtId, txtFirstName, txtLastName;

    public StudentManagementGUI() {
        // --- Window Setup ---
        setTitle("Student Management System - Phase 3");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // --- Top Form Panel (Input Validation) ---
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        formPanel.setBorder(BorderFactory.createTitledBorder("Add / Update Student"));

        formPanel.add(new JLabel("Student ID:"));
        txtId = new JTextField(); formPanel.add(txtId);
        formPanel.add(new JLabel("First Name:"));
        txtFirstName = new JTextField(); formPanel.add(txtFirstName);
        formPanel.add(new JLabel("Last Name:"));
        txtLastName = new JTextField(); formPanel.add(txtLastName);

        JButton btnAdd = new JButton("Add Student");
        JButton btnDelete = new JButton("Delete Selected");
        formPanel.add(btnAdd);
        formPanel.add(btnDelete);

        add(formPanel, BorderLayout.NORTH);

        // --- Center Table Panel (Displaying Student List) ---
        String[] columns = {"ID", "First Name", "Last Name"};
        tableModel = new DefaultTableModel(columns, 0);
        studentTable = new JTable(tableModel);
        add(new JScrollPane(studentTable), BorderLayout.CENTER);

        // --- Bottom Status Bar ---
        JLabel lblStatus = new JLabel(" Ready");
        add(lblStatus, BorderLayout.SOUTH);

        // --- ACTION: Add Student with Validation ---
        btnAdd.addActionListener(e -> {
            String id = txtId.getText().trim();
            String fn = txtFirstName.getText().trim();
            String ln = txtLastName.getText().trim();

            if (id.isEmpty() || fn.isEmpty() || ln.isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fields are required!", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            studentList.add(new Student(id, fn, ln));
            refreshTable();
            clearFields();
            lblStatus.setText(" Student added successfully.");
        });

        // --- ACTION: Delete Student ---
        btnDelete.addActionListener(e -> {
            int selectedRow = studentTable.getSelectedRow();
            if (selectedRow >= 0) {
                studentList.remove(selectedRow);
                refreshTable();
                lblStatus.setText(" Student deleted.");
            } else {
                JOptionPane.showMessageDialog(this, "Please select a student from the table.");
            }
        });

        // --- BONUS: Multithreading (Simulating background Save) ---
        JButton btnSave = new JButton("Save Data (Background)");
        formPanel.add(btnSave);
        btnSave.addActionListener(e -> {
            btnSave.setEnabled(false);
            lblStatus.setText(" Saving in background...");
            
            // SwingWorker handles the task on a separate thread
            new SwingWorker<Void, Void>() {
                @Override
                protected Void doInBackground() throws Exception {
                    Thread.sleep(2000); // Simulate file I/O delay
                    return null;
                }
                @Override
                protected void done() {
                    lblStatus.setText(" Data saved successfully.");
                    btnSave.setEnabled(true);
                }
            }.execute();
        });

        setVisible(true);
    }

    private void refreshTable() {
        tableModel.setRowCount(0);
        for (Student s : studentList) {
            tableModel.addRow(new Object[]{s.id, s.firstName, s.lastName});
        }
    }

    private void clearFields() {
        txtId.setText(""); txtFirstName.setText(""); txtLastName.setText("");
    }

    public static void main(String[] args) {
        // Run the GUI on the Event Dispatch Thread
        SwingUtilities.invokeLater(StudentManagementGUI::new);
    }
}