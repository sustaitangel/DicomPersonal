package Vacaciones;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLayeredPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;

import java.awt.Font;

import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import Imagenes.Img;

import com.toedter.calendar.JDateChooser;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AltaVacaciones extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApaterno;
	private JTextField txtAmaterno;
	private JTextField txtDias;
	private JTextField txtDiasRestantes;
	private JTextField textField_5;
	private JTable tableVerEmpleados;
	private static   String matriz[][]={};
	private static   String vector[]={"Num.Empleado", "Ficha Minera", "Nombre", "A.Paterno", "A.Materno"};
	public static   DefaultTableModel modelo2= new DefaultTableModel(matriz,vector);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaVacaciones frame = new AltaVacaciones();
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
	public AltaVacaciones() {
		setTitle("----Dicom----Vacaciones");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 676, 389);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(220, 220, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setForeground(new Color(255, 69, 0));
		layeredPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Vacaciones", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 0, 0)));
		layeredPane.setBounds(10, 11, 640, 328);
		contentPane.add(layeredPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(255, 255, 255));
		tabbedPane.setForeground(new Color(255, 69, 0));
		tabbedPane.setFont(new Font("Tahoma", Font.BOLD, 11));
		tabbedPane.setBounds(10, 21, 620, 285);
		layeredPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Vacaciones", null, panel, null);
		panel.setLayout(null);
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBorder(new TitledBorder(null, "Buscar", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 69, 0)));
		layeredPane_1.setBounds(10, 11, 595, 74);
		panel.add(layeredPane_1);
		
		textField_5 = new JTextField();
		textField_5.setBounds(26, 31, 134, 20);
		layeredPane_1.add(textField_5);
		textField_5.setColumns(10);
		
		Img ob32 = new Img ();
		JButton btnBuscar = new JButton("",ob32.btnBuscar1());
		btnBuscar.setBounds(170, 23, 48, 37);
		layeredPane_1.add(btnBuscar);
		
		Img ob33 = new Img ();
		JButton btnActualizar = new JButton("",ob33.btnActualizar1());
		btnActualizar.setBounds(286, 23, 48, 37);
		layeredPane_1.add(btnActualizar);
		
		Img ob34 = new Img();
		JButton btnEliminar = new JButton("",ob34.btnEliminar1());
		btnEliminar.setBounds(228, 23, 48, 37);
		layeredPane_1.add(btnEliminar);
		
		JLabel lblNombreONum = new JLabel("Nombre o Num. de Empleado");
		lblNombreONum.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNombreONum.setForeground(new Color(128, 0, 0));
		lblNombreONum.setBounds(15, 13, 147, 14);
		layeredPane_1.add(lblNombreONum);
		
		JLayeredPane layeredPane_2 = new JLayeredPane();
		layeredPane_2.setBorder(new TitledBorder(null, "Vacaciones", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 69, 0)));
		layeredPane_2.setBounds(10, 96, 595, 150);
		panel.add(layeredPane_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 575, 118);
		layeredPane_2.add(scrollPane);
		
		tableVerEmpleados = new JTable(){
			public boolean isCellEditable(int rowIndex, int columnIndex) { 
				if (columnIndex==5) return true; 
				if (columnIndex==3) return false;
				if (columnIndex==2) return true;
				else 
				return false; 
				} 
		};
		tableVerEmpleados.setCellSelectionEnabled(true);
		tableVerEmpleados.setFont(new Font("Tahoma", Font.PLAIN, 11));
		scrollPane.setColumnHeaderView(tableVerEmpleados);
        tableVerEmpleados.setBackground(new Color(255, 255, 255));
		
		scrollPane.setColumnHeaderView(tableVerEmpleados);
		scrollPane.setViewportView(tableVerEmpleados);
		tableVerEmpleados.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "A.Paterno", "A.Materno", "Antig\u00FCedad", "D\u00EDas", "Fecha de Inicio", "Fecha de Termino", "Restantes"
			}
		));
		tableVerEmpleados.getColumnModel().getColumn(0).setPreferredWidth(72);
		tableVerEmpleados.getColumnModel().getColumn(3).setPreferredWidth(73);
		tableVerEmpleados.getColumnModel().getColumn(4).setPreferredWidth(50);
		tableVerEmpleados.getColumnModel().getColumn(5).setPreferredWidth(84);
		tableVerEmpleados.getColumnModel().getColumn(6).setPreferredWidth(95);
		tableVerEmpleados.getColumnModel().getColumn(7).setPreferredWidth(67);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Control de Vacaciones", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre :");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNombre.setForeground(new Color(255, 69, 0));
		lblNombre.setBounds(124, 13, 58, 14);
		panel_1.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(192, 11, 124, 20);
		panel_1.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblApellidoPaterno = new JLabel("Apellido Paterno :");
		lblApellidoPaterno.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblApellidoPaterno.setForeground(new Color(255, 69, 0));
		lblApellidoPaterno.setBounds(66, 38, 116, 14);
		panel_1.add(lblApellidoPaterno);
		
		txtApaterno = new JTextField();
		txtApaterno.setBounds(192, 36, 124, 20);
		panel_1.add(txtApaterno);
		txtApaterno.setColumns(10);
		
		JLabel lblApellidoMaterno = new JLabel("Apellido Materno :");
		lblApellidoMaterno.setBackground(new Color(240, 240, 240));
		lblApellidoMaterno.setForeground(new Color(255, 69, 0));
		lblApellidoMaterno.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblApellidoMaterno.setBounds(62, 63, 120, 14);
		panel_1.add(lblApellidoMaterno);
		
		txtAmaterno = new JTextField();
		txtAmaterno.setBounds(192, 61, 124, 20);
		panel_1.add(txtAmaterno);
		txtAmaterno.setColumns(10);
		
		JLabel lblAntigedad = new JLabel("Antig\u00FCedad :");
		lblAntigedad.setForeground(new Color(255, 69, 0));
		lblAntigedad.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAntigedad.setBounds(98, 88, 84, 14);
		panel_1.add(lblAntigedad);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(192, 86, 124, 20);
		panel_1.add(comboBox);
		
		JLabel lblDias = new JLabel("D\u00EDas :");
		lblDias.setForeground(new Color(255, 69, 0));
		lblDias.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDias.setBounds(146, 113, 36, 14);
		panel_1.add(lblDias);
		
		txtDias = new JTextField();
		txtDias.setEnabled(false);
		txtDias.setEditable(false);
		txtDias.setBounds(192, 111, 124, 20);
		panel_1.add(txtDias);
		txtDias.setColumns(10);
		
		JLabel lblFechaDeInicio = new JLabel("Fecha de inicio :");
		lblFechaDeInicio.setForeground(new Color(255, 69, 0));
		lblFechaDeInicio.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFechaDeInicio.setBounds(80, 138, 102, 14);
		panel_1.add(lblFechaDeInicio);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(192, 137, 124, 20);
		panel_1.add(dateChooser);
		
		JLabel lblFechaDeTermino = new JLabel("Fecha de termino :");
		lblFechaDeTermino.setForeground(new Color(255, 69, 0));
		lblFechaDeTermino.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFechaDeTermino.setBounds(62, 163, 120, 14);
		panel_1.add(lblFechaDeTermino);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(192, 163, 124, 20);
		panel_1.add(dateChooser_1);
		
		JLabel lblDasRestantes = new JLabel("D\u00EDas restantes :");
		lblDasRestantes.setForeground(new Color(255, 69, 0));
		lblDasRestantes.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDasRestantes.setBounds(326, 163, 104, 14);
		panel_1.add(lblDasRestantes);
		
		txtDiasRestantes = new JTextField();
		txtDiasRestantes.setEditable(false);
		txtDiasRestantes.setEnabled(false);
		txtDiasRestantes.setBounds(431, 161, 76, 20);
		panel_1.add(txtDiasRestantes);
		txtDiasRestantes.setColumns(10);
		
		Img ob30 = new Img ();
		JButton btnCancelar = new JButton("",ob30.btnCancelar());
		btnCancelar.setBounds(162, 194, 92, 45);
		panel_1.add(btnCancelar);
		
		Img ob31 = new Img();
		JButton btnGuardar = new JButton("",ob31.btnGuardar());
		btnGuardar.setBounds(264, 194, 92, 45);
		panel_1.add(btnGuardar);
		
		JButton btnVerEmpleados = new JButton("Ver Empleados");
		btnVerEmpleados.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnVerEmpleados.setForeground(new Color(255, 69, 0));
		btnVerEmpleados.setBounds(338, 11, 107, 21);
		panel_1.add(btnVerEmpleados);
		
		JLabel lblFechaDeReanudacion = new JLabel("Fecha de reanudaci\u00F3n :");
		lblFechaDeReanudacion.setForeground(new Color(255, 69, 0));
		lblFechaDeReanudacion.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFechaDeReanudacion.setBounds(326, 138, 150, 14);
		panel_1.add(lblFechaDeReanudacion);
		
		JDateChooser dateChooser_2 = new JDateChooser();
		dateChooser_2.setBounds(476, 137, 119, 20);
		panel_1.add(dateChooser_2);
	}
}
