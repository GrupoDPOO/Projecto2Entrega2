package Vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Logica.Hotel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class GenerarFactura extends JPanel {
	private JTextField txtDocumento;

	
	public GenerarFactura() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Documento Huesped:");
		lblNewLabel.setBounds(71, 52, 103, 31);
		add(lblNewLabel);
		
		txtDocumento = new JTextField();
		txtDocumento.setBounds(189, 57, 143, 26);
		add(txtDocumento);
		txtDocumento.setColumns(10);
		
		JButton btnNewButton = new JButton("Generar Factura");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Hotel hotel = new Hotel();
				try {
					hotel.generarFactura(txtDocumento.getText());
					JOptionPane.showMessageDialog(null, "Factura guardada en el sistema la pude encontrar en ./facturas");
				} catch (IOException | ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Error al general la factura");
				}
			}
		});
		btnNewButton.setBounds(154, 142, 134, 50);
		add(btnNewButton);

	}

}
