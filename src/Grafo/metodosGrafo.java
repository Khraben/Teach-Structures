package Grafo;

import Diseños.Lienzos;
import Punteros.punteroDestino;
import Punteros.punteroDoble;
import Punteros.punteroGrafo;
import Punteros.punteroVertical;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.DefaultListModel;

public class metodosGrafo {

    public Vertice grafo; //inicio

    //inserta un vertice en el grafo
    public boolean insertarVertice(String nombre, String info) {
        Vertice nuevo = new Vertice(nombre, info);
        if (grafo == null) {
            grafo = nuevo;
            return true;
        }
        nuevo.sig = grafo;
        grafo.ant = nuevo;
        grafo = nuevo;
        return true;
    }

    //busca un vertice y lo retorna
    public Vertice buscarVertice(String nombre) {
        Vertice aux = grafo;
        while (aux != null) {
            if (aux.nombre.equals(nombre)) {
                return aux;
            }
            aux = aux.sig;
        }
        return null;
    }

    //inserta un arco en el grafo
    public boolean insertarArco(Vertice origen, Vertice destino, int peso) {
        Arco nuevo = new Arco(peso);
        nuevo.destino = destino;
        if (origen.sigA == null) {
            origen.sigA = nuevo;
            return true;
        }
        origen.sigA.ant = nuevo;
        nuevo.sig = origen.sigA;
        origen.sigA = nuevo;
        return true;
    }

    //busca un arco y lo retorna
    public Arco buscarArco(Vertice origen, Vertice destino) {
        Arco aux = origen.sigA;
        while (aux != null) {
            if (aux.destino == destino) {
                return aux;
            }
            aux = aux.sig;
        }
        return null;
    }

    //elimina un arco del grafo
    public boolean eliminarArco(Vertice origen, Arco auxA) {
        if (origen.sigA == auxA) {
            origen.sigA = auxA.sig;
            if (auxA.sig != null) {
                auxA.sig.ant = null;
            }
            return true;
        }
        auxA.ant.sig = auxA.sig;
        if (auxA.sig != null) {
            auxA.sig.ant = auxA.ant;
        }
        return true;
    }

    //eliminar un vertice del grafo
    public boolean eliminarVertice(Vertice verticeEliminar) {
        Vertice aux = grafo;
        while (aux != null) {
            if ((aux.sigA != null) & (aux != verticeEliminar)) {
                Arco auxArco = buscarArco(aux, verticeEliminar);
                if (auxArco != null) {
                    eliminarArco(aux, auxArco);
                }
            }
            aux = aux.sig;

        }
        if (grafo == verticeEliminar) {
            if (grafo.sig == null) {
                grafo = null;
                return true;
            }
            grafo = grafo.sig;
            grafo.ant = null;
            return true;
        }
        verticeEliminar.ant.sig = verticeEliminar.sig;
        if (verticeEliminar.sig != null) {
            verticeEliminar.sig.ant = verticeEliminar.ant;
        }
        return true;
    }

    //recorre el grafo de forma amplitud(no recursivo)
    public DefaultListModel recorridoAmplitud() {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.clear();
        if (grafo != null) {
            Vertice aux = grafo;
            while (aux != null) {
                listModel.addElement("Vertice: " + aux.nombre);
                listModel.addElement("Info: " + aux.info);
                if (aux.sigA != null) {
                    listModel.addElement("   Arcos:");
                    Arco auxArco = aux.sigA;
                    while (auxArco != null) {
                        listModel.addElement("      Destino: " + auxArco.destino.nombre);
                        listModel.addElement("      Peso: " + auxArco.peso);
                        if (auxArco.sig != null) {
                            listModel.addElement("___________________________");
                        }
                        auxArco = auxArco.sig;
                    }
                }
                listModel.addElement(" ");
                listModel.addElement(" ");
                aux = aux.sig;
            }
        }
        return listModel;
    }

    //recorre el grafo en forma de profundidad (recursivo)
    public void recorridoProfundidad(Vertice grafo, DefaultListModel listModel) {
        if ((grafo == null) | (grafo.marca == true)) {
            return;
        }
        grafo.marca = true;
        listModel.addElement(" ");
        listModel.addElement("Vertice: " + grafo.nombre);
        listModel.addElement("Info: " + grafo.info);
        if (grafo.sigA != null) {
            listModel.addElement("   Arcos:");
            Arco aux = grafo.sigA;
            while (aux != null) {
                listModel.addElement("      Destino: " + aux.destino.nombre);
                listModel.addElement("      Peso: " + aux.peso);
                recorridoProfundidad(aux.destino, listModel);
                if (aux.sig != null) {
                    listModel.addElement("___________________________");
                }
                aux = aux.sig;
            }
        }
    }

    //limpia las marcas de los vertices (las deja en false)
    public void limpiarMarcas() {
        if (grafo != null) {
            Vertice aux = grafo;
            while (aux != null) {
                aux.marca = false;
                aux = aux.sig;
            }
        }
    }//pone todas las marcas de los vertices en false

