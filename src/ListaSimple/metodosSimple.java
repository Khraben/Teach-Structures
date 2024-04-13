package ListaSimple;

import Diseños.Lienzos;
import Punteros.punteroSimple;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class metodosSimple {

    Simple inicio, ultimo;
    
    //insertar un nodo al inicio de la lista
    public boolean insertarInicio(int id, String dato) {
        Simple nuevo = new Simple(id, dato);
        if (inicio == null) {
            ultimo = inicio = nuevo;
            return true;
        }
        if (buscar(id) == null) {
            nuevo.sig = inicio;
            inicio = nuevo;
            return true;
        }
        return false;
    }
    
    //inserta un nodo al final de la lista
    public boolean insertarFinal(int id, String dato) {
        Simple nuevo = new Simple(id, dato);
        if (inicio == null) {
            ultimo = inicio = nuevo;
            return true;
        }
        if (buscar(id) == null) {
            ultimo.sig = nuevo;
            ultimo = nuevo;
            return true;
        }
        return false;
    }
    
    //inserta un nodo de forma ordenada en la lista
    public boolean insertarOrdenado(int id, String dato) {
        Simple nuevo = new Simple(id, dato);
        if (inicio == null) {
            ultimo = inicio = nuevo;
            return true;
        }
        if (nuevo.id < inicio.id) {
            nuevo.sig = inicio;
            inicio = nuevo;
            return true;
        }
        if (nuevo.id > ultimo.id) {
            ultimo.sig = nuevo;
            ultimo = nuevo;
            return true;
        }
        Simple temp = inicio;
        while (temp != null) {
            if (temp.id < nuevo.id & temp.sig.id > nuevo.id) {
                nuevo.sig = temp.sig;
                temp.sig = nuevo;
                return true;
            }
            temp = temp.sig;
        }

        return false;
    }
    
    //busca un nodo y lo retorna
    public Simple buscar(int id) {
        Simple temp = inicio;
        while (temp != null) {
            if (temp.id == id) {
                return temp;
            }
            temp = temp.sig;
        }
        return null;
    }
    
    //modifica un node de la lista 
    public boolean modificar(int id, String dato) {
        if (buscar(id) != null) {
            Simple temp = inicio;
            while (temp != null) {
                if (temp.id == id) {
                    temp.dato = dato;
                    return true;
                }
                temp = temp.sig;
            }
        }

        return false;
    }

    //elimina un nodo de la lista
    public boolean eliminar(int id) {
        if (inicio.id == id) {
            inicio = inicio.sig;
            return true;
        }
        Simple temp = inicio;
        Simple ant = inicio;
        while (temp != null) {
            if (temp.id == id) {
                if (temp == ultimo) {
                    ultimo = ant;
                    ultimo.sig = null;
                    return true;
                }
                ant.sig = temp.sig;
                return true;
            }
            ant = temp;
            temp = temp.sig;
        }
        return false;
    }

    //pinta los nodos de la lista
    public void paint(Graphics g, Lienzos lienzo) {
        if (inicio != null) {
            Simple temp = inicio;
            Simple ant = inicio;
            while (temp != null) {
                temp.paint(g);
                if (ant != temp) {
                    punteroSimple puntero = new punteroSimple(ant.x + 135, ant.y + 50);
                    puntero.paint(g, lienzo);
                }
                ant = temp;
                temp = temp.sig;
            }
            g.setColor(Color.black);
            g.fillRect(inicio.x + 20, inicio.y - 30, 80, 25);
            g.fillRect(ultimo.x + 20, ultimo.y + 125, 80, 25);
            g.setColor(Color.WHITE);
            g.setFont(new Font("HP Simplified Light", Font.BOLD, 22));
            g.drawString("INICIO", inicio.x + 33, inicio.y - 10);
            g.drawString("ULTIMO", ultimo.x + 25, ultimo.y + 145);
        }

    }
    
    //asigna las posiciones de los nodos de la lista
    public void asignarPosiciones() {
        int cont = 1;
        Simple temp = inicio;
        while (temp != null) {
            if (cont == 1) {
                temp.x = 100;
            } else {
                temp.x = (cont * 220) - 120;
            }
            cont += 1;
            temp = temp.sig;
        }
    }
    
    //obtiene la cantidad de nodos de la lista
    public int obtenerCantNodos() {
        int cant = 0;
        Simple temp = inicio;
        while (temp != null) {
            cant += 1;
            temp = temp.sig;
        }
        return cant;
    }
}
