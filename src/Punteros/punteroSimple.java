package Punteros;

import Diseños.Lienzos;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class punteroSimple {

    int x, y;
    String imagenSimple = "src\\Img\\punteroSimple.png";
    Image img;

    public punteroSimple(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Image imgSimple() {
        img = Toolkit.getDefaultToolkit().getImage(imagenSimple);
        return img;
    }

    public void paint(Graphics g, Lienzos lienzo) {
        this.imgSimple();
        g.drawImage(img, x, y, lienzo);
    }
}
