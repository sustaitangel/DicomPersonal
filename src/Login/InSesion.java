package Login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import Imagenes.Img;
import Principal.Principal;
import Sqls.IniSesion;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InSesion extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField pswContra;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InSesion frame = new InSesion();
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
	public InSesion() {
		setTitle("-----DICOM----Inicio de Sesion ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 423, 167);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBienvendio = new JLabel("BIENVENIDO");
		lblBienvendio.setForeground(new Color(255, 69, 0));
		lblBienvendio.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBienvendio.setBounds(140, 11, 99, 14);
		contentPane.add(lblBienvendio);
		
		Img lg01 = new Img ();
		JLabel lblNewLabel = new JLabel(lg01.login());
		lblNewLabel.setBounds(10, 37, 145, 62);
		contentPane.add(lblNewLabel);
		
		JLabel lblUsuario = new JLabel("Usuario :");
		lblUsuario.setForeground(new Color(255, 69, 0));
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUsuario.setBounds(192, 51, 57, 14);
		contentPane.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char car=e.getKeyChar();
				String vacio=pswContra.getText();
				if(car==KeyEvent.VK_ENTER && vacio.length()==0 ){
					JOptionPane.showMessageDialog(txtUsuario, "Escriba Contraseña");
										
				}
				if(car==KeyEvent.VK_ENTER && vacio.length()!=0) {
						IniSesion ini=new IniSesion();
						ini.iniSecion(txtUsuario, pswContra);
						System.out.println("hola"+IniSesion.conta);
						InSesion.this.dispose();
						if(IniSesion.conta>=5){
						
					}
				}
			}
		});
		txtUsuario.setBounds(255, 49, 116, 20);
		contentPane.add(txtUsuario, "6, 3, 3, 1, fill, top");
		txtUsuario.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a :");
		lblContrasea.setForeground(new Color(255, 69, 0));
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblContrasea.setBounds(165, 74, 84, 14);
		contentPane.add(lblContrasea);
		
		pswContra = new JPasswordField();
		pswContra.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char car=e.getKeyChar();
				if(car==KeyEvent.VK_ENTER){

					String pass=new String(pswContra.getPassword());
					if(pass.length()==0){
						JOptionPane.showMessageDialog(txtUsuario, "Escriba Contraseña");
					}else{
						Iniciar ini=new Iniciar();
						ini.iniSecion(txtUsuario, pswContra);

						System.out.println("hola"+Iniciar.conta);
						if(Iniciar.conta>=5){
								
							JOptionPane.showMessageDialog(txtUsuario,"Ha Excedido el número de intentos");
							Principal x=new Principal();
							x.bloqueo();
	}
}
				}
			}
		});
		contentPane.add(pswContra, "6, 5, 3, 1, fill, top");
		pswContra.setBounds(255, 72, 116, 20);
		contentPane.add(pswContra);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(160, 99, 89, 18);
		contentPane.add(btnCancelar);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pass=new String(pswContra.getPassword());
				if(pass.length()==0){
					JOptionPane.showMessageDialog(txtUsuario, "Escriba Contraseña");
				}else{
					Iniciar ini=new Iniciar();
					ini.iniSecion(txtUsuario, pswContra);

					System.out.println("hola"+Iniciar.conta);
					if(Iniciar.conta>=5){
						
						JOptionPane.showMessageDialog(txtUsuario,"Ha Excedido el número de intentos");
						Principal x=new Principal();
						x.bloqueo();
	}
}
			}
		});
		btnEntrar.setBounds(265, 99, 89, 18);
		contentPane.add(btnEntrar);
	}

}
