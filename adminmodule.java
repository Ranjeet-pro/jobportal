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
public class adminmodule extends JFrame implements ActionListener{
    JButton loginout, back,addj, viewj, updatej, deletej, adde, viewe, updatee, deletee, addjs, viewjs, updatejs, deletejs;
    adminmodule(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(1200, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1200, 1000);
        add(image);

        JLabel heading = new JLabel("WELCOME ADMIN");
        heading.setBounds(150, 20, 1000, 100);
        heading.setFont(new Font("Raleway", Font.BOLD, 100));
        image.add(heading);
        JLabel job = new JLabel("JOBS");
        job.setBounds(100, 150, 150, 50);
        job.setFont(new Font("Raleway", Font.BOLD, 50));
        image.add(job);
        JLabel employer = new JLabel("EMPLOYERS");
        employer.setBounds(400, 150, 350, 50);
        employer.setFont(new Font("Raleway", Font.BOLD, 50));
        image.add(employer);
        JLabel jobseeker = new JLabel("JOB SEEKERS");
        jobseeker.setBounds(800, 150, 400, 50);
        jobseeker.setFont(new Font("Raleway", Font.BOLD, 50));
        image.add(jobseeker);
        loginout = new JButton("LOGOUT");
        loginout.setBounds(1000, 500, 150, 50);
        loginout.setFont(new Font("Arial", Font.PLAIN, 20));
        loginout.addActionListener(this);
        image.add(loginout);
        back = new JButton("BACK");
        back.setBounds(800, 500, 150, 50);
        back.setFont(new Font("Arial", Font.PLAIN, 20));
        back.addActionListener(this);
        image.add(back);

        addj = new JButton("Add Jobs");
        addj.setBounds(100, 230, 100, 40);
        addj.addActionListener(this);
        image.add(addj);
        viewj = new JButton("View jobs");
        viewj.setBounds(100, 280, 100, 40);
        viewj.addActionListener(this);
        image.add(viewj);
        updatej = new JButton("Update jobs");
        updatej.setBounds(100, 340, 100, 40);
        updatej.addActionListener(this);
        image.add(updatej);
        deletej = new JButton("Delete jobs");
        deletej.setBounds(100, 400, 100, 40);
        deletej.addActionListener(this);
        image.add(deletej);
        adde = new JButton("Add Employer");
        adde.setBounds(420, 230, 130, 40);
        adde.addActionListener(this);
        image.add(adde);
        viewe = new JButton("View Employer");
        viewe.setBounds(420, 280, 130, 40);
        viewe.addActionListener(this);
        image.add(viewe);
        updatee = new JButton("Update Employer");
        updatee.setBounds(420, 340, 130, 40);
        updatee.addActionListener(this);
        image.add(updatee);
        deletee = new JButton("Delete Employer");
        deletee.setBounds(420, 400, 130, 40);
        deletee.addActionListener(this);
        image.add(deletee);
        addjs = new JButton("Add Jobseeker");
        addjs.setBounds(830, 230, 150, 40);
        addjs.addActionListener(this);
        image.add(addjs);
        viewjs = new JButton("View jobseeker");
        viewjs.setBounds(830, 280, 150, 40);
        viewjs.addActionListener(this);
        image.add(viewjs);
        updatejs = new JButton("Update jobseeker");
        updatejs.setBounds(830, 340, 150, 40);
        updatejs.addActionListener(this);
        image.add(updatejs);
        deletejs = new JButton("Delete jobseeker");
        deletejs.setBounds(830, 400, 150, 40);
        deletejs.addActionListener(this);
        image.add(deletejs);

        setSize(1200, 1000);
        setLocation(10, 10);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addj) {
            setVisible(false);
            new addjobs();
        } else if (ae.getSource() == viewj) {
            setVisible(false);
            new addjobs();
        } else if (ae.getSource() == updatej) {
            setVisible(false);
            new addjobs();
        } else if (ae.getSource() == deletej) {
            setVisible(false);
            new addjobs();
        }else if (ae.getSource() == adde) {
            setVisible(false);
            new employer();
        }else if (ae.getSource() == viewe) {
            setVisible(false);
            new employer();
        } else if (ae.getSource() == updatee) {
            setVisible(false);
            new employer();
        } else if (ae.getSource() == deletee) {
            setVisible(false);
            new employer();
        }else if (ae.getSource() == addjs) {
            setVisible(false);
            new jobseeker();
        }else if (ae.getSource() == viewjs) {
            setVisible(false);
            new jobseeker();
        } else if (ae.getSource() == updatejs) {
            setVisible(false);
            new jobseeker();
        }else if (ae.getSource() == loginout) {
            setVisible(false);
            new login();
        }else if (ae.getSource() == back) {
            setVisible(false);
            new adminlogin();
        } else {
            setVisible(false);
            new jobseeker();
        }
    }
    
    public static void main(String[] args) {
        new adminmodule();
    }
    
}
