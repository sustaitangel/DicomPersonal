package Faltas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLayeredPane;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import Empleados.AltaEmpleados;
import Faltas.Componentes;
import Empleados.ModificarEmpleados;
import Imagenes.Img;

import com.toedter.calendar.JDateChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Calendar;

public class ModificarFaltas extends JFrame {

	private JPanel contentPane;
	public static JTextField txtFaltas;
	public static JTextField txtNumEmpleado;
	public static JTextField txtClaveMinera;
	public static JTextField txtNombre;
	public static JTextField txtApaterno;
	public static JTextField txtAmaterno;
	public static JTextField txtFecha;
	public static JTextField txtFolio;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JOptionPane.showMessageDialog(null, AltaFaltas.NumEmpleado+" aqui abro");
					ModificarFaltas frame = new ModificarFaltas();
					frame.setVisible(true);
					 llenarCampos(AltaFaltas.NumEmpleado,null,null ,null,null,null);
						
						JOptionPane.showMessageDialog(null, AltaFaltas.NumEmpleado+" aqui abro");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	 static void llenarCampos(String Folio,String NumEmpleado,
				String Nombre,String Apaterno,String Amaterno,String Faltas)
	 {
			JOptionPane.showMessageDialog(null, AltaEmpleados.NumEmpleado+" codigo de modificasr");
			txtFolio.setText(AltaEmpleados.NumEmpleado);
			txtNumEmpleado.setText(AltaEmpleados.NumEmpleado);
			txtNombre.setText(Nombre);
			txtApaterno.setText(Apaterno);
			txtAmaterno.setText(Amaterno);
			txtFaltas.setText(Faltas);
			
		}
	public ModificarFaltas() {
		setTitle("Dicom-----Modificar Faltas\r\n");
		setBackground(new Color(220, 220, 220));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 471, 366);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(220, 220, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Modificar Faltas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 69, 0)));
		layeredPane.setBounds(10, 11, 435, 305);
		contentPane.add(layeredPane);
		
		JLabel lblNumEmpleado = new JLabel("Numero de empleado :");
		lblNumEmpleado.setForeground(new Color(255, 69, 0));
		lblNumEmpleado.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNumEmpleado.setBounds(44, 50, 144, 14);
		layeredPane.add(lblNumEmpleado);
		
		txtNumEmpleado = new JTextField();
		txtNumEmpleado.setForeground(new Color(128, 0, 0));
		txtNumEmpleado.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtNumEmpleado.setEditable(false);
		txtNumEmpleado.setColumns(10);
		txtNumEmpleado.setBounds(193, 45, 133, 20);
		layeredPane.add(txtNumEmpleado);
		
		JLabel lblNombre = new JLabel("Nombre :");
		lblNombre.setForeground(new Color(255, 69, 0));
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNombre.setBounds(130, 75, 58, 20);
		layeredPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setForeground(new Color(128, 0, 0));
		txtNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtNombre.setEditable(false);
		txtNombre.setColumns(10);
		txtNombre.setBounds(193, 76, 133, 20);
		layeredPane.add(txtNombre);
		
		JLabel lblApaterno = new JLabel("Apellido Paterno :");
		lblApaterno.setForeground(new Color(255, 69, 0));
		lblApaterno.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblApaterno.setBounds(72, 106, 116, 20);
		layeredPane.add(lblApaterno);
		
		txtApaterno = new JTextField();
		txtApaterno.setForeground(new Color(128, 0, 0));
		txtApaterno.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtApaterno.setEditable(false);
		txtApaterno.setColumns(10);
		txtApaterno.setBounds(193, 107, 133, 20);
		layeredPane.add(txtApaterno);
		
		JLabel lblAmaterno = new JLabel("Apellido Materno :");
		lblAmaterno.setForeground(new Color(255, 69, 0));
		lblAmaterno.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAmaterno.setBounds(69, 137, 119, 20);
		layeredPane.add(lblAmaterno);
		
		txtAmaterno = new JTextField();
		txtAmaterno.setForeground(new Color(128, 0, 0));
		txtAmaterno.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtAmaterno.setEditable(false);
		txtAmaterno.setColumns(10);
		txtAmaterno.setBounds(193, 138, 133, 20);
		layeredPane.add(txtAmaterno);
		
		JLabel lblFecha = new JLabel("Fecha :");
		lblFecha.setForeground(new Color(255, 69, 0));
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFecha.setBounds(141, 164, 47, 20);
		layeredPane.add(lblFecha);
		
		JLabel lblFaltas = new JLabel("Faltas :");
		lblFaltas.setForeground(new Color(255, 69, 0));
		lblFaltas.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFaltas.setBounds(141, 195, 47, 20);
		layeredPane.add(lblFaltas);
		
		txtFaltas = new JTextField();
		txtFaltas.setForeground(new Color(128, 0, 0));
		txtFaltas.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtFaltas.setColumns(10);
		txtFaltas.setBounds(193, 196, 133, 20);
		layeredPane.add(txtFaltas);
		
		Img mf01 = new Img();
		JButton btnCancelar = new JButton("",mf01.btnCancelar());
		btnCancelar.setBounds(132, 249, 92, 45);
		layeredPane.add(btnCancelar);
		JDateChooser dateChooserFaltas = new JDateChooser();
		dateChooserFaltas.setForeground(new Color(128, 0, 0));
		dateChooserFaltas.setBounds(193, 164, 133, 20);
		layeredPane.add(dateChooserFaltas);
		
		Img mf02 = new Img ();
		JButton btnGuardar = new JButton("",mf02.btnGuardar());
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int replay = JOptionPane.showConfirmDialog(null,"El registro será modificado. ¿Desea continuar?",
						"Confirmar",JOptionPane.YES_NO_OPTION);
				if (replay == JOptionPane.YES_OPTION) {
					
							Componentes on=new Componentes();
							int ano = dateChooserFaltas.getCalendar().get(Calendar.YEAR);
							int mes = dateChooserFaltas.getCalendar().get(Calendar.MONTH) + 1;
							int dia = dateChooserFaltas.getCalendar().get(Calendar.DAY_OF_MONTH);
							String fechaF= String.valueOf(ano)+"-"+String.valueOf(mes)+"-"+String.valueOf(dia);
							on.actualizarProductos(txtFolio,txtNumEmpleado, txtNombre, txtApaterno, txtAmaterno,fechaF,txtFaltas);
							ModificarFaltas.this.dispose();
							
					
				} else {}
			}
		});
		btnGuardar.setBounds(234, 249, 92, 45);
		layeredPane.add(btnGuardar);
		
		JLabel lblFolio = new JLabel("Folio :");
		lblFolio.setForeground(new Color(255, 69, 0));
		lblFolio.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFolio.setBounds(151, 25, 37, 14);
		layeredPane.add(lblFolio);
		
		txtFolio = new JTextField();
		txtFolio.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtFolio.setForeground(new Color(128, 0, 0));
		txtFolio.setEditable(false);
		txtFolio.setBounds(193, 23, 133, 20);
		layeredPane.add(txtFolio);
		txtFolio.setColumns(10);
		
		
		
	
		
		
	}
}
