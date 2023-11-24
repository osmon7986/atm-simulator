package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;


public class Pinchange extends JFrame implements ActionListener {
    JLabel image, text, text2, text3;
    JPasswordField PinChange, PinCheck;
    JButton submit, back;
    String pin;
    Pinchange(String pin) {
        this.pin = pin;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(10,10,700,700);
        add(image);

        text = new JLabel("Change your Pin ");
        text.setForeground(Color.black);
        text.setFont(new Font("System", Font.BOLD, 12));
        text.setBounds(255,340,200,20);
        image.add(text);

        text2 = new JLabel("New PIN ");
        text2.setForeground(Color.black);
        text2.setFont(new Font("System", Font.BOLD, 12));
        text2.setBounds(220,360,200,20);
        image.add(text2);

        text3 = new JLabel("Re-Enter PIN ");
        text3.setForeground(Color.black);
        text3.setFont(new Font("System", Font.BOLD, 12));
        text3.setBounds(220,380,200,20);
        image.add(text3);

        PinChange = new JPasswordField();
        PinChange.setFont(new Font("Raleway", Font.BOLD, 12));
        PinChange.setBounds(300, 360, 90, 20);
        image.add(PinChange);

        PinCheck = new JPasswordField();
        PinCheck.setFont(new Font("Raleway", Font.BOLD, 12));
        PinCheck.setBounds(300, 380, 90, 20);
        image.add(PinCheck);

        submit = new JButton("submit");
        submit.setFont(new Font("System", Font.BOLD, 12));
        submit.setBounds(305,440,95,20);
        submit.addActionListener(this);
        image.add(submit);

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
        if (ae.getSource() == submit) {
            String pinchange = PinChange.getText();
            String pincheck = PinCheck.getText();
            if (pinchange.isEmpty() | pincheck.isEmpty()){
                JOptionPane.showMessageDialog(null,"Please enter your new pin");
            } else{
                try{
                    Conn conn = new Conn();
                    PreparedStatement ps = conn.c.prepareStatement("update bankmanagementsystem.signup3 set pinnumber = ? where pinnumber = ? ");
                    ps.setString(1,pinchange);
                    ps.setString(2,pin);
                    PreparedStatement ps2 = conn.c.prepareStatement("update bankmanagementsystem.bank set pin = ? where pin = ? ");
                    ps2.setString(1,pinchange);
                    ps2.setString(2,pin);
                    PreparedStatement ps3 = conn.c.prepareStatement("update bankmanagementsystem.login set pin = ? where pin = ? ");
                    ps3.setString(1,pinchange);
                    ps3.setString(2,pin);

                    ps.executeUpdate();
                    ps2.executeUpdate();
                    ps3.executeUpdate();
                    setVisible(false);
                    JOptionPane.showMessageDialog(null,"pin change successful");
                    pin = pinchange;
                    new Transaction(pin).setVisible(true);

                }catch (Exception e){
                    System.out.println(e);
                }
            }
        }else if (ae.getSource() == back){
            setVisible(false);
            new Transaction(pin).setVisible(true);
        }
    }

    public static void main(String args[]){

        new Pinchange("");
    }
}
