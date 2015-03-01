import javax.swing.*;
import java.awt.*;

/**
 * Created by Aleksandr on 01.03.2015.
 */
public class Player {
    public static final int MAX_V = 8;
    public static final int MAX_LEFT = 300;
    public static final int MAX_RIGHT = 480;

    Image img = new ImageIcon("D:\\Джава с нуля\\Обменник\\Джава Практика\\HW\\HW1\\FormulaF1\\src\\main\\resources\\мой кар.jpg").getImage();
    public Rectangle getRect(){
        return new Rectangle(x,y, 15, 30);
    }

    int v=0;
    int dv=0;
    int s=0;

    int layer1=0;
    int layer2=-1585;
    int x=400;
    int y=580;

    public void move(){
        s+=v;
        v+=dv;
        if (v <=0) v=0;
        if (v >=MAX_V) v = MAX_V;
        if (x<= MAX_LEFT) x = MAX_LEFT;
        if (x>= MAX_RIGHT) x = MAX_RIGHT;
        if (layer2+v >=0){
            layer1=-0;
            layer2=-1585;
        }else {
            layer1+=v;
            layer2+=v;
        }
    }

    public void keyPressed(int code) {
        if (code == java.awt.event.KeyEvent.VK_RIGHT){
            x+=10;
            img = new ImageIcon("D:\\Джава с нуля\\Обменник\\Джава Практика\\HW\\HW1\\FormulaF1\\src\\main\\resources\\мой карв право.jpg").getImage();

        }
        if (code == java.awt.event.KeyEvent.VK_LEFT){
            x-=10;
            img = new ImageIcon("D:\\Джава с нуля\\Обменник\\Джава Практика\\HW\\HW1\\FormulaF1\\src\\main\\resources\\мой карв лево.jpg").getImage();
        }
        if (code == java.awt.event.KeyEvent.VK_DOWN){
            dv=-1;
        }
        if (code == java.awt.event.KeyEvent.VK_UP){
            dv=+1;
            img = new ImageIcon("D:\\Джава с нуля\\Обменник\\Джава Практика\\HW\\HW1\\FormulaF1\\src\\main\\resources\\мой кар вперед.jpg").getImage();
        }

    }

    public void keyReleased(int code) {
        if (code == java.awt.event.KeyEvent.VK_UP ||
                code == java.awt.event.KeyEvent.VK_DOWN){
            dv=0;
            img = new ImageIcon("D:\\Джава с нуля\\Обменник\\Джава Практика\\HW\\HW1\\FormulaF1\\src\\main\\resources\\мой кар.jpg").getImage();
        }
        if (code == java.awt.event.KeyEvent.VK_LEFT ||
                code == java.awt.event.KeyEvent.VK_RIGHT){
            x+=0;
            img = new ImageIcon("D:\\Джава с нуля\\Обменник\\Джава Практика\\HW\\HW1\\FormulaF1\\src\\main\\resources\\мой кар.jpg").getImage();
        }
    }

}
