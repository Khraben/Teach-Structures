package Punteros;

import Diseños.Lienzos;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class punteroVertical {

    int x, y;
    String imagenVertical = "src\\Img\\punteroVertical.png";
    Image img;

    public punteroVertical(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Image imgVertical() {
        img = Toolkit.getDefaultToolkit().getImage(imagenVertical);
        return img;
    }

    public void paint(Graphics g, Lienzos lienzo) {
        this.imgVertical();
        g.drawImage(img, x, y, lienzo);
    }
}
