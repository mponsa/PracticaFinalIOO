package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.App;
import model.Mensaje;
import model.SalaDeChat;
import model.Usuario;
import observador.IObservador;


public class VistaSwingSala extends JFrame implements IObservador {
	private SalaDeChat chat;
	private App app;
	private JTextArea consola;
	private JButton btnEnviarMensaje;
	private JTextField texto;
	private JButton btnAñadirUser;
	private JComboBox<String> usuarios;
	
	public VistaSwingSala(App app, SalaDeChat chat) {
		// TODO Auto-generated constructor stub
		this.chat = chat;
		this.app  = app;
		this.app.agregarObservador(this);
		configurarVentana();
		inicializarComponentes();
	}

	public void configurarVentana(){
		this.setTitle(chat.getNombre());
		this.setSize(530,600);
		this.setLayout(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);;
	}
	
	public void inicializarComponentes(){
		//Instancio componentes
		btnAñadirUser = new JButton();
		consola = new JTextArea();
		btnEnviarMensaje = new JButton();
		texto = new JTextField();
		usuarios = new JComboBox();
	
		//ActionListeners
		btnAñadirUser.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new VistaSwingAñadirUsuario(app, chat);
			}
			
		});
		btnEnviarMensaje.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Usuario usr = null;
				for (Usuario user : chat.getUsuarios()){
					if (user.getNombre() == usuarios.getSelectedItem()){
						usr = user;
					}
				}
				if(usr != null){
					chat.addMensaje(texto.getText(), usr);
					texto.setText("");
					app.actualizarObservadores();
				}
				
			}
			
		});
		
		//GetMensajesPrevios.
		for (Mensaje i : chat.getMensajes()){
			consola.setText(consola.getText() + i.getEmisor().getNombre() + " Dice: "  + i.getContent() + " \n");
		}
		
		//Emisor
		for (Usuario e : chat.getUsuarios()){
			usuarios.addItem(e.getNombre());
		}
		
		//Añadir objetos a la vista Principal
		this.add(btnAñadirUser);
		this.add(consola);
		this.add(btnEnviarMensaje);
		this.add(texto);
		this.add(usuarios);
		
		//Localizacion y limites.
		btnAñadirUser.setBounds(10, 10, 100, 35);
		consola.setBounds(120,10,300,500);
		usuarios.setBounds(10,485,100,35);
		btnEnviarMensaje.setBounds(10, 520, 100, 35);
		texto.setBounds(120,520,300,35);
		
		//TextoBotones
		btnAñadirUser.setText("Añadir Usuario");
		btnEnviarMensaje.setText("Enviar");
		

		
		

		
	}
	
	
	
	@Override
	public void Actualizar() {
		// TODO Auto-generated method stub
		//Emisor
		usuarios.removeAllItems();
		consola.setText("");
		for (Usuario e : chat.getUsuarios()){
			usuarios.addItem(e.getNombre());
		}
		
		for (Mensaje i : chat.getMensajes()){
			consola.setText(consola.getText() + i.getEmisor().getNombre() + " Dice: "  + i.getContent() + " \n");
		}
		
	}
	

}
