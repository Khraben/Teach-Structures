package Punteros;

import Diseños.Lienzos;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class punteroArbDer {

    int x, y;
    String imagenArbDer = "src\\Img\\punteroArbDer.png";
    Image img;

    public punteroArbDer(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Image imgArbDer() {
        img = Toolkit.getDefaultToolkit().getImage(imagenArbDer);
        return img;
    }

    public void paint(Graphics g, Lienzos lienzo) {
        this.imgArbDer();
        g.drawImage(img, x, y, lienzo);
    }
}
