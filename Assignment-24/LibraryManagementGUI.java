import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class LibraryManagementGUI {
    private static final String URL = "jdbc:mysql://localhost:3306/jdbc";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        JFrame frame = new JFrame("Library Management System");

        JLabel l1 = new JLabel("Book ID:");
        l1.setBounds(30, 30, 90, 25);
        JTextField t1 = new JTextField();
        t1.setBounds(130, 30, 150, 25);

        JLabel l2 = new JLabel("Title:");
        l2.setBounds(30, 70, 90, 25);
        JTextField t2 = new JTextField();
        t2.setBounds(130, 70, 150, 25);

        JLabel l3 = new JLabel("Author:");
        l3.setBounds(30, 110, 90, 25);
        JTextField t3 = new JTextField();
        t3.setBounds(130, 110, 150, 25);

        JLabel l4 = new JLabel("Price:");
        l4.setBounds(30, 150, 90, 25);
        JTextField t4 = new JTextField();
        t4.setBounds(130, 150, 150, 25);

        JButton bAdd = new JButton("Add Book");
        bAdd.setBounds(100, 200, 110, 30);

        bAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String sql = "INSERT INTO library_books (book_id, title, author, price) VALUES (?, ?, ?, ?)";
                try (Connection con = DriverManager.getConnection(URL, USER, PASS);
                     PreparedStatement pstmt = con.prepareStatement(sql)) {

                    pstmt.setInt(1, Integer.parseInt(t1.getText()));
                    pstmt.setString(2, t2.getText());
                    pstmt.setString(3, t3.getText());
                    pstmt.setDouble(4, Double.parseDouble(t4.getText()));

                    pstmt.executeUpdate();
                    JOptionPane.showMessageDialog(frame, "Book Added Successfully!");

                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
                }
            }
        });

        frame.add(l1); frame.add(t1);
        frame.add(l2); frame.add(t2);
        frame.add(l3); frame.add(t3);
        frame.add(l4); frame.add(t4);
        frame.add(bAdd);

        frame.setSize(330, 290);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}