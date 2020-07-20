package collegemanagementsystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;

class AddTeacher implements ActionListener{

    JFrame f;
    JLabel lbg,lnew,lname,luser,lid,ldob,laddr,lph,lemail,ldept;
    JTextField tname,tuser,tid,tdob,taddr,tph,temail;
    JButton b,b1,b2,b3;
    JComboBox c1;
      
    public AddTeacher(){
        f = new JFrame("Add Teacher");
        f.setBackground(Color.white);
        f.setLayout(null);

        lbg = new JLabel();
        lbg.setBounds(0,0,900,700);
        lbg.setLayout(null);
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("collegemanagementsystem/icons/general.jpeg"));
        Image i3 = img.getImage().getScaledInstance(1220, 700,Image.SCALE_DEFAULT);
        ImageIcon icc3 = new ImageIcon(i3);
        lbg.setIcon(icc3);

        lnew = new JLabel("New Teacher Details");
        lnew.setBounds(320,30,500,50);
        lnew.setFont(new Font("serif",Font.ITALIC,25));
        lnew.setForeground(Color.black);
        lbg.add(lnew);
        f.add(lbg);

        lname = new JLabel("Name");
        lname.setBounds(50,150,100,30);
        lname.setFont(new Font("serif",Font.BOLD,20));
        lbg.add(lname);

        tname=new JTextField();
        tname.setBounds(200,150,150,30);
        lbg.add(tname);

        luser = new JLabel("Username");
        luser.setBounds(400,150,200,30);
        luser.setFont(new Font("serif",Font.BOLD,20));
        lbg.add(luser);

        tuser=new JTextField();
        tuser.setBounds(600,150,150,30);
        lbg.add(tuser);

        lid= new JLabel("Emp id");
        lid.setBounds(50,200,100,30);
        lid.setFont(new Font("serif",Font.BOLD,20));
        lbg.add(lid);

        tid=new JTextField();
        tid.setBounds(200,200,150,30);
        lbg.add(tid);

        ldob= new JLabel("DOB (dd/mm/yyyy)");  
        ldob.setBounds(400,200,200,30);
        ldob.setFont(new Font("serif",Font.BOLD,20));
        lbg.add(ldob);

        tdob=new JTextField();
        tdob.setBounds(600,200,150,30);
        lbg.add(tdob);

        laddr= new JLabel("Address");
        laddr.setBounds(50,250,100,30);
        laddr.setFont(new Font("serif",Font.BOLD,20));
        lbg.add(laddr);

        taddr=new JTextField();
        taddr.setBounds(200,250,150,30);
        lbg.add(taddr);

        lph= new JLabel("Contact No");
        lph.setBounds(400,250,100,30);
        lph.setFont(new Font("serif",Font.BOLD,20));
        lbg.add(lph);

        tph=new JTextField();
        tph.setBounds(600,250,150,30);
        lbg.add(tph);

        lemail= new JLabel("Email Id");
        lemail.setBounds(50,300,100,30);
        lemail.setFont(new Font("serif",Font.BOLD,20));
        lbg.add(lemail);

        temail=new JTextField();
        temail.setBounds(200,300,150,30);
        lbg.add(temail);
        
        ldept= new JLabel("Department");
        ldept.setBounds(400,300,130,30);
        ldept.setFont(new Font("serif",Font.BOLD,20));    
        lbg.add(ldept);
        
        String dept[] = {"Physics","Mathematics","Chemistry","Biology","Computer Science","English","Political Science","Commerce","Economics"};
        c1 = new JComboBox(dept);
        c1.setBackground(Color.WHITE);
        c1.setBounds(600,300,150,30);
        lbg.add(c1);
        
        b = new JButton("Submit");
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.setBounds(250,550,150,40);
        
        lbg.add(b);

        b1=new JButton("Cancel");   
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(450,550,150,40);
        
        lbg.add(b1);
        
        b.addActionListener(this);
        b1.addActionListener(this);
        
        f.setVisible(true);
        f.setSize(900,700);
        f.setLocation(250,30);
        f.getContentPane().setBackground(Color.WHITE);
    }

    @Override
    public void actionPerformed(ActionEvent ae){
        
        String name = tname.getText();
        String username = tuser.getText();
        String empid = tid.getText();
        String dob = tdob.getText();
        String address = taddr.getText();
        String contactno = tph.getText();
        String email = temail.getText();
        String department = (String)c1.getSelectedItem();
        
        if(ae.getSource() == b){
            try{
                conn c2 = new conn();
                String q = "insert into teacher values('"+name+"','"+username+"','"+empid+"','"+dob+"','"+address+"','"+contactno+"','"+email+"','"+department+"');";
                PreparedStatement st = c2.c.prepareStatement(q);
                st.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Teacher Details Inserted Successfully");
                f.setVisible(false);
                c2.c.close();
            }catch(HeadlessException | SQLException ee){
                System.out.println("Error: "+ee);
            }
        }else if(ae.getSource() == b1){
            f.setVisible(false);
        }
    }
    public static void main(String[] arg){
        new AddTeacher().f.setVisible(true);
    }
}