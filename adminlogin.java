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
public class adminlogin extends JFrame implements ActionListener{
    JTextField tfusername;
    JPasswordField tfpassword;
    JButton loginA,back;
    JCheckBox chp;
    adminlogin(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lblusername = new JLabel("Username *");
        lblusername.setBounds(40, 20, 100, 30);
        add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(150, 20, 150, 30);
        add(tfusername);
        
        JLabel lblpassword = new JLabel("Password *");
        lblpassword.setBounds(40, 70, 100, 30);
        add(lblpassword);
        
        tfpassword = new JPasswordField();
        tfpassword.setBounds(150, 70, 150, 30);
        add(tfpassword);
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
        chp.setBounds(40, 100, 150, 25);
        add(chp);
        
        loginA = new JButton("LOGIN");
        loginA.setBounds(150, 140, 150, 30);
        loginA.setBackground(Color.BLACK);
        loginA.setForeground(Color.WHITE);
        loginA.addActionListener(this);
        add(loginA);
        back = new JButton("BACK");
        back.setBounds(150, 175, 150, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 200, 200);
        add(image);
        
        JLabel lblname = new JLabel("ADMIN LOGIN");
        lblname.setBounds(400, 200, 200, 70);
        add(lblname);
        
        setSize(600, 300);
        setLocation(450, 200);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==loginA){
            try{
                String username=tfusername.getText();
                String password=tfpassword.getText();
                Conn c=new Conn();
                String query="select * from login where username = '"+username+"' and password = '"+password+"'";
                ResultSet rs=c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new adminmodule();
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
            new login();
        }
    }
    public static void main(String[] args) {
        new adminlogin();
    }
}
