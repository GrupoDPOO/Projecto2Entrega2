package Vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Logica.Hotel;
import Logica.Servicio;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegistrarServicio extends JPanel {
	
	private JTable tablaProductos;
	private DefaultTableModel model;
	private JTextField txtCodigo;
	private JTextField txtDocumento;

	
	public RegistrarServicio() throws IOException {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Lista de Productos:");
		lblNewLabel.setBounds(45, 38, 172, 22);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 71, 436, 219);
		add(scrollPane);
		
		tablaProductos = new JTable();
		tablaProductos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				int seleccion = tablaProductos.rowAtPoint(e.getPoint());
				txtCodigo.setText(String.valueOf(tablaProductos.getValueAt(seleccion, 0)));
			}
		});
		scrollPane.setViewportView(tablaProductos);
		
		model = new DefaultTableModel();
		String[] columnas = {"Codigo","Pruducto/Servicio","Hora Inicial","Hora Final","Precio"};
		model.setColumnIdentifiers(columnas);
		this.llenarTabla();
		tablaProductos.setModel(model);
		
		JLabel lblNewLabel_1 = new JLabel("Codigo Producto/Servicio: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(45, 353, 159, 22);
		add(lblNewLabel_1);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(210, 355, 129, 21);
		add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Documento de la persona:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(45, 399, 159, 22);
		add(lblNewLabel_1_1);
		
		txtDocumento = new JTextField();
		txtDocumento.setColumns(10);
		txtDocumento.setBounds(210, 401, 129, 21);
		add(txtDocumento);
		
		JButton btnNewButton = new JButton("REGISTRAR SERVICIO");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Hotel hotel = new Hotel();
				try {
					hotel.registrarServicio(txtCodigo.getText(), txtDocumento.getText());
					JOptionPane.showMessageDialog(null, "Servicio Registrado");
					txtCodigo.setText("");
					txtDocumento.setText("");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Documento no encontrado en la base de datos intente de nuevo");
				}
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(151, 466, 210, 38);
		add(btnNewButton);
		

	}
	
	private void llenarTabla() throws IOException {
		Hotel hotel = new Hotel();
		ArrayList<Servicio> servicios = hotel.getServicios();
		System.out.println(servicios.size());
		for(int i=0;i<servicios.size();i++) {
			System.out.println("Hiooa");
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
