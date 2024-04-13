package Sublistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Principal {

    int x;
    int y = 5;
    int id;
    Sublista sigSub;
    String dato;
    Principal sig,ant;

    public Principal(int id, String dato) {
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
