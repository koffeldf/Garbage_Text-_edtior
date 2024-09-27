import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main extends JPanel 
{

    public Main () 
    {
        setLayout(null);
        setBackground(Color.DARK_GRAY);
        
        JButton savef = new JButton("Save");
        savef.setSize(100, 30);
        savef.setBounds(300,0,100,30);
        savef.setBorderPainted(false);
        savef.setBackground(Color.BLACK);
        savef.setFocusable(false);
        savef.setForeground(Color.DARK_GRAY);
        savef.setVisible(false);
 
        JButton open = new JButton("Open");
        open.setSize(100, 30);
        open.setBounds(180,0,100,30);
        open.setBorderPainted(false);
        open.setBackground(Color.BLACK);
        open.setFocusable(false);
        open.setForeground(Color.DARK_GRAY);

        JTextArea edt = new JTextArea();
        edt.setSize(400,400);
        edt.setBounds(0,30,600,500);
        edt.setVisible(true);
        edt.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 19));
        edt.setForeground(Color.black);
        edt.setBackground(Color.gray);

        JLabel topbar = new JLabel();
        topbar.setText("DRED");
        topbar.setForeground(Color.BLACK);
        topbar.setFont(new Font("Agency FB", Font.BOLD, 30));
        topbar.setBounds(50, -80, 200, 200);
        JFileChooser cf = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text","java","py","cpp","c","html","css","js","c#");
        cf.setFileFilter(filter);
        
        boolean opn = false;

        open.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                cf.showSaveDialog(cf);
                String fina = null;
                try 
                {
                    FileReader fr = new FileReader(cf.getSelectedFile());
                    int i;
                    while((i=fr.read()) != -1)
                    {
                        fina += (char)i;
                    }
                } 
                catch (IOException e1) {
                    
                    e1.printStackTrace();
                }
                savef.setVisible(true);
                edt.setText(fina);
            }
        });

        savef.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                String filep = cf.getSelectedFile().getAbsolutePath().toString();
                FileWriter fw;
                try 
                {
                    fw = new FileWriter(filep);
                    fw.write(edt.getText());
                    fw.close();
                } 
                catch (IOException e1) 
                {
                    e1.printStackTrace();
                }
                ;
            
            }
        });

        add(edt);
        add(topbar);
        add(open);
        add(savef);
    }

    @Override
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.lightGray);
        g2d.setStroke(new BasicStroke(60));
        g2d.drawLine(0, 0, 1960, 0);
    }

 public static void main(String[] args) 
 {
  ImageIcon logo = new ImageIcon("edicon.jpg");
       
       JFrame Window = new JFrame("Dred_Text_Ed");
       Window.setSize(600, 400);
       Window.setResizable(false);
       Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       Window.add(new Main());
       Window.setIconImage(logo.getImage());
       Window.setVisible(true);
 }
}