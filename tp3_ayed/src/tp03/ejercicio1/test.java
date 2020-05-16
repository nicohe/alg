package tp03.ejercicio1;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio3.ContadorArbol;
import tp03.ejercicio4.RedBinariaLlena;
import tp03.ejercicio5.ProfundidadDeArbolBinario;

public class test {

	public static void main(String[] args) {
		/*ArbolBinario<Integer> ab= new ArbolBinario<Integer>(new Integer(40));
		ArbolBinario<Integer> hijoIzquierdo= new ArbolBinario<Integer>(25);
		hijoIzquierdo.agregarHijoIzquierdo(new ArbolBinario<Integer>(10));
		hijoIzquierdo.agregarHijoDerecho(new ArbolBinario<Integer>(32));
		ArbolBinario<Integer> hijoDerecho= new ArbolBinario<Integer>(78);
		ab.agregarHijoIzquierdo(hijoIzquierdo);
		ab.agregarHijoDerecho(hijoDerecho);
		
		System.out.println("Cantidad de hojas del árbol: " + ab.contarHojas());
		 */
		 
		ArbolBinario<Integer> arbol0 = new ArbolBinario<>(0);
	    ArbolBinario<Integer> arbol1 = new ArbolBinario<>(1);
	    ArbolBinario<Integer> arbol2 = new ArbolBinario<>(2);
	    ArbolBinario<Integer> arbol3 = new ArbolBinario<>(3);
	    ArbolBinario<Integer> arbol4 = new ArbolBinario<>(4);
	    ArbolBinario<Integer> arbol5 = new ArbolBinario<>(5);
	    ArbolBinario<Integer> arbol6 = new ArbolBinario<>(6);
	    ArbolBinario<Integer> arbol7 = new ArbolBinario<>(7);
	    ArbolBinario<Integer> arbol8 = new ArbolBinario<>(8);
	    ArbolBinario<Integer> arbol9 = new ArbolBinario<>(9);

	    arbol0.agregarHijoIzquierdo(arbol1);
	    arbol0.agregarHijoDerecho(arbol7);

	    arbol1.agregarHijoIzquierdo(arbol2);
	    arbol1.agregarHijoDerecho(arbol5);

	    arbol2.agregarHijoIzquierdo(arbol3);
	    arbol2.agregarHijoDerecho(arbol4);

	    arbol5.agregarHijoIzquierdo(arbol6);

	    arbol7.agregarHijoIzquierdo(arbol8);
	    arbol7.agregarHijoDerecho(arbol9);

	    arbol0.pprint();
	    //System.out.println("espejado:");
	    //arbol0.espejo().pprint();
	    //arbol0.recorridoPorNiveles();
	    
	    //arbol0.entreNiveles(1, 3);
	    
	    /*
	    ContadorArbol contadorArbol = new ContadorArbol(arbol0);
        ListaGenerica<Integer> listaPreOrden = new ContadorArbol(arbol0, "preorden").numerosPares();
        System.out.println("los numeros pares en preorden son: " + listaPreOrden);

        ListaGenerica<Integer> listaInOrden = new ContadorArbol(arbol0, "inorden").numerosPares();
        System.out.println("los numeros pares en inorden son: " + listaInOrden);

        ListaGenerica<Integer> listaPostOrden = new ContadorArbol(arbol0, "postorden").numerosPares();
        System.out.println("los numeros pares en postorden son: " + listaPostOrden);
        */
	    
//        RedBinariaLlena red  = new RedBinariaLlena(arbol0);
//        System.out.println("el mayor retardo posible es: " + red.retardoReenvio());
        

//        ProfundidadDeArbolBinario profundidadDeArbolBinario = new ProfundidadDeArbolBinario(arbol0);
//        int p = 2;
//        System.out.println("la suma de los elementos en el nivel " + p + " es: " + profundidadDeArbolBinario.sumaElementosProfundidad(p));
	}

}


