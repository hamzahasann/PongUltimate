import java.awt.Color;
import java.util.*;
class Ball{
    public double x,y,width,height;
    public double theta;
    public Color color;
    private double speed=10;
    public int winWidth,winHeight;
    static boolean inRange(int x,int a,int b){
        return (a<=x && x<=b);
    }
    public Ball(double tx,double ty,double ttheta,Color tcolor,int ww,int wh){
        x=tx;
        y=ty;
        theta=Math.PI-ttheta;
        color=tcolor;
        // speed=2;
        width=10;
        height=10;
        winWidth=ww;
        winHeight=wh;
    }
    public void update(){
        double vx=speed*Math.cos(theta),vy=speed*Math.sin(theta);
        x+=vx;
        y+=vy;
        if(y<=0){
            y=0;
            theta=-theta;
        }if(y>=winHeight){
            y=winHeight;
            theta=-theta;
        }
    }
    public boolean collide(Paddle paddle){
        int dir;
        if(Math.cos(theta)<0)dir=-1;
        else dir=1;
        if(dir==-1){
            if(
                inRange(x,paddle.x,paddle.x+paddle.width) && inRange(y,paddle.y,paddle.y+paddle.height) ||
                inRange(x,paddle.x,paddle.x+paddle.width) && inRange(y+height,paddle.y,paddle.y+paddle.height)
            ){
                theta=Math.PI-theta;
                x=paddle.x+paddle.width;
                double dist=(y+1.0*height/2)-(paddle.y+1.0*paddle.height/2);
                theta=Math.asin(Math.sin(Math.PI/3)*(dist*2/paddle.height));
                return true;
            }
        }else{
            if(
                inRange(x+width,paddle.x,paddle.x+paddle.width) && inRange(y,paddle.y,paddle.y+paddle.height) ||
                inRange(x+width,paddle.x,paddle.x+paddle.width) && inRange(y+width,paddle.y,paddle.y+paddle.height)
            ){
                theta=Math.PI-theta;
                x=paddle.x;
                double dist=(y+1.0*height/2)-(paddle.y+1.0*paddle.height/2);
                theta=Math.asin(Math.sin(Math.PI/3)*(dist*2/paddle.height));
                theta=Math.PI-theta;
                return true;
            }
        }return false;
    }public boolean intersect(double p1[],double p2[],double q1[],double q2[]){
        
    }
    public boolean collide(RotatePaddle paddle){
        //input line,point

        return true;
    }
}
