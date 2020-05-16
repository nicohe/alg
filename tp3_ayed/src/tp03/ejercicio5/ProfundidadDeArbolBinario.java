package tp03.ejercicio5;

import tp02.ejercicio2.ColaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class ProfundidadDeArbolBinario {
	private ArbolBinario<Integer> arbol;

    public ProfundidadDeArbolBinario(ArbolBinario<Integer> arbol) {
        this.arbol = arbol;
    }

    public int sumaElementosProfundidad(int p) {
        int nivel = 0;
        int suma = 0;
        ColaGenerica<ArbolBinario<Integer>> cola = new ColaGenerica<>();
        cola.encolar(this.arbol);
        cola.encolar(null);
        ArbolBinario<Integer> elem;
        while (!cola.esVacia() && nivel <= p) {
            elem = cola.desencolar();
            if (elem != null) {
                if (nivel == p) {
                    suma += elem.getDatoRaiz();
                } else {  // no es necesario encolar una vez procesado el nivel p
                    if (!elem.getHijoIzquierdo().esVacio()) {
                        cola.encolar(elem.getHijoIzquierdo());
                    }
                    if (!elem.getHijoDerecho().esVacio()) {
                        cola.encolar(elem.getHijoDerecho());
                    }
                }
            } else {
                if (!cola.esVacia()) {
                    nivel++;
                    cola.encolar(null);
                }
            }
        }
        return suma;
    }
}
