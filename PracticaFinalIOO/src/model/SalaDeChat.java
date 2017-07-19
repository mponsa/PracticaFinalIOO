package model;

import java.util.*;


public class SalaDeChat extends App {
	private static int max_participantes = 5;
	private String nombre;
	
	
	protected List<Usuario> usuarios = new ArrayList<Usuario>();
	protected List<Mensaje> mensajes = new ArrayList<Mensaje>();
	
	public SalaDeChat(String nombre){
		this.nombre = nombre;
	}
	
	public String getNombre(){
		return this.nombre; 
	}
	
	
	
	public List<Usuario> getUsuarios(){
		return usuarios;
	}
	
	public List<Mensaje> getMensajes(){
		return mensajes;
	}
	
	public int cantUsuarios(){
		int res = 0;
		for(Usuario usr : usuarios){
			res++;
		}
		return res;
	}
	
	public boolean addUser(Usuario usr){
		if(this.cantUsuarios()<=5){
		usuarios.add(usr);
		return true;
		}else{
		return false;
		}
	}
	
	public void addMensaje(String mensaje, Usuario emisor){
		this.mensajes.add(new Mensaje(emisor,mensaje));
	}
	
 }
