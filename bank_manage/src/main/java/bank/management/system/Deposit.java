package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.util.*;

public class Deposit extends JFrame implements ActionListener {

    JLabel text,text2,image;
    JButton deposit,back;
    JTextField amount;
    String pin;
    Deposit(String pin) {
        this.pin=pin;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(10,10,700,700);
        add(image);

        text = new JLabel("Enter the amount " );
        text.setForeground(Color.black);
        text.setFont(new Font("System", Font.BOLD, 12));
        text.setBounds(255,350,200,20);
        image.add(text);

        text2 = new JLabel("you want to deposit");
        text2.setForeground(Color.black);
        text2.setFont(new Font("System", Font.BOLD, 12));
        text2.setBounds(250,370,400,20);
        image.add(text2);

        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 12));
        amount.setBounds(230, 400, 150, 20);
        image.add(amount);

        deposit = new JButton("Deposit");
        deposit.setFont(new Font("System", Font.BOLD, 12));
        deposit.setBounds(305,440,95,20);
        deposit.addActionListener(this);
        image.add(deposit);

        back = new JButton("Back");
        back.setFont(new Font("System", Font.BOLD, 12));
        back.setBounds(305,460,95,20);
        back.addActionListener(this);
        image.add(back);

        setSize(700,700);
        setLocation(300,0);
        //setUndecorated(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == deposit) {
            String number = amount.getText();
            Date date = new Date();
            if (number.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Plaese enter the amount you want to deposit.");
            } else {
                try {
                    Conn conn = new Conn();
//                  String query = "insert into bankmanagementsystem.bank value ('" + pin + "', '" + date + "', 'Deposit', '" + number + "')";
                    PreparedStatement ps = conn.c.prepareStatement("insert into bankmanagementsystem.bank (pin, date, type, amount) values(?,?,?,?)");
                    ps.setString(1,pin);
                    ps.setString(2,String.valueOf(date));
                    ps.setString(3,"Deposit");
                    ps.setString(4,number);
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, number+" Deposit Successfully");
                    setVisible(false);
                    new Transaction(pin).setVisible(true);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } else if (ae.getSource() == back){
            setVisible(false);
            new Transaction(pin).setVisible(true);
        }
    }

    public static void main(String args[]) {

        new Deposit("");
    }
}
