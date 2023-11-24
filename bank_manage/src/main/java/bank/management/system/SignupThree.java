package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.util.Random;

public class SignupThree extends JFrame implements ActionListener{

    JButton submit, cancel;
    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    String formno;
    SignupThree(String formno) {
        this.formno = formno;
        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");

        JLabel AccountDetails = new JLabel("Page3: AccountDetails");
        AccountDetails.setFont(new Font("Raleway", Font.BOLD,20 ));
        AccountDetails.setBounds(150,80,400,30);
        add(AccountDetails);

        JLabel Type = new JLabel("Account Type");
        Type.setFont(new Font("Raleway", Font.BOLD, 20));
        Type.setBounds(50,160,400, 30);
        add(Type);

        r1 = new JRadioButton("Saving Account:");
        r1.setFont(new Font("Raleway", Font.BOLD, 12));
        r1.setBounds(50,200,250,20);
        r1.setBackground(Color.white);
        add(r1);

        r2 = new JRadioButton("Fixed Deposit Account:");
        r2.setFont(new Font("Raleway", Font.BOLD, 12));
        r2.setBounds(300,200,250,20);
        r2.setBackground(Color.white);
        add(r2);

        r3 = new JRadioButton("Current Account:");
        r3.setFont(new Font("Raleway", Font.BOLD, 12));
        r3.setBounds(50,250,250,20);
        r3.setBackground(Color.white);
        add(r3);

        r4 = new JRadioButton("Recuuring Deposit Account:");
        r4.setFont(new Font("Raleway", Font.BOLD, 12));
        r4.setBounds(300,250,250,20);
        r4.setBackground(Color.white);
        add(r4);

        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);

        JLabel card = new JLabel("Card Number:");
        card.setFont(new Font("Raleway",Font.BOLD, 20));
        card.setBounds(50, 290, 200,30);
        add(card);

        JLabel number = new JLabel("xxxx-xxxx-xxxx-7414");
        number.setFont(new Font("Raleway",Font.BOLD, 20));
        number.setBounds(250, 290, 300,30);
        add(number);

        JLabel carddetail = new JLabel("your 16 Digit Card Number");
        carddetail.setFont(new Font("Raleway",Font.BOLD, 12));
        carddetail.setBounds(50, 315, 200,15);
        add(carddetail);

        JLabel Pin = new JLabel("PIN:");
        Pin.setFont(new Font("Raleway",Font.BOLD, 20));
        Pin.setBounds(50, 330, 200,30);
        add(Pin);

        JLabel Pnumber = new JLabel("xxxx");
        Pnumber.setFont(new Font("Raleway",Font.BOLD, 20));
        Pnumber.setBounds(250, 330, 200,30);
        add(Pnumber);

        JLabel pindetail = new JLabel("your 4 Digit Card Number");
        pindetail.setFont(new Font("Raleway",Font.BOLD, 12));
        pindetail.setBounds(50, 355, 200,15);
        add(pindetail);

        JLabel services = new JLabel("service Required:");
        services.setFont(new Font("Raleway",Font.BOLD, 20));
        services.setBounds(50, 370, 200,30);
        add(services);

        c1= new JCheckBox("ATM CARD");
        c1.setBackground(Color.white);
        c1.setFont(new Font("Raleway",Font.BOLD, 12));
        c1.setBounds(50,410,200,30);
        add(c1);

        c2= new JCheckBox("Mobile Banking");
        c2.setBackground(Color.white);
        c2.setFont(new Font("Raleway",Font.BOLD, 12));
        c2.setBounds(50,440,200,30);
        add(c2);

        c3= new JCheckBox("Cheque Book");
        c3.setBackground(Color.white);
        c3.setFont(new Font("Raleway",Font.BOLD, 12));
        c3.setBounds(50,470,200,30);
        add(c3);

        c4= new JCheckBox("Internet Banking");
        c4.setBackground(Color.white);
        c4.setFont(new Font("Raleway",Font.BOLD, 12));
        c4.setBounds(250,410,200,30);
        add(c4);

        c5= new JCheckBox("EMAIL ");
        c5.setBackground(Color.white);
        c5.setFont(new Font("Raleway",Font.BOLD, 12));
        c5.setBounds(250,440,200,30);
        add(c5);

        c6= new JCheckBox("E-statement");
        c6.setBackground(Color.white);
        c6.setFont(new Font("Raleway",Font.BOLD, 12));
        c6.setBounds(250,470,200,30);
        add(c6);

        c7= new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge");
        c7.setBackground(Color.white);
        c7.setFont(new Font("Raleway",Font.BOLD, 12));
        c7.setBounds(50,520,600,30);
        add(c7);

        submit = new JButton("Submit");
        submit.setBounds(400,570,100,30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(520,570,100,30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.white);


        setSize(650,650);
        setLocation(250,40);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit){
            String accountType = null;
            if(r1.isSelected()){
                accountType = "Saving Account";
            }else if (r2.isSelected()){
                accountType = "Fixed Deposit Account";
            }else if (r3.isSelected()){
                accountType = "Current Account";
            }else if (r4.isSelected()){
                accountType = "Recuring Deposit Account:";
            }
            Random random = new Random();
            String cardnumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);

            String pinnumber = "" + Math.abs((random.nextLong() % 9000L)+ 1000L);

            String facility = "";
            if (c1.isSelected()) {
                facility = facility + " ATM Card";
            }
            if (c2.isSelected()) {
                facility = facility + " Mobile Banking";
            }
            if (c3.isSelected()) {
                facility = facility + " cheque Book";
            }
            if (c4.isSelected()) {
                facility = facility + " Internet Banking";
            }
            if (c5.isSelected()) {
                facility = facility + " EMAIL";
            }
            if (c6.isSelected()) {
                facility = facility + " E-statement";
            }

            try{
                if (c7.isSelected()) {
                    if (accountType.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Account Type is Required");
                    } else {
                        Conn c = new Conn();
                    //    String query1 = "insert into bankmanagementsystem.signup3 values ('"+formno+"','"+accountType+"', '"+cardnumber+"', '"+pinnumber+"', '"+facility+"')";
                    //    String query2 = "insert into bankmanagementsystem.login values ('"+formno+"', '"+cardnumber+"', '"+pinnumber+"')";
                        PreparedStatement ps = c.c.prepareStatement("insert into bankmanagementsystem.signup3 (formno, accountType, cardnumber, pinnumber, facility) values(?,?,?,?,?)");
                        ps.setString(1, formno);
                        ps.setString(2, accountType);
                        ps.setString(3, cardnumber);
                        ps.setString(4, pinnumber);
                        ps.setString(5, facility);
                        PreparedStatement ps2 = c.c.prepareStatement("insert into bankmanagementsystem.login (formno, cardnumber, pin) values(?,?,?)");
                        ps2.setString(1, formno);
                        ps2.setString(2, cardnumber);
                        ps2.setString(3, pinnumber);
                        ps.executeUpdate();
                        ps2.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Card Number:" + cardnumber + "\n Pin: " + pinnumber);

                        setVisible(false);
                        new Deposit(pinnumber).setVisible(false);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Please check the declaration options.");
                }
            }catch (Exception e) {
                System.out.println(e);
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main (String args[]) {

        new SignupThree("");
    }
}
