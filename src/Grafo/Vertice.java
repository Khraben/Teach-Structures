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
public class Vertice {

    int x = 50, y;
    String nombre, info;
    Vertice sig, ant;
    Arco sigA;
    boolean marca;

    int valorMin;

    public Vertice(String nombre, String info) {
        this.nombre = nombre;
        this.info = info;
        this.marca = false;
        this.valorMin = 999999999;
    }

    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(x, y, 120, 120);
        g.setColor(Color.black);
        g.setFont(new Font("HP Simplified Light", Font.PLAIN, 13));
        g.drawString("Nombre: " + nombre, x + 30, y + 30);
        g.drawString("Info: " + info, x + 20, y + 80);
    }
}
