package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import model.App;
import model.SalaDeChat;
import model.Usuario;

public class VistaSwingAñadirUsuario extends JFrame{
	protected App app;
	private SalaDeChat chat;
	
	private VistaSwingAñadirUsuario vista;
	
	private JLabel lbNombre;
	protected JComboBox<String> combo;
	protected JButton btnAñadir;


	public VistaSwingAñadirUsuario(App app, SalaDeChat chat){
		this.app = app;
		this.chat = chat;
		this.vista = this;
		configurarVentana();
		inicializarComponentes();
	} 
	
	public void configurarVentana(){
		this.setTitle("AñadirUser");
		this.setSize(300,300);
		this.setLayout(null);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void inicializarComponentes(){
		//Instancio componentes
		lbNombre = new JLabel();
		combo = new JComboBox();
		btnAñadir = new JButton();
		
		//Seteo de usuarios para agregar
		for(Usuario usr : app.getUsuarios()){
			combo.addItem(usr.getNombre());
		}
		
		btnAñadir.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Usuario usr = null;
				
				for (Usuario user : app.getUsuarios()){
					if (user.getNombre() == combo.getSelectedItem()){
						usr = user;
					}
				}
				if(usr != null){
					chat.addUser(usr);
					app.actualizarObservadores();
				}
				
				vista.dispose();
			}
			
		});
	
		//Añadir al JFRAME
		this.add(lbNombre);
		this.add(combo);
		this.add(btnAñadir);
		
		//Localización y limites
		lbNombre.setBounds(10,5,100,35);
		combo.setBounds(10,40,100,35);
		btnAñadir.setBounds(120,40, 100, 35);
		
		//Texto
		lbNombre.setText("Nombre:");
		btnAñadir.setText("Añadir");
		
		
	}
	
	
}
