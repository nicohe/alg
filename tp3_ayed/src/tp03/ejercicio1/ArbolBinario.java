package tp03.ejercicio1;

import tp02.ejercicio2.*;
public class ArbolBinario<T> {

	private NodoBinario<T> raiz;

	public ArbolBinario(T dato) {
		this.raiz = new NodoBinario<T>(dato);
	}

	private ArbolBinario(NodoBinario<T> nodo) {
		this.raiz = nodo;
	}

	private NodoBinario<T> getRaiz() {
		return raiz;
	}

	public T getDatoRaiz() {
		if (this.getRaiz() != null) {
			return this.getRaiz().getDato();
		} else {
			return null;
		}
	}

	public ArbolBinario<T> getHijoIzquierdo() {
		return new ArbolBinario<T>(this.raiz.getHijoIzquierdo());
	}

	public ArbolBinario<T> getHijoDerecho() {
		return new ArbolBinario<T>(this.raiz.getHijoDerecho());
	}

	public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
		this.raiz.setHijoIzquierdo(hijo.getRaiz());
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo) {
		this.raiz.setHijoDerecho(hijo.getRaiz());
	}

	public void eliminarHijoIzquierdo() {
		this.raiz.setHijoIzquierdo(null);
	}

	public void eliminarHijoDerecho() {
		this.raiz.setHijoDerecho(null);
	}

	public boolean esVacio() {
		return this.getDatoRaiz() == null;
	}

	public boolean esHoja() {
		return this.getDatoRaiz() != null && this.getHijoIzquierdo().esVacio() && this.getHijoDerecho().esVacio();
	}
	
	public int contarHojas() {
		if(this.esVacio()) return 0;
		else if(this.esHoja()) return 1;
		else return this.getHijoIzquierdo().contarHojas() + this.getHijoDerecho().contarHojas();
	}
	
	public ArbolBinario<T> espejo(){
		ArbolBinario<T> aux = new ArbolBinario<>(this.getDatoRaiz());
		if(!this.getHijoIzquierdo().esVacio())
			aux.agregarHijoDerecho(this.getHijoIzquierdo().espejo());
		if(!this.getHijoDerecho().esVacio())
			aux.agregarHijoIzquierdo(this.getHijoDerecho().espejo());
		return aux;
	}

	private void pprint(String prefijo, boolean esIzquierdo, boolean esDerecho) {
		if (!this.getHijoDerecho().esVacio()) {
			String pre = prefijo + (esIzquierdo ? "│   " : "    ");
			this.getHijoDerecho().pprint(pre, false, true);
		}

		if (esDerecho) {
			System.out.println(prefijo + "┌── " + this.getDatoRaiz().toString());
		} else if (esIzquierdo) {
			System.out.println(prefijo + "└── " + this.getDatoRaiz().toString());
		} else {
			System.out.println(prefijo + "├── " + this.getDatoRaiz().toString());
		}

		if (!this.getHijoIzquierdo().esVacio()) {
			String pre = prefijo + (esDerecho ? "│   " : "    ");
			this.getHijoIzquierdo().pprint(pre, true, false);
		}
	}

	public void pprint() {
		this.pprint("", false, false);
	}
	
	
	public void recorridoPorNiveles() {
		ArbolBinario arbol = null;
		ColaGenerica<ArbolBinario> cola = new ColaGenerica<ArbolBinario>();
		cola.encolar(this);
		cola.encolar(null);

		int nivel = 0;

		System.out.println("Nivel: " + nivel);

		while (!cola.esVacia()) {
			arbol = cola.desencolar();
			if (arbol != null) {

				System.out.print(arbol.getDatoRaiz() + "\t");
				if (!arbol.getHijoIzquierdo().esVacio()) {
					cola.encolar(arbol.getHijoIzquierdo());
				}
				if (!arbol.getHijoDerecho().esVacio()) {
					cola.encolar(arbol.getHijoDerecho());
				}
			} else if (!cola.esVacia()) {
				System.out.println();
				cola.encolar(null);
				nivel++;
				System.out.println("\nNivel: " + nivel);
			}

		}
	}
	
	public void entreNiveles(int n, int m) {
		int nivel = 0;
		ColaGenerica<ArbolBinario<T>> cola = new ColaGenerica<>();
		cola.encolar(this);
		cola.encolar(null);

		ArbolBinario<T> arbol = null;

		while (!cola.esVacia() && nivel <= m) {
			arbol = cola.desencolar();
			if (arbol != null) {
				if (nivel >= n && nivel <= m) {
					System.out.print(arbol.getDatoRaiz() + " ");
				}
				if (!arbol.getHijoIzquierdo().esVacio()) {
					cola.encolar(arbol.getHijoIzquierdo());
				}
				if (!arbol.getHijoDerecho().esVacio()) {
					cola.encolar(arbol.getHijoDerecho());
				}
			} else {
				if (!cola.esVacia()) {
					nivel++;
					cola.encolar(null);
					System.out.println();
				}
			}
		}
	}

}