package Punteros;

import Diseños.Lienzos;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class punteroSublista {

    int x, y;
    String imagenSublista = "src\\Img\\punteroSublista.png";
    Image img;

    public punteroSublista(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Image imgSublista() {
        img = Toolkit.getDefaultToolkit().getImage(imagenSublista);
        return img;
    }

    public void paint(Graphics g, Lienzos lienzo) {
        this.imgSublista();
        g.drawImage(img, x, y, lienzo);
    }
}
