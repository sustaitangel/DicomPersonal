package Usuarios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.border.TitledBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import Conexion.Conectar;
import Imagenes.Img;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class Usuarios extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApaterno;
	private JTextField txtAmaterno;
	private JPasswordField passwordContrasena;
	private JLabel lblRepetirContrasea;
	private JPasswordField passwordRepetirContrasena;
	private JLabel lblTipoDeUsuario;
	private JTextField txtNombreUsuario;
	int tipo;
	String tipo1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Usuarios frame = new Usuarios();
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
	public Usuarios() {
		setTitle("---Dicom-- Alta de usuarios ---");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 316);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBorder(new TitledBorder(null, "Usuarios", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 69, 0)));
		layeredPane.setBounds(10, 11, 414, 255);
		contentPane.add(layeredPane);
		
		JLabel lblNombre = new JLabel("Nombre :");
		lblNombre.setForeground(new Color(255, 69, 0));
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNombre.setBounds(88, 22, 58, 14);
		layeredPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(147, 20, 132, 20);
		layeredPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblApellidoPaterno = new JLabel("Apellido Paterno :");
		lblApellidoPaterno.setForeground(new Color(255, 69, 0));
		lblApellidoPaterno.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblApellidoPaterno.setBounds(30, 47, 116, 14);
		layeredPane.add(lblApellidoPaterno);
		
		txtApaterno = new JTextField();
		txtApaterno.setBounds(147, 46, 132, 20);
		layeredPane.add(txtApaterno);
		txtApaterno.setColumns(10);
		
		JLabel lblApellidoMaterno = new JLabel("Apellido Materno :");
		lblApellidoMaterno.setForeground(new Color(255, 69, 0));
		lblApellidoMaterno.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblApellidoMaterno.setBounds(27, 73, 119, 14);
		layeredPane.add(lblApellidoMaterno);
		
		txtAmaterno = new JTextField();
		txtAmaterno.setBounds(147, 72, 132, 20);
		layeredPane.add(txtAmaterno);
		txtAmaterno.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a :");
		lblContrasea.setForeground(new Color(255, 69, 0));
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblContrasea.setBounds(62, 98, 84, 14);
		layeredPane.add(lblContrasea);
		
		passwordContrasena = new JPasswordField();
		passwordContrasena.setBounds(147, 98, 132, 20);
		layeredPane.add(passwordContrasena);
		
		lblRepetirContrasea = new JLabel("Repetir Contrase\u00F1a :");
		lblRepetirContrasea.setForeground(new Color(255, 69, 0));
		lblRepetirContrasea.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRepetirContrasea.setBounds(10, 123, 136, 14);
		layeredPane.add(lblRepetirContrasea);
		
		passwordRepetirContrasena = new JPasswordField();
		passwordRepetirContrasena.setBounds(147, 124, 132, 20);
		layeredPane.add(passwordRepetirContrasena);
		
		lblTipoDeUsuario = new JLabel("Tipo de Usuario :");
		lblTipoDeUsuario.setForeground(new Color(255, 69, 0));
		lblTipoDeUsuario.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTipoDeUsuario.setBounds(39, 148, 107, 14);
		layeredPane.add(lblTipoDeUsuario);
		
		JComboBox comboBoxTipoUsuario = new JComboBox();
		comboBoxTipoUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tipo1=(String)comboBoxTipoUsuario.getSelectedItem();
				 if(tipo1.equals("Administrador"))
				 {
					 tipo=1;
				 }
				 if(tipo1.equals("Auxiliar"))
				 {
					 tipo=2;
				 }
			}
			
		});
		Conectar con=new Conectar();
		ArrayList<TipoUsuario>lista1= con.obtenerTipos();
		for (int i=0;i<lista1.size();i++)
		{
			TipoUsuario otipo=lista1.get(i);
			comboBoxTipoUsuario.addItem(otipo.getNombreArticulo());
		
		}
		comboBoxTipoUsuario.setBounds(147, 146, 132, 20);
		layeredPane.add(comboBoxTipoUsuario);
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre de Usuario :");
		lblNombreDeUsuario.setForeground(new Color(255, 69, 0));
		lblNombreDeUsuario.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNombreDeUsuario.setBounds(14, 173, 132, 14);
		layeredPane.add(lblNombreDeUsuario);
		
		txtNombreUsuario = new JTextField();
		txtNombreUsuario.setBounds(145, 171, 134, 20);
		layeredPane.add(txtNombreUsuario);
		txtNombreUsuario.setColumns(10);
		
		Img ob40 = new Img ();
		JButton btnCancelar = new JButton("",ob40.btnCancelar());
		btnCancelar.setBounds(115, 199, 92, 45);
		layeredPane.add(btnCancelar);
		
		Img ob41 = new Img ();
		JButton btnGuardar = new JButton("",ob41.btnGuardar());
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AltaDtb alta=new AltaDtb();
				alta.altaUsuario(txtNombre, txtApaterno, txtAmaterno, passwordContrasena, 
						passwordRepetirContrasena, txtNombreUsuario, tipo);
			}
		});
		btnGuardar.setBounds(217, 199, 92, 45);
		layeredPane.add(btnGuardar);
	}
}
