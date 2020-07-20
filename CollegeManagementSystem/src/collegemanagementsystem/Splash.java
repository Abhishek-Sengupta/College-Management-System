package collegemanagementsystem;
import java.awt.*;
import javax.swing.*;

public class Splash
{
    public static void main(String s[])
    {
        Frame f = new Frame(); 
        f.setVisible(true); 
        f.setSize(1060,740);
        f.setLocation(150,0);
    }
}

class Frame extends JFrame implements Runnable{
    Thread t1;
    Frame(){
        super("College Management System");
        setLayout(new FlowLayout());
        ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("collegemanagementsystem/icons/clgbuilding.jpg"));
        Image i1 = c1.getImage().getScaledInstance(1060, 740,Image.SCALE_DEFAULT);
         // To add the image to the JFrame, we use JLabel, in which we can't pass the image directly,
         // but it can accept an image icon object instead.
         // So we convert the image to an image icon object.
        ImageIcon i2 = new ImageIcon(i1);
        JLabel j1 = new JLabel(i2);
        add(j1);
        t1 = new Thread(this);
        t1.start(); // implicitly calls run method
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    @Override
    public void run(){
        try{
            // Display the Splash screen for 5 seconds & then display login screen
            Thread.sleep(5000);
            this.setVisible(false);
            new Login().setVisible(true);
            
        }catch(InterruptedException e){
        }
    }
}
