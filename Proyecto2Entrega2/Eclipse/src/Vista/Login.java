package Vista;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.Hotel;
import Logica.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtClave;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 681, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Login = new JLabel("Login");
		Login.setFont(new Font("Times New Roman", Font.BOLD, 18));
		Login.setBounds(289, 57, 86, 36);
		contentPane.add(Login);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(212, 125, 61, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblClave = new JLabel("Clave");
		lblClave.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblClave.setBounds(212, 196, 61, 14);
		contentPane.add(lblClave);
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(212, 150, 213, 20);
		contentPane.add(txtUsuario);
		
		JButton btnNewButton = new JButton("INGRESAR");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario = txtUsuario.getText();
				String clave = txtClave.getText();
				
				
				Hotel hotel = new Hotel();
				try {
					hotel.cargarArchivos();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				Usuario user = hotel.validarUsuario(usuario, clave);
				
				if (user==null){
					JOptionPane.showMessageDialog(null, "Usuario no encontrado");
					limpiar();
				}else {
					VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(user);
					ventanaPrincipal.setVisible(true);
					dispose();

				}
				
			}
		});
		btnNewButton.setBounds(272, 275, 114, 23);
		contentPane.add(btnNewButton);
		
		txtClave = new JPasswordField();
		txtClave.setBounds(212, 221, 213, 20);
		contentPane.add(txtClave);
	}
	
	public void limpiar() {
		txtUsuario.setText("");
		txtClave.setText("");
	}
}
