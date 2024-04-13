package Punteros;

import Diseños.Lienzos;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class punteroGrafo {

    int x, y;
    String imagenGrafo = "src\\Img\\punteroGrafo.png";
    Image img;

    public punteroGrafo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Image imgGrafo() {
        img = Toolkit.getDefaultToolkit().getImage(imagenGrafo);
        return img;
    }

    public void paint(Graphics g, Lienzos lienzo) {
        this.imgGrafo();
        g.drawImage(img, x, y, lienzo);
    }
}
