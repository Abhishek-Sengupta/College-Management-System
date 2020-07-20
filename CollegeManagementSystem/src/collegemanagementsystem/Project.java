package collegemanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Project extends JFrame implements ActionListener{
    Project(){
        super("College Management System");
        setLocation(150,0);
        setSize(1060,740);
        
        ImageIcon ic =  new ImageIcon(ClassLoader.getSystemResource("collegemanagementsystem/icons/clgbg.jpeg"));
        Image i3 = ic.getImage().getScaledInstance(1060, 740,Image.SCALE_DEFAULT);
        ImageIcon icc3 = new ImageIcon(i3);
        JLabel l1 = new JLabel(icc3);
        
        add(l1);
        
        JMenuBar mb  = new JMenuBar();
        JMenu cmenu = new JMenu("Create New");
        JMenuItem m1 = new JMenuItem("New Faculty");
        JMenuItem m2 = new JMenuItem("New Staff");
        JMenuItem m3 = new JMenuItem("New Student Admission");
        cmenu.setForeground(Color.BLUE);
        
        
        m1.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("collegemanagementsystem/icons/new.png"));
        Image image1 = icon1.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
        m1.setIcon(new ImageIcon(image1));
        m1.setBackground(Color.WHITE);
        
        m2.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon2 = new ImageIcon(ClassLoader.getSystemResource("collegemanagementsystem/icons/new.png"));
        Image image2 = icon2.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        m2.setIcon(new ImageIcon(image2));
        m2.setBackground(Color.WHITE);
        
        m3.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon3 = new ImageIcon(ClassLoader.getSystemResource("collegemanagementsystem/icons/new.png"));
        Image image3 = icon3.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        m3.setIcon(new ImageIcon(image3));
        m3.setBackground(Color.WHITE);
    
        m1.addActionListener(this);
        m2.addActionListener(this);
        m3.addActionListener(this);
        
        JMenu user = new JMenu("Details");
        JMenuItem u1 = new JMenuItem("Student Details");
        JMenuItem u2 = new JMenuItem("Teacher Details");
        JMenuItem u3 = new JMenuItem("Staff Details");
        user.setForeground(Color.BLUE);
        
        u1.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon4 = new ImageIcon(ClassLoader.getSystemResource("collegemanagementsystem/icons/details.jpg"));
        Image image4 = icon4.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
        u1.setIcon(new ImageIcon(image4));
        u1.setBackground(Color.WHITE);
        
        u2.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon5 = new ImageIcon(ClassLoader.getSystemResource("collegemanagementsystem/icons/details.jpg"));
        Image image5 = icon5.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
        u2.setIcon(new ImageIcon(image5));
        u2.setBackground(Color.WHITE);
        
        u3.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon6 = new ImageIcon(ClassLoader.getSystemResource("collegemanagementsystem/icons/details.jpg"));
        Image image6 = icon6.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
        u3.setIcon(new ImageIcon(image6));
        u3.setBackground(Color.WHITE);
        
        u1.addActionListener(this);
        u2.addActionListener(this);
        u3.addActionListener(this);
        
        
        JMenu exam = new JMenu("Examination");
        JMenuItem c1 = new JMenuItem("Examination Details");
        JMenuItem c2 = new JMenuItem("Enter Marks");
        exam.setForeground(Color.BLUE);
        
        c1.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon30 = new ImageIcon(ClassLoader.getSystemResource("collegemanagementsystem/icons/exam.png"));
        Image image31 = icon30.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
        c1.setIcon(new ImageIcon(image31));
        c1.setBackground(Color.WHITE);
        exam.add(c1);
        
        c2.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon32 = new ImageIcon(ClassLoader.getSystemResource("collegemanagementsystem/icons/exam.png"));
        Image image33 = icon32.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
        c2.setIcon(new ImageIcon(image33));
        c2.setBackground(Color.WHITE);
        exam.add(c2);

        c1.addActionListener(this);
        c2.addActionListener(this);
        
        JMenu update = new JMenu("Update Details");
        JMenuItem r1 = new JMenuItem("Update Student Record");
        JMenuItem r2 = new JMenuItem("Update Teacher Record");
        JMenuItem r3 = new JMenuItem("Update Staff Record");
        update.setForeground(Color.BLUE);
        
        r1.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon7 = new ImageIcon(ClassLoader.getSystemResource("collegemanagementsystem/icons/update.png"));
        Image image7 = icon7.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
        r1.setIcon(new ImageIcon(image7));
        r1.setBackground(Color.WHITE);
        
        r1.addActionListener(this);
        
        r2.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon8 = new ImageIcon(ClassLoader.getSystemResource("collegemanagementsystem/icons/update.png"));
        Image image8 = icon8.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
        r2.setIcon(new ImageIcon(image8));
        r2.setBackground(Color.WHITE);
        
        r2.addActionListener(this);
        
        r3.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon9 = new ImageIcon(ClassLoader.getSystemResource("collegemanagementsystem/icons/update.png"));
        Image image9 = icon9.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
        r3.setIcon(new ImageIcon(image9));
        r3.setBackground(Color.WHITE);
        
        r3.addActionListener(this);
        
        JMenu exit = new JMenu("Exit");
        JMenuItem logout = new JMenuItem("Logout");
        exit.setForeground(Color.BLUE);
        logout.setFont(new Font("monospaced",Font.BOLD,16));
        logout.setBackground(Color.WHITE);
        
        logout.addActionListener(this);
        exit.add(logout);
        
        cmenu.add(m1);
        cmenu.add(m2);
        cmenu.add(m3);
        
        user.add(u1);
        user.add(u2);
        user.add(u3);
        
        update.add(r1);
        update.add(r2);
        update.add(r3);
         
        mb.add(cmenu);
        mb.add(user);
        mb.add(exam);
        mb.add(update);
        mb.add(exit);
        
        setJMenuBar(mb);
        setFont(new Font("Senserif",Font.BOLD,16));
        setLayout(new FlowLayout());
        setVisible(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        String msg = ae.getActionCommand();
        if(msg.equals("New Student Admission")){
            new AddStudent().f.setVisible(true);
            
        }else if(msg.equals("New Faculty")){
            new AddTeacher().f.setVisible(true);
            
        }else if(msg.equals("New Staff")){
            new AddStaff().f.setVisible(true);
            
        }else if(msg.equals("Student Details")){
            new StudentDetails().setVisible(true);
            
        }else if(msg.equals("Teacher Details")){
            new TeacherDetails().setVisible(true);
            
        }else if(msg.equals("Staff Details")){
            new StaffDetails().setVisible(true);
            
        }else if(msg.equals("Update Student Record")){
            new UpdateStudent().f.setVisible(true);
            
        }else if(msg.equals("Update Teacher Record")){
            new UpdateTeacher().f.setVisible(true);
            
        }else if(msg.equals("Update Staff Record")){
            new UpdateStaff().f.setVisible(true);
            
        }else if(msg.equals("Examination Details")){
            new ExaminationDetails().setVisible(true);
            
        }else if(msg.equals("Enter Marks")){
            new EnterMarks().setVisible(true);
        }
        
        else if(msg.equals("Logout")){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    public static void main(String[] args){
        new Project().setVisible(true);
    }
}