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
public class ajob extends JFrame implements ActionListener{
    JButton loginout, back,b1,b2,b3,b4;
    JTextField title,loc,des,sal,res,work;
    Choice id;
    ajob(){
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
        JLabel lblid=new JLabel("Job id");
        lblid.setBounds(50, 160, 150, 30);
        lblid.setForeground(Color.white);
        lblid.setFont(new Font("Arial", Font.PLAIN, 18));
        image.add(lblid);
        id = new Choice();
        id.setBounds(200, 160, 150, 30);
        id.setFont(new Font("Arial", Font.PLAIN, 18));
        image.add(id);
        JLabel lbltitle=new JLabel("Job Title");
        lbltitle.setBounds(400, 160, 150, 30);
        lbltitle.setForeground(Color.white);
        lbltitle.setFont(new Font("Arial", Font.PLAIN, 18));
        image.add(lbltitle);
        title = new JTextField();
        title.setBounds(550, 160, 150, 30);
        title.setFont(new Font("Arial", Font.PLAIN, 18));
        image.add(title);
        JLabel lbldes=new JLabel("Description");
        lbldes.setBounds(750, 160, 150, 30);
        lbldes.setForeground(Color.white);
        lbldes.setFont(new Font("Arial", Font.PLAIN, 18));
        image.add(lbldes);
        des = new JTextField();
        des.setBounds(900, 160, 150, 30);
        des.setFont(new Font("Arial", Font.PLAIN, 18));
        image.add(des);
        JLabel lblloc=new JLabel("Job location");
        lblid.setBounds(50, 200, 150, 30);
        lblid.setForeground(Color.white);
        lblid.setFont(new Font("Arial", Font.PLAIN, 18));
        image.add(lblid);
        loc = new JTextField();
        loc.setBounds(200, 200, 150, 30);
        loc.setFont(new Font("Arial", Font.PLAIN, 18));
        image.add(loc);
        JLabel lblsal=new JLabel("Salary");
        lblsal.setBounds(400, 200, 150, 30);
        lblsal.setForeground(Color.white);
        lblsal.setFont(new Font("Arial", Font.PLAIN, 18));
        image.add(lblsal);
        sal = new JTextField();
        sal.setBounds(550, 200, 150, 30);
        sal.setFont(new Font("Arial", Font.PLAIN, 18));
        image.add(sal);
        JLabel lblres=new JLabel("Responsibilities");
        lblres.setBounds(750, 200, 170, 30);
        lblres.setForeground(Color.white);
        lblres.setFont(new Font("Arial", Font.PLAIN, 18));
        image.add(lblres);
        res = new JTextField();
        res.setBounds(920, 200, 150, 30);
        res.setFont(new Font("Arial", Font.PLAIN, 18));
        image.add(res);
        JLabel lblwr=new JLabel("Working hrs.");
        lblwr.setBounds(50, 240, 150, 30);
        lblwr.setForeground(Color.white);
        lblwr.setFont(new Font("Arial", Font.PLAIN, 18));
        image.add(lblwr);
        work = new JTextField();
        work.setBounds(200, 240, 150, 30);
        work.setFont(new Font("Arial", Font.PLAIN, 18));
        image.add(work);
        JTable table1 = new JTable();
        table1.setBounds(50, 280, 900, 200);
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from job");
            table1.setModel(DbUtils.resultSetToTableModel(rs));
            while(rs.next()){
                id.add(rs.getString("job_id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        JScrollPane jsp = new JScrollPane(table1);
        jsp.setBounds(50, 280, 900, 200);
        image.add(jsp);
        b1 = new JButton("ADD JOB");
        b1.setBounds(50, 490, 100, 40);
        image.add(b1);
        b2 = new JButton("UPDATE JOB");
        b2.setBounds(160, 490, 120, 40);
        image.add(b2);
        b3 = new JButton("DELETE JOB");
        b3.setBounds(290, 490, 120, 40);
        image.add(b3);
        b4 = new JButton("VIEW JOB");
        b4.setBounds(420, 490, 120, 40);
        image.add(b4);
        
        setSize(1200, 1000);
        setLocation(10, 10);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==b1){
            String jtitle=title.getText();
        String jloc=loc.getText();
        String jdes=des.getText();
        String jsal=sal.getText();
        String jres=res.getText();
        String jwr=work.getText();
        try{
           Conn c=new Conn();
           String query="select * from job where job_id = '"+id.getSelectedItem()+"'";
           ResultSet rs=c.s.executeQuery(query);
        }catch(Exception e){
            e.printStackTrace();
        }
        }   
    }
    public static void main(String[] args){
        new ajob();
    }
}
