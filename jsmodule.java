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
public class jsmodule extends JFrame implements ActionListener{
    JButton back,search2, apply, searchb, feedb, loginA, loginout, add;
    JTable table1;
    JTextField a1;
    jsmodule(){
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
        add = new JButton("RESUME");
        add.setBounds(50, 150, 150, 40);
        add.setFont(new Font("Arial", Font.PLAIN, 20));
        add.addActionListener(this);
        image.add(add);
        loginA = new JButton("VIEW MESSAGES");
        loginA.setBounds(250, 150, 200, 40);
        loginA.setFont(new Font("Arial", Font.PLAIN, 20));
        loginA.addActionListener(this);
        image.add(loginA);
        feedb = new JButton("FEEDBACK");
        feedb.setBounds(1000, 150, 150, 40);
        feedb.setFont(new Font("Arial", Font.PLAIN, 20));
        feedb.addActionListener(this);
        image.add(feedb);
        JLabel search = new JLabel("Search job by job_title:-");
        search.setBounds(480, 150, 270, 30);
        search.setForeground(Color.white);
        search.setFont(new Font("Arial", Font.PLAIN, 25));
        image.add(search);
        a1 = new JTextField();
        a1.setBounds(750, 150, 100, 30);
        image.add(a1);
        searchb = new JButton("SEARCH");
        searchb.setBounds(850, 150, 120, 30);
        searchb.setFont(new Font("Arial", Font.PLAIN, 20));
        searchb.addActionListener(this);
        image.add(searchb);
        table1 = new JTable();
        table1.setBounds(50, 205, 1100, 300);
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from job");
            table1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        JScrollPane jsp = new JScrollPane(table1);
        jsp.setBounds(50, 205, 1100, 300);
        image.add(jsp);
        
        search2 = new JButton("PROFILE");
        search2.setBounds(50, 510, 120, 30);
        search2.setFont(new Font("Arial", Font.PLAIN, 20));
        search2.addActionListener(this);
        image.add(search2);
        apply = new JButton("APPLY FOR JOB");
        apply.setBounds(200, 510, 220, 30);
        apply.setFont(new Font("Arial", Font.PLAIN, 20));
        apply.addActionListener(this);
        image.add(apply);
        
        setSize(1200, 1000);
        setLocation(10, 10);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == searchb) {
            String s1 = a1.getText();
            String query = "select * from job where job_title = '"+s1+"'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table1.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }  else if (ae.getSource() == add) {
            //setVisible(false);
            //new job();
            JOptionPane.showMessageDialog(null, "Work is in prpgress");
        }else if (ae.getSource() == loginA) {
            //setVisible(false);
            //new viewmessages();
            JOptionPane.showMessageDialog(null,"Work is in progress, please wait for some time...");
        }else if (ae.getSource() == feedb) {
            setVisible(false);
            new feedback();
        }else if (ae.getSource() == search2) {
            setVisible(false);
            //new profile();
            JOptionPane.showMessageDialog(null,"Work is in progress, please wait for some time...");
        }else if (ae.getSource() == apply) {
            JOptionPane.showMessageDialog(null, "Applied successfully");
            //setVisible(false);
            //new feedback();
        }else if(ae.getSource()==back){
            setVisible(false);
            new jslogin();
        }else {
            setVisible(false);
            new jslogin();
        }
    }
    public static void main(String[] args){
        new jsmodule();
    }
    
}
