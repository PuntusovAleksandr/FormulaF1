import javax.swing.*;
import java.awt.*;

/**
 * Created by Aleksandr on 01.03.2015.
 */
public class Enemy {

    int x;
    int y;
    int v;
    Image img = new ImageIcon("D:\\Джава с нуля\\Обменник\\Джава Практика\\HW\\HW1\\FormulaF1\\src\\main\\resources\\враг кар.jpg").getImage();
    Road road;
    public Rectangle getRect(){
        return new Rectangle(x,y, 15, 30);
    }

    public Enemy(int x, int y, int v, Road road) {
        this.x = x;
        this.y = y;
        this.v = v;
        this.road = road;
    }

    public void move(){
        y = y + road.p.v+v;

    }


}
