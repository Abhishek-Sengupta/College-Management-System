package collegemanagementsystem;
import java.sql.*;  

public class conn
{
    Connection c;
    Statement s;
    public conn(){
        try{
            // Register mysql driver
            Class.forName("com.mysql.jdbc.Driver");
            // Establish connection with database
            c =DriverManager.getConnection("jdbc:mysql:///collegemanagementsystem","root","");
            s =c.createStatement();
        }catch(ClassNotFoundException | SQLException e){ 
            System.out.println(e);
        }  
    }  
}