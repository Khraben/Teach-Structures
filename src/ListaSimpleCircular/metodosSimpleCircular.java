package ListaSimpleCircular;

import Diseños.Lienzos;
import Punteros.punteroSimple;
import Punteros.punteroUltimo;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class metodosSimpleCircular {

    SimpleCircular inicio, ultimo;
    
    //insertar un nodo al inicio de la lista
    public boolean insertarInicio(int id, String dato) {
        SimpleCircular nuevo = new SimpleCircular(id, dato);
        if (inicio == null) {
            ultimo = inicio = nuevo;
            ultimo.sig = inicio;
            return true;
        }
        if (buscar(id) == null) {
            nuevo.sig = inicio;
            inicio = nuevo;
            ultimo.sig = inicio;
            return true;
        }
        return false;
    }
    
    //inserta un nodo al final de la lista
    public boolean insertarFinal(int id, String dato) {
        SimpleCircular nuevo = new SimpleCircular(id, dato);
        if (inicio == null) {
            ultimo = inicio = nuevo;
            ultimo.sig = inicio;
            return true;
        }
        if (buscar(id) == null) {
            ultimo.sig = nuevo;
            ultimo = nuevo;
            ultimo.sig = inicio;
            return true;
        }
        return false;
    }
    
    //insertar un nodo ordenado por id en la lista
    public boolean insertarOrdenado(int id, String dato) {
        SimpleCircular nuevo = new SimpleCircular(id, dato);
        if (inicio == null) {
            ultimo = inicio = nuevo;
            ultimo.sig = inicio;
            return true;
        }
        if (nuevo.id < inicio.id) {
            nuevo.sig = inicio;
            inicio = nuevo;
            ultimo.sig = inicio;
            return true;
        }
        if (nuevo.id > ultimo.id) {
            ultimo.sig = nuevo;
            ultimo = nuevo;
            ultimo.sig = inicio;
            return true;
        }
        SimpleCircular temp = inicio;
        do {
            if (temp.id < nuevo.id & temp.sig.id > nuevo.id) {
                nuevo.sig = temp.sig;
                temp.sig = nuevo;
                return true;
            }
            temp = temp.sig;
        } while (temp != inicio);
        return false;
    }

    //busca un nodo en la lista y lo retorna, si no encuentra nodo retorna null
    public SimpleCircular buscar(int id) {
        if (inicio != null) {
            SimpleCircular temp = inicio;
            do {
                if (temp.id == id) {
                    return temp;
                }
                temp = temp.sig;
            } while (temp != inicio);
        }
        return null;
    }

    //iliminar un nodo de la lista
    public boolean eliminar(int id) {
        if (inicio.id == id) {
            if (inicio == ultimo) {
                inicio = ultimo = null;
                return true;
            } else {
                inicio = inicio.sig;
                ultimo.sig = inicio;
                return true;
            }
        }
        SimpleCircular temp = inicio;
        SimpleCircular ant = inicio;
        do {
            if (temp.id == id) {
                if (temp == ultimo) {
                    ultimo = ant;
                    ultimo.sig = inicio;
                    return true;
                }
                ant.sig = temp.sig;
                return true;
            }
            ant = temp;
            temp = temp.sig;
        } while (temp != inicio);
        return false;
    }
    
    //modifica un nodo de la lista
    public boolean modificar(int id, String dato) {
        if (buscar(id) != null) {
            SimpleCircular temp = inicio;
            do {
                if (temp.id == id) {
                    temp.dato = dato;
                    return true;
                }
                temp = temp.sig;
            } while (temp != inicio);
        }

        return false;
    }
    
    //pinta los nodos y punteros de la lista en pantalla(interfaz)
    public void paint(Graphics g, Lienzos lienzo) {
        if (inicio != null) {
            SimpleCircular temp = inicio;
            SimpleCircular ant = inicio;
            do {
                temp.paint(g);
                if (temp != ant) {
                    punteroSimple puntero = new punteroSimple(ant.x + 135, ant.y + 50);
                    puntero.paint(g, lienzo);
                }
                ant = temp;
                temp = temp.sig;
            } while (temp != inicio);
            if (inicio != ultimo) {
                punteroUltimo puntero = new punteroUltimo(ultimo.x + 135, ultimo.y + 50);
                puntero.paint(g, lienzo);
                g.setFont(new Font("HP Simplified Light", Font.BOLD, 13));
                g.drawString("INICIO", ultimo.x + 170, ultimo.y + 135);
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

    //asigna las posiciones de los nodos para luego pintarlos
    public void asignarPosiciones() {
        if (inicio != null) {
            int cont = 1;
            SimpleCircular temp = inicio;
            do {
                if (cont == 1) {
                    temp.x = 100;
                } else {
                    temp.x = (cont * 220) - 120;
                }
                cont += 1;
                temp = temp.sig;
            } while (temp != inicio);
        }
    }
    
    //obtiene la cantidad de nodos de la lista
    public int obtenerCantNodos() {
        int cant = 0;
        SimpleCircular temp = inicio;
        do {
            if (temp != null) {
                cant += 1;
                temp = temp.sig;
            }
        } while (temp != inicio);
        return cant;
    }
}
