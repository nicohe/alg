package tp04.ejercicio1;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;

public class test {

	public static void main(String[] args) {
		ArbolGeneral<String> a1 = new ArbolGeneral<String>("1");
		ArbolGeneral<String> a3 = new ArbolGeneral<String>("3");
		ListaGenerica<ArbolGeneral<String>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<String>>();
		
		
		
		ListaGenerica<ArbolGeneral<String>> hijos2 = new ListaEnlazadaGenerica<ArbolGeneral<String>>();
		ArbolGeneral<String> a4 = new ArbolGeneral<String>("4");
		ArbolGeneral<String> a5 = new ArbolGeneral<String>("5");
		ArbolGeneral<String> a6 = new ArbolGeneral<String>("6");
		hijos2.agregarFinal(a4);
		hijos2.agregarFinal(a5);
		hijos2.agregarFinal(a6);
		
		
		ArbolGeneral<String> a2 = new ArbolGeneral<String>("2", hijos2);
		
		hijos.agregarFinal(a1); 
		hijos.agregarFinal(a2); 
		hijos.agregarFinal(a3);
		ArbolGeneral<String> a = new ArbolGeneral<String>("0", hijos);
		
		System.out.println("Datos del Arbol: "+a.preOrden());
		System.out.println("Datos del Arbol: "+a.postOrden());
		System.out.println("Datos del Arbol: "+a.inOrden());
		System.out.println("Datos del Arbol: "+a.porNiveles());
		System.out.println("Alturas del Arbol: "+a.altura());
		System.out.println("Nivel del dato en el Arbol: "+a.nivel("2"));
		if(a.esAncestro("2", "5")) System.out.println("Es ancestro");
		System.out.println("El minimo caudal: " + a.minimoCaudal(2.0));
		System.out.println("El minimo caudal2: " + a.minimoCaudal2(2.0));
	}

}
