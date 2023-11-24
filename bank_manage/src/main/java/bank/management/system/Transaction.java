package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Transaction extends JFrame implements ActionListener{
    JButton deposit, withdrawl, fastcash, ministatement, pinchange, balanceenquiry, exit;
    JLabel text,image;
    String pin;
    Transaction(String pin){
        this.pin=pin;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0,0,700,700);
        add(image);

        text = new JLabel("Please select your Transaction");
        text.setBounds(225, 350, 500, 35);
        text.setForeground(Color.black);
        text.setFont(new Font("System", Font.BOLD, 11));
        image.add(text);

        deposit = new JButton("deposit");

        deposit.setBounds(210,395,95,20);
        deposit.setFont(new Font("System", Font.BOLD, 11));
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawl = new JButton("Cash withdrawl");
        withdrawl.setBounds(210,415,95,20);
        withdrawl.setFont(new Font("System", Font.BOLD, 8));
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fastcash = new JButton("fastcash");
        fastcash.setBounds(210,435,95,20);
        fastcash.setFont(new Font("System", Font.BOLD, 12));
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement = new JButton("ministatement");
        ministatement.setBounds(305,395,95,20);
        ministatement.setFont(new Font("System", Font.BOLD, 8));
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinchange = new JButton("Pin change");
        pinchange.setBounds(305,415,95,20);
        pinchange.setFont(new Font("System", Font.BOLD, 8));
        pinchange.addActionListener(this);
        image.add(pinchange);

        balanceenquiry = new JButton("Balanceenquiry");
        balanceenquiry.setBounds(305,435,95,20);
        balanceenquiry.setFont(new Font("System", Font.BOLD, 8));
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);

        exit = new JButton("Exit");
        exit.setBounds(305,455,95,20);
        exit.setFont(new Font("System", Font.BOLD, 12));
        exit.addActionListener(this);
        image.add(exit);

        setSize(700,700);
        setLocation(300,0);
        //setUndecorated(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit) {
            System.exit(0);
        } else if (ae.getSource() == deposit) {
            setVisible(false);
            new Deposit(pin).setVisible(true);
        } else if (ae.getSource() == withdrawl) {
            setVisible(false);
            new Withdrawl(pin).setVisible(true);
        } else if (ae.getSource() == fastcash) {
            setVisible(false);
            new Fastcash(pin).setVisible(true);
        } else if (ae.getSource() == pinchange) {
            setVisible(false);
            new Pinchange(pin).setVisible(true);
        } else if (ae.getSource() == balanceenquiry) {
            setVisible(false);
            new BalanceEnquiry(pin).setVisible(true);
        } else if (ae.getSource() == ministatement) {
            setVisible(false);
            new Ministatement(pin).setVisible(true);
        }
    }
    public static void main(String args[]){
        new Transaction("");
    }
}
