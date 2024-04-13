package Sublistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Secundaria {

    int x;
    int y = 383;
    int id;
    String dato;
    Secundaria sig, ant;

    public Secundaria(int id, String dato) {
        this.id = id;
        this.dato = dato;
    }

    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(x, y, 120, 120);
        g.setColor(Color.black);
        g.setFont(new Font("HP Simplified Light", Font.PLAIN, 13));
        g.drawString("ID: " + id, x + 40, y + 30);
        g.drawString("Dato: " + dato, x + 5, y + 70);
    }
}
