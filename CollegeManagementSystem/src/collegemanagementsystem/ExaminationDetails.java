package collegemanagementsystem;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;

public class ExaminationDetails extends JFrame implements ActionListener{

   private final JPanel contentPane;
   private JTable table;
   private final JTextField search;
   private final JButton b1;

    String x[] = {"Name","Username","Roll No","Stream","Class"};
    String y[][] = new String[20][5];
    int i=0, j=0;
    ExaminationDetails()
    {
        setBounds(350, 200, 930, 475);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        try{
            conn c19  = new conn();
            String s1 = "select * from student;";
            PreparedStatement st1 = c19.c.prepareStatement(s1);
            ResultSet rs  = st1.executeQuery(s1);
            while(rs.next()){
                y[i][j++]=rs.getString("name");
                y[i][j++]=rs.getString("username");
                y[i][j++]=rs.getString("rollno");
                y[i][j++]=rs.getString("stream");
                y[i][j++]=rs.getString("standard");
                i++;
                j=0;
            }
            table = new JTable(y,x);
            c19.c.close();
            }catch(SQLException sqle){
        }

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(70, 130, 1000, 280);
        contentPane.add(scrollPane);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
               int row = table.getSelectedRow();
               //roll no. obtained from 3rd column of the row clicked by mouse
               search.setText(table.getModel().getValueAt(row, 2).toString());
            }
        });
       
        table.setBackground(new Color(240, 248, 255));
        table.setForeground(Color.DARK_GRAY);
        table.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        scrollPane.setViewportView(table);

        b1 = new JButton("Result");
        b1.addActionListener(this);
        b1.setForeground(new Color(199, 21, 133));
        b1.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
        b1.setBounds(564, 89, 138, 33);
        contentPane.add(b1);

       
        JLabel l1 = new JLabel("Check Result");
        l1.setForeground(new Color(107, 142, 35));
        l1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 30));
        l1.setBounds(300, 15, 400, 47);
        contentPane.add(l1);

       
        search = new JTextField();
        search.setBackground(new Color(255, 240, 245));
        search.setBorder(new LineBorder(new Color(255, 105, 180), 2, true));
        search.setForeground(new Color(47, 79, 79));
        search.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 17));
        search.setBounds(189, 89, 357, 33);
        contentPane.add(search);
        search.setColumns(10);

        JLabel l3 = new JLabel("Back");
        l3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
            }
        });
        l3.setForeground(Color.GRAY);
        l3.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
        l3.setBounds(97, 89, 72, 33);
        contentPane.add(l3);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 128, 128), 3, true), "Examination-Details",
        TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 128, 0)));
        panel.setBounds(67, 54, 1100, 368);
        contentPane.add(panel);
        panel.setBackground(Color.WHITE);
        setSize(1200,500);
        setLocation(100,30);
   
        try {
            conn c5 = new conn();
            String sql = "select * from student;";
            PreparedStatement st = c5.c.prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            table.setModel(DbUtils.resultSetToTableModel(rs));
            c5.c.close();
        }catch(SQLException se) {}
    }
   
   @Override
    public void actionPerformed(ActionEvent ae){
        try{
            conn c20 = new conn();
            if(ae.getSource() == b1){            
                new Marks(Integer.parseInt(search.getText())).setVisible(true);
                this.setVisible(false);
            }
            c20.c.close();
        }catch(Exception e){}
    }

    public static void main(String[] args){
        new ExaminationDetails().setVisible(true);
    }
}
