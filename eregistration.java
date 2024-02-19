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
public class eregistration extends JFrame implements ActionListener{
    Random ran = new Random();
    int number = ran.nextInt(999999);
    JTextField tfuname,tfp,tfename, tfcname, tfemail, tfphone, tfedesignation, tfcaddress;
    JButton reg, back;
    JLabel lblempid;
    eregistration(){
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel heading = new JLabel("EMPLOYER REGISTRATION");
        heading.setBounds(100, 10, 800, 100);
        heading.setForeground(Color.white);
        heading.setFont(new Font("SAN_SERIF", Font.PLAIN, 50));
        add(heading);
        
        JLabel labelname = new JLabel("Employer Name");
        labelname.setBounds(50, 120, 150, 30);
        labelname.setForeground(Color.white);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);
        
        tfename = new JTextField();
        tfename.setBounds(250, 120, 150, 30);
        add(tfename);
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
        tfp = new JTextField();
        tfp.setBounds(650, 160, 150, 30);
        add(tfp);
        
        JLabel labelfname = new JLabel("Company Name");
        labelfname.setBounds(50, 160, 150, 30);
        labelfname.setForeground(Color.white);
        labelfname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelfname);
        
        tfcname = new JTextField();
        tfcname.setBounds(250, 160, 150, 30);
        add(tfcname);
      
        
        JLabel labeladdress = new JLabel("Company Address");
        labeladdress.setBounds(50, 200, 150, 30);
        labeladdress.setForeground(Color.white);
        labeladdress.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeladdress);
        
        tfcaddress = new JTextField();
        tfcaddress.setBounds(250, 200, 150, 30);
        add(tfcaddress);
        
        JLabel labelphone = new JLabel("Contact no.");
        labelphone.setBounds(50, 240, 150, 30);
        labelphone.setForeground(Color.white);
        labelphone.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(250, 240, 150, 30);
        add(tfphone);
        
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50, 280, 150, 30);
        labelemail.setForeground(Color.white);
        labelemail.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(250, 280, 150, 30);
        add(tfemail);
        
        
        
        JLabel labeldesignation = new JLabel("Website name");
        labeldesignation.setBounds(50, 320, 200, 30);
        labeldesignation.setForeground(Color.white);
        labeldesignation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldesignation);
        
        tfedesignation = new JTextField();
        tfedesignation.setBounds(250, 320, 150, 30);
        add(tfedesignation);
        
        
        
        JLabel labelempId = new JLabel("Employer id");
        labelempId.setBounds(50, 360, 150, 30);
        labelempId.setForeground(Color.white);
        labelempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelempId);
        
        lblempid = new JLabel("" + number);
        lblempid.setBounds(250, 360, 150, 30);
        lblempid.setForeground(Color.white);
        lblempid.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblempid);
        
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
            String name = tfename.getText();
            String cname = tfcname.getText();
            String address = tfcaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String designation = tfedesignation.getText();
            String empid = lblempid.getText();
            String uname=tfuname.getText();
            String pass=tfp.getText();
            try {
                Conn conn = new Conn();
                String query = "insert into employer values('"+empid+"', '"+name+"', '"+email+"', '"+cname+"', '"+address+"',  '"+phone+"', '"+designation+"')";
                String query1 = "insert into login values('"+uname+"','"+pass+"')";
                conn.s.executeUpdate(query);
                conn.s.executeUpdate(query1);
                JOptionPane.showMessageDialog(null, "Registration done successfully");
                setVisible(false);
                new elogin();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new elogin();
        }
    }
    public static void main(String[] args){
        new eregistration();
    }
}
