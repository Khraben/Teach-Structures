package ListaDobleCircular;

import Diseños.Lienzos;
import Punteros.punteroDoble;
import Punteros.punteroInicio;
import Punteros.punteroUltimo;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class metodosDobleCircular {

    DobleCircular inicio, ultimo;
    
    //busca un nodo y lo retorna
    public DobleCircular buscar(int id) {
        if (inicio != null) {
            DobleCircular temp = inicio;
            do {
                if (temp.id == id) {
                    return temp;
                }
                temp = temp.sig;
            } while (temp != inicio);
        }
        return null;
    }

    //insertar un nodo al inicio de la lista
    public boolean insertarInicio(int id, String dato) {
        DobleCircular nuevo = new DobleCircular(id, dato);
        if (inicio == null) {
            ultimo = inicio = nuevo;
            ultimo.sig = inicio;
            inicio.ant = ultimo;
            return true;
        }
        if (buscar(id) == null) {
            nuevo.sig = inicio;
            inicio.ant = nuevo;
            inicio = nuevo;
            ultimo.sig = inicio;
            inicio.ant = ultimo;
            return true;
        }
        return false;
    }

    //inserta un nodo al final de la lista
    public boolean insertarFinal(int id, String dato) {
        DobleCircular nuevo = new DobleCircular(id, dato);
        if (inicio == null) {
            ultimo = inicio = nuevo;
            ultimo.sig = inicio;
            inicio.ant = ultimo;
            return true;
        }
        if (buscar(id) == null) {
            ultimo.sig = nuevo;
            nuevo.ant = ultimo;
            ultimo = nuevo;
            ultimo.sig = inicio;
            inicio.ant = ultimo;
        }
        return false;
    }

    //inserta un nodo de forma ordenada en la lista
    public boolean insertarOrdenado(int id, String dato) {
        DobleCircular nuevo = new DobleCircular(id, dato);
        if (inicio == null) {
            ultimo = inicio = nuevo;
            ultimo.sig = inicio;
            inicio.ant = ultimo;
            return true;
        }
        if (nuevo.id < inicio.id) {
            nuevo.sig = inicio;
            inicio.ant = nuevo;
            inicio = nuevo;
            ultimo.sig = inicio;
            inicio.ant = ultimo;
            return true;
        }
        if (nuevo.id > ultimo.id) {
            nuevo.ant = ultimo;
            ultimo.sig = nuevo;
            ultimo = nuevo;
            ultimo.sig = inicio;
            inicio.ant = ultimo;
            return true;
        }

        DobleCircular temp = inicio;
        while (temp != null) {
            if (temp.id < nuevo.id & temp.sig.id > nuevo.id) {
                nuevo.ant = temp;
                nuevo.sig = temp.sig;
                temp.sig.ant = nuevo;
                temp.sig = nuevo;
                return true;
            }
            temp = temp.sig;
        }
        return false;
    }

    //elimina un nodo de la lista
    public boolean eliminar(int id) {
        DobleCircular temp = buscar(id);
        if (temp != null) {
            if (inicio == temp) {
                if (temp.sig == inicio) {
                    inicio = ultimo = null;
                    return true;
                }
                inicio = inicio.sig;
                inicio.ant = ultimo;
                ultimo.sig = inicio;
                return true;
            }
            if (ultimo == temp) {
                ultimo = ultimo.ant;
                ultimo.sig = inicio;
                inicio.ant = ultimo;
                return true;
            }
            temp.sig.ant = temp.ant;
            temp.ant.sig = temp.sig;
            return true;
        }
        return false;
    }

    //modifica un node de la lista
    public boolean modificar(int id, String dato) {
        if (buscar(id) != null) {
            DobleCircular temp = inicio;
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

    //pinta los nodos de la lista
    public void paint(Graphics g, Lienzos lienzo) {
        if (inicio != null) {
            DobleCircular temp = inicio;
            DobleCircular ant = inicio;
            do {
                temp.paint(g);
                if (temp != ant) {
                    punteroDoble puntero = new punteroDoble(ant.x + 135, ant.y + 50);
                    puntero.paint(g, lienzo);
                }
                ant = temp;
                temp = temp.sig;
            } while (temp != inicio);
            if (inicio != ultimo) {
                punteroUltimo punteroU = new punteroUltimo(ultimo.x + 135, ultimo.y + 50);
                punteroU.paint(g, lienzo);
                g.setFont(new Font("HP Simplified Light", Font.BOLD, 13));
                g.drawString("INICIO", ultimo.x + 170, ultimo.y + 135);
                punteroInicio punteroI = new punteroInicio(inicio.x - 80, inicio.y + 5);
                punteroI.paint(g, lienzo);
                g.setFont(new Font("HP Simplified Light", Font.BOLD, 13));
                g.drawString("ULTIMO", inicio.x - 85, inicio.y - 3);
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
        if (inicio != null) {
            int cont = 1;
            DobleCircular temp = inicio;
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
        DobleCircular temp = inicio;
        do {
            if (temp != null) {
                cant += 1;
                temp = temp.sig;
            }
        } while (temp != inicio);
        return cant;
    }
}
