import javax.swing.*;

/**
 * Created by Aleksandr on 01.03.2015.
 */
public class Main {

    public static void main(String[] args) {
        JFrame f = new JFrame("MyResing");
        f.setDefaultCloseOperation(3);
        f.setSize(800, 750);
        f.setLocationRelativeTo(null);
        f.add(new Road());
        f.setVisible(true);
    }

}
