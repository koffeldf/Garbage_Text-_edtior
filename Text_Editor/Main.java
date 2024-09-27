import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main 
{
    public static void main(String[] args) throws IOException
    {
        ImageIcon icon = new ImageIcon("icon.jpg");
        
        String filep = "/home";
        boolean rfp = false;
        JLabel lublw = new JLabel();
        lublw.setText("Type_File_Path");
        lublw.setHorizontalAlignment(JLabel.CENTER);
        lublw.setSize(300, 300);
        lublw.setFont(new Font("Verdana", Font.PLAIN, 18));
       
        JTextField jf = new JTextField();
        jf.setTes

        JFrame frame = new JFrame();
        frame.isAlwaysOnTop();
        frame.setIconImage(icon.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setTitle("TEXT_THING");
        frame.setSize(600, 600);
        frame.setVisible(true);
        frame.add(lublw);
        Scanner input = new Scanner(System.in);
       while(!rfp)
       {
        filep = input.nextLine();
        lublw.setText(filep + " |is this right ?");
        String rfpyn = input.nextLine();
        if(rfpyn.equals("yes"))
        {
            rfp = true;
        }        
       }
       lublw.setText("Type what You want in the File");
       String filecon = input.nextLine();
       FileWriter writ = new FileWriter(filep);
       writ.write(filecon);
       writ.close();
       lublw.setText("BY");
       input.close();
       System.exit(0);
    }
}
