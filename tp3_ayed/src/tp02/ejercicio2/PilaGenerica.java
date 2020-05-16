package tp02.ejercicio2;

public class PilaGenerica<T> {

	private ListaGenerica<T> datos;
	
	public PilaGenerica() {
		datos = new ListaEnlazadaGenerica<T>();
	}
	
	public void apilar(T elem) {
		datos.agregarFinal(elem);
	}
	
	public T desapilar() {
		T aux = datos.elemento(datos.tamanio());
		datos.eliminarEn(datos.tamanio());
		return aux;
	}
	
	public T tope() {
		return datos.elemento(datos.tamanio());
	}
	
	public boolean esVacia() {
		return datos.esVacia();
	}
	
	public String print() {
		return datos.toString();
	}
}
