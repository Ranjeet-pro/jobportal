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
import java.awt.event.*;
import java.sql.*;
public class jslogin extends JFrame implements ActionListener{
    JTextField tfusername;
    JPasswordField tfpassword;
    JButton loginA, loginb,back;
    jslogin(){
       getContentPane().setBackground(Color.yellow);
        setLayout(null);
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/banner-948414551.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1200, 1000, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image1 = new JLabel(i6);
        image1.setBounds(0, 0, 1200, 1000);
        add(image1);

        JLabel heading = new JLabel("JOB SEEKER LOGIN");
        heading.setBounds(100, 10, 1000, 100);
        heading.setForeground(Color.white);
        heading.setFont(new Font("Raleway", Font.BOLD, 100));
        image1.add(heading);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(200, 200, 200, 50);
        lblusername.setForeground(Color.white);
        lblusername.setFont(new Font("Arial", Font.PLAIN, 30));
        image1.add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(400, 200, 200, 50);
        tfusername.setFont(new Font("Arial", Font.PLAIN, 30));
        image1.add(tfusername);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(200, 300, 200, 50);
        lblpassword.setFont(new Font("Arial", Font.PLAIN, 30));
        lblpassword.setForeground(Color.white);
        image1.add(lblpassword);

        tfpassword = new JPasswordField();
        tfpassword.setBounds(400, 300, 200, 50);
        tfpassword.setFont(new Font("Arial", Font.PLAIN, 30));
        image1.add(tfpassword);
        JCheckBox chp=new JCheckBox("Show password");
        chp.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(chp.isSelected()){
                    tfpassword.setEchoChar((char)0);
                }else{
                    tfpassword.setEchoChar('*');
                }
            }
        });
        chp.setBounds(400, 360, 150, 30);
        image1.add(chp);

        loginA = new JButton("LOGIN");
        loginA.setBounds(400, 450, 150, 50);
        loginA.addActionListener(this);
        loginA.setFont(new Font("Arial", Font.PLAIN, 20));
        image1.add(loginA);
        loginb = new JButton("NEW REGISTRATION");
        loginb.setBounds(400, 510, 300, 50);
        loginb.addActionListener(this);
        loginb.setFont(new Font("Arial", Font.PLAIN, 20));
        image1.add(loginb);
        back = new JButton("BACK");
        back.setBounds(710,510,150,50);
        back.addActionListener(this);
        back.setFont(new Font("serif", Font.PLAIN, 20));
        image1.add(back);

        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(150, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(850, 200, 150, 200);
        image1.add(image);

        setSize(1200, 1000);
        setLocation(10, 10);
        setVisible(true); 
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==loginA){
            try {
            String username = tfusername.getText();
            String password = tfpassword.getText();
            
            Conn c = new Conn();
            String query = "select * from login where username = '"+username+"' and password = '"+password+"'";
            
            ResultSet rs = c.s.executeQuery(query);
            if (rs.next()) {
                setVisible(false);
                new jsmodule();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password");
                setVisible(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        }else if(ae.getSource()==back){
            setVisible(false);
            new login();
        }else{
            setVisible(false);
            new jsregistration();
        }
    }
    public static void main(String[] args){
        new jslogin();
    }
    
}
