package collegemanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class StudentDetails extends JFrame implements ActionListener{
 
    JLabel l1,l2,l3;
    JTable tstu;
    JButton b1,b2,b3;
    JTextField t2;
   
    String x[] = {"Name","Username","Roll No","DOB","Address","Contact No","Email","Class","Stream"};
    String y[][] = new String[20][9];
    int i=0, j=0;
    StudentDetails(){
        super("Student Details");
        setSize(1260,650);
        setLocation(50,30);
        setLayout(null);
        
        l1 = new JLabel("Enter roll number to delete Student : ");
        l1.setBounds(50,360,400,30);
        l1.setFont(new Font("serif",Font.BOLD,20));
        add(l1);
        
        t2 = new JTextField();
        t2.setBounds(400,360,200,30);
        add(t2);
        
        b1 = new JButton("Delete");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(620, 360, 100 ,30);
        add(b1);
            
        l2 = new JLabel("Add New Student");
        l2.setBounds(50,450,400,30);
        l2.setFont(new Font("serif",Font.BOLD,20));
        add(l2);
        
        b2 = new JButton("Add Student");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(300, 450, 150 ,30);
        add(b2);
        
        l3 = new JLabel("Update Student Details");
        l3.setBounds(50,490,400,30);
        l3.setFont(new Font("serif",Font.BOLD,20));
        add(l3);
        
        b3 = new JButton("Update Student");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(300, 490, 150 ,30);
        add(b3);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        
        try{
            conn c9  = new conn();
            String s1 = "select * from student;";
            PreparedStatement st1 = c9.c.prepareStatement(s1);
            ResultSet rs  = st1.executeQuery(s1);
            while(rs.next()){
                y[i][j++]=rs.getString("name");
                y[i][j++]=rs.getString("username");
                y[i][j++]=rs.getString("rollno");
                y[i][j++]=rs.getString("dob");
                y[i][j++]=rs.getString("address");
                y[i][j++]=rs.getString("contactno");
                y[i][j++]=rs.getString("email");
                y[i][j++]=rs.getString("standard");
                y[i][j++]=rs.getString("stream");
                i++;
                j=0;
            }
            tstu = new JTable(y,x);
            c9.c.close();
            }catch(SQLException e){
        }
        
        JScrollPane sp = new JScrollPane(tstu);
        sp.setBounds(20,20,1200,330);
        add(sp);
        
        getContentPane().setBackground(Color.WHITE);
        
        b1.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        
        conn c10  = new conn();
        if(ae.getSource() == b1){
            try{
                String a = t2.getText();
                String q = "delete from student where rollno = '"+a+"';";
                PreparedStatement st2 = c10.c.prepareStatement(q);
                c10.s.executeUpdate(q);
                this.setVisible(false);
                new StudentDetails().setVisible(true);
                c10.c.close();
            }catch(SQLException e){}
    
        }else if(ae.getSource() == b2){
            new AddStudent().f.setVisible(true);
            this.setVisible(false);
        }else if(ae.getSource() == b3){
            new UpdateStudent().f.setVisible(true);
            this.setVisible(false);
        }
    }
    public static void main(String[] args){
        new StudentDetails().setVisible(true);
    }
    
}

