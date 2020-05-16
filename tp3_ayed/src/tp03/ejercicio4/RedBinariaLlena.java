package tp03.ejercicio4;

import tp03.ejercicio1.ArbolBinario;

public class RedBinariaLlena {
	private ArbolBinario<Integer> arbol;

    public RedBinariaLlena(ArbolBinario<Integer> arbol) {
        this.arbol = arbol;
    }

    private int retardoReenvio(ArbolBinario<Integer> arbol) {
        if (arbol.esVacio()) {
            return 0;
        }
        if (arbol.esHoja()) {
            return arbol.getDatoRaiz();
        }
        return arbol.getDatoRaiz() + Math.max(
                this.retardoReenvio(arbol.getHijoIzquierdo()),
                this.retardoReenvio(arbol.getHijoDerecho())
        );
    }

    public int retardoReenvio() {
        return this.retardoReenvio(this.arbol);
    }
}
