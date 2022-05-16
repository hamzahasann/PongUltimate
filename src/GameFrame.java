import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class GameFrame extends JFrame{
    public GameFrame(int w,int h){
        this.setTitle("Pong");
        this.setLayout(null);
        this.setUndecorated(true);
        this.setSize(new Dimension(w,h));
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        ImageIcon image=new ImageIcon("../assets/appIcon.png");
        this.setIconImage(image.getImage());
        // KeyListener listener=new MyKeyListener();
        // addKeyListener(listener);
        // setFocusable(true);
    }
}
