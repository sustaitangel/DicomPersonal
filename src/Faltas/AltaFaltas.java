package Faltas;

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

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Conexion.Conectar;
import Empleados.AgregarEmpleados;
import Empleados.AltaEmpleados;
import Empleados.ModificarEmpleados;
import Faltas.Componentes;
import Imagenes.Img;

import com.toedter.calendar.JDateChooser;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.util.Calendar;

public class AltaFaltas extends JFrame {

	private JPanel contentPane;
	private JTextField txtFaltas;
	private JTextField txtBuscarEmpleados;
	private JTextField txtFolio;
	private JTable tableVerEmpleados;
	private static   String matriz[][]={};
	private static   String vector[]={"Folio","Num.Empleado", "Nombre", "A.Paterno", "A.Materno","Fecha","Faltas"};
	public static   DefaultTableModel modelo2= new DefaultTableModel(matriz,vector);
	public static JTextField txtNumEmpleado = new JTextField();
	public static JTextField txtNombre = new JTextField();
	public static JTextField txtApaterno = new JTextField();
	public static JTextField txtAmaterno = new JTextField();
	Componentes componentes = new Componentes();
	Conectar conex = new Conectar();
	java.sql.Connection con;
	java.sql.Statement list;
	ResultSet rs;
	public static String NumEmpleado;
	public static String Nombre;
	public static String Apaterno;
	public static String Amaterno;
	public static String Fecha;
	public static String Faltas;
	public static String Folio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaFaltas frame = new AltaFaltas();
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
	void listarProductos(String buscar){
		JTextField hola = null;
		String sql = "";
		try {
			con = conex.conexion(hola);
			String[] titulos = {"Folio","Num.Empleado", "Nombre", "A.paterno", "A.materno", "Fecha","Faltas"};
			if (buscar.equals("")) {
				sql = "select folio,num_empleado,nombre,apellido_paterno,apellido_materno,fecha,faltas " +
						"from faltas_has_empleados as p ";
				
			} else {
				sql = "select folio,num_empleado,nombre,apellido_paterno,apellido_materno,fecha,faltas " +
						"from faltas_has_empleados as p " +
						"where nombre like '%" + buscar + "%'" +
						" OR num_empleado LIKE '%" + buscar + "%'";
			}
			list =  con.createStatement();
			DefaultTableModel model = new DefaultTableModel(null, titulos);
			tableVerEmpleados.setModel(model);
			rs = list.executeQuery(sql);
			
			while (rs.next()) {
				model.addRow(new Object[] {rs.getString("folio"),rs.getString("num_empleado"),rs.getString("nombre"),
						rs.getString("apellido_paterno"),rs.getString("apellido_materno"),rs.getString("fecha"),rs.getString("faltas")});
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public AltaFaltas() {
		setTitle("---DICOM--- ALTA DE ASISTENCIAS ---");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 612, 429);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(220, 220, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Relacion de Faltas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 0, 0)));
		layeredPane.setBounds(10, 11, 576, 368);
		contentPane.add(layeredPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(255, 255, 255));
		tabbedPane.setFont(new Font("Tahoma", Font.BOLD, 11));
		tabbedPane.setForeground(new Color(255, 69, 0));
		tabbedPane.setBounds(10, 34, 556, 323);
		layeredPane.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(245, 245, 245));
		tabbedPane.addTab("Faltas", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Buscar", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 69, 0)));
		layeredPane_1.setBounds(10, 11, 488, 73);
		panel_1.add(layeredPane_1);
		
		txtBuscarEmpleados = new JTextField();
		txtBuscarEmpleados.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				componentes.mayusculas(e);
			}
		});
		txtBuscarEmpleados.setBounds(36, 33, 142, 20);
		layeredPane_1.add(txtBuscarEmpleados);
		txtBuscarEmpleados.setColumns(10);
		
		JLabel lblNombreONum = new JLabel("Nombre o Num. Empleado");
		lblNombreONum.setForeground(new Color(128, 0, 0));
		lblNombreONum.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblNombreONum.setBounds(45, 15, 133, 14);
		layeredPane_1.add(lblNombreONum);
		
		Img ob23 = new Img ();
		JButton btnBuscar = new JButton("",ob23.btnBuscar1());
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String buscarString = txtBuscarEmpleados.getText();
				if (!buscarString.equals("")) {
					listarProductos(buscarString);
					txtBuscarEmpleados.setText("");
				}else{
					listarProductos("");
				}
			}
		});
		btnBuscar.setBounds(188, 25, 48, 37);
		layeredPane_1.add(btnBuscar);
		
		Img ob24 = new Img ();
		JButton btnEliminar = new JButton("",ob24.btnEliminar1());
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				componentes.eliminarProducto(tableVerEmpleados);
				listarProductos("");
			}
		});
		btnEliminar.setBounds(246, 25, 48, 37);
		layeredPane_1.add(btnEliminar);
		
		Img ob25 = new Img ();
		JButton btnActualizar = new JButton("",ob25.btnActualizar1());
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarFaltas fm10=new  ModificarFaltas();
				fm10.setVisible(true);
				fm10.setLocation(600, 100);
				ModificarFaltas.txtFolio.setText(AltaFaltas.Folio);
				ModificarFaltas.txtNumEmpleado.setText(AltaFaltas.NumEmpleado);
				ModificarFaltas.txtNombre.setText(AltaFaltas.Nombre);
				ModificarFaltas.txtApaterno.setText(AltaFaltas.Apaterno);
				ModificarFaltas.txtAmaterno.setText(AltaFaltas.Amaterno);
				ModificarFaltas.txtFaltas.setText(AltaFaltas.Faltas);
			}
		});
		btnActualizar.setBounds(304, 25, 48, 37);
		layeredPane_1.add(btnActualizar);
		
		JLayeredPane layeredPane_2 = new JLayeredPane();
		layeredPane_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Lista De Control De Asistencia", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 69, 0)));
		layeredPane_2.setBounds(20, 95, 521, 189);
		panel_1.add(layeredPane_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 20, 501, 158);
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
				"Folio","Num.Empleado","Nombre", "A.Paterno", "A.Materno", "Fecha", "Faltas"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, true, true, true, true, true, true, false, true, true, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableVerEmpleados.getColumnModel().getColumn(0).setPreferredWidth(88);
		tableVerEmpleados.getColumnModel().getColumn(3).setPreferredWidth(67);
		tableVerEmpleados.getColumnModel().getColumn(4).setPreferredWidth(81);
		tableVerEmpleados.getColumnModel().getColumn(4).setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 245, 245));
		tabbedPane.addTab("Alta de faltas", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre :");
		lblNombre.setForeground(new Color(255, 69, 0));
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNombre.setBounds(141, 84, 58, 20);
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtNombre.setForeground(new Color(128, 0, 0));
		txtNombre.setEditable(false);
		txtNombre.setBounds(205, 85, 133, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblApellidoPaterno = new JLabel("Apellido Paterno :");
		lblApellidoPaterno.setForeground(new Color(255, 69, 0));
		lblApellidoPaterno.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblApellidoPaterno.setBounds(83, 115, 116, 20);
		panel.add(lblApellidoPaterno);
		
		txtApaterno = new JTextField();
		txtApaterno.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtApaterno.setEditable(false);
		txtApaterno.setForeground(new Color(128, 0, 0));
		txtApaterno.setBounds(205, 116, 133, 20);
		panel.add(txtApaterno);
		txtApaterno.setColumns(10);
		
		JLabel lblApellidoMaterno = new JLabel("Apellido Materno :");
		lblApellidoMaterno.setForeground(new Color(255, 69, 0));
		lblApellidoMaterno.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblApellidoMaterno.setBounds(80, 146, 119, 20);
		panel.add(lblApellidoMaterno);
		
		txtAmaterno = new JTextField();
		txtAmaterno.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtAmaterno.setForeground(new Color(128, 0, 0));
		txtAmaterno.setEditable(false);
		txtAmaterno.setBounds(205, 147, 133, 20);
		panel.add(txtAmaterno);
		txtAmaterno.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha :");
		lblFecha.setForeground(new Color(255, 69, 0));
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFecha.setBounds(152, 177, 47, 20);
		panel.add(lblFecha);
		
		JDateChooser dateChooserFaltas = new JDateChooser();
		dateChooserFaltas.setForeground(new Color(128, 0, 0));
		dateChooserFaltas.setBounds(205, 177, 133, 20);
		panel.add(dateChooserFaltas);
		
		JLabel lblFaltas = new JLabel("Faltas :");
		lblFaltas.setForeground(new Color(255, 69, 0));
		lblFaltas.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFaltas.setBounds(153, 208, 47, 20);
		panel.add(lblFaltas);
		
		txtFaltas = new JTextField();
		txtFaltas.setForeground(new Color(128, 0, 0));
		txtFaltas.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtFaltas.setBounds(205, 209, 133, 20);
		panel.add(txtFaltas);
		txtFaltas.setColumns(10);
		
		Img ob20 = new Img();
		JButton btnCancelar = new JButton("",ob20.btnCancelar());
		btnCancelar.setBounds(174, 239, 92, 45);
		panel.add(btnCancelar);
		
		Img ob21 = new Img();
		JButton btnGuardar = new JButton("",ob21.btnGuardar());
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarFaltas n50= new AgregarFaltas();
				int ano = dateChooserFaltas.getCalendar().get(Calendar.YEAR);
				int mes = dateChooserFaltas.getCalendar().get(Calendar.MONTH) + 1;
				int dia = dateChooserFaltas.getCalendar().get(Calendar.DAY_OF_MONTH);
				String fechaF= String.valueOf(ano)+"-"+String.valueOf(mes)+"-"+String.valueOf(dia);
				n50.agregar(txtFolio,txtNumEmpleado, txtNombre, txtApaterno, txtAmaterno,fechaF, txtFaltas);
				
				
				limpiar();	
			}
		});
		btnGuardar.setBounds(280, 239, 92, 45);
		panel.add(btnGuardar);
		tableVerEmpleados.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				componentes.habilitar(btnEliminar, btnActualizar);
				if (arg0.getButton() == 1) {
					
					int fila = tableVerEmpleados.getSelectedRow();
					
					try {
						list = con.createStatement();
						String sqlsString = "select * from faltas_has_empleados where folio = " + 
								tableVerEmpleados.getValueAt(fila, 0);
						ResultSet resultSet = list.executeQuery(sqlsString);
						resultSet.next();
						AltaFaltas.Folio = resultSet.getString("folio");
						AltaFaltas.NumEmpleado = resultSet.getString("num_empleado");
						AltaFaltas.Nombre = resultSet.getString("nombre");
						AltaFaltas.Apaterno = resultSet.getString("apellido_paterno");
						AltaFaltas.Amaterno = resultSet.getString("apellido_materno");
						AltaFaltas.Faltas = resultSet.getString("faltas");
						
						
					} catch (Exception e) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
					}
				}
			}
		});
		componentes.deshabilitar(btnEliminar,btnActualizar);
		JButton btnVerEmpelados = new JButton("Ver Empleados");
		btnVerEmpelados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltaEmpleados fm10=new  AltaEmpleados();
				fm10.setVisible(true);
				fm10.setLocation(600, 100);
			}
		});
		btnVerEmpelados.setBackground(new Color(220, 220, 220));
		btnVerEmpelados.setForeground(new Color(255, 69, 0));
		btnVerEmpelados.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnVerEmpelados.setBounds(348, 50, 116, 23);
		panel.add(btnVerEmpelados);
		
		JLabel lblNumeroDeEmpleado = new JLabel("Numero de empleado :");
		lblNumeroDeEmpleado.setForeground(new Color(255, 69, 0));
		lblNumeroDeEmpleado.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNumeroDeEmpleado.setBounds(53, 59, 144, 14);
		panel.add(lblNumeroDeEmpleado);
		
		txtNumEmpleado = new JTextField();
		txtNumEmpleado.setEditable(false);
		txtNumEmpleado.setForeground(new Color(128, 0, 0));
		txtNumEmpleado.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtNumEmpleado.setBounds(205, 54, 133, 20);
		panel.add(txtNumEmpleado);
		txtNumEmpleado.setColumns(10);
		
		JLabel lblFolio = new JLabel("Folio :");
		lblFolio.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFolio.setForeground(new Color(255, 69, 0));
		lblFolio.setBounds(53, 11, 37, 14);
		panel.add(lblFolio);
		
		txtFolio = new JTextField();
		txtFolio.setBounds(100, 9, 133, 20);
		panel.add(txtFolio);
		txtFolio.setColumns(10);
		
	
	}
	public void limpiar(){
		txtNumEmpleado.setText("");
		txtNombre.setText("");
		txtApaterno.setText("");
		txtAmaterno.setText("");
		txtFaltas.setText("");
	}
}
