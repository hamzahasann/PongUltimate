import java.awt.Color;
class Paddle{
    public int x,y,speed,width,height;
    public Color color;
    int WIDTH=900,HEIGHT=600;
    public Paddle(int tx,int ty,Color tcolor){
        x=tx;
        y=ty;
        width=25;
        height=100;
        speed=0;
        color=tcolor;
    }public void update(){
        y+=speed;
        if(y<0){
            y=0;
        }if(y>HEIGHT-height){
            y=HEIGHT-height;
        }
    }
}
class RotatePaddle extends Paddle{
    boolean isClockwise;
    double theta,rotSpeed;
    int center[];
    public double vertex[][];
    public RotatePaddle(int tx,int ty,Color tcolor,int twidth,int theight,boolean tisClockwise,double trotSpeed){
        super(tx,ty,tcolor);
        width=twidth;
        height=theight;
        isClockwise=tisClockwise;
        theta=0;
        rotSpeed=trotSpeed;
        center=new int[2];
        vertex=new double[2][4];
        vertex[0][0]=vertex[0][3]=x-width/2;
        vertex[0][1]=vertex[0][2]=x+width/2;
        vertex[1][0]=vertex[1][1]=y-height/2;
        vertex[1][2]=vertex[1][3]=y+height/2;
        vertex=rotate(vertex,theta,center);
        setCenter(x,y);
    }public void update(){
        if(isClockwise){
            theta-=rotSpeed;
        }else{
            theta+=rotSpeed;
        }vertex=rotate(vertex,rotSpeed,center);
    }public void setCenter(int tx,int ty){
        center[0]=tx;
        center[1]=ty;
    }
    public double[][] rotate(double vertex[][],double theta,int center[]){
        for(int i=0;i<2;i++){
            for(int j=0;j<4;j++){
                vertex[i][j]-=center[i];
            }
        }double tf[][]={
            {Math.cos(theta),-Math.sin(theta)},
            {Math.sin(theta),Math.cos(theta)}
        };
        double nvertex[][]=new double[2][4];
        for(int i=0;i<2;i++){
            for(int j=0;j<4;j++){
                for(int k=0;k<2;k++){
                    nvertex[i][j]+=tf[i][k]*vertex[k][j];
                }
            }
        }
        for(int i=0;i<2;i++){
            for(int j=0;j<4;j++){
                vertex[i][j]=nvertex[i][j]+center[i];
            }
        }
        return vertex;
    }
    
}
