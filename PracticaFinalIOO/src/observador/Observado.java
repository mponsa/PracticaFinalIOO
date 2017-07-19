package observador;

import java.util.*;


public abstract class Observado {
	
	//Lista de observadores
	private List<IObservador> observadores = new ArrayList<IObservador>();
	
	//Agregar un observador
	public void agregarObservador(IObservador obs){
		this.observadores.add(obs);
	}
	
	public void borrarObservador(IObservador obs){
		this.observadores.remove(obs);
	}
	
	public void borrarObservador(){
		this.observadores.clear();
	}
	
	public void actualizarObservadores(){
		for(IObservador i : observadores){
			i.Actualizar();
		}
		
	}
	
}
