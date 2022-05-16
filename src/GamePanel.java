import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.*;
import java.util.*;
import java.awt.Event;
import java.awt.event.*;
class GamePanel extends JPanel{
    Paddle left,right;
    int margin,width,height;
    Ball ball;
    GamePanel(int WIDTH,int HEIGHT){
        width=WIDTH;
        height=HEIGHT;
        this.setBackground(Color.black);
        this.setLayout(null);
        this.setBounds(0, 0, WIDTH, HEIGHT);
        this.setVisible(true);
        margin=25;
        left=new Paddle(margin,HEIGHT/2-50,Color.blue);
        right=new Paddle(WIDTH-margin-25-10,HEIGHT/2-50,Color.red);
        ball=new Ball(WIDTH/2,HEIGHT/2,0,Color.white,WIDTH,HEIGHT);
        KeyListener listener=new MyKeyListener();
        addKeyListener(listener);
        setFocusable(true);
        new javax.swing.Timer(1,new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                update();
                repaint();
            }
        }).start();
    }
    public void update(){
        ball.collide(left);
        ball.collide(right);
        left.update();
        right.update();
        ball.update();
        if(ball.x<-50 || ball.x>(width+50)){
            ball=new Ball(width/2,height/2,0,Color.white,width,height);
        }
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(left.color);
        g.fillRect(left.x,left.y,left.width,left.height);
        g.setColor(right.color);
        g.fillRect(right.x,right.y,right.width,right.height);
        g.setColor(ball.color);
        g.fillRect((int)ball.x,(int)ball.y,ball.width,ball.height);
    }
    public class MyKeyListener implements KeyListener{
        @Override
        public void keyTyped(KeyEvent e){

        }
        @Override
        public void keyPressed(KeyEvent e){
            if(e.getKeyCode()==KeyEvent.VK_W){
                left.speed=-10;
            }else if(e.getKeyCode()==KeyEvent.VK_S){
                left.speed=10;
            }if(e.getKeyCode()==KeyEvent.VK_UP){
                right.speed=-10;
            }else if(e.getKeyCode()==KeyEvent.VK_DOWN){
                right.speed=10;
            }
        }
        @Override
        public void keyReleased(KeyEvent e){
            if(e.getKeyCode()==KeyEvent.VK_W || e.getKeyCode()==KeyEvent.VK_S){
                left.speed=0;
            }if(e.getKeyCode()==KeyEvent.VK_UP || e.getKeyCode()==KeyEvent.VK_DOWN){
                right.speed=0;
            }
        }
    }
}
