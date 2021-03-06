import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;


public class Comunicacion extends Thread implements Observer {
	
	private ArrayList<ControlCliente> clientes;
	private ServerSocket ss;
	
	public Comunicacion() {
		clientes =  new ArrayList<>();
		try {
			ss =  new ServerSocket(6001);
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				recibirClientes();
				sleep(100);			
			} catch (IOException e) {				
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
		}
	}

	private void recibirClientes() throws IOException {
		Socket s = ss.accept();		
		ControlCliente nuevo = new ControlCliente(s);
		Thread controlCliente =  new Thread(nuevo);
		controlCliente.start();
		clientes.add(nuevo);
	}

	@Override
	public void update(Observable arg0, Object arg1) {		

	}

}
