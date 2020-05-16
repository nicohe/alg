package tp04.ejercicio1;

import tp02.ejercicio2.ColaGenerica;
import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;

public class AreaEmpresa {
	
	private String id;
	private Integer tiempo;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getTiempo() {
		return tiempo;
	}

	public void setTiempo(Integer tiempo) {
		this.tiempo = tiempo;
	}
	
	public Integer devolverMaximoPromedio(ArbolGeneral<AreaEmpresa> arbol) {
		ArbolGeneral<AreaEmpresa> aux;
		ColaGenerica<ArbolGeneral<AreaEmpresa>> cola = new ColaGenerica<ArbolGeneral<AreaEmpresa>>();
		ListaGenerica<ArbolGeneral<AreaEmpresa>> hijos;		
		Integer max = -1;
		Integer promedio = 0;
		Integer cantNodos = 0;
		cola.encolar(arbol);
		cola.encolar(null);
		
		while(!cola.esVacia()) {
			aux = cola.desencolar();
			if(!aux.esVacio()) {
				promedio += aux.getDatoRaiz().getTiempo();
				cantNodos++;
				
				hijos = aux.getHijos();
				hijos.comenzar();
				while (!hijos.fin()) {
					cola.encolar(hijos.proximo());					
				}
			} else {
				promedio /= cantNodos;
				if(promedio > max) promedio = max;
				
				if(!cola.esVacia()) {
					cola.encolar(null);
					promedio = 0;
					cantNodos = 0;
				}
			}
		}
		
		return max;
	}
	
}
