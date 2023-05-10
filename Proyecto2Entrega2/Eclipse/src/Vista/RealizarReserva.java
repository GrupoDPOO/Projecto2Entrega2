package Vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Logica.Acompañante;
import Logica.Hotel;
import Logica.Huesped;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class RealizarReserva extends JPanel {
	private JTextField txtIngreso;
	private JTextField txtSalida;
	private JTextField txtCodigo;
	private JTextField txtHuesped;
	private JTextField txtDocumento;
	private JTextField txtCorreo;
	private JTextField txtTelefono;
	private JTextField txtCantidad;

	
	public RealizarReserva() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Fecha Ingreso (dd/mm/yyyy):");
		lblNewLabel.setBounds(29, 32, 148, 24);
		add(lblNewLabel);
		
		txtIngreso = new JTextField();
		txtIngreso.setBounds(187, 32, 148, 24);
		add(txtIngreso);
		txtIngreso.setColumns(10);
		
		JLabel lblFechaSalidaddmmyyyy = new JLabel("Fecha Salida (dd/mm/yyyy):");
		lblFechaSalidaddmmyyyy.setBounds(29, 67, 148, 24);
		add(lblFechaSalidaddmmyyyy);
		
		txtSalida = new JTextField();
		txtSalida.setColumns(10);
		txtSalida.setBounds(187, 67, 148, 24);
		add(txtSalida);
		
		JLabel lblCdigo = new JLabel("Código:");
		lblCdigo.setBounds(39, 123, 66, 24);
		add(lblCdigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(91, 123, 90, 24);
		add(txtCodigo);
		
		JLabel lblNombreHuesped = new JLabel("Nombre Huesped:");
		lblNombreHuesped.setBounds(224, 123, 98, 24);
		add(lblNombreHuesped);
		
		txtHuesped = new JTextField();
		txtHuesped.setColumns(10);
		txtHuesped.setBounds(318, 123, 113, 24);
		add(txtHuesped);
		
		JLabel lblDocumento = new JLabel("Documento");
		lblDocumento.setBounds(29, 171, 66, 24);
		add(lblDocumento);
		
		txtDocumento = new JTextField();
		txtDocumento.setColumns(10);
		txtDocumento.setBounds(91, 171, 105, 24);
		add(txtDocumento);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setBounds(247, 171, 66, 24);
		add(lblCorreo);
		
		txtCorreo = new JTextField();
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(298, 173, 133, 24);
		add(txtCorreo);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(29, 224, 66, 24);
		add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(91, 224, 105, 24);
		add(txtTelefono);
		
		JButton btnRealizarReserva = new JButton("Realizar Reserva");
		btnRealizarReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Hotel hotel = new Hotel();
				int id = (int) (Math.random()*1000+1);
				int idReserva = (int) (Math.random()*1000+1);
				try {
					ArrayList<Acompañante> huespedes = new ArrayList<>();
					ArrayList<Integer> habitaciones = new ArrayList<>();
					Acompañante acompañante = new Acompañante(idReserva, id,txtHuesped.getText(),txtDocumento.getText());
					huespedes.add(acompañante);
					habitaciones.add(Integer.parseInt(txtCodigo.getText()));
					double precioReserva = hotel.tarifaPorReserva(habitaciones, txtIngreso.getText(), txtSalida.getText());
					Huesped huesped = new Huesped(idReserva,id,txtHuesped.getText(),txtDocumento.getText(),txtCorreo.getText(),txtTelefono.getText(),1);
					hotel.registrarReserva(idReserva,habitaciones, txtIngreso.getText(), txtSalida.getText(), id, huesped, huespedes,precioReserva);
					JOptionPane.showMessageDialog(null, "Reserva Realizada");
					limpiar();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnRealizarReserva.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnRealizarReserva.setBounds(171, 356, 151, 25);
		add(btnRealizarReserva);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
		});
		btnLimpiar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLimpiar.setBounds(171, 400, 151, 25);
		add(btnLimpiar);
		
		txtCantidad = new JTextField();
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(345, 226, 86, 24);
		add(txtCantidad);
		
		JLabel lblCantidadHuespedes = new JLabel("Cantidad huespedes");
		lblCantidadHuespedes.setBounds(224, 229, 111, 24);
		add(lblCantidadHuespedes);
		
		
	}
	private void limpiar() {
		txtCodigo.setText("");
		txtIngreso.setText("");
		txtSalida.setText("");
		txtHuesped.setText("");
		txtDocumento.setText("");
		txtCorreo.setText("");
		txtTelefono.setText("");
		txtCantidad.setText("");
	}
	
}
