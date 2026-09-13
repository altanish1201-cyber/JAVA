import javax.swing.*;
import java.awt.event.*;

public class StudentRegistrationDemo {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Student Registration Form");

        JLabel l1 = new JLabel("Roll No:");
        l1.setBounds(30, 30, 80, 25);

        JTextField t1 = new JTextField();
        t1.setBounds(120, 30, 150, 25);

        JLabel l2 = new JLabel("Name:");
        l2.setBounds(30, 70, 80, 25);

        JTextField t2 = new JTextField();
        t2.setBounds(120, 70, 150, 25);

        JLabel l3 = new JLabel("Course:");
        l3.setBounds(30, 110, 80, 25);

        JTextField t3 = new JTextField();
        t3.setBounds(120, 110, 150, 25);

        JButton button = new JButton("Register");
        button.setBounds(100, 160, 100, 30);

        JLabel label = new JLabel();
        label.setBounds(30, 200, 280, 30);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText("Student Registered Successfully!");
            }
        });

        frame.add(l1);
        frame.add(t1);
        frame.add(l2);
        frame.add(t2);
        frame.add(l3);
        frame.add(t3);
        frame.add(button);
        frame.add(label);

        frame.setSize(330, 280);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}