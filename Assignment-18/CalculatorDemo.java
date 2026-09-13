import javax.swing.*;
import java.awt.event.*;

public class CalculatorDemo {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Simple Calculator");

        JLabel l1 = new JLabel("First Number:");
        l1.setBounds(30, 30, 100, 25);

        JTextField t1 = new JTextField();
        t1.setBounds(140, 30, 140, 25);

        JLabel l2 = new JLabel("Second Number:");
        l2.setBounds(30, 70, 100, 25);

        JTextField t2 = new JTextField();
        t2.setBounds(140, 70, 140, 25);

        JButton bAdd = new JButton("Add");
        bAdd.setBounds(50, 120, 80, 30);

        JButton bSub = new JButton("Sub");
        bSub.setBounds(160, 120, 80, 30);

        JLabel label = new JLabel();
        label.setBounds(30, 170, 250, 30);

        bAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double a = Double.parseDouble(t1.getText());
                double b = Double.parseDouble(t2.getText());
                double result = a + b;
                label.setText("Result: " + result);
            }
        });

        bSub.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double a = Double.parseDouble(t1.getText());
                double b = Double.parseDouble(t2.getText());
                double result = a - b;
                label.setText("Result: " + result);
            }
        });

        frame.add(l1);
        frame.add(t1);
        frame.add(l2);
        frame.add(t2);
        frame.add(bAdd);
        frame.add(bSub);
        frame.add(label);

        frame.setSize(330, 260);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}