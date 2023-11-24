package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;

public class SignupTwo extends JFrame implements ActionListener{
    JTextField homenumtextfield,phonenumtextfield;
    JComboBox<String> religionbox,levelbox,incomebox,educatebox,occupationbox;
    JButton next, cancel;
    JRadioButton No,Yes,SNo,SYes;
    String formno;
    SignupTwo(String formno) {
        this.formno = formno;
        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        JLabel AdditionalDetails = new JLabel("Page 2: Additional Details");
        AdditionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        AdditionalDetails.setBounds(290,80,400,30);
        add(AdditionalDetails);

        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway", Font.BOLD, 20));
        religion.setBounds(50,160,200, 30);
        add(religion);

        String [] valReligion = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religionbox= new JComboBox<>(valReligion);
        religionbox.setSelectedIndex(4);
        religionbox.setBounds(250,160,400,30);
        religionbox.setBackground(Color.white);
        add(religionbox);

        JLabel level = new JLabel("Level:");
        level.setFont(new Font("Raleway", Font.BOLD, 20));
        level.setBounds(50,200,200, 30);
        add(level);

        String [] memlevel = {"Iron", "Bronze", "Silver", "Gold"};
        levelbox= new JComboBox<>(memlevel);
        levelbox.setSelectedIndex(3);
        levelbox.setBounds(250,200,400,30);
        levelbox.setBackground(Color.white);
        add(levelbox);


        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        income.setBounds(50,240,200, 30);
        add(income);

        String [] incomelevel = {"Null", "< 150,000", "< 500,000", "< 1,000,000", "< 5,000,000","up to 10,000,000"};
        incomebox= new JComboBox<>(incomelevel);
        incomebox.setSelectedIndex(5);
        incomebox.setBounds(250,240,400,30);
        incomebox.setBackground(Color.white);
        add(incomebox);

        JLabel education = new JLabel("Education:");
        education.setFont(new Font("Raleway", Font.BOLD, 20));
        education.setBounds(50,280,200, 30);
        add(education);

        JLabel qualification = new JLabel("Qualification:");
        qualification.setFont(new Font("Raleway", Font.BOLD, 20));
        qualification.setBounds(50,300,200, 30);
        add(qualification);

        String [] educatelevel = {"Null", "Under-senior", "Senior", "Graduate", "Post-Graduate","Doctrate","Other"};
        educatebox= new JComboBox<>(educatelevel);
        educatebox.setSelectedIndex(6);
        educatebox.setBounds(250,300,400,30);
        educatebox.setBackground(Color.white);
        add(educatebox);

        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        occupation.setBounds(50,340,200, 30);
        add(occupation);

        String [] occupationValue = {"Null", "student", "Salaried", "Self-Employed", "Bussiness","Retired","Other"};
        occupationbox= new JComboBox<>(occupationValue);
        occupationbox.setSelectedIndex(6);
        occupationbox.setBounds(250,340,400,30);
        occupationbox.setBackground(Color.white);
        add(occupationbox);

        JLabel homenum = new JLabel("Home Number:");
        homenum.setFont(new Font("Raleway", Font.BOLD, 20));
        homenum.setBounds(50,380,200, 30);
        add(homenum);

        homenumtextfield = new JTextField();
        homenumtextfield.setBounds(250,380,400,30);
        homenumtextfield.setBackground(Color.white);
        add(homenumtextfield);


        JLabel phonenum  = new JLabel("Phone Number:");
        phonenum.setFont(new Font("Raleway", Font.BOLD, 20));
        phonenum.setBounds(50,420,200, 30);
        add(phonenum);

        phonenumtextfield = new JTextField();
        phonenumtextfield.setBounds(250,420,400,30);
        phonenumtextfield.setFont(new Font("Raleway", Font.BOLD, 14));
        add(phonenumtextfield);

        JLabel seniorcitizen = new JLabel("Senior citizen:");
        seniorcitizen.setFont(new Font("Raleway", Font.BOLD, 20));
        seniorcitizen.setBounds(50,460,200, 30);
        add(seniorcitizen);

        SYes = new JRadioButton(("Yes"));
        SYes.setBounds(250,460,100,30);
        SYes.setBackground(Color.white);
        add(SYes);

        SNo = new JRadioButton(("No"));
        SNo.setBounds(400,460,100,30);
        SNo.setBackground(Color.white);
        add(SNo);

        ButtonGroup scgroup = new ButtonGroup();
        scgroup.add(SYes);
        scgroup.add(SNo);

        JLabel exisaccount = new JLabel("Exisiting Account:");
        exisaccount.setFont(new Font("Raleway", Font.BOLD, 20));
        exisaccount.setBounds(50,500,200, 30);
        add(exisaccount);

        Yes = new JRadioButton(("Yes"));
        Yes.setBounds(250,500,100,30);
        Yes.setBackground(Color.white);
        add(Yes);

        No = new JRadioButton(("No"));
        No.setBounds(400,500,100,30);
        No.setBackground(Color.white);
        add(No);

        ButtonGroup existgroup = new ButtonGroup();
        existgroup.add(Yes);
        existgroup.add(No);

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
            String homenum = homenumtextfield.getText();
            String phonenum = phonenumtextfield.getText();
            String sreligion = (String) religionbox.getSelectedItem();
            String smemlevel = (String) levelbox.getSelectedItem();
            String sincome = (String) incomebox.getSelectedItem();
            String seducate = (String) educatebox.getSelectedItem();
            String soccupation = (String) occupationbox.getSelectedItem();
            String seniorcitizen = null;
            if (SYes.isSelected()) {
                seniorcitizen = "Yes";
            } else if (SNo.isSelected()) {
                seniorcitizen = "No";
            }
            String exisaccount = null;
            if (Yes.isSelected()) {
                exisaccount = "Yes";
            } else if (No.isSelected()) {
                exisaccount = "No";
            }
            try {
                if (homenum.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "homenumber is Required");
                } else {
                    Conn c = new Conn();
                //    String query = "insert into bankmanagementsystem.signup2 VALUES ('" + sreligion + "','" + smemlevel + "','" + sincome + "','" + seducate + "','" + soccupation + "','" + homenum + "','" + phonenum + "','" + seniorcitizen + "','" + exisaccount + "','" + formno + "')";
                    PreparedStatement ps = c.c.prepareStatement("insert into bankmanagementsystem.signup2 (Religion ,Level ,Income ,Education ,Occupation ,Homenumber ,Phonenumber ,Seniorcitizen ,Existaccount ,formno) values(?,?,?,?,?,?,?,?,?,?)");
                    ps.setString(1,sreligion);
                    ps.setString(2,smemlevel);
                    ps.setString(3,sincome);
                    ps.setString(4,seducate);
                    ps.setString(5,soccupation);
                    ps.setString(6,homenum);
                    ps.setString(7,phonenum);
                    ps.setString(8,seniorcitizen);
                    ps.setString(9,exisaccount);
                    ps.setString(10,formno);

                    ps.executeUpdate();
                    setVisible(false);
                    new SignupThree(formno).setVisible(true);
                }
            } catch (Exception e) {
                System.out.print(e);
            }
        }else if (ae.getSource() == cancel) {
            setVisible(false);
            new Login().setVisible(true);
        }



    }
    public static void main (String[] args) {

        new SignupTwo("");
    }

}