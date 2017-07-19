package model;

public class Mensaje extends App {
	
	private String content;
	private Usuario emisor;

	
	public Mensaje(Usuario emisor, String contenido){
		this.content = contenido;
		this.emisor = emisor;
	};
	
	public String getContent(){
		return this.content;
	};
	
	public Usuario getEmisor(){
		return this.emisor;
	}
}
