package Vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import Logica.Hotel;
import Logica.Reserva;

import javax.swing.JButton;
import java.awt.Cursor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReservaPorHabitacion extends JPanel {
	private JTextField txtCodigo;
	private JTable tablaReservas;
	private DefaultTableModel model;
	private TableRowSorter sorter;

	
	public ReservaPorHabitacion() throws IOException, ParseException {
		setLayout(null);
		
		JLabel lblReservaPorHabitacion = new JLabel("Reserva Por habitacion:");
		lblReservaPorHabitacion.setBounds(31, 138, 230, 22);
		lblReservaPorHabitacion.setFont(new Font("Tahoma", Font.BOLD, 18));
		add(lblReservaPorHabitacion);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(132, 53, 139, 33);
		add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Código Habitación:");
		lblNewLabel.setBounds(31, 62, 90, 14);
		add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sorter.setRowFilter(RowFilter.regexFilter(txtCodigo.getText()));
			}
		});
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(317, 57, 89, 23);
		add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 194, 426, 310);
		add(scrollPane);
		
		tablaReservas = new JTable();
		scrollPane.setViewportView(tablaReservas);
		
		model = new DefaultTableModel();
		String[] columnas = {"Código","Nombre","Cod_Habitacion","FechaInicial","FechaFinal"};
		model.setColumnIdentifiers(columnas);
		this.llenarTabla();
		tablaReservas.setModel(model);
		
		sorter = new TableRowSorter<>(model);
		tablaReservas.setRowSorter(sorter);;
		
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
