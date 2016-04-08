import java.io.IOException;
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
			salida.write("buenos dias".getBytes());
			salida.flush();
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
