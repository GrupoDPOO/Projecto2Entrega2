package Vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Logica.Habitacion;
import Logica.Hotel;
import Logica.Reserva;

public class ConsultarReservas extends JPanel {
	private JTable tablaReservas;
	private DefaultTableModel model;

	
	public ConsultarReservas() throws IOException, ParseException {
		setLayout(null);
		
		JLabel lblListaDeReservas = new JLabel("Lista de Reservas:");
		lblListaDeReservas.setBounds(51, 43, 198, 22);
		lblListaDeReservas.setFont(new Font("Tahoma", Font.BOLD, 18));
		add(lblListaDeReservas);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 118, 462, 363);
		add(scrollPane);
		
		tablaReservas = new JTable();
		scrollPane.setViewportView(tablaReservas);

		model = new DefaultTableModel();
		String[] columnas = {"Código","Nombre","Cod_Habitacion","FechaInicial","FechaFinal"};
		model.setColumnIdentifiers(columnas);
		this.llenarTabla();
		tablaReservas.setModel(model);
	}
	
	private void llenarTabla() throws IOException, ParseException {
		Hotel hotel = new Hotel();
		ArrayList<Reserva> reservas = hotel.getReservas();
		
		for(int i=0;i<reservas.size();i++) {
			
			Object[] fila = new Object[5];
			fila[0] =reservas.get(i).getIdReserva();
			fila[1] = reservas.get(i).getNombreCliente();
			fila[2] =reservas.get(i).getIdHabitacion();
			fila[3] = reservas.get(i).getFechaInicioString();
			fila[4] = reservas.get(i).getFechaFinString();
			model.addRow(fila);
		}
	}

}
