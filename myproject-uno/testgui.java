import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class testgui {

   
    
    public static void main(String[] args) {
        
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
        frame.setSize(1080, 720);
        Container c = frame.getContentPane();
        c.setBackground(Color.WHITE);
        c.setLayout(null);
        
        JPanel panelai = new JPanel();
        panelai.setBounds(0, 0, 850, 150);
        panelai.setBackground(Color.YELLOW);
        panelai.setLayout(null);
        c.add(panelai);

        JPanel panelPl = new JPanel();
        panelPl.setBounds(0, 535, 850, 150);
        panelPl.setBackground(Color.CYAN);
        panelPl.setLayout(null);
        c.add(panelPl);

        JPanel panelBd = new JPanel();
        panelBd .setBounds(0, 150, 850, 390);
        panelBd .setBackground(Color.WHITE);
        panelBd.setLayout(new BorderLayout());
        //panelBd .setLayout(null);
        c.add(panelBd );

        JPanel panelAc = new JPanel();
        panelAc.setBounds(850, 0, 230, 720);
        panelAc.setBackground(Color.BLACK);
        panelAc.setLayout(null);
        c.add(panelAc);

        JButton button1 = new JButton("end turn");
        button1.setBounds(50, 500, 100, 20);
        panelAc.add(button1);

        JButton button2 = new JButton("Draw card");
        button2.setBounds(50, 550, 100, 23);
        panelAc.add(button2);

        JButton button3 = new JButton("put card");
        button3.setBounds(50, 600, 100, 23);
        panelAc.add(button3);

         String a = "pok";

       ImageIcon img1 = new ImageIcon(a+".jpg");
       ImageIcon img2 = new ImageIcon("dis.jpg");
        JLabel label = new JLabel();
            label.setIcon(img1);

        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        panelBd.add(label);

        button1.addActionListener((ActionListener) new ActionListener() {
         
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setIcon(img2);  
            }});  

        }
    
}
