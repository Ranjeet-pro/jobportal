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
public class employermodule extends JFrame implements ActionListener{
    JButton back,loginout,add,loginA,feedb,search,searchb,search2;
    JTextField a1,a2;
    JTable table1,table2;
    JComboBox cbtitle, cbskills;
    employermodule(){
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
        add = new JButton("POST JOBS");
        add.setBounds(50, 160, 150, 40);
        add.setFont(new Font("Arial", Font.PLAIN, 20));
        add.addActionListener(this);
        image.add(add);
        loginA = new JButton("VIEW MESSAGES");
        loginA.setBounds(250, 160, 200, 40);
        loginA.setFont(new Font("Arial", Font.PLAIN, 20));
        loginA.addActionListener(this);
        image.add(loginA);
        feedb = new JButton("FEEDBACK");
        feedb.setBounds(1000, 160, 150, 40);
        feedb.setFont(new Font("Arial", Font.PLAIN, 20));
        feedb.addActionListener(this);
        image.add(feedb);
        JLabel search = new JLabel("Search job by job title:-");
        search.setBounds(460, 160, 280, 30);
        search.setForeground(Color.white);
        search.setFont(new Font("Arial", Font.PLAIN, 25));
        image.add(search); 
        String titles[] ={"Manager", "Programmer","HR","java developer"}; 
        cbtitle = new JComboBox(titles);
        cbtitle.setBounds(750, 160, 100, 30);
        image.add(cbtitle);
        /*a1 = new JTextField();
        a1.setBounds(700, 160, 100, 30);
        image.add(a1);*/
        searchb = new JButton("SEARCH");
        searchb.setBounds(850, 160, 120, 30);
        searchb.setFont(new Font("Arial", Font.PLAIN, 20));
        searchb.addActionListener(this);
        image.add(searchb);
        table1 = new JTable();
        table1.setBounds(50, 205, 1100, 200);
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from job");
            table1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        JScrollPane jsp = new JScrollPane(table1);
        jsp.setBounds(50, 205, 1100, 200);
        image.add(jsp);
        JLabel search1 = new JLabel("Search jobSeekers by skill:-");
        search1.setBounds(50, 410, 350, 30);
        search1.setForeground(Color.white);
        search1.setFont(new Font("Arial", Font.PLAIN, 25));
        image.add(search1);
        String skills[]={"Programmer","Speaking","COmmunication"};
        cbskills = new JComboBox(skills);
        cbskills.setBounds(450,410,150,30);
        image.add(cbskills);
        /*a2 = new JTextField();
        a2.setBounds(450, 410, 150, 30);
        image.add(a2);*/
        search2 = new JButton("SEARCH");
        search2.setBounds(650, 410, 120, 30);
        search2.setFont(new Font("Arial", Font.PLAIN, 20));
        search2.addActionListener(this);
        image.add(search2);
        table2 = new JTable();
        table2.setBounds(50, 450, 1100, 150);
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from jobseeker");
            table2.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        JScrollPane jsp2 = new JScrollPane(table2);
        jsp2.setBounds(50, 450, 1100, 150);
        image.add(jsp2);
        
        setSize(1200, 1000);
        setLocation(10, 10);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        
        if (ae.getSource() == searchb) {
            String s1 = (String) cbtitle.getSelectedItem();
            String query = "select * from job where job_title = '"+s1+"'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table1.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == search2) {
            String s2 = (String) cbskills.getSelectedItem();
            String query = "select * from jobseeker where skills = '"+s2+"'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table2.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == add) {
            setVisible(false);
            new job();
        }else if (ae.getSource() == loginA) {
            //setVisible(false);
            JOptionPane.showMessageDialog(null, "Work in progress, Wait for sometime");
        }else if (ae.getSource() == feedb) {
            setVisible(false);
            new efeedback();
            //JOptionPane.showMessageDialog(null, "Work in progress, Wait for sometime");
        }else if (ae.getSource() == back) {
            setVisible(false);
            new elogin();
            //JOptionPane.showMessageDialog(null, "Work in progress, Wait for sometime");
        } else {
            setVisible(false);
            new login();
        }
    }

    public static void main(String[] args) {
        new employermodule();
    }
    
}
