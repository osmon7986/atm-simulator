package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener {

    JLabel text, text2, image;
    JButton withdrawl, back;
    JTextField amount;
    String pin;
    Withdrawl(String pin) {
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

        text2 = new JLabel("you want to withdrawl");
        text2.setForeground(Color.black);
        text2.setFont(new Font("System", Font.BOLD, 12));
        text2.setBounds(250,370,400,20);
        image.add(text2);

        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 12));
        amount.setBounds(230, 400, 150, 20);
        image.add(amount);

        withdrawl = new JButton("Withdrawl");
        withdrawl.setFont(new Font("System", Font.BOLD, 12));
        withdrawl.setBounds(305,440,95,20);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

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
        if (ae.getSource() == withdrawl) {
            String number = amount.getText();
            Date date = new Date();
            Conn conn = new Conn();
            if (number.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Plaese enter the amount you want to withdrawl.");
            } else {
                try {
                    String sql = "select type, amount from bankmanagementsystem.bank where pin = ?";
                    PreparedStatement ps2 = conn.c.prepareStatement(sql);
                    ps2.setString(1,pin);
                    ResultSet rs = ps2.executeQuery();
                    int balance = 0;
                    while(rs.next()) {
                        if (rs.getString("type").equals("Deposit")) {
                            balance += Integer.parseInt(rs.getString("amount"));
                        } else {
                            balance -= Integer.parseInt(rs.getString("amount"));
                        }
                    }
                    if (ae.getSource() != back && balance < Integer.parseInt(number)){
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }
                    //String query = "insert into bankmanagementsystem.bank value ('" + pin + "', '" + date + "', 'Withdrawl', '" + number + "')";
                    //conn.s.executeUpdate(query);
                    PreparedStatement ps = conn.c.prepareStatement("insert into bankmanagementsystem.bank (pin, date, type, amount) values(?,?,?,?)");
                    ps.setString(1,pin);
                    ps.setString(2,String.valueOf(date));
                    ps.setString(3,"withdrawl");
                    ps.setString(4,number);
                    ps.executeUpdate();

                    JOptionPane.showMessageDialog(null, number+" Withdrawl Successfully");
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

        new Withdrawl("");
    }
}
