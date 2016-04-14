package Empleados;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLayeredPane;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;

import Conexion.Conectar;
import Imagenes.Img;
import Empleados.ModificarEmpleados;
import Empleados.AltaEmpleados;
import Faltas.AltaFaltas;

import com.toedter.calendar.JDateChooser;

import java.awt.Label;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.util.Calendar;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

public class AltaEmpleados extends JFrame {

	private JPanel contentPane;
	private JTextField txtClaveMinera;
	private JTextField txtNombre;
	private JTextField txtPuesto;
	private JTextField txtApaterno;
	private JTextField txtAmaterno;
	private JTextField txtTelefono;
	private JTextField txtEdad;
	private JTextField txtNoimss;
	private JTextField txtRfc;
	private JTextField txtCurp;
	private JTextField txtEscolaridad;
	private JTextField txtCalle;
	private JTextField txtColonia;
	private JTextField txtCiudad;
	private JTextField txtEstado;
	private JTextField txtEstadoCivil;
	private JTextField txtDeconomicos;
	private JTextField txtNombreEmergencia;
	private JTextField txtTelefonoEmergencia;
	private JTextField txtNumEmpleado;
	static String pathArchivo = "";
	private JTextField txtBuscarEmpleados;
	private JTable tableVerEmpleados;
	private static   String matriz[][]={};
	private static   String vector[]={"Num.Empleado", "Ficha Minera", "Nombre", "A.Paterno", "A.Materno", "Area", "Puesto", "Telefono","Edad","No.Imss","R.F.C","Curp","Tipo Sangre","Fecha Inicio"};
	public static   DefaultTableModel modelo2= new DefaultTableModel(matriz,vector);
	int tipo;
	String tipo1;
	int tipoS;
	String tipoS1;
	int tipoSa;
	String tipoSa1;
	int tipoP;
	String tipoP1;
	Conectar conex = new Conectar();
	java.sql.Connection con;
	java.sql.Statement list;
	ResultSet rs;
	Componentes componentes = new Componentes();
	public static String NumEmpleado;
	public static String Nombre;
	public static String ClaveMinera;
	public static String Apaterno;
	public static String Amaterno;
	public static String Puesto;
	public static String Telefono;
	public static String Edad;
	public static String Escolaridad;
	public static String Noimss;
	public static String Rfc;
	public static String Curp;
	public static String Calle;
	public static String Colonia;
	public static String Ciudad;
	public static String Estado;
	public static String EstadoCivil;
	public static String DependientesEconomicos;
	public static String NombreEmergencia;
	public static String TelefonoEmergencia;
	public static String IdEmpleado;
	public static String IdNNombre;
	public static String IdApaterno;
	public static String IdAmaterno;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaEmpleados frame = new AltaEmpleados();
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
			String[] titulos = {"Num.Empleado", "Ficha Minera", "Nombre", "A.Paterno", "A.Materno", "Area", "Puesto", "Telefono","Edad","No.Imss","R.F.C","Curp","Tipo Sangre","Fecha Inicio"};
			if (buscar.equals("")) {
				sql = "select num_empleado,clave_minera,nombre,apellido_paterno,apellido_materno,cat.descripcion,puesto,telefono,edad,no_imss,rfc,curp,sangre_id_sangre,fecha_inicio " +
						"from empleados as p " +
						"inner join categoria_area as cat on id_catArea = area_id_area";
				
			} else {
				sql = "select num_empleado,clave_minera,nombre,apellido_paterno,apellido_materno,cat.descripcion,puesto,telefono,edad,no_imss,rfc,curp,sangre_id_sangre,fecha_inicio " +
						"from empleados as p " +
						"inner join categoria_area as cat on id_catArea = area_id_area " +
						"where nombre like '%" + buscar + "%'" +
						" OR num_empleado LIKE '%" + buscar + "%'" +
						" OR cat.descripcion LIKE '%" + buscar + "%'" +
						" OR clave_minera LIKE '%" + buscar + "%'";
			}
			list =  con.createStatement();
			DefaultTableModel model = new DefaultTableModel(null, titulos);
			tableVerEmpleados.setModel(model);
			rs = list.executeQuery(sql);
			
