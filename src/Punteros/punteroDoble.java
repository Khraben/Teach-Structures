package Punteros;

import Diseños.Lienzos;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class punteroDoble {

    int x, y;
    String imagenDoble = "src\\Img\\punteroDoble.png";
    Image img;

    public punteroDoble(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Image imgDoble() {
        img = Toolkit.getDefaultToolkit().getImage(imagenDoble);
        return img;
    }

    public void paint(Graphics g, Lienzos lienzo) {
        this.imgDoble();
        g.drawImage(img, x, y, lienzo);
    }
}