    //modifica un vertice de la lista
    public boolean modificarVertice(String nombre, String info) {
        if (buscarVertice(nombre) != null) {
            Vertice temp = grafo;
            while (temp != null) {
                if (temp.nombre.equals(nombre)) {
                    temp.info = info;
                    return true;
                }
                temp = temp.sig;
            }
        }
        return false;
    }

    //modifica un arco del grafo
    public boolean modificarArco(Vertice origen, Vertice destino, int peso) {
        Arco temp = origen.sigA;
        while (temp != null) {
            if (temp.destino == destino) {
                temp.peso = peso;
                return true;
            }
            temp = temp.sig;
        }
        return false;
    }

    //pinta los nodos y punteros en interfaz
    public void paint(Graphics g, Lienzos lienzo) {
        if (grafo != null) {
            Vertice temp = grafo;
            Vertice antV = grafo;
            while (temp != null) {
                temp.paint(g);
                if (temp != antV) {
                    punteroVertical puntero = new punteroVertical(antV.x + 45, antV.y + 125);
                    puntero.paint(g, lienzo);
                }
                if (temp.sigA != null) {
                    punteroGrafo puntero = new punteroGrafo(temp.x + 120, temp.y + 25);
                    puntero.paint(g, lienzo);
                }
                Arco aux = temp.sigA;
                Arco antA = temp.sigA;
                while (aux != null) {
                    aux.paint(g);
                    punteroDestino punteroD = new punteroDestino(aux.x + 75, aux.y + 95);
                    punteroD.paint(g, lienzo);
                    g.setColor(Color.BLACK);
                    g.setFont(new Font("HP Simplified Light", Font.PLAIN, 13));
                    g.drawString("Destino:\n" + aux.destino.nombre, aux.x + 90, aux.y + 130);
                    if (aux != antA) {
                        punteroDoble puntero = new punteroDoble(antA.x + 117, antA.y + 45);
                        puntero.paint(g, lienzo);
                    }
                    antA = aux;
                    aux = aux.sig;
                }
                antV = temp;
                temp = temp.sig;
            }
        }
    }

    //asigna la posicion de los nodos en la pantalla
    public void asignarPosiciones() {
        int contV = 1;
        Vertice temp = grafo;
        while (temp != null) {
            if (contV == 1) {
                temp.y = 80;
            } else {
                temp.y = (contV * 200) - 120;
            }
            Arco aux = temp.sigA;
            int contA = 1;
            while (aux != null) {
                aux.y = temp.y + 60;
                if (contA == 1) {
                    aux.x = 200;
                } else {
                    aux.x = (contA * 200) - 5;
                }
                contA += 1;
                aux = aux.sig;
            }
            contV += 1;
            temp = temp.sig;
        }
    }

    //obtiene la cantidad de vertices del grafo
    public int obtenerCantVertices() {
        int cant = 0;
        if (grafo != null) {
            Vertice temp = grafo;
            while (temp != null) {
                cant += 1;
                temp = temp.sig;
            }
        }
        return cant;
    }

    //obtiene la cantidad mayor de arcos que tiene un vertice
    public int obtenerCantMaxArcos() {
        int cant = 0, max = 0;
        if (grafo != null) {
            Vertice temp = grafo;
            while (temp != null) {
                if (temp.sigA != null) {

                    Arco aux = temp.sigA;
                    while (aux != null) {
                        cant += 1;
                        aux = aux.sig;
                    }
                    if (cant > max) {
                        max = cant;
                    }
                    cant = 0;
                }
                temp = temp.sig;
            }
        }
        return max;
    }

    //******METODOS RELACIONADOS AL DIJKSTRA******//
    //
    //
    //
    //*********************************************//
    Arco tempA;
    Vertice auxV;
    int alterna = 999999999;
    int peso = 0;

    public boolean buscarVerticeG() {
        Vertice tempV = grafo;
        while (tempV != null) {
            if (conexo(tempV, tempV) == null) {
                return false;
            }
            tempV = tempV.sig;
        }
        return true;
    }

    public Vertice conexo(Vertice tempV, Vertice igual) {
        if (tempV.sigA != null) {
            tempA = tempV.sigA;
            while (tempA != null) {
                if (tempA.destino == igual) {
                    return igual;
                }
                if (tempA.destino.marca) {
                    tempA = tempA.sig;
                }
                if (!tempA.destino.marca) {
                    tempA.destino.marca = true;
                    if (conexo(tempA.destino, igual) != null) {
                        limpiarMarcas();
                        return igual;
                    }
                }
                if (tempA.sig != null) {
                    tempA = tempA.sig;
                } else {
                    tempA.destino.marca = false;
                }
            }
        }
        return null;
    }

    public void reiniciarValor() {
        Vertice tempV = grafo;
        while (tempV != null) {
            tempV.valorMin = 999999999;
            tempV = tempV.sig;
        }
    }

