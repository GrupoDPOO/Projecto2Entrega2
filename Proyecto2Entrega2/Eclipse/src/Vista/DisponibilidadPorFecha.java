package Vista;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Logica.Habitacion;
import Logica.Hotel;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class DisponibilidadPorFecha extends JPanel {
	private JTextField txtInicio;
	private JTextField txtFinal;
	private JTable tablaReservas;
	private DefaultTableModel model;
	private ArrayList<Habitacion> habitaciones;

	public DisponibilidadPorFecha() {
		setLayout(null);
		
		txtInicio = new JTextField();
		txtInicio.setBounds(175, 43, 114, 20);
		txtInicio.setColumns(10);
		add(txtInicio);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Hotel hotel = new Hotel();
				try {
					 habitaciones = hotel.habitacionesPorFecha(txtInicio.getText(), txtFinal.getText());
					 llenarTabla();
					
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(329, 60, 90, 25);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(btnNewButton);
		
		JLabel lblFechaInicial = new JLabel("Fecha Inicial (dd/mm/yyyy):");
		lblFechaInicial.setBounds(27, 46, 138, 14);
		add(lblFechaInicial);
		
		JLabel lblFechaFinalddmmyyyy = new JLabel("Fecha Final (dd/mm/yyyy):");
		lblFechaFinalddmmyyyy.setBounds(27, 85, 138, 14);
		add(lblFechaFinalddmmyyyy);
		
		txtFinal = new JTextField();
		txtFinal.setColumns(10);
		txtFinal.setBounds(175, 82, 114, 20);
		add(txtFinal);
		
		JLabel lblHabitacionesDisponiblesPor = new JLabel("Habitaciones disponibles por fecha:");
		lblHabitacionesDisponiblesPor.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblHabitacionesDisponiblesPor.setBounds(38, 157, 330, 22);
		add(lblHabitacionesDisponiblesPor);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 214, 447, 341);
		add(scrollPane);
		
		tablaReservas = new JTable();
		scrollPane.setViewportView(tablaReservas);
		
		model = new DefaultTableModel();
		String[] columnas = {"Código","Ubicación","Balcon","Vista","Cocina","C_Niños","C_Adultos","Tipo"};
		model.setColumnIdentifiers(columnas);


	}
	
	private void llenarTabla() {
		for(int i=0;i<habitaciones.size();i++) {
			System.out.println(habitaciones.get(i).toString());
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
			tablaReservas.repaint();
		}
		tablaReservas.setModel(model);
	}

}
