package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;


public class Fastcash extends JFrame implements ActionListener{
    JButton thousand, three_thousand, five_thousand, ten_thousand, thirty_thousand, fifty_thousand, exit;
    JLabel text,image;
    String pin;
    Fastcash(String pin){
        this.pin=pin;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0,0,700,700);
        add(image);

        text = new JLabel("Select withdrawl amount");
        text.setBounds(245, 350, 500, 35);
        text.setForeground(Color.black);
        text.setFont(new Font("System", Font.BOLD, 11));
        image.add(text);

        thousand = new JButton("NTD1000");
        thousand.setBounds(210,395,95,20);
        thousand.setFont(new Font("System", Font.BOLD, 12));
        thousand.addActionListener(this);
        image.add(thousand);

        three_thousand = new JButton("NTD3000");
        three_thousand.setBounds(210,415,95,20);
        three_thousand.setFont(new Font("System", Font.BOLD, 12));
        three_thousand.addActionListener(this);
        image.add(three_thousand);

        five_thousand = new JButton("NTD5000");
        five_thousand.setBounds(210,435,95,20);
        five_thousand.setFont(new Font("System", Font.BOLD, 12));
        five_thousand.addActionListener(this);
        image.add(five_thousand);



        ten_thousand = new JButton("NTD10000");
        ten_thousand.setBounds(305,395,95,20);
        ten_thousand.setFont(new Font("System", Font.BOLD, 12));
        ten_thousand.addActionListener(this);
        image.add(ten_thousand);

        thirty_thousand = new JButton("NTD30000");
        thirty_thousand.setBounds(305,415,95,20);
        thirty_thousand.setFont(new Font("System", Font.BOLD, 12));
        thirty_thousand.addActionListener(this);
        image.add(thirty_thousand);

        fifty_thousand = new JButton("NTD50000");
        fifty_thousand.setBounds(305,435,95,20);
        fifty_thousand.setFont(new Font("System", Font.BOLD, 12));
        fifty_thousand.addActionListener(this);
        image.add(fifty_thousand);

        exit = new JButton("Back");
        exit.setBounds(305,455,95,20);
        exit.setFont(new Font("System", Font.BOLD, 12));
        exit.addActionListener(this);
        image.add(exit);

        setSize(700,700);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == exit){
            setVisible(false);
            new Transaction(pin).setVisible(true);
        } else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            System.out.println(amount);
            Conn c = new Conn();
            try{
                String sql = "select * from bankmanagementsystem.bank where pin = ?";
                PreparedStatement ps = c.c.prepareStatement(sql);
                ps.setString(1,pin);
                ResultSet rs = ps.executeQuery();
                int balance = 0;
                while(rs.next()){
                    if (rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if (ae.getSource() != exit && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }

                Date date = new Date();
                PreparedStatement ps2 = c.c.prepareStatement("insert into bankmanagementsystem.bank (pin, date, type, amount) values(?,?,?,?)");
                ps2.setString(1,pin);
                ps2.setString(2,String.valueOf(date));
                ps2.setString(3,"withdrawl");
                ps2.setString(4,amount);
                ps2.executeUpdate();
                JOptionPane.showMessageDialog(null, amount + "Debited Successfully");

                setVisible(false);
                new Transaction(pin).setVisible(true);
            } catch (Exception e){
                System.out.println(e);
            }
        }
    }
    public static void main(String args[]){
        new Fastcash("");
    }
}
