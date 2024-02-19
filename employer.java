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
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;
public class employer extends JFrame implements ActionListener{
    JButton searchb,loginout, back,b1,b2,b3,b4;
    JTable table1;
    JComboBox a1;
    employer(){
        getContentPane().setBackground(Color.yellow);
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
        JLabel search = new JLabel("Search employer by Company name:-");
        search.setBounds(50, 160, 450, 30);
        search.setForeground(Color.white);
        search.setFont(new Font("Arial", Font.PLAIN, 25));
        image.add(search);
        String cname[]={"Google","Microsoft","LLOYD","Zomato","global ltd."};
        a1 = new JComboBox(cname);
        a1.setBounds(500, 160, 150, 30);
        image.add(a1);
        searchb = new JButton("SEARCH");
        searchb.setBounds(650, 160, 120, 30);
        searchb.setFont(new Font("Arial", Font.PLAIN, 20));
        searchb.addActionListener(this);
        image.add(searchb);
        table1 = new JTable();
        table1.setBounds(50, 200, 900, 200);
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employer");
            table1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        JScrollPane jsp = new JScrollPane(table1);
        jsp.setBounds(50, 200, 900, 200);
        image.add(jsp);
        b1 = new JButton("ADD");
        b1.setBounds(50, 400, 100, 40);
        image.add(b1);
        b2 = new JButton("UPDATE");
        b2.setBounds(160, 400, 120, 40);
        image.add(b2);
        b3 = new JButton("DELETE");
        b3.setBounds(290, 400, 120, 40);
        image.add(b3);
        b4 = new JButton("VIEW");
        b4.setBounds(420, 400, 120, 40);
        image.add(b4);
        setSize(1200, 1000);
        setLocation(10, 10);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==loginout){
            setVisible(false);
            new login();
        }else if(ae.getSource()==back){
            setVisible(false);
            new adminmodule();
        }else if(ae.getSource()==searchb){
            String coname = (String)a1.getSelectedItem();
            try{
               Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employer where comp_name= '"+coname+"' ");
            table1.setModel(DbUtils.resultSetToTableModel(rs)); 
            }catch(Exception e){
               e.printStackTrace(); 
            }
        }else if(ae.getSource()==b1){
            setVisible(false);
            new job();
        }else if(ae.getSource()==b2){
            setVisible(false);
            new job();
        }else if(ae.getSource()==b3){
            setVisible(false);
            new job();
        }else{
            setVisible(false);
            new job();
        }
    }
    public static void main(String[] args){
        new employer();
    }
}
