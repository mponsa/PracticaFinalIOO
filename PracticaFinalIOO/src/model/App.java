package model;

import observador.*;
import java.util.*;

public class App extends Observado {
	protected List <SalaDeChat> salas = new ArrayList<SalaDeChat>();
	protected List <Usuario> usuarios = new ArrayList<Usuario>();
 	
	
	
	public boolean agregarSala(String nombre){
		salas.add(new SalaDeChat(nombre));
		return true;
	}
	
	public void crearUsuario(String nombre){
		usuarios.add(new Usuario(nombre));
	}
	
	public List<SalaDeChat> getSalas(){
		return this.salas;
	}
}
