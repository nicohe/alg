package tp04.ejercicio1;

import tp02.ejercicio2.ColaGenerica;
import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;

public class ArbolGeneral<T> {

	private NodoGeneral<T> raiz;

	public ArbolGeneral() {

		this.raiz = null;
	}

	public ArbolGeneral(T dato) {

		this.raiz = new NodoGeneral<T>(dato);
		
	}

	public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> lista) {

		this(dato);
		ListaGenerica<NodoGeneral<T>> hijos = new ListaEnlazadaGenerica<NodoGeneral<T>>();

		lista.comenzar();
		while (!lista.fin()) {
			ArbolGeneral<T> arbolTemp = lista.proximo();
			hijos.agregarFinal(arbolTemp.getRaiz());
			
		}

		raiz.setListaHijos(hijos);
	}

	private ArbolGeneral(NodoGeneral<T> nodo) {

		this.raiz = nodo;
	}


	private NodoGeneral<T> getRaiz() {

		return this.raiz;
	}

	public T getDatoRaiz() {

		return this.raiz.getDato();
	}

	
	public ListaGenerica<ArbolGeneral<T>> getHijos() {

		ListaGenerica<ArbolGeneral<T>> lista = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		ListaGenerica<NodoGeneral<T>> hijos = (ListaGenerica<NodoGeneral<T>>) this
				.getRaiz().getHijos();
		lista.comenzar();
		hijos.comenzar();

		while (!hijos.fin()) {
			lista.agregarFinal(new ArbolGeneral<T>(hijos.proximo()));
			
		}

		return lista;
	}

	
	public void agregarHijo(ArbolGeneral<T> unHijo) {

		NodoGeneral<T> hijo = unHijo.getRaiz();
		this.raiz.getHijos().agregarFinal(hijo);
	}

	
	public void eliminarHijo(ArbolGeneral<T> unHijo) {

		NodoGeneral<T> hijo = unHijo.getRaiz();
		boolean ok = false;

		ListaGenerica<NodoGeneral<T>> listaHijos = (ListaGenerica<NodoGeneral<T>>) this
				.getRaiz().getHijos();
		listaHijos.comenzar();

		while (!listaHijos.fin() && !ok) {

			NodoGeneral<T> hijoTemp = listaHijos.proximo();
			if (hijoTemp.getDato().equals(hijo.getDato())) {
				ok = listaHijos.eliminar(hijoTemp);
				
			}
		}	

		
	}
	
	public ListaEnlazadaGenerica<T> preOrden() { 
		ListaEnlazadaGenerica<T> lis = new ListaEnlazadaGenerica<T>();
		this.getRaiz().preOrden(lis);
		return lis;
	}
	
	public ListaEnlazadaGenerica<T> postOrden() { 
		ListaEnlazadaGenerica<T> lis = new ListaEnlazadaGenerica<T>();
		this.getRaiz().postOrden(lis);
		return lis;
	}
	
	public ListaEnlazadaGenerica<T> inOrden() { 
		ListaEnlazadaGenerica<T> lis = new ListaEnlazadaGenerica<T>();
		this.getRaiz().inOrden(lis);
		return lis;
	}


	public ListaEnlazadaGenerica<T> porNiveles() { 
		ListaEnlazadaGenerica<T> lis = new ListaEnlazadaGenerica<T>();
		this.getRaiz().porNiveles(lis);
		return lis;
	}
    
	public Integer altura() {
		if(this.esHoja()) {
			return 0;
		} else {
			int altura;
			int max = -1;
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			hijos.comenzar();
			while(!hijos.fin()) {
				altura = 1;
				altura += hijos.proximo().altura();
				
				if(altura > max) max = altura;
			}
			return max;
		}
	}

	
	public Integer nivel(T dato){
		if(this.esHoja()) {
			return -1;
		} else {
			ArbolGeneral<T> arbol = new ArbolGeneral<T>();
			ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
			int nivel = 0;
			boolean encontre = false;
			cola.encolar(this);
			cola.encolar(null);
			
			while(!cola.esVacia() && !encontre) {
				arbol = cola.desencolar();
				if(arbol != null) {
					if(arbol.getDatoRaiz() == dato)	encontre = true;
					else {
						ListaGenerica<ArbolGeneral<T>> hijos = arbol.getHijos();
						hijos.comenzar();
						while (!hijos.fin()) cola.encolar(hijos.proximo());
					}
				}else{
					if(!cola.esVacia() && !encontre){
						nivel++;
						cola.encolar(null);
					}
				}	
			}
			
			if(!encontre) nivel = -1;
			
			return nivel;
		}
		
	}


	public Integer ancho(){
		ArbolGeneral<T> arbol = new ArbolGeneral<T>();
		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
		int cantNodos = 0;
		int max = -1;
		cola.encolar(this);
		cola.encolar(null);
		while(!cola.esVacia()) {
			arbol = cola.desencolar();
			if(arbol != null) {
				ListaGenerica<ArbolGeneral<T>> hijos = arbol.getHijos();
				hijos.comenzar();
				while (!hijos.fin()) {
					cola.encolar(hijos.proximo());
					cantNodos++;
				}
			 }else{
				 if(max < cantNodos){
				   max = cantNodos;
				 }
				 cantNodos = 0;
				 cola.encolar(null);
			  }
		}
		
		return max;
	}

	public Boolean esHoja(){
		return this.getHijos().esVacia() && this.getDatoRaiz() != null;
	}
	
	public Boolean esVacio(){
		return this.getDatoRaiz() == null;
	}
	
	public Boolean esAncestro(T a, T b) {
		ArbolGeneral<T> arbol = new ArbolGeneral<T>();
		ArbolGeneral<T> arbol2 = null;
		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
		ListaGenerica<ArbolGeneral<T>> hijos;
		boolean encontre = false;
		cola.encolar(this);
		cola.encolar(null);
		while(!cola.esVacia() && !encontre) {
			arbol = cola.desencolar();
			if(arbol != null) {
				if(arbol.getDatoRaiz() == a) {
					encontre = true;
					arbol2 = arbol;
				}
				else {
					hijos = arbol.getHijos();
					hijos.comenzar();
					while(!hijos.fin()) {
						cola.encolar(hijos.proximo());
					}
				}
			} else {
				if(!cola.esVacia()) {
					cola.encolar(null);
				}
			}
		}
		
		if(arbol.getDatoRaiz() == a && encontre) {
			return this.esDescendiente(arbol2, b);
		}
		
		return false;
	}
	
	public Boolean esDescendiente(ArbolGeneral<T> a, T b){
		ArbolGeneral<T> arbol = new ArbolGeneral<T>();
		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
		boolean encontre = false;
		cola.encolar(a);
		cola.encolar(null);
		
		while(!cola.esVacia() && !encontre) {
			arbol = cola.desencolar();
			if(arbol != null) {
				if(arbol.getDatoRaiz() == b) encontre = true;
				else {
					ListaGenerica<ArbolGeneral<T>> hijos = arbol.getHijos();
					hijos.comenzar();
					while (!hijos.fin()) cola.encolar(hijos.proximo());
				}
			}else{
				if(!cola.esVacia()){
					cola.encolar(null);
				}
			}	
		}
		return encontre;
	}
	
	public double minimoCaudal(double caudalEntrante) {
		double minCaudal = caudalEntrante;
		ArbolGeneral<T> arbol;
		ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
		if(!hijos.fin()) {
			hijos.comenzar();
			while(!hijos.fin()) {
				minCaudal = Math.min(minCaudal, hijos.proximo().minimoCaudal(caudalEntrante / hijos.tamanio()));
			}
		}
		return minCaudal;
	}
	
	public double minimoCaudal2(double caudalEntrante) {
		int altura = this.altura() + 1;
		for (int i = 0; i < this.altura(); i++) {
			caudalEntrante /= altura;
		}
		return caudalEntrante;
	}
		
}
