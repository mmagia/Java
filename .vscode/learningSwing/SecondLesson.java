import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class SecondLesson {
    // basics of labels in JAVA
    public static void main(String[] args) {
        MyPersonalFrame myFrame = new MyPersonalFrame();
        ImageIcon heart = new ImageIcon("Alina's Heart.png");
        JLabel label = new JLabel(); //create a label
        label.setText("I love Alina"); //set text to a label
        label.setForeground(Color.BLACK); //set font color
        label.setFont(new Font("MV Boli", Font.BOLD, 20)); //set font and its size
        label.setIcon(heart); //set icon to a label
        label.setHorizontalTextPosition(JLabel.CENTER); //set text LEFT, CENTER, RIGHT of imageicon
        label.setVerticalTextPosition(JLabel.TOP); //set text TOP, CENTERM BOTTOM of imageicon
        label.setIconTextGap(0); //set gap of text to image
        label.setBackground(Color.pink);
        label.setOpaque(true);
        myFrame.add(label);
    }
}
