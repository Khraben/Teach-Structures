package Punteros;

import Diseños.Lienzos;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class punteroUltimo {

    int x, y;
    String imagenUltimo = "src\\Img\\punteroUltimo.png";
    Image img;

    public punteroUltimo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Image imgUltimo() {
        img = Toolkit.getDefaultToolkit().getImage(imagenUltimo);
        return img;
    }

    public void paint(Graphics g, Lienzos lienzo) {
        this.imgUltimo();
        g.drawImage(img, x, y, lienzo);
    }
}
