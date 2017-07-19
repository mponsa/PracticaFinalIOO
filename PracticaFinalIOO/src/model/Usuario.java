package model;

public class Usuario extends App {
	private String nombre;
	
	public Usuario(String nombre){
		this.nombre = nombre;
	}
	
	public String getNombre(){
		return this.nombre;
	}
}
