package vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import model.App;

public abstract class VistaSwingCreacion extends JFrame{
	protected App app;
	
	private JLabel lbNombre;
	protected JTextArea texto;
	protected JButton btnAñadir;


	public VistaSwingCreacion(App app){
		this.app = app;
	} 
	
	public void configurarVentana(){
		this.setSize(300,300);
		this.setLayout(null);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void inicializarComponentes(){
		//Instancio componentes
		lbNombre = new JLabel();
		texto = new JTextArea();
		btnAñadir = new JButton();
	
		//Añadir al JFRAME
		this.add(lbNombre);
		this.add(texto);
		this.add(btnAñadir);
		
		//Localización y limites
		lbNombre.setBounds(10,5,100,35);
		texto.setBounds(10,40,100,35);
		btnAñadir.setBounds(120,40, 100, 35);
		
		//Texto
		lbNombre.setText("Nombre:");
		btnAñadir.setText("Añadir");
		
		
	}
	
	
}
