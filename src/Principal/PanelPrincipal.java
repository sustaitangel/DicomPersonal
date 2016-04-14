package Principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import Empleados.AltaEmpleados;
import Faltas.AltaFaltas;
import Imagenes.Img;
import Licencias.Licencias;
import Login.InSesion;
import Login.Iniciar;
import Usuarios.Usuarios;
import Vacaciones.AltaVacaciones;

import java.awt.Window.Type;

import javax.swing.JLabel;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelPrincipal extends JFrame {

	private JPanel contentPane;
	public static InSesion k=new InSesion();
	RelojFecha relojFecha = new RelojFecha();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelPrincipal frame = new PanelPrincipal();
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
	public PanelPrincipal() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(PanelPrincipal.class.getResource("/Imagenes/logoin.png")));
		setTitle("-------Dicom Fresnillo ---------");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 763, 454);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 69, 0));
		contentPane.setBackground(new Color(220, 220, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Img ob01 = new Img();
		JButton btnEmpleados = new JButton("",ob01.btnEmpleados());
		btnEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AltaEmpleados fm=new  AltaEmpleados();
				fm.setVisible(true);
				fm.setLocation(10, 100);
			}
		});
		btnEmpleados.setBounds(10, 11, 98, 56);
		contentPane.add(btnEmpleados);
		
		Img ob02 = new Img();
		JButton btnFaltas = new JButton("",ob02.btnFaltas());
		btnFaltas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AltaFaltas fm5 = new AltaFaltas();
				fm5.setVisible(true);
				fm5.setLocation(300,100);
			}
		});
		btnFaltas.setBounds(10, 78, 98, 56);
		contentPane.add(btnFaltas);
		
		Img ob03 = new Img();
		JButton btnVacaciones = new JButton("",ob03.btnVacaciones());
		btnVacaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AltaVacaciones fm6 = new AltaVacaciones();
				fm6.setVisible(true);
				fm6.setLocation(300,100);
			}
		});
		btnVacaciones.setBounds(10, 145, 98, 56);
		contentPane.add(btnVacaciones);
		
		Img ob04 = new Img();
		JButton btnLicencia = new JButton("",ob04.btnLicencia());
		btnLicencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        Licencias fm7 = new Licencias();
		        fm7.setVisible(true);
		        fm7.setLocation(300,100);
			}
		});
		btnLicencia.setBounds(10, 212, 98, 56);
		contentPane.add(btnLicencia);
		
		Img ob05 = new Img ();
		JButton btnReportes = new JButton("",ob05.btnReportes());
		btnReportes.setBounds(10, 279, 98, 56);
		contentPane.add(btnReportes);
		
		Img ob06 = new Img();
		JButton btnUsuarios = new JButton("",ob06.btnUsuarios());
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuarios fm8 = new Usuarios();
				fm8.setVisible(true);
				fm8.setLocation(300,100);
				
			}
		});
		btnUsuarios.setBounds(10, 346, 98, 56);
		contentPane.add(btnUsuarios);
		
		Img ob07 = new Img();
		JLabel lblNewLabel = new JLabel(ob07.fondo());
		lblNewLabel.setText("");
		lblNewLabel.setBounds(139, 11, 563, 326);
		contentPane.add(lblNewLabel);
		
		JLabel lblUstedEstaEn = new JLabel("Usted esta en el sistema como :");
		lblUstedEstaEn.setForeground(new Color(128, 0, 0));
		lblUstedEstaEn.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUstedEstaEn.setBounds(154, 388, 206, 14);
		contentPane.add(lblUstedEstaEn);
		
		JLabel lblUsuario = new JLabel("");
		lblUsuario.setText(Iniciar.loger);
		lblUsuario.setForeground(new Color(128, 0, 0));
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUsuario.setBounds(370, 388, 297, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblFecha = new JLabel("");
		lblFecha.setForeground(new Color(128, 0, 0));
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 16));
		relojFecha.fecha(lblFecha);
		lblFecha.setBounds(253, 346, 167, 30);
		contentPane.add(lblFecha);
		
		JLabel lblHora = new JLabel("");
		lblHora.setForeground(new Color(128, 0, 0));
		lblHora.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblHora.setBounds(496, 346, 151, 31);
		contentPane.add(lblHora);
		relojFecha.reloj(lblHora);
		
		Img im01 = new Img();
		JLabel label = new JLabel(im01.calendario());
		label.setBounds(197, 343, 46, 34);
		contentPane.add(label);
		
		Img im02 = new Img();
		JLabel lblNewLabel_1 = new JLabel(im02.reloj());
		lblNewLabel_1.setBounds(440, 343, 46, 34);
		contentPane.add(lblNewLabel_1);
	}
	public void cerrar(){
		k.dispose();
	}
}
