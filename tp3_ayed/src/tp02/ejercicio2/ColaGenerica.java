package tp02.ejercicio2;

public class ColaGenerica<T> {
	
	private ListaEnlazadaGenerica<T> datos;
	
	public ColaGenerica() {
		datos = new ListaEnlazadaGenerica<T>();
	}
	
	public void encolar(T elem) {
		datos.agregarFinal(elem);
	}
	
	public T desencolar() {
		T aux = datos.elemento(1);
		datos.eliminarEn(1);
		return aux;
	}
	
	public T tope() {
		return datos.elemento(1);
	}
	
	public boolean esVacia() {
		return datos.esVacia();
	}
	
	public String print() {
		return datos.toString();
	}
}
