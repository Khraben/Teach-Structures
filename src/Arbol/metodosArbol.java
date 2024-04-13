package Arbol;

import Diseños.Lienzos;
import Punteros.punteroArbIzq;
import Punteros.punteroArbDer;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.DefaultListModel;

public class metodosArbol {

    public Arbol raiz, encontrado, anterior;
    boolean ins = true; //se usa porque la recursividad afecta las variables locales
    
    //inserta un nuevo nodo en el arbol
    public boolean insertar(Arbol aux, Arbol nuevo) {
        if (nuevo.id < aux.id) {
            if (aux.izq == null) {
                aux.izq = nuevo;
                return ins = true;
            }
            insertar(aux.izq, nuevo);
        } else if (nuevo.id > aux.id) {
            if (aux.der == null) {
                aux.der = nuevo;
                return ins = true;
            }
            insertar(aux.der, nuevo);
        } else {
            return ins = false;
        }
        return false;
    } //se crea el nuevo y se pregunta si raiz es null antes de llamar el met
    
    //busca y retorna un nodo del arbol... en caso de no encontralo retorna null
    public Arbol buscar(Arbol aux, int id) {
        if (aux == null) {
            return encontrado = null;
        }
        if (id < aux.id) {
            anterior = aux;
            buscar(aux.izq, id);
        } else if (id > aux.id) {
            anterior = aux;
            buscar(aux.der, id);
        } else {
            return encontrado = aux;
        }
        return encontrado;
    }
    
    //recorre el arbol en forma PREORDEN
    public void recorridoPreOrden(Arbol aux, DefaultListModel listModel) {
        if (aux != null) {
            listModel.addElement("Nodo:");
            listModel.addElement("    ID: " + aux.id);
            listModel.addElement("    Dato: " + aux.dato);
            listModel.addElement("");
            recorridoPreOrden(aux.izq, listModel);
            recorridoPreOrden(aux.der, listModel);
        }
        return;
    }
    
    //recorre el arbol en forma INORDEN
    public void recorridoInOrden(Arbol aux, DefaultListModel listModel) {
        if (aux != null) {
            recorridoPreOrden(aux.izq, listModel);
            listModel.addElement("Nodo:");
            listModel.addElement("    ID: " + aux.id);
            listModel.addElement("    Dato: " + aux.dato);
            listModel.addElement("");
            recorridoPreOrden(aux.der, listModel);
        }
        return;
    }

    //recorre el arbol en forma POSTORDEN
    public void recorridoPostOrden(Arbol aux, DefaultListModel listModel) {
        if (aux != null) {
            recorridoPreOrden(aux.izq, listModel);
            recorridoPreOrden(aux.der, listModel);
            listModel.addElement("Nodo:");
            listModel.addElement("    ID: " + aux.id);
            listModel.addElement("    Dato: " + aux.dato);
            listModel.addElement("");
        }
        return;
    }
    
    //elimina un nodo en el arbol
    public void eliminar(Arbol aux) {
        if (aux == raiz) {
            if ((aux.izq == null) & (aux.der == null)) {
                raiz = null;
            } else {
                if (aux.izq == null) {
                    raiz = raiz.der;
                } else {
                    if (aux.der == null) {
                        raiz = raiz.izq;
                    } else {
                        Arbol ant;
                        aux = aux.izq;
                        if (aux.der == null) {
                            aux.der = raiz.der;
                            raiz = raiz.izq;
                        } else {
                            ant = aux;
                            while (aux.der != null) {
                                ant = aux;
                                aux = aux.der;
                            }
                            ant.der = aux.izq;
                            aux.der = raiz.der;
                            aux.izq = raiz.izq;
                            raiz = aux;
                        }
                    }
                }
            }
        } else {
            if ((aux.izq == null) & (aux.der == null)) {
                if (anterior.izq == aux) {
                    anterior.izq = null;
                } else {
                    anterior.der = null;
                }
            } else {
                if (aux.izq == null) {
                    if (anterior.izq == aux) {
                        anterior.izq = aux.der;
                    } else {
                        anterior.der = aux.der;
                    }
                } else {
                    if (aux.der == null) {
                        if (anterior.izq == aux) {
                            anterior.izq = aux.izq;
                        } else {
                            anterior.der = aux.izq;
                        }
                    } else {
                        Arbol ant, temp;
                        temp = aux.izq;
                        if (temp.der == null) {
                            temp.der = aux.der;
                            if (anterior.izq == aux) {
                                anterior.izq = temp;
                            } else {
                                anterior.der = temp;
                            }
                        } else {
                            ant = temp;
                            while (temp.der != null) {
                                ant = temp;
                                temp = temp.der;
                            }
                            ant.der = temp.izq;
                            temp.der = aux.der;
                            temp.izq = aux.izq;
                            if (anterior.izq == aux) {
                                anterior.izq = aux.izq;
                            } else {
                                anterior.der = aux.izq;
                            }
                        }
                    }
                }
            }
        }
    }
    
    //modifica el nodo del arbol que recibe como parametro
    public boolean modificar(Arbol aux, String dato) {
        aux.dato = dato;
        return true;
    }
    
    //pinta los nodos del arbol y sus punteros en la interfaz
    public void paint(Graphics g, Lienzos lienzo, Arbol aux) {
        if (raiz != null) {
            g.setColor(Color.black);
            g.fillRect(raiz.x + 20, raiz.y - 30, 80, 25);
            g.setColor(Color.WHITE);
            g.setFont(new Font("HP Simplified Light", Font.BOLD, 22));
            g.drawString("RAIZ", raiz.x + 40, raiz.y - 10);
        }
        if (aux != null) {
            aux.paint(g);
            if (aux.izq != null) {
                punteroArbIzq puntero = new punteroArbIzq(aux.x - 25, aux.y + 110);
                puntero.paint(g, lienzo);
            }
            if (aux.der != null) {
                punteroArbDer puntero = new punteroArbDer(aux.x + 85, aux.y + 110);
                puntero.paint(g, lienzo);
            }
            paint(g, lienzo, aux.izq);
            paint(g, lienzo, aux.der);
        }
        return;
    }
    
    //asigna las posiciones del los nodos para el metodo de pintar en pantalla
    public void asignarPosiciones(Arbol aux, int xRaiz) {
        if (aux != null) {
            if (aux == raiz) {
                aux.x = xRaiz;
                aux.y = 50;
            }
            if (aux.izq != null) {
                aux.izq.x = aux.x - 135;
                aux.izq.y = aux.y + 120;
            }
            if (aux.der != null) {
                aux.der.x = aux.x + 135;
                aux.der.y = aux.y + 120;
            }
            asignarPosiciones(aux.izq, xRaiz);
            asignarPosiciones(aux.der, xRaiz);
        }
    }
    
    //calcula la altura para moficicar luego el tañana del lienzo(JPANEL)
    public int calcularAltura(Arbol aux) {
        if (aux == null) {
            return -1;
        } else {
            return (1 + Math.max(calcularAltura(aux.izq), calcularAltura(aux.der)));
        }
    }

}
