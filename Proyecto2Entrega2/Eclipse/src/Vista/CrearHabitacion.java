package Vista;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import Logica.Hotel;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class CrearHabitacion extends JPanel {
	private JTextField txtID;
	private JTextField txtUbicacion;
	private JComboBox comboBalcon;
	private JComboBox comboVista;
	private JComboBox comboCama;
	private JComboBox comboCocina;
	private JComboBox comboTipo;
	
	
	public CrearHabitacion() {
		setBackground(Color.WHITE);
		
		JLabel Id = new JLabel("Id:");
		Id.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtID = new JTextField();
		txtID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtID.setColumns(10);
		
		JLabel lblBalcn = new JLabel("Balcón:");
		lblBalcn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblVista = new JLabel("Vista:");
		lblVista.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblTipoCama = new JLabel("Cama:");
		lblTipoCama.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblUbicacin = new JLabel("Ubicación:");
		lblUbicacin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtUbicacion = new JTextField();
		txtUbicacion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtUbicacion.setColumns(10);
		
		JLabel lblCocina = new JLabel("Cocina:");
		lblCocina.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblCantidad = new JLabel("Tipo:");
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		 comboBalcon = new JComboBox();
		comboBalcon.setModel(new DefaultComboBoxModel(new String[] {"", "SI", "NO"}));
		
		comboVista = new JComboBox();
		comboVista.setModel(new DefaultComboBoxModel(new String[] {"", "SI", "NO"}));
		
		comboCocina = new JComboBox();
		comboCocina.setModel(new DefaultComboBoxModel(new String[] {"", "SI", "NO"}));
		
		comboCama = new JComboBox();
		comboCama.setModel(new DefaultComboBoxModel(new String[] {"", "pequeña", "media", "grande", "queen", "king"}));
		
		JButton btnNewButton = new JButton("Guardar Habitación");
		comboTipo = new JComboBox();
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtUbicacion.getText().isEmpty()||txtID.getText().isEmpty() || comboTipo.getSelectedIndex()==0
						|| comboBalcon.getSelectedIndex()==0 || comboVista.getSelectedIndex()==0 || comboCocina.getSelectedIndex()==0
						|| comboCama.getSelectedIndex()==0) {
					JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos");
					
				}else {
					boolean balcon = false;
					boolean vista=false;
					boolean cocina=false;
					
					
					if(comboBalcon.getSelectedItem().toString().equals("SI")) {
						balcon=true;
					}
					if(comboVista.getSelectedItem().toString().equals("SI")) {
						vista=true;
					}
					if(comboCocina.getSelectedItem().toString().equals("SI")) {
						cocina=true;
					}

					
					Hotel hotel = new Hotel();
					try {
						hotel.guardarHabitacion(Integer.valueOf(txtID.getText()), txtUbicacion.getText(), balcon, vista, cocina, comboCama.getSelectedItem().toString(),comboTipo.getSelectedItem().toString());
						JOptionPane.showMessageDialog(null, "Habitación guardada");
						limpiar();
					} catch (NumberFormatException | IOException e1) {
						
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Ocurrio un error al guardar la habitacion revisa que los datos esten bien");
					}
					
				}
			}
		});
		
		
		comboTipo.setModel(new DefaultComboBoxModel(new String[] {"", "estandar", "suite", "suite doble"}));
		
		JButton btnLimpiarCampos = new JButton("Limpiar Campos");
		btnLimpiarCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
		});
		btnLimpiarCampos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimpiarCampos.setForeground(Color.WHITE);
		btnLimpiarCampos.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLimpiarCampos.setBackground(Color.BLUE);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(55)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(28)
									.addComponent(txtID, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
								.addComponent(Id, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
							.addGap(31)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblUbicacin, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(85)
									.addComponent(txtUbicacion, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(24)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(59)
									.addComponent(comboBalcon, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblBalcn, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
							.addGap(59)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCocina, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(57)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(comboTipo, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
										.addComponent(comboCocina, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(24)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblVista, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(59)
									.addComponent(comboVista, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(24)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(59)
									.addComponent(comboCama, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblTipoCama, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
							.addGap(59)
							.addComponent(lblCantidad, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(181)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnLimpiarCampos, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(12, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(52)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(txtID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(Id, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(5)
							.addComponent(lblUbicacin, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtUbicacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBalcon, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblBalcn, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)))
						.addComponent(comboCocina, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(lblCocina, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)))
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(lblVista, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addComponent(comboVista, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(39)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(comboCama, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(2)
									.addComponent(lblTipoCama, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(5)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCantidad, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboTipo, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))))
					.addGap(82)
					.addComponent(btnNewButton)
					.addGap(18)
					.addComponent(btnLimpiarCampos)
					.addGap(199))
		);
		setLayout(groupLayout);

	}
	
	private void limpiar() {
		txtID.setText("");
		txtUbicacion.setText("");
		comboBalcon.setSelectedIndex(0);
		comboVista.setSelectedIndex(0);
		comboCocina.setSelectedIndex(0);
		comboCama.setSelectedIndex(0);
		comboTipo.setSelectedIndex(0);
		
	}
}
