package Punteros;

import Diseños.Lienzos;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class punteroDestino {

    int x, y;
    String imagenDestino = "src\\Img\\punteroDestino.png";
    Image img;

    public punteroDestino(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Image imgDestino() {
        img = Toolkit.getDefaultToolkit().getImage(imagenDestino);
        return img;
    }

    public void paint(Graphics g, Lienzos lienzo) {
        this.imgDestino();
        g.drawImage(img, x, y, lienzo);
    }
}
