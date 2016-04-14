package Empleados;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLayeredPane;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import Imagenes.Img;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class ModificarEmpleados extends JFrame {

	private JPanel contentPane;
	public static JTextField txtNumEmpleado;
	public static JTextField txtClaveMinera;
	public static JTextField txtNombre;
	public static JTextField txtApaterno;
	public static JTextField txtAmaterno;
	public static JTextField txtPuesto;
	public static JTextField txtTelefono;
	public static JTextField txtEdad;
	public static JTextField txtEscolaridad;
	public static JTextField txtNoimss;
	public static JTextField txtRfc;
	public static JTextField txtCurp;
	public static JTextField txtCalle;
	public static JTextField txtColonia;
	public static JTextField txtCiudad;
	public static JTextField txtEstado;
	public static JTextField txtEstadoCivil;
	public static JTextField txtDeconomicos;
	public static JTextField txtNombreEmergencia;
	public static JTextField txtTelefonoEmergencia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JOptionPane.showMessageDialog(null, AltaEmpleados.NumEmpleado+" aqui abro");
					ModificarEmpleados frame = new ModificarEmpleados();
					frame.setVisible(true);
                     llenarCampos(AltaEmpleados.NumEmpleado,null ,null,null,null,null,null,null,null,null,null,null,null,null, null, null, null, null, null, null);
					
					JOptionPane.showMessageDialog(null, AltaEmpleados.NumEmpleado+" aqui abro");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	 static void llenarCampos(String NumEmpleado,String ClaveMinera,
				String Nombre,String Apaterno,String Amaterno,String Puesto,String Telefono,String Edad,
				String Escolaridad, String Noimss, String Rfc, String Curp, String Calle, String Colonia,
				String Ciudad, String Estado, String EstadoCivil, String DependientesEconomicos, String NombreEmergencia, String TelefonoEmergencia)
	 {
			JOptionPane.showMessageDialog(null, AltaEmpleados.NumEmpleado+" codigo de modificasr");
			txtNumEmpleado.setText(AltaEmpleados.NumEmpleado);
			txtNombre.setText(Nombre);
			txtApaterno.setText(Apaterno);
			txtAmaterno.setText(Amaterno);
			txtPuesto.setText(Puesto);
			txtTelefono.setText(Telefono);
			txtEdad.setText(Edad);
			txtEscolaridad.setText(Escolaridad);
			txtNoimss.setText(Noimss);
			txtRfc.setText(Rfc);
			txtCurp.setText(Curp);
			txtCalle.setText(Calle);
			txtColonia.setText(Colonia);
			txtCiudad.setText(Ciudad);
			txtEstado.setText(Estado);
			txtEstadoCivil.setText(EstadoCivil);
			txtDeconomicos.setText(DependientesEconomicos);
			txtNombreEmergencia.setText(NombreEmergencia);
			txtTelefonoEmergencia.setText(TelefonoEmergencia);
			
		}
		
	public ModificarEmpleados() {
		setTitle("--Dicom--ModificarProductos----");
		setBackground(new Color(220, 220, 220));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 675);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(220, 220, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBorder(new TitledBorder(null, "ModificarProductos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 69, 0)));
		layeredPane.setBounds(10, 11, 414, 614);
		contentPane.add(layeredPane);
		
		JLabel lblNumEmpleado = new JLabel("Numero de Empleado :");
		lblNumEmpleado.setForeground(new Color(255, 69, 0));
		lblNumEmpleado.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNumEmpleado.setBounds(48, 24, 143, 14);
		layeredPane.add(lblNumEmpleado);
		
		txtNumEmpleado = new JTextField();
		txtNumEmpleado.setColumns(10);
		txtNumEmpleado.setBounds(192, 22, 143, 20);
		layeredPane.add(txtNumEmpleado);
		
		JLabel lblClaveMinera = new JLabel("Ficha Minera :");
		lblClaveMinera.setForeground(new Color(255, 69, 0));
		lblClaveMinera.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblClaveMinera.setBounds(99, 50, 92, 16);
		layeredPane.add(lblClaveMinera);
		
		txtClaveMinera = new JTextField();
		txtClaveMinera.setColumns(10);
		txtClaveMinera.setBounds(192, 49, 143, 20);
		layeredPane.add(txtClaveMinera);
		
		JLabel lblNombreEmpleado = new JLabel("Nombre del empleado :");
		lblNombreEmpleado.setForeground(new Color(255, 69, 0));
		lblNombreEmpleado.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNombreEmpleado.setBounds(44, 77, 147, 16);
		layeredPane.add(lblNombreEmpleado);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(192, 77, 143, 20);
		layeredPane.add(txtNombre);
		
		JLabel lblApaterno = new JLabel("Apellido Paterno :");
		lblApaterno.setForeground(new Color(255, 69, 0));
		lblApaterno.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblApaterno.setBounds(75, 104, 116, 16);
		layeredPane.add(lblApaterno);
		
		txtApaterno = new JTextField();
		txtApaterno.setColumns(10);
		txtApaterno.setBounds(192, 103, 143, 20);
		layeredPane.add(txtApaterno);
		
		JLabel lblApellidoMaterno = new JLabel("Apellido Materno :");
		lblApellidoMaterno.setForeground(new Color(255, 69, 0));
		lblApellidoMaterno.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblApellidoMaterno.setBounds(72, 131, 119, 16);
		layeredPane.add(lblApellidoMaterno);
		
		txtAmaterno = new JTextField();
		txtAmaterno.setColumns(10);
		txtAmaterno.setBounds(192, 130, 143, 20);
		layeredPane.add(txtAmaterno);
		
		JLabel lbl = new JLabel("Puesto :");
		lbl.setForeground(new Color(255, 69, 0));
		lbl.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbl.setBounds(137, 159, 54, 16);
		layeredPane.add(lbl);
		
		txtPuesto = new JTextField();
		txtPuesto.setColumns(10);
		txtPuesto.setBounds(192, 158, 143, 20);
		layeredPane.add(txtPuesto);
		
		JLabel lblTelefono = new JLabel("Telefono :");
		lblTelefono.setForeground(new Color(255, 69, 0));
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTelefono.setBounds(127, 186, 64, 16);
		layeredPane.add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(192, 185, 143, 20);
		layeredPane.add(txtTelefono);
		
		JLabel lblEdad = new JLabel("Edad :");
		lblEdad.setForeground(new Color(255, 69, 0));
		lblEdad.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEdad.setBounds(150, 214, 41, 16);
		layeredPane.add(lblEdad);
		
		txtEdad = new JTextField();
		txtEdad.setColumns(10);
		txtEdad.setBounds(192, 213, 143, 20);
		layeredPane.add(txtEdad);
		
		JLabel lblEscolaridad = new JLabel("Escolaridad :");
		lblEscolaridad.setForeground(new Color(255, 69, 0));
		lblEscolaridad.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEscolaridad.setBounds(109, 241, 82, 14);
		layeredPane.add(lblEscolaridad);
		
		txtEscolaridad = new JTextField();
		txtEscolaridad.setColumns(10);
		txtEscolaridad.setBounds(193, 239, 142, 20);
		layeredPane.add(txtEscolaridad);
		
		JLabel lblNoimss = new JLabel("No. Imss :");
		lblNoimss.setForeground(new Color(255, 69, 0));
		lblNoimss.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNoimss.setBounds(126, 267, 64, 16);
		layeredPane.add(lblNoimss);
		
		txtNoimss = new JTextField();
		txtNoimss.setColumns(10);
		txtNoimss.setBounds(192, 266, 143, 20);
		layeredPane.add(txtNoimss);
		
		JLabel lblRfc = new JLabel("R.F.C :");
		lblRfc.setForeground(new Color(255, 69, 0));
		lblRfc.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRfc.setBounds(149, 294, 41, 16);
		layeredPane.add(lblRfc);
		
		txtRfc = new JTextField();
		txtRfc.setColumns(10);
		txtRfc.setBounds(192, 293, 143, 20);
		layeredPane.add(txtRfc);
		
		JLabel lblCurp = new JLabel("Curp :");
		lblCurp.setForeground(new Color(255, 69, 0));
		lblCurp.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCurp.setBounds(151, 318, 39, 16);
		layeredPane.add(lblCurp);
		
		txtCurp = new JTextField();
		txtCurp.setColumns(10);
		txtCurp.setBounds(192, 317, 143, 20);
		layeredPane.add(txtCurp);
		
		JLabel lblCalle = new JLabel("Calle :");
		lblCalle.setForeground(new Color(255, 69, 0));
		lblCalle.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCalle.setBounds(150, 346, 41, 16);
		layeredPane.add(lblCalle);
		
		txtCalle = new JTextField();
		txtCalle.setColumns(10);
		txtCalle.setBounds(192, 345, 143, 20);
		layeredPane.add(txtCalle);
		
		JLabel lblColonia = new JLabel("Colonia :");
		lblColonia.setForeground(new Color(255, 69, 0));
		lblColonia.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblColonia.setBounds(136, 373, 55, 16);
		layeredPane.add(lblColonia);
		
		txtColonia = new JTextField();
		txtColonia.setColumns(10);
		txtColonia.setBounds(192, 372, 143, 20);
		layeredPane.add(txtColonia);
		
		JLabel lblCiudad = new JLabel("Ciudad :");
		lblCiudad.setForeground(new Color(255, 69, 0));
		lblCiudad.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCiudad.setBounds(137, 401, 54, 14);
		layeredPane.add(lblCiudad);
		
		txtCiudad = new JTextField();
		txtCiudad.setColumns(10);
		txtCiudad.setBounds(192, 399, 143, 20);
		layeredPane.add(txtCiudad);
		
		JLabel lblEstado = new JLabel("Estado :");
		lblEstado.setForeground(new Color(255, 69, 0));
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEstado.setBounds(137, 427, 54, 14);
		layeredPane.add(lblEstado);
		
		txtEstado = new JTextField();
		txtEstado.setColumns(10);
		txtEstado.setBounds(192, 425, 143, 20);
		layeredPane.add(txtEstado);
		
		JLabel lblEstadoCivil = new JLabel("Estado Civil :");
		lblEstadoCivil.setForeground(new Color(255, 69, 0));
		lblEstadoCivil.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEstadoCivil.setBounds(109, 451, 82, 14);
		layeredPane.add(lblEstadoCivil);
		
		txtEstadoCivil = new JTextField();
		txtEstadoCivil.setColumns(10);
		txtEstadoCivil.setBounds(192, 449, 143, 20);
		layeredPane.add(txtEstadoCivil);
		
		JLabel lblDeconomicos = new JLabel("Dependientes Economicos :");
		lblDeconomicos.setForeground(new Color(255, 69, 0));
		lblDeconomicos.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDeconomicos.setBounds(81, 478, 176, 14);
		layeredPane.add(lblDeconomicos);
		
		txtDeconomicos = new JTextField();
		txtDeconomicos.setColumns(10);
		txtDeconomicos.setBounds(260, 476, 75, 20);
		layeredPane.add(txtDeconomicos);
		
		JLabel lblNombre = new JLabel("Nombre :");
		lblNombre.setForeground(new Color(255, 69, 0));
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNombre.setBounds(136, 505, 58, 14);
		layeredPane.add(lblNombre);
		
		txtNombreEmergencia = new JTextField();
		txtNombreEmergencia.setColumns(10);
		txtNombreEmergencia.setBounds(196, 503, 139, 20);
		layeredPane.add(txtNombreEmergencia);
		
		JLabel lblTelefonoEmergencia = new JLabel("Telefono :");
		lblTelefonoEmergencia.setForeground(new Color(255, 69, 0));
		lblTelefonoEmergencia.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTelefonoEmergencia.setBounds(130, 532, 64, 14);
		layeredPane.add(lblTelefonoEmergencia);
		
		txtTelefonoEmergencia = new JTextField();
		txtTelefonoEmergencia.setColumns(10);
		txtTelefonoEmergencia.setBounds(196, 530, 139, 20);
		layeredPane.add(txtTelefonoEmergencia);
		
		Img mo01 = new Img();
		JButton btnCancelar = new JButton("",mo01.btnCancelar());
		btnCancelar.setBounds(137, 557, 92, 45);
		layeredPane.add(btnCancelar);
		
		Img mo02 = new Img ();
		JButton btnGuardar = new JButton("",mo02.btnGuardar());
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int replay = JOptionPane.showConfirmDialog(null,"El registro será modificado. ¿Desea continuar?",
						"Confirmar",JOptionPane.YES_NO_OPTION);
				if (replay == JOptionPane.YES_OPTION) {
					
							Componentes on=new Componentes();
							on.actualizarProductos(txtNumEmpleado, txtClaveMinera, txtNombre, txtApaterno, txtAmaterno, txtPuesto, txtTelefono,
									txtEdad,txtEscolaridad, txtNoimss, txtRfc, txtCurp, txtCalle, txtColonia, txtCiudad, txtEstado, txtEstadoCivil, txtDeconomicos,
									txtNombreEmergencia, txtTelefonoEmergencia);
							ModificarEmpleados.this.dispose();
							
					
				} else {}
			}
		});
		btnGuardar.setBounds(243, 557, 92, 45);
		layeredPane.add(btnGuardar);
	}
}
