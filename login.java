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
public class login extends JFrame implements ActionListener{
    JButton Alogin, Elogin, Jlogin;
    login(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/banner-948414551.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1200, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1200, 1000);
        add(image);
        
        JLabel h1 = new JLabel("JOBPortal");
        h1.setBounds(0, 0, 500, 100);
        h1.setForeground(Color.white);
        h1.setFont(new Font("Raleway",Font.PLAIN, 50));
        image.add(h1);
        
        
        Alogin = new JButton("CLICK HERE TO LOGIN AS ADMIN");
        Alogin.setBounds(400, 150, 500, 70);
        Alogin.setFont(new Font("Raleway",Font.PLAIN,20));
        Alogin.addActionListener(this);
        image.add(Alogin);
        
        
        
        Elogin = new JButton("CLICK HERE TO LOGIN AS EMPLOYER");
        Elogin.setBounds(400, 230, 500, 70);
        Elogin.setFont(new Font("Raleway",Font.PLAIN,20));
        Elogin.addActionListener(this);
        image.add(Elogin);
        
        Jlogin = new JButton("CLICK HERE TO LOGIN AS JOB SEEKER");
        Jlogin.setBounds(400, 310, 500, 70);
        Jlogin.setFont(new Font("Raleway",Font.PLAIN,20));
        Jlogin.addActionListener(this);
        image.add(Jlogin);
        
        
        
        setSize(1200, 1000);
        setLocation(10, 10);
        setVisible(true);
    }
     public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==Alogin){
            setVisible(false);
            new adminlogin();
        }else if(ae.getSource()==Elogin){
            setVisible(false);
            new elogin();
        }else{
            setVisible(false);
            new jslogin();
        }
        
    }
    
    public static void main(String args[]){
        new login();
    }
    
}
