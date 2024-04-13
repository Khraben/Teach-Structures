package ListaSimpleCircular;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class SimpleCircular {

    int x;
    int y = 130;
    int id;
    String dato;
    SimpleCircular sig;

    public SimpleCircular(int id, String dato) {
        this.id = id;
        this.dato = dato;
    }

    public void paint(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillOval(x, y, 120, 120);
        g.setColor(Color.black);
        g.setFont(new Font("HP Simplified Light", Font.PLAIN, 13));
        g.drawString("ID: " + id, x + 40, y + 30);
        g.drawString("Dato: " + dato, x + 20, y + 80);
    }
}
