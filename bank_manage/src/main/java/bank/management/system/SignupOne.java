package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.PreparedStatement;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener{
    long random;
    JTextField nametextfield,fnametextfield,emailtextfield,addresstextfield,citytextfield,statetextfield,Pincodetextfield;
    JButton next, cancel;
    JDateChooser dateChooser;
    JRadioButton male,female,married,unmarried,other;
    SignupOne() {

        setLayout(null);

        Random ran =new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);

        JLabel formno = new JLabel("APPLICATION FORM NO. "+ random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(140,20,600,40);
        add(formno);

        JLabel PersonalDetails = new JLabel("Page 1: Personal Details");
        PersonalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        PersonalDetails.setBounds(290,80,400,30);
        add(PersonalDetails);

        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(50,160,200, 30);
        add(name);

        nametextfield = new JTextField();
        nametextfield.setBounds(250,160,400,30);
        nametextfield.setFont(new Font("Raleway", Font.BOLD, 14));
        add(nametextfield);

        JLabel fathername = new JLabel("Father's Name:");
        fathername.setFont(new Font("Raleway", Font.BOLD, 20));
        fathername.setBounds(50,200,200, 30);
        add(fathername);

        fnametextfield = new JTextField();
        fnametextfield.setBounds(250,200,400,30);
        fnametextfield.setFont(new Font("Raleway", Font.BOLD, 14));
        add(fnametextfield);

        JLabel birth = new JLabel("Date of Birth:");
        birth.setFont(new Font("Raleway", Font.BOLD, 20));
        birth.setBounds(50,240,200, 30);
        add(birth);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(250,240,200,30);
        dateChooser.setForeground(new Color(105,105,105));
        add(dateChooser);

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(50,280,200, 30);
        add(gender);

        male = new JRadioButton(("Male"));
        male.setBounds(250,280,100,30);
        male.setBackground(Color.white);
        add(male);

        female = new JRadioButton(("Female"));
        female.setBounds(400,280,100,30);
        female.setBackground(Color.white);
        add(female);

        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);

        JLabel email = new JLabel("Email address:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(50,320,200, 30);
        add(email);

        emailtextfield = new JTextField();
        emailtextfield.setBounds(250,320,400,30);
        emailtextfield.setFont(new Font("Raleway", Font.BOLD, 14));
        add(emailtextfield);

        JLabel marital = new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(50,360,200, 30);
        add(marital);

        married = new JRadioButton(("married"));
        married.setBounds(250,360,100,30);
        married.setBackground(Color.white);
        add(married);

        unmarried = new JRadioButton(("unmarried"));
        unmarried.setBounds(350,360,100,30);
        unmarried.setBackground(Color.white);
        add(unmarried);

        other = new JRadioButton(("other"));
        other.setBounds(450,360,100,30);
        other.setBackground(Color.white);
        add(other);

        ButtonGroup martialgroup = new ButtonGroup();
        martialgroup.add(married);
        martialgroup.add(unmarried);
        martialgroup.add(other);

        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(50,400,200, 30);
        add(address);

        addresstextfield = new JTextField();
        addresstextfield.setBounds(250,400,400,30);
        addresstextfield.setFont(new Font("Raleway", Font.BOLD, 14));
        add(addresstextfield);

        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(50,440,200, 30);
        add(city);

        citytextfield = new JTextField();
        citytextfield.setBounds(250,440,400,30);
        citytextfield.setFont(new Font("Raleway", Font.BOLD, 14));
        add(citytextfield);

        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(50,480,200, 30);
        add(state);

        statetextfield = new JTextField();
        statetextfield.setBounds(250,480,400,30);
        statetextfield.setFont(new Font("Raleway", Font.BOLD, 14));
        add(statetextfield);

        JLabel Pincode = new JLabel("Pin Code:");
        Pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        Pincode.setBounds(50,520,200, 30);
        add(Pincode);

        Pincodetextfield = new JTextField();
        Pincodetextfield.setBounds(250,520,400,30);
        Pincodetextfield.setFont(new Font("Raleway", Font.BOLD, 14));
        add(Pincodetextfield);

        next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setBounds(620,560,80,30);
        next.addActionListener(this);
        add(next);

        cancel = new JButton("Cancel");
        cancel.setBounds(720,560,80,30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.white);

        setSize(850,650);
        setLocation(250,100);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==next){
            String formno = "" + random;    // long
            String name = nametextfield.getText();
            String fname = fnametextfield.getText();
            String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
            String gender = "null";
            if (male.isSelected()) {
                gender = "Male";
            } else if (female.isSelected()) {
                gender = "Female";
            }
            String email = emailtextfield.getText();
            String martial = null;
            if (married.isSelected()) {
                martial = "Married";
            } else if (unmarried.isSelected()) {
                martial = "UnMarried";
            } else if (other.isSelected()) {
                martial = "Other";
            }
            String address = addresstextfield.getText();
            String state = statetextfield.getText();
            String city = citytextfield.getText();
            String pincode = Pincodetextfield.getText();

            try {
                if (name.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Name is Required");
                } else {
                    Conn c = new Conn();
                //    String query = "insert into bankmanagementsystem.signup VALUES ('" + formno + "','" + name + "','" + fname + "','" + dob + "','" + gender + "','" + email + "','" + martial + "','" + address + "','" + city + "','" + pincode + "','" + state + "')";
                    PreparedStatement ps = c.c.prepareStatement("insert into bankmanagementsystem.signup (formno, name, father_name, dob, gender, email, martial_status, address, city, pincode, state) values(?,?,?,?,?,?,?,?,?,?,?)");
                    ps.setString(1,formno);
                    ps.setString(2,name);
                    ps.setString(3,fname);
                    ps.setString(4,dob);
                    ps.setString(5,gender);
                    ps.setString(6,email);
                    ps.setString(7,martial);
                    ps.setString(8,address);
                    ps.setString(9,city);
                    ps.setString(10,pincode);
                    ps.setString(11,state);
                    ps.executeUpdate();
                    setVisible(false);
                    new SignupTwo(formno).setVisible(true);
                }
            } catch (Exception e) {
                System.out.print(e);
            }
        }else if (ae.getSource() == cancel) {
            setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main (String []args) {

        new SignupOne();
    }

}
