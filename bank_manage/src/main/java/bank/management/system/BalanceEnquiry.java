package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {

//寫串接資料庫顯示內容
    JButton back;
    JLabel image, text, text2;
    String pin;

    BalanceEnquiry(String pin) {
        this.pin = pin;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0,0,700,700);
        add(image);


        back = new JButton("Back");
        back.setFont(new Font("System", Font.BOLD, 12));
        back.setBounds(305,460,95,20);
        back.addActionListener(this);
        image.add(back);

        Conn conn = new Conn();
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
            text = new JLabel("your current ");
            text.setForeground(Color.black);
            text.setFont(new Font("System", Font.BOLD, 12));
            text.setBounds(255,350,200,20);
            image.add(text);

            text2 = new JLabel("Account balance: "+ balance);
            text2.setForeground(Color.black);
            text2.setFont(new Font("System", Font.BOLD, 12));
            text2.setBounds(250,370,400,20);
            image.add(text2);

        } catch (Exception e) {
            System.out.println(e);
        }

        setSize(700,700);
        setLocation(300,0);
        //setUndecorated(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back){
            setVisible(false);
            new Transaction(pin).setVisible(true);
        }
    }

    public static void main(String ards[]){
        new BalanceEnquiry("");
    }
}
