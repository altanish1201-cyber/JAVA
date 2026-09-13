import javax.swing.*;
import java.awt.event.*;

public class BankBalanceDemo {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Bank Balance Calculator");

        JLabel l1 = new JLabel("Initial Balance:");
        l1.setBounds(30, 30, 110, 25);

        JTextField t1 = new JTextField();
        t1.setBounds(150, 30, 130, 25);

        JLabel l2 = new JLabel("Amount:");
        l2.setBounds(30, 70, 110, 25);

        JTextField t2 = new JTextField();
        t2.setBounds(150, 70, 130, 25);

        JButton bDeposit = new JButton("Deposit");
        bDeposit.setBounds(40, 120, 100, 30);

        JButton bWithdraw = new JButton("Withdraw");
        bWithdraw.setBounds(160, 120, 100, 30);

        JLabel label = new JLabel();
        label.setBounds(30, 170, 260, 30);

        bDeposit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double balance = Double.parseDouble(t1.getText());
                double amount = Double.parseDouble(t2.getText());
                balance += amount;
                t1.setText(String.valueOf(balance));
                label.setText("Updated Balance: ₹" + balance);
            }
        });

        bWithdraw.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double balance = Double.parseDouble(t1.getText());
                double amount = Double.parseDouble(t2.getText());
                if (amount > balance) {
                    label.setText("Insufficient Balance!");
                } else {
                    balance -= amount;
                    t1.setText(String.valueOf(balance));
                    label.setText("Updated Balance: ₹" + balance);
                }
            }
        });

        frame.add(l1);
        frame.add(t1);
        frame.add(l2);
        frame.add(t2);
        frame.add(bDeposit);
        frame.add(bWithdraw);
        frame.add(label);

        frame.setSize(330, 260);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}