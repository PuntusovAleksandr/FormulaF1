
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Road extends JPanel implements ActionListener, Runnable{

    Timer mainTaimer = new Timer(10, this);
    Image image = new ImageIcon("D:\\Джава с нуля\\Обменник\\Джава Практика\\HW\\HW1\\FormulaF1\\src\\main\\resources\\трасса без каров (конечный вариант).jpg").getImage();
    Player p = new Player();
    Thread enmiesFactory = new Thread(this);
    ArrayList<Enemy> enemies = new ArrayList();

    public Road(){
        mainTaimer.start();
        enmiesFactory.start();
        addKeyListener(new MyKeyAdapter());
        setFocusable(true);
    }
    private class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            p.keyPressed(e.getKeyCode());
        }

        @Override
        public void keyReleased(KeyEvent e) {
            p.keyReleased(e.getKeyCode());
        }
    }

    public void paint(Graphics g) {
        g = (Graphics2D) g;
        g.drawImage(image, 0, p.layer1, null);
        g.drawImage(image, 0, p.layer2, null);
        g.drawImage(p.img, p.x, p.y, null);

        double v = (100/p.MAX_V)*p.v;
        g.setColor(Color.yellow);
        Font font = new Font("Arial", Font.ITALIC, 20);
        g.setFont(font);
        ((Graphics2D) g).drawString("Скорость: "+v+" km/h", 300, 30);

        Iterator<Enemy> i = enemies.iterator();
        while(i.hasNext()){
            Enemy e = i.next();
            if (e.y>=1000 ||e.y<= -1000 || e.x>=500 || e.x <= 300){
                i.remove();
            }else {
                e.move();
                ((Graphics2D) g).drawImage(e.img, e.x, e.y, null);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        p.move();
        repaint();
        System.out.println(enemies.size());
        testCollision();
        testWin();
    }

    private void testWin() {
        if (p.s>5000){
            JOptionPane.showMessageDialog(null, "Вы ПОБЕДИЛИ!!!");
            System.exit(0);
        }
    }

    private void testCollision() {
        Iterator<Enemy> i = enemies.iterator();
        while (i.hasNext()){
            Enemy e= i.next();
            if(p.getRect().intersects(e.getRect())){
                i.remove();
                JOptionPane.showMessageDialog(null, "Вы проиграли!");
                System.exit(1);
            }
        }
    }

    @Override
    public void run() {
        while (true){
            Random rand = new Random();
            try {
                Thread.sleep((rand.nextInt(1000)));
                enemies.add(new Enemy(rand.nextInt(600), -100, rand.nextInt(10),this));

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

