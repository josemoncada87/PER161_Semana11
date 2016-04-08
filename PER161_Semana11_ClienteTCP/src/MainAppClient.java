
public class MainAppClient {
	
	static Comunicacion comCliente; 

	public static void main(String[] args) {		
		comCliente = new Comunicacion();
		comCliente.start();
	}

}
