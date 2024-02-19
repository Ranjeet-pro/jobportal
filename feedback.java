/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ignouproject;

/**
 *
 * @author Ranjeet
 */
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.util.Random;
public class feedback extends JFrame implements ActionListener{
   JLabel feedback_id;
   JTextField t1;
   JButton b1,back,loginout;
    Random ran = new Random();
    int number = ran.nextInt(999999);
    feedback(){
       
       getContentPane().setBackground(Color.white);
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/banner-948414551.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1200, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1200, 1000);
        add(image);

        JLabel heading = new JLabel("JOBPortal");
        heading.setBounds(0, 0, 500, 150);
        heading.setForeground(Color.white);
        heading.setFont(new Font("Raleway", Font.PLAIN, 90));
        image.add(heading);
        loginout = new JButton("LOGOUT");
        loginout.setBounds(1000, 30, 150, 50);
        loginout.setFont(new Font("Arial", Font.PLAIN, 20));
        loginout.addActionListener(this);
        image.add(loginout);
        back = new JButton("BACK");
        back.setBounds(800, 30, 150, 50);
        back.setFont(new Font("Arial", Font.PLAIN, 20));
        back.addActionListener(this);
        image.add(back);
        JLabel h1 = new JLabel("Drop your feedback here:");
        h1.setBounds(100, 160, 800, 60);
        h1.setForeground(Color.magenta);
        h1.setFont(new Font("Raleway", Font.PLAIN, 50));
        image.add(h1);
        JLabel labelempId = new JLabel("Feedback id");
        labelempId.setBounds(50, 230, 150, 30);
        labelempId.setForeground(Color.white);
        labelempId.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(labelempId);
        
        feedback_id = new JLabel("" + number);
        feedback_id.setBounds(200, 230, 150, 30);
        feedback_id.setForeground(Color.white);
        feedback_id.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(feedback_id);
        t1 = new JTextField();
        t1.setBounds(50, 270, 500, 30);
        image.add(t1);
        b1 = new JButton("Submit");
        b1.setBounds(50, 305, 100, 30);
        image.add(b1);
        setSize(1200, 1000);
        setLocation(10, 10);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            String s1 = feedback_id.getText();
            String s2 = t1.getText();
            String query = "insert into feedback values('"+s1+"','"+s2+"')";
            try{
                Conn c = new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Feedback posted successfully..");
                
            }catch (Exception e) {
                e.printStackTrace();
            }
        }else if (ae.getSource() == loginout) {
            setVisible(false);
            new login();
        } else {
            setVisible(false);
            new jsmodule();
        }
    }
     public static void main(String[] args) {
        new feedback();
    } 
}
