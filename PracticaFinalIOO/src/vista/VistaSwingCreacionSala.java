package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.App;

public class VistaSwingCreacionSala extends VistaSwingCreacion {
	VistaSwingCreacionSala vista;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	public VistaSwingCreacionSala(App app){
		super(app);
		vista = this;
		configurarVentana();
		inicializarComponentes();
		
		
	}
	
	public void configurarVentana(){
		super.configurarVentana();
		this.setTitle("Crear Sala de Chat");
	}
	
	
	
	public void inicializarComponentes(){
		super.inicializarComponentes();
		this.btnAñadir.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				app.agregarSala(texto.getText());
				app.actualizarObservadores();
				vista.dispose();
			}
			
		});
	}
}
