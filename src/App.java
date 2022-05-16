// package src;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
class App{
    private static GameFrame frame;
    private static int WIDTH=900,HEIGHT=600;
    private static void initWindow(){
        frame=new GameFrame(WIDTH,HEIGHT);
    }public static void main(String[] args){
        initWindow();
        displayTitleScreen();
    }public static void displayTitleScreen(){
        JLabel titleScreen=new JLabel();
        titleScreen.setLayout(null);
        titleScreen.setBackground(Color.black);
        titleScreen.setOpaque(true);
        frame.add(titleScreen);
        titleScreen.setBounds(0,0,WIDTH,HEIGHT);
        JButton playButton=new JButton();
        playButton.setText("PLAY");
        playButton.setForeground(Color.white);
        playButton.setContentAreaFilled(false);
        playButton.setBorderPainted(false);
        playButton.setFocusPainted(false);
        playButton.setFont(new Font("Monospaced",Font.BOLD,30));
        playButton.addActionListener(e->startGame());
        titleScreen.add(playButton);
        playButton.setBounds(WIDTH/2-75,HEIGHT/2-25+100,150,50);
    }public static void startGame(){
        frame.getContentPane().removeAll();
        frame.repaint();
        GamePanel gamePanel=new GamePanel(WIDTH,HEIGHT);
        frame.add(gamePanel);
        gamePanel.requestFocus();
    }
}
