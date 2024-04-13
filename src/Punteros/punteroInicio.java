package Punteros;

import Diseños.Lienzos;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class punteroInicio {

    int x, y;
    String imagenInicio = "src\\Img\\punteroInicio.png";
    Image img;

    public punteroInicio(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Image imgInicio() {
        img = Toolkit.getDefaultToolkit().getImage(imagenInicio);
        return img;
    }

    public void paint(Graphics g, Lienzos lienzo) {
        this.imgInicio();
        g.drawImage(img, x, y, lienzo);
    }
}
