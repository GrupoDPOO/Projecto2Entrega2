package Vista;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class menuAdministrador extends JPanel {

	/**
	 * Create the panel.
	 */
	public menuAdministrador(VentanaPrincipal ventana) {
		setBackground(Color.CYAN);
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("ADMINISTRADOR");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Crear Nueva Habitación");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					ventana.nuevoPanel("crearHabitacion");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBackground(new Color(75, 0, 130));
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(btnNewButton);
		
		JButton btnNivelDeOcupacin = new JButton("Nivel de ocupación del hotel");
		btnNivelDeOcupacin.setBackground(new Color(75, 0, 130));
		btnNivelDeOcupacin.setForeground(Color.WHITE);
		btnNivelDeOcupacin.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNivelDeOcupacin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(btnNivelDeOcupacin);
		
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
		btnCerrarSesin.setBackground(new Color(75, 0, 130));
		btnCerrarSesin.setForeground(Color.WHITE);
		btnCerrarSesin.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCerrarSesin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(btnCerrarSesin);

	}

}
