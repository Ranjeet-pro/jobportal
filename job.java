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
import java.util.Random;
public class job extends JFrame implements ActionListener{
    Random ran = new Random();
    int number = ran.nextInt(999999);
    JButton reg, back;
    JTextField tftitle, tfloc, tfsal, tfwor, tfdes, tfres;
    JLabel lbljid;
    job(){
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
        JLabel h2 = new JLabel("Job Title:-");
        h2.setBounds(100, 120, 150, 30);
        h2.setForeground(Color.white);
        h2.setFont(new Font("Raleway",Font.PLAIN, 25));
        image.add(h2);
        tftitle = new JTextField();
        tftitle.setBounds(350,120,150,30);
        tftitle.setFont(new Font("Raleway",Font.PLAIN, 25));
        image.add(tftitle);
        JLabel h3 = new JLabel("Job Location:-");
        h3.setBounds(100, 160, 200, 30);
        h3.setForeground(Color.white);
        h3.setFont(new Font("Raleway",Font.PLAIN, 25));
        image.add(h3);
        tfloc = new JTextField();
        tfloc.setBounds(350,160,150,30);
        tfloc.setFont(new Font("Raleway",Font.PLAIN, 25));
        image.add(tfloc);
        JLabel h4 = new JLabel("Salary:-");
        h4.setBounds(100, 200, 200, 30);
        h4.setForeground(Color.white);
        h4.setFont(new Font("Raleway",Font.PLAIN, 25));
        image.add(h4);
        tfsal = new JTextField();
        tfsal.setBounds(350,200,150,30);
        tfsal.setFont(new Font("Raleway",Font.PLAIN, 25));
        image.add(tfsal);
        JLabel h5 = new JLabel("Working hrs.:-");
        h5.setBounds(100, 240, 200, 30);
        h5.setForeground(Color.white);
        h5.setFont(new Font("Raleway",Font.PLAIN, 25));
        image.add(h5);
        tfwor = new JTextField();
        tfwor.setBounds(350,240,150,30);
        tfwor.setFont(new Font("Raleway",Font.PLAIN, 25));
        image.add(tfwor);
        JLabel h6 = new JLabel("Description:-");
        h6.setBounds(100, 280, 200, 30);
        h6.setForeground(Color.white);
        h6.setFont(new Font("Raleway",Font.PLAIN, 25));
        image.add(h6);
        tfdes = new JTextField();
        tfdes.setBounds(350,280,200,30);
        tfdes.setFont(new Font("Raleway",Font.PLAIN, 25));
        image.add(tfdes);
        JLabel h7 = new JLabel("Responsibilities:-");
        h7.setBounds(100, 320, 200, 30);
        h7.setForeground(Color.white);
        h7.setFont(new Font("Raleway",Font.PLAIN, 25));
        image.add(h7);
        tfres = new JTextField();
        tfres.setBounds(350,320,200,30);
        tfres.setFont(new Font("Raleway",Font.PLAIN, 25));
        image.add(tfres);
        JLabel jid = new JLabel("Job id");
        jid.setBounds(100, 360, 150, 30);
        jid.setForeground(Color.WHITE);
        jid.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(jid);
        
        lbljid = new JLabel("" + number);
        lbljid.setBounds(250, 360, 150, 30);
        lbljid.setForeground(Color.WHITE);
        lbljid.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(lbljid);
        reg = new JButton("ADD");
        reg.setBounds(200, 450, 150, 40);
        reg.setFont(new Font("serif", Font.PLAIN, 20));
        reg.addActionListener(this);
        image.add(reg);
        
        back = new JButton("BACK");
        back.setBounds(450, 450, 150, 40);
        back.setFont(new Font("serif", Font.PLAIN, 20));
        back.addActionListener(this);
        image.add(back);
        
        setSize(1200, 1000);
        setLocation(10, 10);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==reg){
            String title = tftitle.getText();
            String loc = tfloc.getText();
            String sal = tfsal.getText();
            String wor = tfwor.getText();
            String des = tfdes.getText();
            String res = tfres.getText();
            String jid = lbljid.getText();
            
            try {
                Conn conn = new Conn();
                String query = "insert into job values('"+jid+"', '"+title+"', '"+loc+"', '"+des+"', '"+sal+"',  '"+res+"', '"+wor+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Job added successfully");
                setVisible(false);
                new job();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            setVisible(false);
            new employermodule();
        }
    }
    public static void main(String[] args) {
        new job();
    }

    
}
