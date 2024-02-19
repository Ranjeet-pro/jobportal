/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ignouproject;

/**
 *
 * @author Ranjeet
 */
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
public class jsregistration extends JFrame implements ActionListener{
    Random ran = new Random();
    int number = ran.nextInt(999999);
    JTextField tfskills, tfres,tfuname, tfjsname,  tfemail, tfphone, tfeducation, tfaddress, tfexperience;
    JButton reg, back;
    JComboBox cbeducation;
    JLabel lbljsid;
    JPasswordField tfp;
    jsregistration(){
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel heading = new JLabel("JOB SEEKER REGISTRATION");
        heading.setBounds(100, 10, 800, 100);
        heading.setForeground(Color.white);
        heading.setFont(new Font("SAN_SERIF", Font.PLAIN, 50));
        add(heading);
        
        JLabel labelname = new JLabel("Full Name");
        labelname.setBounds(50, 120, 150, 30);
        labelname.setForeground(Color.white);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);
        
        tfjsname = new JTextField();
        tfjsname.setBounds(250, 120, 150, 30);
        add(tfjsname);
        JLabel labeluname = new JLabel("User Name");
        labeluname.setBounds(450,120,150,30);
        labeluname.setForeground(Color.white);
        labeluname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeluname);
        tfuname = new JTextField();
        tfuname.setBounds(650, 120, 150, 30);
        add(tfuname);
        JLabel labelpass = new JLabel("Password");
        labelpass.setBounds(450,160,150,30);
        labelpass.setForeground(Color.white);
        labelpass.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelpass);
        tfp = new JPasswordField();
        tfp.setBounds(650, 160, 150, 30);
        add(tfp);
        JCheckBox chp=new JCheckBox("Show password");
        chp.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(chp.isSelected()){
                    tfp.setEchoChar((char)0);
                }else{
                    tfp.setEchoChar('*');
                }
            }
        });
        chp.setBounds(650, 200, 150, 30);
        add(chp);
        JLabel resume = new JLabel("Resume link");
        resume.setBounds(450, 240, 150, 30);
        resume.setForeground(Color.white);
        resume.setFont(new Font("serif", Font.PLAIN, 20));
        add(resume);
        tfres = new JTextField();
        tfres.setBounds(650,240,150,30);
        add(tfres);
        JLabel skills = new JLabel("Skill");
        skills.setBounds(450,280,150,30);
        skills.setForeground(Color.white);
        skills.setFont(new Font("serif", Font.PLAIN, 20));
        add(skills);
        tfskills = new JTextField();
        tfskills.setBounds(650,280,150,30);
        add(tfskills);
        JLabel labeladdress = new JLabel("Address");
        labeladdress.setBounds(50, 160, 150, 30);
        labeladdress.setForeground(Color.white);
        labeladdress.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(250, 160, 150, 30);
        add(tfaddress);
        
        JLabel labelphone = new JLabel("Contact no.");
        labelphone.setBounds(50, 200, 150, 30);
        labelphone.setForeground(Color.white);
        labelphone.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(250, 200, 150, 30);
        add(tfphone);
        
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50, 240, 150, 30);
        labelemail.setForeground(Color.white);
        labelemail.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(250, 240, 150, 30);
        add(tfemail);
        
        
        
        JLabel labeleducation = new JLabel("Heighest Education");
        labeleducation.setBounds(50, 280, 200, 30);
        labeleducation.setForeground(Color.white);
        labeleducation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeleducation);
        String courses[] = {"BBA", "BCA", "BA", "BSC", "B.COM", "BTech", "MBA", "MCA", "MA", "MTech", "MSC", "PHD"};
        cbeducation = new JComboBox(courses);
        cbeducation.setBackground(Color.WHITE);
        cbeducation.setBounds(250, 280, 150, 30);
        add(cbeducation);
        JLabel labelexperience = new JLabel("Experience");
        labelexperience.setBounds(50, 320, 200, 30);
        labelexperience.setForeground(Color.white);
        labelexperience.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelexperience);
        
        tfexperience = new JTextField();
        tfexperience.setBounds(250, 320, 150, 30);
        add(tfexperience);
        
        
        JLabel labelempId = new JLabel("jobSeeker id");
        labelempId.setBounds(50, 360, 150, 30);
        labelempId.setForeground(Color.white);
        labelempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelempId);
        
        lbljsid = new JLabel("" + number);
        lbljsid.setBounds(250, 360, 150, 30);
        lbljsid.setForeground(Color.white);
        lbljsid.setFont(new Font("serif", Font.PLAIN, 20));
        add(lbljsid);
        
        reg = new JButton("REGISTER");
        reg.setBounds(250, 410, 150, 40);
        reg.addActionListener(this);
        add(reg);
        
        back = new JButton("Back");
        back.setBounds(450, 410, 150, 40);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/banner-948414551.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1200, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1200, 900);
        add(image);
        
        setSize(1200,1000);
        setLocation(100,30);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == reg) {
            String name = tfjsname.getText();
            String uname = tfuname.getText();
            String address = tfaddress.getText();
            String skills = tfskills.getText();
            String res=tfres.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String designation = (String) cbeducation.getSelectedItem();
            String experience = tfexperience.getText();
            String empid = lbljsid.getText();
            String pass = new String(tfp.getPassword());
            try {
                Conn conn = new Conn();
                String query = "insert into jobseeker values('"+empid+"',  '"+name+"', '"+email+"', '"+phone+"',  '"+address+"','"+skills+"', '"+designation+"','"+experience+"','"+res+"')";
                String query1 = "insert into login values('"+uname+"','"+pass+"')";
                conn.s.executeUpdate(query);
                conn.s.executeUpdate(query1);
                JOptionPane.showMessageDialog(this, "Registration done successfully");
                setVisible(false);
                new jslogin();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new jslogin();
        }
    }
    public static void main(String[] args){
        new jsregistration();
    }
    
}
