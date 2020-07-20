package collegemanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class StaffDetails extends JFrame implements ActionListener{
 
    JLabel l1,l2,l3;
    JTable tstaff;
    JButton b1,b2,b3;
    JTextField t2;
    String x[] = {"Name","Username","Employee ID","DOB","Address","Contact No","Email","Designation"};
    String y[][] = new String[20][8];
    int i=0, j=0;
    StaffDetails(){
        super("Staff Details");
        setSize(1260,650);
        setLocation(50,30);
        setLayout(null);
        
        l1 = new JLabel("Enter employee id to delete Staff : ");
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
            
        l2 = new JLabel("Add New Staff");
        l2.setBounds(50,450,400,30);
        l2.setFont(new Font("serif",Font.BOLD,20));
        add(l2);
        
        b2 = new JButton("Add");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(300, 450, 150 ,30);
        add(b2);
        
        l3 = new JLabel("Update Staff Details");
        l3.setBounds(50,490,400,30);
        l3.setFont(new Font("serif",Font.BOLD,20));
        add(l3);
        
        b3 = new JButton("Update");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(300, 490, 150 ,30);
        add(b3);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        
        try{
            conn c7 = new conn();
            String s1 = "select * from staff;";
            PreparedStatement st1 = c7.c.prepareStatement(s1);
            ResultSet rs  = st1.executeQuery(s1);
            while(rs.next()){
                y[i][j++]=rs.getString("name");
                y[i][j++]=rs.getString("username");
                y[i][j++]=rs.getString("empid");
                y[i][j++]=rs.getString("dob");
                y[i][j++]=rs.getString("address");
                y[i][j++]=rs.getString("contactno");
                y[i][j++]=rs.getString("email");
                y[i][j++]=rs.getString("designation");
                i++;
                j=0;
            }
            tstaff = new JTable(y,x);
            c7.c.close();
            }catch(SQLException e){
        }
        
        JScrollPane sp = new JScrollPane(tstaff);
        sp.setBounds(20,20,1200,330);
        add(sp);
        
        getContentPane().setBackground(Color.WHITE);
        
        b1.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        
        conn c8 = new conn();
        if(ae.getSource() == b1){
            try{
                String a = t2.getText();
                String q = "delete from staff where empid = '"+a+"';";
                PreparedStatement st1 = c8.c.prepareStatement(q);
                st1.executeUpdate(q);

                this.setVisible(false);
                new StaffDetails().setVisible(true);
                c8.c.close();
            }catch(SQLException e){}
    
        }else if(ae.getSource() == b2){
            new AddStaff().f.setVisible(true);
            this.setVisible(false);
        }else if(ae.getSource() == b3){
            new UpdateStaff().f.setVisible(true);
            this.setVisible(false);
        }
    }
    public static void main(String[] args){
        new StaffDetails().setVisible(true);
    }   
}
