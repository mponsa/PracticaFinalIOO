package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import model.*;
import observador.*;

public class VistaSwing extends JFrame implements IObservador{
	protected App app;
	
	private JButton btnAbrirSala;
	private JMenuBar barraMenu;
	private JMenu crear;
	private JMenuItem addSalas;
	private JMenuItem addUsuarios;
	public JComboBox<String> salas;
	private JLabel label1;
	
	public VistaSwing(App app){
		this.app = app;
		app.agregarObservador(this);
		configurarVentana();
		inicializarComponentes();
	}
	
	public void configurarVentana(){
		this.setTitle("Aplicacion de Mensajeria");
		this.setSize(360,300);
		this.setLayout(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void inicializarComponentes(){
		
		//Instancio Componentes
		btnAbrirSala = new JButton();
		barraMenu = new JMenuBar(); 
		crear = new JMenu("Menu de Creacion");
		addSalas = new JMenuItem("Crear Salas");
		addUsuarios = new JMenuItem("Crear Usuario");
		salas = new JComboBox<String>();
		label1 = new JLabel();
		
		//ActionListeners
		btnAbrirSala.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		addSalas.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				 new VistaSwingCreacionSala(app);
				
			}
			
		});
		
		addUsuarios.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new VistaSwingCreacionUser(app);
			}
			
		});
		
		//Texto inicial LABEL
		label1.setText("No actualizado");

		
		//Agregado al JFRAME.
		this.add(btnAbrirSala);
		this.add(salas);
		this.add(label1);
		this.setJMenuBar(barraMenu);
		
		
		//Localizacion y limites.
		btnAbrirSala.setBounds(10, 40, 100, 35);
		salas.setBounds(120,40,200,35);
		label1.setBounds(10, 10, 100, 30);
		
		//TextoBotones
		btnAbrirSala.setText("Abrir Sala");
		btnAbrirSala.setActionCommand("1");
		
		
		//BarraDeMENU
		barraMenu.add(crear);	
		
		//Boton de menu
		crear.add(addSalas);
		crear.add(addUsuarios);
		
		//Seteo de salas
		salas = new JComboBox();
		if(app.getSalas().isEmpty()){
			salas.addItem("No hay salas creadas aún");
		}else{
		for(SalaDeChat i : app.getSalas()){
			salas.addItem(i.getNombre());
		}
		}
		


	}

	@Override
	public void Actualizar() {
		// TODO Auto-generated method stub
		
		label1.setText("Actualizado");
		
		//Get Salas Nuevas
		if(app.getSalas().isEmpty()){
			salas.addItem("No hay salas creadas aún");
		}else{
		for(SalaDeChat i : app.getSalas()){
			salas.addItem(i.getNombre());
		}
		}
		
	
	};
	
}