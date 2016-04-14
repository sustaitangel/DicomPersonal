package Licencias;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLayeredPane;
import javax.swing.border.TitledBorder;
import javax.swing.JTabbedPane;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import Imagenes.Img;

import com.toedter.calendar.JDateChooser;

import javax.swing.JTextPane;
import javax.swing.JButton;

public class Licencias extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApaterno;
	private JTextField txtAmaterno;
	private JTextField txtEquipoQueOpera;
	private JTextField txtAñosExperiencia;
	private JTextField txtTipoLicencia;
	private JTextField txtNoLicencia;
	private JTextField txtObservaciones;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Licencias frame = new Licencias();
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
	public Licencias() {
		setTitle("---DICOM---Licencias de Conducir");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 626, 394);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(220, 220, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Relacion de Licencias de Conducir", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 0, 0)));
		layeredPane.setBounds(10, 11, 578, 333);
		contentPane.add(layeredPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(255, 255, 255));
		tabbedPane.setForeground(new Color(255, 69, 0));
		tabbedPane.setFont(new Font("Tahoma", Font.BOLD, 11));
		tabbedPane.setBounds(10, 21, 558, 301);
		layeredPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Licencias", null, panel, null);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Alta de Licencias", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre :");
		lblNombre.setForeground(new Color(255, 69, 0));
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNombre.setBounds(125, 10, 58, 20);
		panel_1.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(189, 11, 126, 20);
		panel_1.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblApellidoPaterno = new JLabel("Apellido Paterno :");
		lblApellidoPaterno.setForeground(new Color(255, 69, 0));
		lblApellidoPaterno.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblApellidoPaterno.setBounds(66, 41, 117, 20);
		panel_1.add(lblApellidoPaterno);
		
		txtApaterno = new JTextField();
		txtApaterno.setBounds(189, 42, 126, 20);
		panel_1.add(txtApaterno);
		txtApaterno.setColumns(10);
		
		JLabel lblApellidoMaterno = new JLabel("Apellido Materno :");
		lblApellidoMaterno.setForeground(new Color(255, 69, 0));
		lblApellidoMaterno.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblApellidoMaterno.setBounds(64, 70, 119, 20);
		panel_1.add(lblApellidoMaterno);
		
		txtAmaterno = new JTextField();
		txtAmaterno.setBounds(189, 71, 126, 20);
		panel_1.add(txtAmaterno);
		txtAmaterno.setColumns(10);
		
		JLabel lblEquipoQueOpera = new JLabel("Equipo que opera :");
		lblEquipoQueOpera.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEquipoQueOpera.setForeground(new Color(255, 69, 0));
		lblEquipoQueOpera.setBounds(63, 96, 126, 20);
		panel_1.add(lblEquipoQueOpera);
		
		txtEquipoQueOpera = new JTextField();
		txtEquipoQueOpera.setBounds(189, 97, 126, 20);
		panel_1.add(txtEquipoQueOpera);
		txtEquipoQueOpera.setColumns(10);
		
		JLabel lblAosDeExperiencia = new JLabel("A\u00F1os de experiencia :");
		lblAosDeExperiencia.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAosDeExperiencia.setForeground(new Color(255, 69, 0));
		lblAosDeExperiencia.setBounds(43, 125, 140, 20);
		panel_1.add(lblAosDeExperiencia);
		
		txtAñosExperiencia = new JTextField();
		txtAñosExperiencia.setBounds(189, 126, 126, 20);
		panel_1.add(txtAñosExperiencia);
		txtAñosExperiencia.setColumns(10);
		
		JLabel lblTipoDeLicencia = new JLabel("Tipo de licencia :");
		lblTipoDeLicencia.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTipoDeLicencia.setForeground(new Color(255, 69, 0));
		lblTipoDeLicencia.setBounds(77, 156, 106, 20);
		panel_1.add(lblTipoDeLicencia);
		
		txtTipoLicencia = new JTextField();
		txtTipoLicencia.setBounds(189, 157, 126, 20);
		panel_1.add(txtTipoLicencia);
		txtTipoLicencia.setColumns(10);
		
		JLabel lblNoLicencia = new JLabel("No. Licencia :");
		lblNoLicencia.setForeground(new Color(255, 69, 0));
		lblNoLicencia.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNoLicencia.setBounds(97, 186, 86, 14);
		panel_1.add(lblNoLicencia);
		
		txtNoLicencia = new JTextField();
		txtNoLicencia.setBounds(189, 184, 126, 20);
		panel_1.add(txtNoLicencia);
		txtNoLicencia.setColumns(10);
		
		JLabel lblFechaDeExpedicion = new JLabel("Fecha de expedicion :");
		lblFechaDeExpedicion.setForeground(new Color(255, 69, 0));
		lblFechaDeExpedicion.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFechaDeExpedicion.setBounds(43, 211, 140, 20);
		panel_1.add(lblFechaDeExpedicion);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(189, 211, 126, 20);
		panel_1.add(dateChooser);
		
		JLabel lblFechaDeVigencia = new JLabel("Fecha de vigencia :");
		lblFechaDeVigencia.setForeground(new Color(255, 69, 0));
		lblFechaDeVigencia.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFechaDeVigencia.setBounds(57, 242, 126, 20);
		panel_1.add(lblFechaDeVigencia);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(189, 242, 126, 20);
		panel_1.add(dateChooser_1);
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBorder(new TitledBorder(null, "Observaciones", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 69, 0)));
		layeredPane_1.setBounds(325, 41, 218, 104);
		panel_1.add(layeredPane_1);
		
		txtObservaciones = new JTextField();
		txtObservaciones.setBounds(10, 21, 198, 73);
		layeredPane_1.add(txtObservaciones);
		txtObservaciones.setColumns(10);
		
	    Img ob35 = new Img ();
		JButton btnCancelar = new JButton("",ob35.btnCancelar());
		btnCancelar.setBounds(334, 183, 92, 45);
		panel_1.add(btnCancelar);
		
		Img ob36 = new Img ();
		JButton btnGuardar = new JButton("",ob36.btnGuardar());
		btnGuardar.setBounds(436, 183, 92, 45);
		panel_1.add(btnGuardar);
		
		JButton btnVerEmpleados = new JButton("Ver Empleados");
		btnVerEmpleados.setForeground(new Color(255, 69, 0));
		btnVerEmpleados.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnVerEmpleados.setBounds(337, 10, 117, 23);
		panel_1.add(btnVerEmpleados);
	}
}
