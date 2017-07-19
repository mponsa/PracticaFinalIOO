package programa;
import model.*;
import observador.*;
import vista.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		App app1 = new App();
		
		app1.agregarSala("Sala1");
		app1.crearUsuario("Prueba1");
		
		VistaSwing vista = new VistaSwing(app1);
		
	}

}
