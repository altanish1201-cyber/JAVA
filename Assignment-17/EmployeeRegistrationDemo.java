import javax.swing.*;
import java.awt.event.*;

public class EmployeeRegistrationDemo {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Employee Registration Form");

        JLabel l1 = new JLabel("Emp ID:");
        l1.setBounds(30, 30, 90, 25);

        JTextField t1 = new JTextField();
        t1.setBounds(130, 30, 150, 25);

        JLabel l2 = new JLabel("Name:");
        l2.setBounds(30, 70, 90, 25);

        JTextField t2 = new JTextField();
        t2.setBounds(130, 70, 150, 25);

        JLabel l3 = new JLabel("Department:");
        l3.setBounds(30, 110, 90, 25);

        JTextField t3 = new JTextField();
        t3.setBounds(130, 110, 150, 25);

        JLabel l4 = new JLabel("Salary:");
        l4.setBounds(30, 150, 90, 25);

        JTextField t4 = new JTextField();
        t4.setBounds(130, 150, 150, 25);

        JButton button = new JButton("Submit");
        button.setBounds(110, 200, 100, 30);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = t1.getText();
                String name = t2.getText();
                String dept = t3.getText();
                String salary = t4.getText();

                String info = "Employee Details:\n"
                            + "ID: " + id + "\n"
                            + "Name: " + name + "\n"
                            + "Department: " + dept + "\n"
                            + "Salary: " + salary;

                JOptionPane.showMessageDialog(frame, info);
            }
        });

        frame.add(l1);
        frame.add(t1);
        frame.add(l2);
        frame.add(t2);
        frame.add(l3);
        frame.add(t3);
        frame.add(l4);
        frame.add(t4);
        frame.add(button);

        frame.setSize(330, 290);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}