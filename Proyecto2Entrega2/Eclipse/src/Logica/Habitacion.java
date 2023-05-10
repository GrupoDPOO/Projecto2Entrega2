package Logica;
import java.util.ArrayList;

public class Habitacion {
	
	//Atributos
	
	private int identificador;
	private String ubicacion;
	private boolean balcon;
	private boolean vista;
	private boolean cocina;
	private ArrayList<Cama> camas;
	private String tipo;
	
	
	//Constructor
	
	public Habitacion(int identificador, String ubicacion, boolean balcon,
			boolean vista, boolean cocina, ArrayList<Cama> camas, String tipo) {
		super();
		this.identificador = identificador;
		this.ubicacion = ubicacion;
		this.balcon = balcon;
		this.vista = vista;
		this.cocina = cocina;
		this.camas = camas;
		this.tipo=tipo;
		

	}

	public int getIdentificador() {
		return identificador;
	}

	

    public String getUbicacion() {
        return ubicacion;
    }

    
    public boolean isBalcon() {
        return balcon;
    }

  
    public boolean isVista() {
        return vista;
    }

   

    public boolean isCocina() {
        return cocina;
    }

  

    public ArrayList<Cama> getCamas() {
        return camas;
    }

  

    public String getTipo() {
        return tipo;
    }

    

	@Override
	public String toString() {
		
		return identificador + ";" + ubicacion + ";" + balcon
				+ ";" + vista + ";" + cocina + ";" + "mediana" + ";" + tipo;
	}
	
	public int capacidadNinos() {
		
		
		return 3;
	}
	
	public int capacidadAdultos() {
		
		
		return 2;
	}
	
	public int capacidad() {
		int total=0;
		int capN = this.capacidadNinos();
		int capA = this.capacidadAdultos();
		total= capN + capA;
		
		return total;
	}
	
	
	
	
	
	
	

}
