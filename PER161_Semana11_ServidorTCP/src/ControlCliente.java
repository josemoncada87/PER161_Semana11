import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Observable;


public class ControlCliente extends Observable implements Runnable {
	
	private Socket s;

	public ControlCliente(Socket s) {
		this.s = s ;		
		
		OutputStream salida;
		try {
			
			salida = s.getOutputStream();
			ObjectOutputStream salidaObjetos =  new ObjectOutputStream(salida);			
			salidaObjetos.writeObject(new String("hola amiwito"));
			salidaObjetos.flush();
			//salida.write("buenos dias".getBytes());
			//salida.flush();
		} catch (IOException e) {			
			e.printStackTrace();
		}		
		
	}

	@Override
	public void run() {
		while (true) {			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
		}
	}
}
