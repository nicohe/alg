package tp03.ejercicio3;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class ContadorArbol {
	private ArbolBinario<Integer> arbol;
    private String recorrido;

    public ContadorArbol(ArbolBinario<Integer> arbol, String recorrido) {
        this.arbol = arbol;
        this.recorrido = recorrido;
    }

    public ContadorArbol(ArbolBinario<Integer> arbol) {
        this.arbol = arbol;
    }

    public ListaGenerica<Integer> numerosPares() {
        ListaGenerica<Integer> lista = new ListaEnlazadaGenerica<>();
        switch (this.recorrido) {
            case "preorden":
                this.numerosParesPreOrden(this.arbol, lista);
                break;
            case "inorden":
                this.numerosParesInOrden(this.arbol, lista);
                break;
            case "postorden":
                this.numerosParesPostOrden(this.arbol, lista);
                break;
            default:
                this.numerosParesPreOrden(this.arbol, lista);
        }
        return lista;
    }
    
    private void numerosParesPreOrden(ArbolBinario<Integer> arbol, ListaGenerica<Integer> lista) {
        if (arbol.getDatoRaiz() % 2 == 0) {
            lista.agregarFinal(arbol.getDatoRaiz());
        }
        if (!arbol.getHijoIzquierdo().esVacio()) {
            this.numerosParesPreOrden(arbol.getHijoIzquierdo(), lista);
        }
        if (!arbol.getHijoDerecho().esVacio()) {
            this.numerosParesPreOrden(arbol.getHijoDerecho(), lista);
        }
    }
    
    private void numerosParesInOrden(ArbolBinario<Integer> arbol, ListaGenerica<Integer> lista) {
        if (!arbol.getHijoIzquierdo().esVacio()) {
            this.numerosParesPreOrden(arbol.getHijoIzquierdo(), lista);
        }
        if (arbol.getDatoRaiz() % 2 == 0) {
            lista.agregarFinal(arbol.getDatoRaiz());
        }
        if (!arbol.getHijoDerecho().esVacio()) {
            this.numerosParesPreOrden(arbol.getHijoDerecho(), lista);
        }
    }
    
    private void numerosParesPostOrden(ArbolBinario<Integer> arbol, ListaGenerica<Integer> lista) {
        if (!arbol.getHijoIzquierdo().esVacio()) {
            this.numerosParesPreOrden(arbol.getHijoIzquierdo(), lista);
        }
        if (!arbol.getHijoDerecho().esVacio()) {
            this.numerosParesPreOrden(arbol.getHijoDerecho(), lista);
        }
        if (arbol.getDatoRaiz() % 2 == 0) {
            lista.agregarFinal(arbol.getDatoRaiz());
        }
    }
    
}
