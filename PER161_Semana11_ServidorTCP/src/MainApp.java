
public class MainApp {
	
	static Comunicacion com;

	public static void main(String[] args) {
		System.out.print("INICIANDO ... ");
		com = new Comunicacion();
		com.start();
		System.out.println("ESPERANDO");
	}

}
