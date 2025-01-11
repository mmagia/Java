import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MyPersonalFrame extends JFrame{
    public MyPersonalFrame() {
        Color backgroundColor = new Color(240, 240, 240);
        ImageIcon image = new ImageIcon("appLogo.png"); // creates imageIcon
        this.setTitle("My wonderful password manager!"); // sets title of this
        this.setLocation(520, 320);
        //this.setResizable(false); // prevent this from being resized
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500); // sets the x,y dimensions
        this.setVisible(true); // makes this visible
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(backgroundColor); // change color of background
    }
}
