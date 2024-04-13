package Sublistas;

import Diseños.Lienzos;
import Punteros.punteroDoble;
import Punteros.punteroSublista;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class metodosSublista {

    Principal inicioP, ultimoP;
    public Secundaria inicioS, ultimoS;
    
    //insertar en lista principal
    public boolean insertarEnPrincipal(int id, String dato) {
        Principal nuevo = new Principal(id, dato);
        if (inicioP == null) {
            ultimoP = inicioP = nuevo;
            return true;
        }
        if (nuevo.id < inicioP.id) {
            nuevo.sig = inicioP;
            inicioP.ant = nuevo;
            inicioP = nuevo;
            return true;
        }
        if (nuevo.id > ultimoP.id) {
            nuevo.ant = ultimoP;
            ultimoP.sig = nuevo;
            ultimoP = nuevo;
            return true;
        }

        Principal temp = inicioP;
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
    
    //insertar en lista secundaria
    public boolean insertarEnSecundaria(int id, String dato) {
        Secundaria nuevo = new Secundaria(id, dato);
        if (inicioS == null) {
            ultimoS = inicioS = nuevo;
            return true;
        }
        if (nuevo.id < inicioS.id) {
            nuevo.sig = inicioS;
            inicioS.ant = nuevo;
            inicioS = nuevo;
            return true;
        }
        if (nuevo.id > ultimoS.id) {
            nuevo.ant = ultimoS;
            ultimoS.sig = nuevo;
            ultimoS = nuevo;
            return true;
        }

        Secundaria temp = inicioS;
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
    
    //busca un nodo en la sublista y lo retorna... en caso de no encontrarlo retorna null
    public Sublista buscar(int id) {
        Sublista temp = inicioP.sigSub;
        while (temp != null) {
            if (temp.id == id) {
                return temp;
            }
            temp = temp.sig;
        }
        return null;
    }
    
    //busca un nodo en la lista secundaria y lo retorna... en caso de no encontrarlo retorna null
    public Secundaria buscarSec(int id) {
        Secundaria temp = inicioS;
        while (temp != null) {
            if (temp.id == id) {
                return temp;
            }
            temp = temp.sig;
        }
        return null;
    }
    
    //insertar inicio en la sublista
    public boolean insertarInicio(int id, String info, Secundaria destino) {
        Sublista nuevo = new Sublista(id, info, destino);
        if (inicioP.sigSub == null) {
            inicioP.sigSub = nuevo;
            return true;
        }
        if (buscar(id) == null) {
            nuevo.sig = inicioP.sigSub;
            inicioP.sigSub.ant = nuevo;
            inicioP.sigSub = nuevo;
            return true;
        }
        return false;
    }
    
    //insertar final en la sublista
    public boolean insertarFinal(int id, String info, Secundaria destino) {
        Sublista nuevo = new Sublista(id, info, destino);
        if (inicioP.sigSub == null) {
            inicioP.sigSub = nuevo;
            return true;
        }
        if (buscar(id) == null) {
            Sublista temp = inicioP.sigSub;
            while (temp != null) {
                if (temp.sig == null) {
                    temp.sig = nuevo;
                    nuevo.ant = temp;
                    return true;
                }
                temp = temp.sig;
            }
        }
        return false;
    }
    
    //insertar ordenado en la sublista
    public boolean insertarOrdenado(int id, String info, Secundaria destino) {
        Sublista nuevo = new Sublista(id, info, destino);
        if (inicioP.sigSub == null) {
            inicioP.sigSub = nuevo;
            return true;
        }
        if (nuevo.id < inicioP.sigSub.id) {
            nuevo.sig = inicioP.sigSub;
            inicioP.sigSub.ant = nuevo;
            inicioP.sigSub = nuevo;
            return true;
        }
        Sublista temp = inicioP.sigSub;
        while (temp != null) {
            if (temp.sig == null & nuevo.id > temp.id) {
                temp.sig = nuevo;
                nuevo.ant = temp;
                return true;
            } else {
                if (temp.id < nuevo.id & temp.sig.id > nuevo.id) {
                    nuevo.ant = temp;
                    nuevo.sig = temp.sig;
                    temp.sig.ant = nuevo;
                    temp.sig = nuevo;
                    return true;
                }
            }
            temp = temp.sig;
        }
        return false;
    }
    
    //modifica un nodo de la sublista
    public boolean modificar(int id, String info, Secundaria destino) {
        if (buscar(id) != null) {
            Sublista temp = inicioP.sigSub;
            while (temp != null) {
                if (temp.id == id) {
                    temp.info = info;
                    temp.sigSec = destino;
                    return true;
                }
                temp = temp.sig;
            }
        }

        return false;
    }
    
    //eliminar un nodo de la sublista
    public boolean eliminar(int id) {
        Sublista temp = buscar(id);
        if (temp != null) {
            if (inicioP.sigSub == temp) {
                if (temp.sig == null) {
                    inicioP.sigSub = null;
                    return true;
                }
                inicioP.sigSub = inicioP.sigSub.sig;
                inicioP.sigSub.ant = null;
                return true;
            }
            temp.sig.ant = temp.ant;
            temp.ant.sig = temp.sig;
            return true;
        }
        return false;
    }
    
    //pinta la lista principal en interfaz
    public void pintarPrincipal(Graphics g, Lienzos lienzo) {
        if (inicioP != null) {
            Principal temp = inicioP;
            Principal ant = inicioP;
            while (temp != null) {
                temp.paint(g);
                if (temp != ant) {
                    punteroDoble puntero = new punteroDoble(ant.x + 135, ant.y + 50);
                    puntero.paint(g, lienzo);
                }
                ant = temp;
                temp = temp.sig;
            }
            g.setColor(Color.black);
            g.fillRect(inicioP.x - 40, inicioP.y + 125, 80, 25);
            g.fillRect(ultimoP.x + 80, ultimoP.y + 125, 80, 25);
            g.setColor(Color.WHITE);
            g.setFont(new Font("HP Simplified Light", Font.BOLD, 22));
            g.drawString("INICIO", inicioP.x - 27, inicioP.y + 145);
            g.drawString("ULTIMO", ultimoP.x + 85, ultimoP.y + 145);
        }
    }
    
    //pinta la lista secundaria en interfaz
    public void pintarSecundaria(Graphics g, Lienzos lienzo) {
        if (inicioS != null) {
            Secundaria temp = inicioS;
            Secundaria ant = inicioS;
            while (temp != null) {
                temp.paint(g);
                if (temp != ant) {
                    punteroDoble puntero = new punteroDoble(ant.x + 135, ant.y + 50);
                    puntero.paint(g, lienzo);
                }
                ant = temp;
                temp = temp.sig;
            }
            g.setColor(Color.black);
            g.fillRect(inicioS.x - 40, inicioS.y - 30, 80, 25);
            g.fillRect(ultimoS.x + 80, ultimoS.y - 30, 80, 25);
            g.setColor(Color.WHITE);
            g.setFont(new Font("HP Simplified Light", Font.BOLD, 22));
            g.drawString("INICIO", inicioS.x - 27, inicioS.y - 10);
            g.drawString("ULTIMO", ultimoS.x + 85, ultimoS.y - 10);
        }
    }
    
    //pinta la sublista y sus punteros en interfaz
    public void paint(Graphics g, Lienzos lienzo) {
        pintarPrincipal(g, lienzo);
        punteroSublista inicoSub = new punteroSublista(inicioP.x + 103, inicioP.y + 115);
        inicoSub.paint(g, lienzo);
        pintarSecundaria(g, lienzo);
        if (inicioP != null) {
            if (inicioP.sigSub != null) {
                Sublista temp = inicioP.sigSub;
                Sublista ant = inicioP.sigSub;
                while (temp != null) {
                    temp.paint(g);
                    if (temp != ant) {
                        punteroDoble puntero = new punteroDoble(ant.x + 107, ant.y + 45);
                        puntero.paint(g, lienzo);
                    }
                    ant = temp;
                    temp = temp.sig;
                }
                Sublista aux = inicioP.sigSub;
                while (aux != null) {
                    if (aux.sigSec != null) {
                        Secundaria sec = buscarSec(aux.sigSec.id);
                        g.drawLine(aux.x + 52, aux.y + 105, sec.x + 60, sec.y);
                    }
                    aux = aux.sig;
                }
            }
        }

    }
    
    //asigna la posicion de los nodos en interfaz
    public void asignarPosiciones() {
        int cont = 1;
        Sublista temp = inicioP.sigSub;
        while (temp != null) {
            if (cont == 1) {
                temp.x = 100;
            } else {
                temp.x = (cont * 180) - 80;
            }

            cont += 1;
            temp = temp.sig;
        }
    }
    
    //obtiene la cantidad de nodos de la sublista para luego modificar el tamaño del JPANEL(lienzo)
    public int obtenerCantNodos() {
        int cant = 0;
        if (inicioP != null) {
            Sublista temp = inicioP.sigSub;
            while (temp != null) {
                cant += 1;
                temp = temp.sig;
            }
        }
        return cant;
    }
    
    //asigna posiciiones en la lista principal
    public void posicionesPrin() {
        int cont = 1;
        Principal temp = inicioP;
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
    
    //asigna posicisiones en la lista secundaria
    public void posicionesSec() {
        int cont = 1;
        Secundaria temp = inicioS;
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
}
