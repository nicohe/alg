package tp04.ejercicio1;

import tp02.ejercicio2.ColaGenerica;
import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;

public class NodoGeneral<T> {

    private T dato;
    private ListaGenerica<NodoGeneral<T>> listaHijos;
    
    public NodoGeneral(T dato){

        this.dato = dato;
        listaHijos = new ListaEnlazadaGenerica<NodoGeneral<T>>();
    }
    
    public T getDato(){

        return this.dato;
    }    
    
    public ListaGenerica<NodoGeneral<T>> getHijos(){

        return this.listaHijos;
    }     
    
    public void setDato(T dato){

        this.dato = dato;
    }
    
    public void setListaHijos(ListaGenerica<NodoGeneral<T>> lista){

        this.listaHijos = lista;
    }    
    
    
  public void preOrden(ListaGenerica<T> l){
		l.agregarFinal(this.getDato());
		ListaGenerica<NodoGeneral<T>> lHijos = this.getHijos();
		lHijos.comenzar();
		while(!lHijos.fin()){
			(lHijos.proximo()).preOrden(l);
		}
	}
	
	public void postOrden(ListaGenerica<T> l){		
		ListaGenerica<NodoGeneral<T>> lHijos = this.getHijos();
		lHijos.comenzar();
		while(!lHijos.fin()){
			(lHijos.proximo()).postOrden(l);
		}
		l.agregarFinal(this.getDato());
	}
	
	public void inOrden(ListaGenerica<T> l){		
		ListaGenerica<NodoGeneral<T>> lHijos = this.getHijos();
		if(lHijos.tamanio() == 0) {
			l.agregarFinal(this.getDato());
		} else {
			lHijos.comenzar();
			if(!lHijos.fin()){
				(lHijos.proximo()).inOrden(l);
			}
			l.agregarFinal(this.getDato());
			while(!lHijos.fin()){
				(lHijos.proximo()).inOrden(l);
			}
		}
	}
	
	public void porNiveles(ListaEnlazadaGenerica<T> lis) {
		
		NodoGeneral<T> aux;
		ColaGenerica<NodoGeneral<T>> cola = new ColaGenerica<NodoGeneral<T>>();
		ListaGenerica<NodoGeneral<T>> hijos;
		cola.encolar(this);
		
		while(!cola.esVacia()) {
			aux = cola.desencolar();
			if(aux != null) {
				lis.agregarFinal(aux.getDato());
				
				hijos = aux.getHijos();
				hijos.comenzar();
				while (!hijos.fin()) {
					cola.encolar(hijos.proximo());
				}
			}else{
				if(!cola.esVacia()){
					cola.encolar(null);
				}
			}	
		}
	}	
}
