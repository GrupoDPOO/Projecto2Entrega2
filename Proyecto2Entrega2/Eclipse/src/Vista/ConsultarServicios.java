package Vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Logica.Hotel;
import Logica.Servicio;

public class ConsultarServicios extends JPanel {
	private JTable tablaProductos;
	private DefaultTableModel model;

	
	public ConsultarServicios() throws IOException {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Lista de Productos:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(33, 43, 201, 31);
		add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 124, 436, 374);
		add(scrollPane);
		
		tablaProductos = new JTable();
		scrollPane.setViewportView(tablaProductos);
		
		model = new DefaultTableModel();
		String[] columnas = {"Codigo","Pruducto/Servicio","Hora Inicial","Hora Final","Precio"};
		model.setColumnIdentifiers(columnas);
		this.llenarTabla();
		tablaProductos.setModel(model);
		
		

	}
	
	private void llenarTabla() throws IOException {
		Hotel hotel = new Hotel();
		ArrayList<Servicio> servicios = hotel.getServicios();
		System.out.println(servicios.size());
		for(int i=0;i<servicios.size();i++) {
			
			Object[] fila = new Object[5];
			fila[0] = servicios.get(i).getCodigo();
			fila[1] = servicios.get(i).getProducto();
			fila[2] = servicios.get(i).getHoraInicial();
			fila[3] = servicios.get(i).getHoraFinal();
			fila[4] = servicios.get(i).getPrecio();
			model.addRow(fila);
		}
	}
}