			while (rs.next()) {
				model.addRow(new Object[] {rs.getString("num_empleado"),rs.getString("clave_minera"),rs.getString("nombre"),
						rs.getString("apellido_paterno"),rs.getString("apellido_materno"),rs.getString("cat.descripcion"),rs.getString("puesto"),rs.getString("telefono"),rs.getString("edad"),rs.getString("no_imss"),
						rs.getString("rfc"),rs.getString("curp"),rs.getString("sangre_id_sangre"),rs.getString("fecha_inicio")});
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public AltaEmpleados() {
		setTitle("-----Dicom----  Alta De Empleados");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1348, 513);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(220, 220, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setForeground(new Color(128, 0, 0));
		layeredPane.setBorder(new TitledBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 69, 0)), "Alta de Empleados", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 0, 0)));
		layeredPane.setBounds(10, 11, 1312, 452);
		contentPane.add(layeredPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(255, 255, 255));
		tabbedPane.setForeground(new Color(255, 69, 0));
		tabbedPane.setFont(new Font("Tahoma", Font.BOLD, 11));
		tabbedPane.setBounds(10, 21, 1292, 420);
		layeredPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Empleados", null, panel, null);
		panel.setLayout(null);
		
		JLayeredPane layeredPane_2 = new JLayeredPane();
		layeredPane_2.setBorder(new TitledBorder(null, "Buscar", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 69, 0)));
		layeredPane_2.setBounds(274, 11, 608, 78);
		panel.add(layeredPane_2);
		
		txtBuscarEmpleados = new JTextField();
		txtBuscarEmpleados.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				componentes.mayusculas(e);
			}
		});
		txtBuscarEmpleados.setBounds(42, 31, 202, 20);
		layeredPane_2.add(txtBuscarEmpleados);
		txtBuscarEmpleados.setColumns(10);
		
		JLabel lblNumeroEmpleado = new JLabel("Numero empleado \u00F3 Nombre");
		lblNumeroEmpleado.setForeground(new Color(128, 0, 0));
		lblNumeroEmpleado.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNumeroEmpleado.setBounds(58, 11, 173, 14);
		layeredPane_2.add(lblNumeroEmpleado);
		
		Img op01= new Img();
		JButton btnBuscar = new JButton("",op01.btnBuscar());
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String buscarString = txtBuscarEmpleados.getText();
				if (!buscarString.equals("")) {
					listarProductos(buscarString);
					txtBuscarEmpleados.setText("");
				}else{
					listarProductos("");
				}
				
			}
		});
		btnBuscar.setBounds(254, 21, 61, 41);
		layeredPane_2.add(btnBuscar);
		
		Img op2 = new Img();
		JButton btnEliminar = new JButton("",op2.btnEliminar());
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				componentes.eliminarProducto(tableVerEmpleados);
				listarProductos("");
			}
		});
		btnEliminar.setBounds(325, 21, 61, 41);
		layeredPane_2.add(btnEliminar);
		
		Img op3 = new Img();
		JButton btnActualizar = new JButton("",op3.btnActualizar());
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarEmpleados ob20 = new ModificarEmpleados();
				ob20.setVisible(true);
				ob20.setLocation(700,50);
				ModificarEmpleados.txtNumEmpleado.setText(AltaEmpleados.NumEmpleado);
				ModificarEmpleados.txtClaveMinera.setText(AltaEmpleados.ClaveMinera);
				ModificarEmpleados.txtNombre.setText(AltaEmpleados.Nombre);
				ModificarEmpleados.txtApaterno.setText(AltaEmpleados.Apaterno);
				ModificarEmpleados.txtAmaterno.setText(AltaEmpleados.Amaterno);
				ModificarEmpleados.txtPuesto.setText(AltaEmpleados.Puesto);
				ModificarEmpleados.txtTelefono.setText(AltaEmpleados.Telefono);
				ModificarEmpleados.txtEdad.setText(AltaEmpleados.Edad);
				ModificarEmpleados.txtEscolaridad.setText(AltaEmpleados.Escolaridad);
				ModificarEmpleados.txtNoimss.setText(AltaEmpleados.Noimss);
				ModificarEmpleados.txtRfc.setText(AltaEmpleados.Rfc);
				ModificarEmpleados.txtCurp.setText(AltaEmpleados.Curp);
				ModificarEmpleados.txtCalle.setText(AltaEmpleados.Calle);
				ModificarEmpleados.txtColonia.setText(AltaEmpleados.Colonia);
				ModificarEmpleados.txtCiudad.setText(AltaEmpleados.Ciudad);
				ModificarEmpleados.txtEstado.setText(AltaEmpleados.Estado);
				ModificarEmpleados.txtEstadoCivil.setText(AltaEmpleados.EstadoCivil);
				ModificarEmpleados.txtDeconomicos.setText(AltaEmpleados.DependientesEconomicos);
				ModificarEmpleados.txtNombreEmergencia.setText(AltaEmpleados.NombreEmergencia);
				ModificarEmpleados.txtTelefonoEmergencia.setText(AltaEmpleados.TelefonoEmergencia);




				
				
			}
		});
		btnActualizar.setBounds(396, 21, 61, 41);
		layeredPane_2.add(btnActualizar);
		
		JLayeredPane layeredPane_3 = new JLayeredPane();
		layeredPane_3.setBorder(new TitledBorder(null, "Lista de Empleados", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 69, 0)));
		layeredPane_3.setBounds(20, 100, 1257, 281);
		panel.add(layeredPane_3);
		layeredPane_3.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 23, 1237, 247);
		layeredPane_3.add(scrollPane);
		
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
				"Num.Empleado", "Ficha Minera", "Nombre", "A.Paterno", "A.Materno", "Area", "Puesto", "Telefono", "Edad", "No.Imss", "R.F.C", "Curp", "Tipo Sangre", "Fecha Inicio"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, true, true, true, true, true, true, false, true, true, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableVerEmpleados.getColumnModel().getColumn(0).setPreferredWidth(109);
		tableVerEmpleados.getColumnModel().getColumn(3).setPreferredWidth(67);
		tableVerEmpleados.getColumnModel().getColumn(4).setPreferredWidth(81);
		tableVerEmpleados.getColumnModel().getColumn(7).setResizable(false);
		
		Img fm1= new Img();
		JLabel lblNewLabel = new JLabel(fm1.LogoFrame());
		lblNewLabel.setBounds(20, 11, 184, 78);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(255, 69, 0));
		tabbedPane.addTab("Alta de Empleados", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblClaveMinera = new JLabel("Ficha Minera :");
		lblClaveMinera.setForeground(new Color(255, 69, 0));
		lblClaveMinera.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblClaveMinera.setBounds(155, 38, 92, 16);
		panel_1.add(lblClaveMinera);
		
		txtClaveMinera = new JTextField();
		txtClaveMinera.setColumns(10);
		txtClaveMinera.setBounds(248, 37, 143, 20);
		panel_1.add(txtClaveMinera);
		
		JLabel lblNombre = new JLabel("Nombre del empleado :");
		lblNombre.setForeground(new Color(255, 69, 0));
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNombre.setBounds(100, 65, 147, 16);
		panel_1.add(lblNombre);
		
		JLabel lblArea = new JLabel("\u00C1rea :");
		lblArea.setForeground(new Color(255, 69, 0));
		lblArea.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblArea.setBounds(206, 146, 41, 16);
		panel_1.add(lblArea);
		
		JComboBox comboBoxArea = new JComboBox();
		comboBoxArea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tipo1=(String)comboBoxArea.getSelectedItem();
				if(tipo1.equals("Gerencia")){
					tipo=11;
				}
				if(tipo1.equals("Salud Ocupacional")){
					tipo=10;
				}
				if(tipo1.equals("Limpieza")){
					tipo=9;
				}
				if(tipo1.equals("Vigilancia")){
					tipo=8;
				}
				if(tipo1.equals("Administrativo")){
					tipo=7;
				}
				if(tipo1.equals("MttoEquipoLigero")){
					tipo=6;
				}
				if(tipo1.equals("MttoEquipoPesado")){
					tipo=5;
				}
				if(tipo1.equals("MttoZarpeo")){
					tipo=4;
				}
				if(tipo1.equals("Zarpeo")){
					tipo=3;
				}
				if(tipo1.equals("Desarrollo")){
					tipo=2;
				}
				if(tipo1.equals("Servicios")){
					tipo=1;
				}
			
			}
		});
		comboBoxArea.setBounds(248, 145, 143, 20);
		comboBoxArea.setModel(new DefaultComboBoxModel(new String[] {"Servicios", "Desarrollo","Zarpeo", "MttoZarpeo","MttoEquipoPesado","MttoEquipoLigero","Adminisrtrativo","Vigilancia","Limpieza","Salud Ocupacional","Gerencia"}));
		panel_1.add(comboBoxArea);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(248, 65, 143, 20);
		panel_1.add(txtNombre);
		
		JLabel lblPuesto = new JLabel("Puesto :");
		lblPuesto.setForeground(new Color(255, 69, 0));
		lblPuesto.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPuesto.setBounds(193, 174, 54, 16);
		panel_1.add(lblPuesto);
		
		txtPuesto = new JTextField();
		txtPuesto.setColumns(10);
		txtPuesto.setBounds(248, 173, 143, 20);
		panel_1.add(txtPuesto);
		
		JLabel lblApaterno = new JLabel("Apellido Paterno :");
		lblApaterno.setForeground(new Color(255, 69, 0));
		lblApaterno.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblApaterno.setBounds(131, 92, 116, 16);
		panel_1.add(lblApaterno);
		
		txtApaterno = new JTextField();
		txtApaterno.setColumns(10);
		txtApaterno.setBounds(248, 91, 143, 20);
		panel_1.add(txtApaterno);
		
		JLabel lblAmaterno = new JLabel("Apellido Materno :");
		lblAmaterno.setForeground(new Color(255, 69, 0));
		lblAmaterno.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAmaterno.setBounds(128, 119, 119, 16);
		panel_1.add(lblAmaterno);
		
		txtAmaterno = new JTextField();
		txtAmaterno.setColumns(10);
		txtAmaterno.setBounds(248, 118, 143, 20);
		panel_1.add(txtAmaterno);
		
		JLabel lblTelefono = new JLabel("Telefono :");
		lblTelefono.setForeground(new Color(255, 69, 0));
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTelefono.setBounds(183, 201, 64, 16);
		panel_1.add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(248, 200, 143, 20);
		panel_1.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento :");
		lblFechaDeNacimiento.setForeground(new Color(255, 69, 0));
		lblFechaDeNacimiento.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFechaDeNacimiento.setBounds(107, 228, 140, 16);
		panel_1.add(lblFechaDeNacimiento);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(248, 224, 143, 20);
		panel_1.add(dateChooser);
		
		JLabel lblEdad = new JLabel("Edad :");
		lblEdad.setForeground(new Color(255, 69, 0));
		lblEdad.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEdad.setBounds(206, 252, 41, 16);
		panel_1.add(lblEdad);
		
		txtEdad = new JTextField();
		txtEdad.setBounds(248, 251, 143, 20);
		panel_1.add(txtEdad);
		txtEdad.setColumns(10);
		
		JLabel lblNimss = new JLabel("No. Imss :");
		lblNimss.setForeground(new Color(255, 69, 0));
		lblNimss.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNimss.setBounds(461, 40, 64, 16);
		panel_1.add(lblNimss);
		
		txtNoimss = new JTextField();
		txtNoimss.setBounds(527, 39, 143, 20);
		panel_1.add(txtNoimss);
		txtNoimss.setColumns(10);
		
		JLabel lblRfc = new JLabel("R.F.C :");
		lblRfc.setForeground(new Color(255, 69, 0));
		lblRfc.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRfc.setBounds(484, 67, 41, 16);
		panel_1.add(lblRfc);
		
		txtRfc = new JTextField();
		txtRfc.setBounds(527, 66, 143, 20);
		panel_1.add(txtRfc);
		txtRfc.setColumns(10);
		
		JLabel lblCurp = new JLabel("Curp :");
		lblCurp.setForeground(new Color(255, 69, 0));
		lblCurp.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCurp.setBounds(486, 91, 39, 16);
		panel_1.add(lblCurp);
		
		txtCurp = new JTextField();
		txtCurp.setBounds(527, 90, 143, 20);
		panel_1.add(txtCurp);
		txtCurp.setColumns(10);
		
		JLabel lblEscolaridad = new JLabel("Escolaridad :");
		lblEscolaridad.setForeground(new Color(255, 69, 0));
		lblEscolaridad.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEscolaridad.setBounds(165, 279, 82, 14);
		panel_1.add(lblEscolaridad);
		
		txtEscolaridad = new JTextField();
		txtEscolaridad.setBounds(249, 277, 142, 20);
		panel_1.add(txtEscolaridad);
		txtEscolaridad.setColumns(10);
		
		JLabel lblSexo = new JLabel("Sexo :");
		lblSexo.setForeground(new Color(255, 69, 0));
		lblSexo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSexo.setBounds(485, 119, 41, 16);
		panel_1.add(lblSexo);
		
		JLabel lblCalle = new JLabel("Calle :");
		lblCalle.setForeground(new Color(255, 69, 0));
		lblCalle.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCalle.setBounds(485, 145, 41, 16);
		panel_1.add(lblCalle);
		
		txtCalle = new JTextField();
		txtCalle.setBounds(527, 144, 143, 20);
		panel_1.add(txtCalle);
		txtCalle.setColumns(10);
		
		JLabel lblColonia = new JLabel("Colonia :");
		lblColonia.setForeground(new Color(255, 69, 0));
		lblColonia.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblColonia.setBounds(471, 172, 55, 16);
		panel_1.add(lblColonia);
		
		txtColonia = new JTextField();
		txtColonia.setBounds(527, 171, 143, 20);
		panel_1.add(txtColonia);
		txtColonia.setColumns(10);
		
		JLabel lblCiudad = new JLabel("Ciudad :");
		lblCiudad.setForeground(new Color(255, 69, 0));
		lblCiudad.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCiudad.setBounds(472, 200, 54, 14);
		panel_1.add(lblCiudad);
		
		txtCiudad = new JTextField();
		txtCiudad.setBounds(527, 198, 143, 20);
		panel_1.add(txtCiudad);
		txtCiudad.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado :");
		lblEstado.setForeground(new Color(255, 69, 0));
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEstado.setBounds(472, 226, 54, 14);
		panel_1.add(lblEstado);
		
		txtEstado = new JTextField();
		txtEstado.setBounds(527, 224, 143, 20);
		panel_1.add(txtEstado);
		txtEstado.setColumns(10);
		
		JLabel lblEstadoCivil = new JLabel("Estado Civil :");
		lblEstadoCivil.setForeground(new Color(255, 69, 0));
		lblEstadoCivil.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEstadoCivil.setBounds(444, 250, 82, 14);
		panel_1.add(lblEstadoCivil);
		
		txtEstadoCivil = new JTextField();
		txtEstadoCivil.setBounds(527, 248, 143, 20);
		panel_1.add(txtEstadoCivil);
		txtEstadoCivil.setColumns(10);
		
		JLabel lblDependientesEconomicos = new JLabel("Dependientes Economicos :");
		lblDependientesEconomicos.setForeground(new Color(255, 69, 0));
		lblDependientesEconomicos.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDependientesEconomicos.setBounds(416, 276, 176, 14);
		panel_1.add(lblDependientesEconomicos);
		
		txtDeconomicos = new JTextField();
		txtDeconomicos.setBounds(595, 274, 75, 20);
		panel_1.add(txtDeconomicos);
		txtDeconomicos.setColumns(10);
		
		JLabel lblTipoSangre = new JLabel("Tipo Sangre :");
		lblTipoSangre.setForeground(new Color(255, 69, 0));
		lblTipoSangre.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTipoSangre.setBounds(751, 41, 86, 14);
		panel_1.add(lblTipoSangre);
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBorder(new TitledBorder(null, "En caso de Emergencia llamar a ", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 69, 0)));
		layeredPane_1.setBounds(699, 188, 343, 121);
		panel_1.add(layeredPane_1);
		
		JLabel lblNombreEmergencia = new JLabel("Nombre :");
		lblNombreEmergencia.setForeground(new Color(255, 69, 0));
		lblNombreEmergencia.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNombreEmergencia.setBounds(45, 29, 58, 14);
		layeredPane_1.add(lblNombreEmergencia);
		
		txtNombreEmergencia = new JTextField();
		txtNombreEmergencia.setBounds(105, 27, 139, 20);
		layeredPane_1.add(txtNombreEmergencia);
		txtNombreEmergencia.setColumns(10);
		
		JLabel lblParentesco = new JLabel("Parentesco :");
		lblParentesco.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblParentesco.setForeground(new Color(255, 69, 0));
		lblParentesco.setBounds(20, 54, 83, 14);
		layeredPane_1.add(lblParentesco);
		
		JLabel lblTelefonoEmergencia = new JLabel("Telefono :");
		lblTelefonoEmergencia.setForeground(new Color(255, 69, 0));
		lblTelefonoEmergencia.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTelefonoEmergencia.setBounds(39, 79, 64, 14);
		layeredPane_1.add(lblTelefonoEmergencia);
		
		txtTelefonoEmergencia = new JTextField();
		txtTelefonoEmergencia.setBounds(105, 77, 139, 20);
		layeredPane_1.add(txtTelefonoEmergencia);
		txtTelefonoEmergencia.setColumns(10);
		
		JComboBox comboBoxParentesco = new JComboBox();
		comboBoxParentesco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tipoP1=(String)comboBoxParentesco.getSelectedItem();
				if(tipoP1.equals("Vecino")){
					tipoP=15;
				}
				if(tipoP1.equals("Tia")){
					tipoP=14;
				}
				if(tipoP1.equals("Suegra")){
					tipoP=13;
				}
				if(tipoP1.equals("Novia")){
					tipoP=12;
				}
				if(tipoP1.equals("Madre")){
					tipoP=11;
				}
				if(tipoP1.equals("Hijo")){
					tipoP=10;
				}
				if(tipoP1.equals("Hija")){
					tipoP=9;
				}
				if(tipoP1.equals("Hermano")){
					tipoP=8;
				}
				if(tipoP1.equals("Hermana")){
					tipoP=7;
				}
				if(tipoP1.equals("Esposa")){
					tipoP=6;
				}
				if(tipoP1.equals("Esposo")){
					tipoP=5;
				}
				if(tipoP1.equals("Cuñado")){
					tipoP=4;
				}
				if(tipoP1.equals("Cuñada")){
					tipoP=3;
				}
				if(tipoP1.equals("Abuelo")){
					tipoP=2;
				}
				if(tipoP1.equals("Padre")){
					tipoP=1;
				}
			}
		});
		comboBoxParentesco.setBounds(105, 52, 139, 20);
		comboBoxParentesco.setModel(new DefaultComboBoxModel(new String[] {"Padre","Abuelo","Cuñada","Cuñado","Esposo","Esposa","Hermana","Hermano","Hija","Hijo","Madre","Novia","Suegra","Tia","Vecino"}));
		layeredPane_1.add(comboBoxParentesco);
		
		Img ob10 = new Img();
		JLabel lblImagen = new JLabel(ob10.btnFondoFoto());
		lblImagen.setBackground(new Color(255, 160, 122));
		lblImagen.setBounds(1014, 11, 179, 153);
		panel_1.add(lblImagen);
		
		JLabel lblNumeroDeEmpleado = new JLabel("Numero de Empleado :");
		lblNumeroDeEmpleado.setForeground(new Color(255, 69, 0));
		lblNumeroDeEmpleado.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNumeroDeEmpleado.setBounds(104, 13, 143, 14);
		panel_1.add(lblNumeroDeEmpleado);
		
		txtNumEmpleado = new JTextField();
		txtNumEmpleado.setBounds(248, 11, 143, 20);
		panel_1.add(txtNumEmpleado);
		txtNumEmpleado.setColumns(10);
		
		Img n01 = new Img();
		JButton btnCancelar = new JButton("",n01.btnCancelar());
		btnCancelar.setBounds(448, 322, 92, 45);
		panel_1.add(btnCancelar);
		
		JComboBox comboBoxTipoSangre = new JComboBox();
		comboBoxTipoSangre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tipoSa1=(String)comboBoxTipoSangre.getSelectedItem();
				if(tipoSa1.equals("O RH+")){
					tipoSa=8;
				}
				if(tipoSa1.equals("O RH-")){
					tipoSa=7;
				}
				if(tipoSa1.equals("NO SABE")){
					tipoSa=6;
				}
				if(tipoSa1.equals("B RH+")){
					tipoSa=5;
				}
				if(tipoSa1.equals("B RH-")){
					tipoSa=4;
				}
				if(tipoSa1.equals("AB RH+")){
					tipoSa=3;
				}
				if(tipoSa1.equals("A RH+")){
					tipoSa=2;
				}
				if(tipoSa1.equals("A RH-")){
					tipoSa=1;
				}
				
			}
		});
		comboBoxTipoSangre.setBounds(839, 39, 119, 20);
		comboBoxTipoSangre.setModel(new DefaultComboBoxModel(new String[] {"A RH-","A RH+","AB RH+","B RH-","B RH+","NO SABE","O RH-","O RH+"}));
		panel_1.add(comboBoxTipoSangre);
		
		JLabel lblFechaDeInicio = new JLabel("Fecha de inicio :");
		lblFechaDeInicio.setForeground(new Color(255, 69, 0));
		lblFechaDeInicio.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFechaDeInicio.setBounds(735, 68, 102, 14);
		panel_1.add(lblFechaDeInicio);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(839, 67, 119, 20);
		panel_1.add(dateChooser_1);
		
		JLabel lblFechaVencimiento = new JLabel("Fecha Vencimiento :");
		lblFechaVencimiento.setForeground(new Color(255, 69, 0));
		lblFechaVencimiento.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFechaVencimiento.setBounds(708, 95, 129, 14);
		panel_1.add(lblFechaVencimiento);
		
		JDateChooser dateChooser_2 = new JDateChooser();
		dateChooser_2.setBounds(839, 93, 119, 20);
		panel_1.add(dateChooser_2);
		
		Img n02 = new Img();
		JButton btnGuardar = new JButton("",n02.btnGuardar());
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarEmpleados n= new AgregarEmpleados();
				int ano = dateChooser.getCalendar().get(Calendar.YEAR);
				int mes = dateChooser.getCalendar().get(Calendar.MONTH) + 1;
				int dia = dateChooser.getCalendar().get(Calendar.DAY_OF_MONTH);
				String fecha= String.valueOf(ano)+"-"+String.valueOf(mes)+"-"+String.valueOf(dia);
				int ano1 = dateChooser_1.getCalendar().get(Calendar.YEAR);
				int mes1 = dateChooser_1.getCalendar().get(Calendar.MONTH) + 1;
				int dia1 = dateChooser_1.getCalendar().get(Calendar.DAY_OF_MONTH);
				String fecha1= String.valueOf(ano1)+"-"+String.valueOf(mes1)+"-"+String.valueOf(dia1);
				int ano2 = dateChooser_2.getCalendar().get(Calendar.YEAR);
				int mes2 = dateChooser_2.getCalendar().get(Calendar.MONTH) + 1;
				int dia2 = dateChooser_2.getCalendar().get(Calendar.DAY_OF_MONTH);
				String fecha2= String.valueOf(ano2)+"-"+String.valueOf(mes2)+"-"+String.valueOf(dia2);
			
				n.agregar(txtNumEmpleado, txtClaveMinera, txtNombre, txtApaterno, txtAmaterno, tipo, txtPuesto, txtTelefono, fecha, txtEdad, txtEscolaridad, txtNoimss, 
						txtRfc, txtCurp, tipoS, txtCalle, txtColonia, txtCiudad, txtEstado, txtEstadoCivil, txtDeconomicos, tipoSa, fecha1, fecha2, txtNombreEmergencia, tipoP, txtTelefonoEmergencia,pathArchivo);
				ImageIcon icono = new ImageIcon(""); 
				lblImagen.setIcon(icono);
				
				limpiar();	
			}
		});
		tableVerEmpleados.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				componentes.habilitar(btnEliminar, btnActualizar);
				if (arg0.getButton() == 1) {
					
					int fila = tableVerEmpleados.getSelectedRow();
					final int id=Integer.parseInt(tableVerEmpleados.getValueAt(fila, 0).toString());
					try {
						int selected;
						selected=tableVerEmpleados.getSelectedRow(); 
						String IdNumEmpleado;
						String IdNombre;
						String IdAp;
						String IdAm;
						IdNumEmpleado=tableVerEmpleados.getValueAt(selected, 0).toString();
						IdNombre=tableVerEmpleados.getValueAt(selected, 2).toString();
						IdAp=tableVerEmpleados.getValueAt(selected, 3).toString();
						IdAm=tableVerEmpleados.getValueAt(selected, 4).toString();
						IdNNombre=IdNombre;
						IdEmpleado=IdNumEmpleado;
						IdApaterno = IdAp;
						IdAmaterno = IdAm;
						AltaFaltas.txtNumEmpleado.setText(IdEmpleado);
						AltaFaltas.txtNombre.setText(IdNNombre);
						AltaFaltas.txtApaterno.setText(IdApaterno);
						AltaFaltas.txtAmaterno.setText(IdAmaterno);
						list = con.createStatement();
						String sqlsString = "select * from empleados where num_empleado = " + 
								tableVerEmpleados.getValueAt(fila, 0);
						ResultSet resultSet = list.executeQuery(sqlsString);
						resultSet.next();
						AltaEmpleados.NumEmpleado = resultSet.getString("num_empleado");
						AltaEmpleados.ClaveMinera = resultSet.getString("clave_minera");
						AltaEmpleados.Nombre = resultSet.getString("nombre");
						AltaEmpleados.Apaterno = resultSet.getString("apellido_paterno");
						AltaEmpleados.Amaterno = resultSet.getString("apellido_materno");
						AltaEmpleados.Puesto = resultSet.getString("puesto");
						AltaEmpleados.Telefono = resultSet.getString("telefono");
						AltaEmpleados.Edad = resultSet.getString("edad");
						AltaEmpleados.Escolaridad = resultSet.getString("escolaridad");
						AltaEmpleados.Noimss = resultSet.getString("no_imss");
						AltaEmpleados.Rfc = resultSet.getString("rfc");
						AltaEmpleados.Curp = resultSet.getString("curp");
						AltaEmpleados.Calle = resultSet.getString("calle");
						AltaEmpleados.Colonia = resultSet.getString("colonia");
						AltaEmpleados.Ciudad = resultSet.getString("ciudad");
						AltaEmpleados.Estado = resultSet.getString("estado");
						AltaEmpleados.EstadoCivil = resultSet.getString("estado_civil");
						AltaEmpleados.DependientesEconomicos = resultSet.getString("dependientes_economicos");
						AltaEmpleados.NombreEmergencia = resultSet.getString("nombre_emergencia");
						AltaEmpleados.TelefonoEmergencia = resultSet.getString("telefono_parentesco");
						
						
					} catch (Exception e) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
					}
				}
			}
		});
		componentes.deshabilitar(btnEliminar,btnActualizar);
		btnGuardar.setBounds(550, 322, 92, 45);
		panel_1.add(btnGuardar);
		
		Img n03 = new Img();
		JButton btnAgregarFoto = new JButton("",n03.btnAgregarFoto());
		btnAgregarFoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser elegir = new JFileChooser();
				elegir.setFileFilter(new FileNameExtensionFilter("Archivo de Imagen","jpg","png","jpeg"));
				int opcion = elegir.showOpenDialog(btnAgregarFoto);
				if (opcion == JFileChooser.APPROVE_OPTION) {
					pathArchivo = elegir.getSelectedFile().getPath();
					Image foto = getToolkit().getImage(pathArchivo);
					foto = foto.getScaledInstance(160, 142, 0);
					lblImagen.setIcon(new ImageIcon(foto));
				}
			}
		});
		btnAgregarFoto.setBounds(793, 322, 92, 45);
		panel_1.add(btnAgregarFoto);
	
		JComboBox comboBoxSexo = new JComboBox();
		comboBoxSexo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tipoS1=(String)comboBoxArea.getSelectedItem();
				if(tipoS1.equals("Masculino")){
					tipoS=2;
				}
				if(tipoS1.equals("Femenino")){
					tipoS=1;
				}
			}
		});
		comboBoxSexo.setBounds(527, 118, 143, 20);
		comboBoxSexo.setModel(new DefaultComboBoxModel(new String[] {"Femenino","Masculino"}));
		panel_1.add(comboBoxSexo);
	}
	
	public void limpiar(){
		txtNumEmpleado.setText("");
		txtClaveMinera.setText("");
		txtNombre.setText("");
		txtApaterno.setText("");
		txtAmaterno.setText("");
		txtPuesto.setText("");
		txtTelefono.setText("");
		txtEdad.setText("");
		txtEscolaridad.setText("");
		txtNoimss.setText("");
		txtRfc.setText("");
		txtCurp.setText("");
		txtCalle.setText("");
		txtColonia.setText("");
		txtCiudad.setText("");
		txtEstado.setText("");
		txtEstadoCivil.setText("");
		txtDeconomicos.setText("");
		txtNombreEmergencia.setText("");
		txtTelefonoEmergencia.setText("");
		
		
		
		
		
	}
}
