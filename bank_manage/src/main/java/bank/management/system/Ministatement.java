package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class Ministatement extends JFrame implements ActionListener {
    JLabel text, bank, card, text2;
    JButton back;
    String pin;
    Ministatement(String pin) {
        this.pin = pin;
        setTitle("Mini Statement");

        setLayout(null);

        text = new JLabel();
        text.setBounds(20, 140, 400, 200);
        add(text);

        bank = new JLabel("Bank");
        bank.setBounds(150,20,100,20);
        add(bank);

        card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        back = new JButton("Back");
        back.setFont(new Font("System", Font.BOLD, 12));
        back.setBounds(250,460,95,20);
        back.addActionListener(this);
        add(back);



        Conn c = new Conn();
        try{

            String sql="SELECT * from bankmanagementsystem.login where pin = ?";
            PreparedStatement ps = c.c.prepareStatement(sql);
            ps.setString(1,pin);
            ResultSet rs =ps.executeQuery();
            while(rs.next()) {
                card.setText("Card Number: " + rs.getString("cardnumber").substring(0, 4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        try{
            PreparedStatement ps = c.c.prepareStatement("SELECT * FROM bankmanagementsystem.bank where pin = ?");
            ps.setString(1,pin);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                text.setText(text.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            String sql = "select type, amount from bankmanagementsystem.bank where pin = ?";
            PreparedStatement ps = c.c.prepareStatement(sql);
            ps.setString(1, pin);
            ResultSet rs = ps.executeQuery();
            int balance = 0;
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            text2 = new JLabel("Your current Account balance is "+ balance);
            text2.setForeground(Color.black);
            text2.setFont(new Font("System", Font.BOLD, 12));
            text2.setBounds(20,370,400,20);
            add(text2);
        }catch (Exception e){
            System.out.println(e);
        }
        setSize(400,600);
        setLocation(20,0);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new Transaction(pin).setVisible(true);
        }
    }

    public static void main(String args[]) {

        new Ministatement("");
    }
}


