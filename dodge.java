
import java.awt.Font;

public class dodge { 
        int diem = 0 ;
        int highscore = 0;
        int diemcao = 0;
        int sobong = 0;
        
        double[] rx = new double[150];
        double[] ry = new double[150];
        double[] vx = new double[150];
        double[] vy = new double[150];     
        double radius ;              
   
        boolean lvlup, thua ;
        double radius1 ;
    
    
    
    
    public static boolean kt(double x1,double x2,double y1,double y2, double tongBK, double w){
        double kc = Math.sqrt(Math.pow(x1-x2,2.0)+Math.pow(y1-y2,2.0));
        if(kc < (tongBK - w/5)) return true;
        else return false;
    }

    

    
    public void hienThi(double x,double y){
            StdDraw.setPenColor(StdDraw.RED); 
            StdDraw.filledCircle(x, y, 0.1); 
    }
    
   
    
    
    public void choiTroChoi(){
       
            for( int i =0; i < 150 ;i++){
            rx[i]=Math.random()*1.8-0.9;
            ry[i]=Math.random()*1.8-0.9;
            vx[i]=Math.random()*0.01;
            vy[i]=Math.random()*0.01;
            }        
        
       
        
            
         while(true){   
            
                thua = false;
                lvlup = false;
                double p =Math.random()*1.8-0.9;
                double q =Math.random()*1.8-0.9;
           
          
            
            
            
             while(true){
            
 
                StdDraw.clear(StdDraw.LIGHT_GRAY);
            
                Font ww = new Font("Arial", Font.BOLD, 20);
                StdDraw.setFont(ww);
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.text(-0.95,-0.95 ,String.valueOf(diem));
                StdDraw.text(-0.95, 0.95,  String.valueOf(diemcao)); 
            
                hienThi(p,q);
            
         
            
                StdDraw.setPenColor(StdDraw.BLUE);
                double a = StdDraw.mouseX();
                double b = StdDraw.mouseY();
                StdDraw.filledCircle(a, b, radius1);
            
  
               
            
                for(int i=0; i<sobong; i++){
                    if (Math.abs(rx[i] + vx[i]) > 1.0 - radius) vx[i] = -vx[i];
                    if (Math.abs(ry[i] + vy[i]) > 1.0 - radius) vy[i] = -vy[i];
                }   
            
                for( int i = 0; i< sobong; i++){
                    rx[i] = rx[i] + vx[i]; 
                    ry[i] = ry[i] + vy[i]; 
                }
             
            
           
            
                if(kt(a,p,b,q,radius1 + 0.1,0)==true){
                    lvlup = true;
                    break;
                }
            
                
                for( int i = 0; i< sobong; i++){
                    if(kt(a,rx[i],b,ry[i],radius1 + radius,radius)) {
                    thua = true;
                    }
                }
                 
                 
                if(thua) {
                    break;
                }
                
                for (int i = 0; i<sobong; i++){
                    StdDraw.setPenColor(StdDraw.BLACK); 
                    StdDraw.filledCircle(rx[i], ry[i], radius); 
                }
            
                StdDraw.show();

           
                StdDraw.pause(20);
            
                if(lvlup){ 
                    break;
                }
            
            } 
            
            if(thua){ 
                    break;
            }
            
            if(lvlup) {sobong = sobong +1; diem = diem +1;}
            if(diem >= highscore) highscore = diem ;
        
            if(diem%10 == 0) {  
                if(radius > 0.01)  radius = radius - 0.01;
                else {
                    if (radius1 >0.02) radius1 = radius1 -0.01;
                }
            } 
         
         
         
        }
    }
    
    
    

    
    public void chayChuongTrinh(){
            StdDraw.picture(0.5, 0.5, "anhNen1.png");
        
            while(true){
                StdDraw.setXscale(-1.0, 1.0);
                StdDraw.setYscale(-1.0, 1.0);
                StdDraw.enableDoubleBuffering();
            
        
            
                Font o =new Font("Arial", Font.BOLD, 30);
                StdDraw.setFont(o);
                StdDraw.setPenColor(StdDraw.MAGENTA);
                StdDraw.text(0, 0, "PRESS SPACEBAR TO START"); 
                StdDraw.show();
                sobong = 0;
                diem = 0;
                while(true){
               
                    if( StdDraw.isKeyPressed(32) ==true ){
                        choiTroChoi();
                        break;
                    }
                 
                    diemcao = highscore;
                    radius = 0.05 ;
                    radius1 = 0.05;
                }
            
                for (int i = 0; i<sobong; i++){
                    StdDraw.setPenColor(StdDraw.BLACK); 
                    StdDraw.filledCircle(rx[i], ry[i], radius); 
                }
            
                StdDraw.setFont(o);
                StdDraw.setPenColor(StdDraw.MAGENTA);
                StdDraw.text(0, -0.25, "HIGHSCORE: "+highscore); 
                StdDraw.show();
            
            }
    }
  
    
    
    
    
    
    
    public dodge(){
       chayChuongTrinh();
    }
    
    
    
    public static void main(String[] args) {
        
            dodge a= new dodge();
        
        
    } 


}
