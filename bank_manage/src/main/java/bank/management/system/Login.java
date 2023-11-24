package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.concurrent.locks.ReadWriteLock;

public class Login extends JFrame implements ActionListener{
    JButton signin,signup,clear;
    JTextField cardtextfield;
    JPasswordField pintextfield;
    JLabel label, text, cardno, pin;
    Login(){

        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tiger.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        label = new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);

        text = new JLabel("welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200,40,250, 40);
        add(text);

        cardtextfield = new JTextField();
        cardtextfield.setBounds(300,150,250,30);
        cardtextfield.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardtextfield);

        cardno = new JLabel("Card No:");
        cardno.setFont(new Font("Raleway", Font.BOLD, 38));
        cardno.setBounds(120,150,250, 30);
        add(cardno);

        pintextfield = new JPasswordField();
        pintextfield.setBounds(300,220,250,30);
        add(pintextfield);

        pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 38));
        pin.setBounds(120,220,250, 30);
        add(pin);

        signin = new JButton("SIGN IN");
        signin.setBounds(300,300,100,30);
        signin.setBackground(Color.black);
        signin.setForeground(Color.white);
        signin.addActionListener(this);
        add(signin);

        signup = new JButton("SIGN UP");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.black);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);

        clear = new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);

        getContentPane().setBackground(Color.white);

        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() ==  clear){
            cardtextfield.setText("");
            pintextfield.setText("");
        }else if(ae.getSource() == signin) {
            Conn conn = new Conn();
            String cardnumber = cardtextfield.getText();
            char[] pinnumber = pintextfield.getPassword();
            String pin = String.valueOf(pinnumber);
            System.out.println(pinnumber);
            //String query = "select * from bankmanagementsystem.login where cardnumber = '"+cardnumber+"' and pin = '"+pin+"'";
            String query = "select * from bankmanagementsystem.login where cardnumber = ? and pin = ?";
            try {
                PreparedStatement ps = conn.c.prepareStatement(query);
                ps.setString(1,cardnumber);
                ps.setString(2,pin);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    setVisible(false);
                    new Transaction(pin).setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }else if(ae.getSource() == signup) {
            setVisible(false);
            new SignupOne().setVisible(true);
        }

    }

    public static void main(String[] args){
        new Login();
    }
}
