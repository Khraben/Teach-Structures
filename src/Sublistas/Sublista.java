package Sublistas;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Sublista {

    int x;
    int y = 202;
    int id;
    String info;
    Sublista sig, ant;
    Secundaria sigSec;

    public Sublista(int id, String info, Secundaria sigSec) {
        this.id = id;
        this.info = info;
        this.sigSec = sigSec;
    }
    
    public void paint(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillOval(x, y, 105, 105);
        g.setColor(Color.black);
        g.setFont(new Font("HP Simplified Light", Font.PLAIN, 13));
        g.drawString("Info: "+info, x+20, y+80);
        g.drawString("ID: " + id, x + 40, y + 30);
    }
}
