package Vista;

import java.awt.EventQueue;
import java.io.IOException;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.Usuario;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Color;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	public JButton crearHab;
	private Usuario user;
	JPanel panel_1;
	JPanel panel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Usuario user=null;
					VentanaPrincipal frame = new VentanaPrincipal(user);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal(Usuario user) {
		this.user=user;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 805, 599);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		if(user.getRol().equals("administrador")) {
			
			menuAdministrador _menuAdministrador = new menuAdministrador(this);
			_menuAdministrador.setSize(300,600);
			_menuAdministrador.setLocation(0,0);
			panel_1.removeAll();
			panel_1.add(_menuAdministrador, BorderLayout.WEST);
			panel_1.revalidate();
			panel_1.repaint();
			
		}else if(user.getRol().equals("recepcionista")) {
			
			MenuRecepcionista menuRecepcionista = new MenuRecepcionista(this);
			menuRecepcionista.setSize(300,600);
			panel_1.removeAll();
			panel_1.add(menuRecepcionista, BorderLayout.WEST);
			menuRecepcionista.setSize(300,600);
			menuRecepcionista.setVisible(true);
			
		}else if(user.getRol().equals("empleado")) {
			
			MenuEmpleado menuEmpleado = new MenuEmpleado(this);
			panel_1.removeAll();
			panel_1.add(menuEmpleado, BorderLayout.WEST);
			menuEmpleado.setSize(300,600);
			menuEmpleado.setVisible(true);
		}
	}
	
	public void nuevoPanel(String opt) throws IOException, ParseException {
		
		if(opt.equals("crearHabitacion")) {
			
			CrearHabitacion crearHabitacion = new CrearHabitacion();
			crearHabitacion.setSize(500,600);
			crearHabitacion.setLocation(0,0);
			panel_2.removeAll();
			panel_2.add(crearHabitacion,BorderLayout.CENTER);
			panel_2.revalidate();
			panel_2.repaint();
			
			
			
		}else if(opt.equals("consultarServicios")) {
			ConsultarServicios consultarServicios = new ConsultarServicios();
			consultarServicios.setSize(500,600);
			consultarServicios.setLocation(0,0);
			
			panel_2.removeAll();;
			
			panel_2.add(consultarServicios,BorderLayout.CENTER);
			panel_2.revalidate();
			panel_2.repaint();
			
		}else if(opt.equals("registrarServicio")) {
			RegistrarServicio registrarServicio = new RegistrarServicio();
			registrarServicio.setSize(500,600);
			registrarServicio.setLocation(0,0);
			panel_2.removeAll();;
			
			panel_2.add(registrarServicio);
			panel_2.revalidate();
			panel_2.repaint();
			
		}else if(opt.equals("inventarioHabitaciones")) {
			
			ConsultarHabitaciones habs = new ConsultarHabitaciones();
			habs.setSize(500,600);
			habs.setLocation(0,0);
			panel_2.removeAll();
			panel_2.add(habs,BorderLayout.CENTER);
			panel_2.revalidate();
			panel_2.repaint();
		}else if(opt.equals("consultarReservas")) {
			ConsultarReservas reservas = new ConsultarReservas();
			reservas.setSize(500,600);
			reservas.setLocation(0,0);
			panel_2.removeAll();;
			
			panel_2.add(reservas,BorderLayout.CENTER);
			panel_2.revalidate();
			panel_2.repaint();
		}else if(opt.equals("reservasPorHabitacion")) {
			ReservaPorHabitacion reser = new ReservaPorHabitacion();
			reser.setSize(500,600);
			reser.setLocation(0,0);
			panel_2.removeAll();;
			
			panel_2.add(reser,BorderLayout.CENTER);
			panel_2.revalidate();
			panel_2.repaint();
			
		}else if(opt.equals("habitacionesPorFecha")) {
			DisponibilidadPorFecha habsFecha = new DisponibilidadPorFecha();
			habsFecha.setSize(500,600);
			habsFecha.setLocation(0,0);
			panel_2.removeAll();;
			
			panel_2.add(habsFecha,BorderLayout.CENTER);
			panel_2.revalidate();
			panel_2.repaint();
		}else if(opt.equals("realizarReserva")) {
			RealizarReserva realizar = new RealizarReserva();
			realizar.setSize(500,600);
			realizar.setLocation(0,0);
			panel_2.removeAll();;
			
			panel_2.add(realizar,BorderLayout.CENTER);
			panel_2.revalidate();
			panel_2.repaint();
		}else if(opt.equals("Factura")) {
			GenerarFactura factura = new GenerarFactura();
			factura.setSize(500,600);
			factura.setLocation(0,0);
			panel_2.removeAll();;
			
			panel_2.add(factura,BorderLayout.CENTER);
			panel_2.revalidate();
			panel_2.repaint();
		}else if(opt.equals("Cerrar")) {
			dispose();
		}
	}

}
