package collegemanagementsystem;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

class UpdateTeacher implements ActionListener{

    JFrame f;
    JLabel lupdate,lnew,lname,luser,lid,ldob,laddr,lph,lemail,ldept;
    JTextField ttempid,tname,tuser,tid,tdob,taddr,tph,temail;
    JButton b,b1,b2;
    JComboBox c1;

    UpdateTeacher(){
        f=new JFrame("Update Teacher details");
        f.setSize(900,650);
        f.setLocation(250,30); 
        f.setBackground(Color.white);
        f.setLayout(null);

        JLabel llempid = new JLabel("Enter employee id to update the data of teacher");
        llempid.setBounds(50,100,500,30);
        llempid.setFont(new Font("serif",Font.ITALIC,20));
        f.add(llempid);
        
        ttempid = new JTextField();
        ttempid.setBounds(500,100,200,30);
        f.add(ttempid);
        
        b2 = new JButton("Update");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(720,100,100,30);
        f.add(b2);
        b2.addActionListener(this);

        lupdate = new JLabel("Update Teacher Details:");
        lupdate.setBounds(50,10,500,50);
        lupdate.setFont(new Font("serif",Font.ITALIC,40));
        lupdate.setForeground(Color.black);
        f.add(lupdate);

        lname = new JLabel("Name");
        lname.setBounds(50,170,100,30);
        lname.setFont(new Font("serif",Font.BOLD,20));
        f.add(lname);

        tname=new JTextField();
        tname.setBounds(200,170,150,30);
        f.add(tname);

        luser = new JLabel("Username");
        luser.setBounds(400,170,100,30);
        luser.setFont(new Font("serif",Font.BOLD,20));
        f.add(luser);

        tuser=new JTextField();
        tuser.setBounds(600,170,150,30);
        f.add(tuser);

        lid= new JLabel("Emp id");
        lid.setBounds(50,220,100,30);
        lid.setFont(new Font("serif",Font.BOLD,20));
        f.add(lid);

        tid=new JTextField();
        tid.setBounds(200,220,150,30);
        f.add(tid);

        ldob= new JLabel("DOB (dd/mm/yyyy)");  
        ldob.setBounds(400,220,200,30);
        ldob.setFont(new Font("serif",Font.BOLD,20));
        f.add(ldob);

        tdob=new JTextField();
        tdob.setBounds(600,220,150,30);
        f.add(tdob);

        laddr= new JLabel("Address");
        laddr.setBounds(50,270,100,30);
        laddr.setFont(new Font("serif",Font.BOLD,20));
        f.add(laddr);

        taddr=new JTextField();
        taddr.setBounds(200,270,150,30);
        f.add(taddr);

        lph= new JLabel("Contact No");
        lph.setBounds(400,270,100,30);
        lph.setFont(new Font("serif",Font.BOLD,20));
        f.add(lph);

        tph=new JTextField();
        tph.setBounds(600,270,150,30);
        f.add(tph);

        lemail= new JLabel("Email Id");
        lemail.setBounds(50,320,100,30);
        lemail.setFont(new Font("serif",Font.BOLD,20));
        f.add(lemail);

        temail=new JTextField();
        temail.setBounds(200,320,150,30);
        f.add(temail);
        
        ldept= new JLabel("Department");
        ldept.setBounds(400,320,130,30);
        ldept.setFont(new Font("serif",Font.BOLD,20));    
        f.add(ldept);
        
        String dept[] = {"Physics","Mathematics","Chemistry","Biology","Computer Science","English","Political Science","Commerce","Economics"};
        c1 = new JComboBox(dept);
        c1.setBackground(Color.WHITE);
        c1.setBounds(600,320,150,30);
        f.add(c1);
        
        b = new JButton("Submit");
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.setBounds(250,520,150,40);
        
        f.add(b);

        b1=new JButton("Cancel");   
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(450,520,150,40);
        
        f.add(b1);
        
        b.addActionListener(this);
        b1.addActionListener(this);
        
        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b){
            try{
                conn c17 = new conn();
                String sdept = (String)c1.getSelectedItem();
                String str1 = "update teacher set name='"+tname.getText()+"',username='"+tuser.getText()+"',dob='"+tdob.getText()+"',address='"+taddr.getText()+"',contactno='"+tph.getText()+"',email='"+temail.getText()+"',department='"+sdept+"'where empid = '"+ttempid.getText()+"';";
                PreparedStatement st1 = c17.c.prepareStatement(str1);
                st1.executeUpdate(str1);
                JOptionPane.showMessageDialog(null,"successfully updated");
                f.setVisible(false);
                new TeacherDetails().setVisible(true);
                c17.c.close();
            }catch(HeadlessException | SQLException e){
                System.out.println("The error is:"+e);
            }
        }
        if(ae.getSource()==b1){
            f.setVisible(false);
        }
        if(ae.getSource() == b2){
            try{
                conn c18 = new conn();
                String str2 = "select * from teacher where empid = '"+ttempid.getText()+"';";
                PreparedStatement st2 = c18.c.prepareStatement(str2);
                ResultSet rs = st2.executeQuery(str2);

                if(rs.next()){
                    f.setVisible(true);
             
                    tname.setText(rs.getString("name"));
                    tuser.setText(rs.getString("username"));
                    tid.setText(rs.getString("empid"));
                    tdob.setText(rs.getString("dob"));
                    taddr.setText(rs.getString("address"));
                    tph.setText(rs.getString("contactno"));
                    temail.setText(rs.getString("email"));
                    c1.setSelectedItem(rs.getString("department"));
                }
                c18.c.close();
            }catch(SQLException ex){}
        }
    }

    public static void main(String[] arg){
        new UpdateTeacher().f.setVisible(true);
    }
}
