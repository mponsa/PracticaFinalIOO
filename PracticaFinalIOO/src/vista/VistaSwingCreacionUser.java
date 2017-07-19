package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.App;

public class VistaSwingCreacionUser extends VistaSwingCreacion {
	VistaSwingCreacionUser vista;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	public VistaSwingCreacionUser(App app){
		super(app);
		vista = this;
		configurarVentana();
		inicializarComponentes();
	}
	
	public void configurarVentana(){
		super.configurarVentana();
		this.setTitle("Crear Usuario");
	}
	
	
	public void inicializarComponentes(){
		super.inicializarComponentes();
		this.btnAñadir.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				app.crearUsuario(texto.getText());
				app.actualizarObservadores();
				vista.dispose();
			}
			
		});
	}
}
