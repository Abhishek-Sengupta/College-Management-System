package collegemanagementsystem;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

class UpdateStudent implements ActionListener{

    JFrame f;
    JLabel lupdate,lnew,lname,luser,lroll,ldob,laddr,lph,lemail,lstream,lclass;
    JTextField ttroll,tname,tuser,troll,tdob,taddr,tph,temail;
    JButton b,b1,b2;
    JComboBox c1,c2;

    UpdateStudent(){
        f=new JFrame("Update Student details");
        f.setSize(900,650);
        f.setLocation(250,30);
        f.setBackground(Color.white);
        f.setLayout(null);

        JLabel llroll = new JLabel("Enter roll number to update the data of student");
        llroll.setBounds(50,100,500,30);
        llroll.setFont(new Font("serif",Font.ITALIC,20));
        f.add(llroll);
        
        ttroll = new JTextField();
        ttroll.setBounds(500,100,200,30);
        f.add(ttroll);
        
        b2 = new JButton("Update");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(720,100,100,30);
        f.add(b2);
        b2.addActionListener(this);
 
        lupdate = new JLabel("Update Student Details:");
        lupdate.setBounds(50,10,500,50);
        lupdate.setFont(new Font("serif",Font.ITALIC,40));
        lupdate.setForeground(Color.black);
        f.add(lupdate);

        lname = new JLabel("Name");
        lname.setBounds(50,150,100,30);
        lname.setFont(new Font("serif",Font.BOLD,20));
        f.add(lname);

        tname=new JTextField();
        tname.setBounds(200,150,150,30);
        f.add(tname);

        luser = new JLabel("Username");
        luser.setBounds(400,150,200,30);
        luser.setFont(new Font("serif",Font.BOLD,20));
        f.add(luser);

        tuser=new JTextField();
        tuser.setBounds(600,150,150,30);
        f.add(tuser);

        lroll= new JLabel("Roll No");
        lroll.setBounds(50,200,100,30);
        lroll.setFont(new Font("serif",Font.BOLD,20));
        f.add(lroll);

        troll=new JTextField();
        troll.setBounds(200,200,150,30);
        f.add(troll);

        ldob= new JLabel("DOB (dd/mm/yyyy)");  
        ldob.setBounds(400,200,200,30);
        ldob.setFont(new Font("serif",Font.BOLD,20));
        f.add(ldob);

        tdob=new JTextField();
        tdob.setBounds(600,200,150,30);
        f.add(tdob);

        laddr= new JLabel("Address");
        laddr.setBounds(50,250,100,30);
        laddr.setFont(new Font("serif",Font.BOLD,20));
        f.add(laddr);

        taddr=new JTextField();
        taddr.setBounds(200,250,150,30);
        f.add(taddr);

        lph= new JLabel("Contact No");
        lph.setBounds(400,250,100,30);
        lph.setFont(new Font("serif",Font.BOLD,20));
        f.add(lph);

        tph=new JTextField();
        tph.setBounds(600,250,150,30);
        f.add(tph);

        lemail= new JLabel("Email Id");
        lemail.setBounds(50,300,100,30);
        lemail.setFont(new Font("serif",Font.BOLD,20));
        f.add(lemail);

        temail=new JTextField();
        temail.setBounds(200,300,150,30);
        f.add(temail);

        lstream= new JLabel("Stream");
        lstream.setBounds(400,300,130,30);
        lstream.setFont(new Font("serif",Font.BOLD,20));    
        f.add(lstream);
        
        String stream[] = {"Humanities","Commerce","Science"};
        c1 = new JComboBox(stream);
        c1.setBackground(Color.WHITE);
        c1.setBounds(600,300,150,30);
        f.add(c1);

        lclass= new JLabel("Class");
        lclass.setBounds(50,350,130,30);
        lclass.setFont(new Font("serif",Font.BOLD,20));
        f.add(lclass);

        String classs[] = {"11","12"};
        c2 = new JComboBox(classs);
        c2.setBackground(Color.WHITE);
        c2.setBounds(200,350,150,30);
        f.add(c2);
        
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
                conn c15 = new conn();
                String sstream = (String)c1.getSelectedItem();
                String sclass = (String)c2.getSelectedItem();
                String str1 = "update student set name='"+tname.getText()+"',username='"+tuser.getText()+"',dob='"+tdob.getText()+"',address='"+taddr.getText()+"',contactno='"+tph.getText()+"',email='"+temail.getText()+"',stream='"+sstream+"',standard='"+sclass+"' where rollno = '"+ttroll.getText()+"';";
                PreparedStatement st1 = c15.c.prepareStatement(str1);
                st1.executeUpdate(str1);
                JOptionPane.showMessageDialog(null,"successfully updated");
                f.setVisible(false);
                new StudentDetails().setVisible(true);
                c15.c.close();
            }catch(HeadlessException | SQLException e){
                System.out.println("The error is:"+e);
            }
        }
        if(ae.getSource()==b1){
            f.setVisible(false);
        }
        if(ae.getSource() == b2){
            try{
                conn c16 = new conn();
                String str2 = "select * from student where rollno = '"+ttroll.getText()+"';";
                PreparedStatement st2 = c16.c.prepareStatement(str2);
                ResultSet rs = st2.executeQuery(str2);

                if(rs.next()){
                    f.setVisible(true);
                    
                    tname.setText(rs.getString("name"));
                    tuser.setText(rs.getString("username"));
                    troll.setText(rs.getString("rollno"));
                    tdob.setText(rs.getString("dob"));
                    taddr.setText(rs.getString("address"));
                    tph.setText(rs.getString("contactno"));
                    temail.setText(rs.getString("email"));
                    c1.setSelectedItem(rs.getString("stream"));
                    c2.setSelectedItem(rs.getString("standard"));
                }
                c16.c.close();
            }catch(SQLException ex){}
        }
    }

    public static void main(String[] arg){
        new UpdateStudent().f.setVisible(true);
    }
}