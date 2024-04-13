package Punteros;

import Diseños.Lienzos;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class punteroArbIzq {

    int x, y;
    String imagenArbIzq = "src\\Img\\punteroArbIzq.png";
    Image img;

    public punteroArbIzq(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Image imgArbIzq() {
        img = Toolkit.getDefaultToolkit().getImage(imagenArbIzq);
        return img;
    }

    public void paint(Graphics g, Lienzos lienzo) {
        this.imgArbIzq();
        g.drawImage(img, x, y, lienzo);
    }
}
