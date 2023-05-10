package Vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Logica.Habitacion;
import Logica.Hotel;
import Logica.Servicio;

public class ConsultarHabitaciones extends JPanel {
	private JTable tablaHabitaciones;
	private DefaultTableModel model;


	public ConsultarHabitaciones() throws IOException {
		setLayout(null);
		
		JLabel lblListaDeHabitaciones = new JLabel("Lista de Habitaciones:");
		lblListaDeHabitaciones.setBounds(46, 30, 216, 22);
		lblListaDeHabitaciones.setFont(new Font("Tahoma", Font.BOLD, 18));
		add(lblListaDeHabitaciones);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(46, 112, 391, 385);
		add(scrollPane);
		
		tablaHabitaciones = new JTable();
		scrollPane.setViewportView(tablaHabitaciones);
		
		model = new DefaultTableModel();
		String[] columnas = {"Código","Ubicación","Balcon","Vista","Cocina","C_Niños","C_Adultos","Tipo"};
		model.setColumnIdentifiers(columnas);
		this.llenarTabla();
		tablaHabitaciones.setModel(model);
		

	}
	
	private void llenarTabla() throws IOException {
		Hotel hotel = new Hotel();
		ArrayList<Habitacion> habitaciones = hotel.getInventario();
		
		for(int i=0;i<habitaciones.size();i++) {
			
			Object[] fila = new Object[8];
			fila[0] =habitaciones.get(i).getIdentificador();
			fila[1] = habitaciones.get(i).getUbicacion();
			fila[2] =habitaciones.get(i).isBalcon();
			fila[3] = habitaciones.get(i).isCocina();
			fila[4] = habitaciones.get(i).isVista();
			fila[5]= habitaciones.get(i).capacidadNinos();
			fila[6]=habitaciones.get(i).capacidadAdultos();
			fila[7]=habitaciones.get(i).getTipo();
			model.addRow(fila);
		}
	}

}
