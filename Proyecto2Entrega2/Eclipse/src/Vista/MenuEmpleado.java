package Vista;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class MenuEmpleado extends JPanel {

	/**
	 * Create the panel.
	 */
	public MenuEmpleado(VentanaPrincipal ventana) {
		setBackground(new Color(135, 206, 235));
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblEmpleado = new JLabel("EMPLEADO");
		lblEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmpleado.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(lblEmpleado);
		
		JButton btnConsultarMenuY = new JButton("Consultar menu y servicios");
		btnConsultarMenuY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ventana.nuevoPanel("consultarServicios");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnConsultarMenuY.setForeground(Color.WHITE);
		btnConsultarMenuY.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnConsultarMenuY.setBackground(new Color(75, 0, 130));
		add(btnConsultarMenuY);
		
		JButton btnRegistrarServicio = new JButton("Registrar Servicio");
		btnRegistrarServicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ventana.nuevoPanel("registrarServicio");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnRegistrarServicio.setForeground(Color.WHITE);
		btnRegistrarServicio.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRegistrarServicio.setBackground(new Color(75, 0, 130));
		add(btnRegistrarServicio);
		
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
