package Grafo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author khrab
 */
public class Arco {

    int x, y;
    Arco sig, ant;
    Vertice destino;
    int peso;

    public Arco(int peso) {
        this.peso = peso;
    }

    public void paint(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillOval(x, y, 105, 105);
        g.setColor(Color.black);
        g.setFont(new Font("HP Simplified Light", Font.PLAIN, 13));
        g.drawString("Peso: " + peso, x + 20, y + 55);
    }
}