    public void parametrosMin(String inicio, String destino, DefaultListModel z) {
        reiniciarValor();
        if (buscarVerticeG()) {
            if (buscarVertice(inicio) != null && buscarVertice(destino) != null) {
                Vertice a = buscarVertice(inicio);
                a.valorMin = 0;
                Vertice b = buscarVertice(destino);
                auxV = a;
                z.addElement("Vertice de salida: " + a.nombre);
                z.addElement("Ruta con menor peso:");
                rutaMinima(a, b, 0, a.sigA, z);
            }
        }
    }

    public int rutaMinima(Vertice inicioV, Vertice destino, int rutaMinima, Arco opcion, DefaultListModel z) {
        peso = opcion.peso;
        if (auxV == inicioV) {//Establece el valor minimo de inicio
            rutaMinima = peso;
            if (opcion.destino == destino) { //Caso de que el nodo que se inicia, se conecta al destino
                if (opcion.sig != null) {//En caso de que exista otra ruta hacia destino
                    alterna = rutaMinima(inicioV, destino, 0, opcion.sig, z);
                    if (alterna < rutaMinima) {//Busca si existe una ruta alterna con menor peso
                        z.addElement("\tVertice: " + inicioV.nombre + " a " + ubicarAlterna(inicioV, peso).destino.nombre);
                        return alterna;
                    }
                } else {//Caso de que no exista ruta alterna
                    z.addElement("\tVertice: " + inicioV.nombre + " a " + opcion.destino.nombre);
                    return rutaMinima;
                }
            } else {
                if (opcion.sig != null) {//En caso de que exista otra ruta hacia destino
                    alterna = rutaMinima(inicioV, destino, 0, opcion.sig, z);
                    if (alterna < rutaMinima) {//Busca si existe una ruta alterna con menor peso
                        z.addElement("\tVertice: " + inicioV.nombre + " a " + ubicarAlterna(inicioV, peso).destino.nombre);
                        rutaMinima(ubicarAlterna(inicioV, peso).destino, destino, alterna, ubicarAlterna(inicioV, peso), z);
                    } else {
                        z.addElement("\tVertice: " + inicioV.nombre + " a " + opcion.destino.nombre);
                        rutaMinima(opcion.destino, destino, rutaMinima + peso, opcion.destino.sigA, z);
                    }
                } else {
                    inicioV.marca = true;
                    z.addElement("\tVertice: " + inicioV.nombre + " a " + opcion.destino.nombre);
                    rutaMinima(opcion.destino, destino, rutaMinima + peso, opcion.destino.sigA, z);
                    return rutaMinima;
                }
            }
        } else if (peso + rutaMinima < inicioV.valorMin) {//Trasladarse de un nodo a otro sin que haya sido explorado
            inicioV.valorMin = peso + rutaMinima;
            if (opcion.destino == destino) {//caso de que el siguiente nodo sea el destino
                if (opcion.sig != null) { //si existe una ruta alterna
                    alterna = rutaMinima(inicioV, destino, rutaMinima, opcion.sig, z);
                    if (alterna < rutaMinima) {//Ruta alterna con menor peso
                        inicioV.valorMin = alterna;
                        z.addElement("\tVertice: " + inicioV.nombre + " a " + ubicarAlterna(inicioV, peso).destino.nombre);
                        return alterna;
                    } else {//Caso de que no exista ruta alterna
                        z.addElement("\tVertice: " + inicioV.nombre + " a " + opcion.destino.nombre);
                        return rutaMinima;
                    }
                }
            } else {//Caso de que el nodo siguiente no sea destino
                if (!opcion.destino.marca) { //si no ha sido visitado antes
                    if (opcion.sig != null) {//si existe una ruta alterna
                        alterna = rutaMinima(inicioV, destino, rutaMinima, opcion.sig, z);
                        if (alterna > rutaMinima) {
                            inicioV.valorMin = alterna;
                            z.addElement("\tVertice: " + inicioV.nombre + " a " + ubicarAlterna(inicioV, peso).destino.nombre);
                            rutaMinima(ubicarAlterna(inicioV, peso).destino, destino, alterna + peso, ubicarAlterna(inicioV, peso).destino.sigA, z);
                            return alterna;
                        } else {//si la ruta alterna es mayor
                            inicioV.valorMin = rutaMinima;
                            z.addElement("\tVertice: " + inicioV.nombre + " a " + opcion.destino.nombre);
                            rutaMinima(opcion.destino, destino, rutaMinima + peso, opcion.destino.sigA, z);
                            return rutaMinima;
                        }
                    } else {//si no existe ruta alterna o ya se provaron todas las rutas
                        inicioV.marca = true;
                        inicioV.valorMin = rutaMinima;
                        z.addElement("\tVertice: " + inicioV.nombre + " a " + opcion.destino.nombre);
                        rutaMinima(opcion.destino, destino, rutaMinima + peso, opcion.destino.sigA, z);
                        return rutaMinima;
                    }
                }
            }
        }
        return rutaMinima;
    }

    public Arco ubicarAlterna(Vertice inicioV, int peso) {
        Arco auxA = inicioV.sigA;
        while (auxA != null) {
            if (auxA.peso == peso) {
                return auxA;
            }
            auxA = auxA.sig;
        }
        return null;
    }
}
