package Vista;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class MenuRecepcionista extends JPanel {

	/**
	 * Create the panel.
	 */
	public MenuRecepcionista(VentanaPrincipal ventana) {
		setBackground(new Color(32, 178, 170));
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblRecepcionista = new JLabel("RECEPCIONISTA");
		lblRecepcionista.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecepcionista.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(lblRecepcionista);
		
		JButton btnConsultarInventarioHabitaciones = new JButton("Inventario habitaciones");
		btnConsultarInventarioHabitaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ventana.nuevoPanel("inventarioHabitaciones");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnConsultarInventarioHabitaciones.setForeground(Color.WHITE);
		btnConsultarInventarioHabitaciones.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnConsultarInventarioHabitaciones.setBackground(new Color(75, 0, 130));
		add(btnConsultarInventarioHabitaciones);
		
		JButton btnConsultarTodasLas = new JButton("Todas las reservas");
		btnConsultarTodasLas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ventana.nuevoPanel("consultarReservas");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnConsultarTodasLas.setForeground(Color.WHITE);
		btnConsultarTodasLas.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnConsultarTodasLas.setBackground(new Color(75, 0, 130));
		add(btnConsultarTodasLas);
		
		JButton btnConsultarLasReservas = new JButton("Reservas de una habitación");
		btnConsultarLasReservas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ventana.nuevoPanel("reservasPorHabitacion");
				} catch (IOException | ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnConsultarLasReservas.setForeground(Color.WHITE);
		btnConsultarLasReservas.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnConsultarLasReservas.setBackground(new Color(75, 0, 130));
		add(btnConsultarLasReservas);
		
		JButton btnConsultarDisponibilidadDe = new JButton("Disponibilidad de habitación por fecha");
		btnConsultarDisponibilidadDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ventana.nuevoPanel("habitacionesPorFecha");
				} catch (IOException | ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnConsultarDisponibilidadDe.setForeground(Color.WHITE);
		btnConsultarDisponibilidadDe.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnConsultarDisponibilidadDe.setBackground(new Color(75, 0, 130));
		add(btnConsultarDisponibilidadDe);
		
		JButton btnRealizarReserva = new JButton("Realizar Reserva");
		btnRealizarReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ventana.nuevoPanel("realizarReserva");
				} catch (IOException | ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnRealizarReserva.setForeground(Color.WHITE);
		btnRealizarReserva.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRealizarReserva.setBackground(new Color(75, 0, 130));
		add(btnRealizarReserva);
		
		JButton btnGenerarFactura = new JButton("Generar Factura");
		btnGenerarFactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ventana.nuevoPanel("Factura");
				} catch (IOException | ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnGenerarFactura.setForeground(Color.WHITE);
		btnGenerarFactura.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnGenerarFactura.setBackground(new Color(75, 0, 130));
		add(btnGenerarFactura);
		
		JButton btnCerrarSesin = new JButton("Cerrar Sesión");
		btnCerrarSesin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ventana.nuevoPanel("Cerrar");
				} catch (IOException | ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnCerrarSesin.setForeground(Color.WHITE);
		btnCerrarSesin.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCerrarSesin.setBackground(new Color(75, 0, 130));
		add(btnCerrarSesin);

	}

}
