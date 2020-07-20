package collegemanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class Marks extends JFrame{

   JTextArea t1;
   JPanel p1;
   
   Marks(){}
   Marks(int roll){
       setSize(500,600);
       setLayout(new BorderLayout());
       
       p1 = new JPanel();

       t1 = new JTextArea(50,15);
       JScrollPane jsp = new JScrollPane(t1);
       t1.setFont(new Font("Senserif",Font.ITALIC,18));
       
       add(p1,"North");
       
       add(jsp,"Center");
       
       setLocation(250,30);
       mark(roll);
   }
   
   public void mark(int r){
    try{
           conn c6 = new conn();
           t1.setText("\tEXAMINATION RESULTS\n\n\tSUBJECTS\n");
           String sql1 = "select * from subject where rollno='"+r+"';";
           PreparedStatement st1 = c6.c.prepareStatement(sql1);
           ResultSet rs1 = st1.executeQuery();
           
           if(rs1.next()){
               t1.append("\n\t"+rs1.getString("subject1"));
               t1.append("\n\t"+rs1.getString("subject2"));
               t1.append("\n\t"+rs1.getString("subject3"));
               t1.append("\n\t"+rs1.getString("subject4"));
               t1.append("\n\t"+rs1.getString("subject5"));
               t1.append("\n-------------------------------------------------");
               t1.append("\n");
           }
           String sql2 = "select * from marks where rollno='"+r+"';";
           PreparedStatement st2 = c6.c.prepareStatement(sql2);
           ResultSet rs2 = st2.executeQuery(sql2);
           
           if(rs2.next()){
               int marks1 = Integer.parseInt(rs2.getString("marks1"));
               int marks2 = Integer.parseInt(rs2.getString("marks2"));
               int marks3 = Integer.parseInt(rs2.getString("marks3"));
               int marks4 = Integer.parseInt(rs2.getString("marks4"));
               int marks5 = Integer.parseInt(rs2.getString("marks5"));
               int total = marks1+marks2+marks3+marks4+marks5;
               
               t1.append("\n\tMARKS\n\n\t"+rs2.getString("marks1"));
               t1.append("\n\t"+rs2.getString("marks2"));
               t1.append("\n\t"+rs2.getString("marks3"));
               t1.append("\n\t"+rs2.getString("marks4"));
               t1.append("\n\t"+rs2.getString("marks5"));
               t1.append("\n-------------------------------------------------");
               t1.append("\n");
               t1.append("\n\tTotal Marks:\t");
               t1.append(total+"/500");
           }
           c6.c.close();
       }catch(SQLException e){
       }
   }
   
   public static void main(String[] args){
       new Marks().setVisible(true);
   }
}
