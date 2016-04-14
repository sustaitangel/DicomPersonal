package Empleados;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Conexion.Conectar;

import com.mysql.jdbc.PreparedStatement;

public class Componentes {
	JTextField hola = null;
	Conectar conex = new Conectar();
	java.sql.Connection con = conex.conexion(hola);
	java.sql.Statement list;
	ResultSet rs;
	
	void limpiar(JTextField codigo, JTextField nombre, 
			JTextArea descripcion, JTextField cantidad, JTextField precio){
		codigo.setText("");
		nombre.setText("");
		descripcion.setText("");
		cantidad.setText("");
		precio.setText("");
	}
	
	void mayusculas(KeyEvent e){
		char keyChar = e.getKeyChar();
	    if (Character.isLowerCase(keyChar)) {
	    	e.setKeyChar(Character.toUpperCase(keyChar));
	    }
	}
	
	void numerosEnteros(KeyEvent e){
		char c = e.getKeyChar();
		if(c < '0' || c > '9') e.consume();
	}
	
	void numerosFlotantes(JTextField campo,KeyEvent e){
		char c = e.getKeyChar();
		if ((c < '0' || c > '9') && campo.getText().contains(".") 
				&& (c!=(char)KeyEvent.VK_BACK_SPACE)) {
			e.consume();
		} else if ((c < '0' || c > '9') && (c != '.') && (c!=(char)KeyEvent.VK_BACK_SPACE)) {
			e.consume();
		}
	}
	void habilitar(JButton eliminar, JButton actualizar){
		eliminar.setEnabled(true);
		actualizar.setEnabled(true);
	}
	
	void deshabilitar(JButton eliminar, JButton actualizar){
		eliminar.setEnabled(false);
		actualizar.setEnabled(false);
	}
	
	void eliminarProducto(JTable tableVerEmpleados){
		int replay = JOptionPane.showConfirmDialog(null, "El registro será eliminado. ¿Desea continuar?");
		if (replay == JOptionPane.YES_OPTION) {
			try {
				JTextField hola = null;
				con = conex.conexion(hola);
				String sql = "delete from empleados where num_empleado=" + tableVerEmpleados.getValueAt(tableVerEmpleados.getSelectedRow(), 0);
				list = con.createStatement();
				int n = list.executeUpdate(sql);
				if (n > 0) {
					JOptionPane.showMessageDialog(null, "Registro eliminado correctamente");
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Error " +  e.getMessage());
			}
		} else{}
	}
	void actualizarProductos(JTextField txtNumEmpleado,JTextField txtClaveMinera,
			JTextField txtNombre,JTextField txtApaterno,JTextField txtAmaterno,JTextField txtPuesto,JTextField txtTelefono,
			JTextField txtEdad, JTextField txtEscolaridad,JTextField txtNoimss, JTextField txtRfc, JTextField txtCurp, JTextField txtCalle,
			JTextField txtColonia, JTextField txtCiudad, JTextField txtEstado, JTextField txtEstadoCivil, JTextField txtDeconomicos, JTextField txtNombreEmergencia, JTextField txtTelefonoEmergencia){
		String sql="";
		Conectar cx=new Conectar();
		Connection cn=cx.conexion(null);
		Statement comando;
		con = conex.conexion(hola);
		String existente="SELECT * FROM Empleados WHERE num_empleado='"+txtNumEmpleado.getText()+"'";
		try {
			comando=(Statement) cn.createStatement();
			ResultSet rs= ((java.sql.Statement) comando).executeQuery(existente);
			if(rs.next()){
					PreparedStatement ps;
					
						sql = "update empleados set num_empleado = ?, clave_minera = ?,nombre = ?, apellido_paterno = ?," +
								"apellido_materno = ?, puesto = ?,telefono = ?,edad = ?,escolaridad = ?,no_imss = ?,rfc = ?,curp = ?,calle = ?,colonia = ?, ciudad = ?, estado = ?, estado_civil = ?, dependientes_economicos = ?, nombre_emergencia = ?, telefono_parentesco = ? where num_empleado = '"+txtNumEmpleado.getText()+"'";
						ps = (PreparedStatement) con.prepareStatement(sql);
						
						ps.setString(1, txtNumEmpleado.getText());
						ps.setString(2, txtClaveMinera.getText());
						ps.setString(3, txtNombre.getText());
						ps.setString(4, txtApaterno.getText());
						ps.setString(5, txtAmaterno.getText());
						ps.setString(6, txtPuesto.getText());
						ps.setString(7, txtTelefono.getText());
						ps.setString(8, txtEdad.getText());
						ps.setString(9, txtEscolaridad.getText());
						ps.setString(10, txtNoimss.getText());
						ps.setString(11, txtRfc.getText());
						ps.setString(12, txtCurp.getText());
						ps.setString(13, txtCalle.getText());
						ps.setString(14, txtColonia.getText());
						ps.setString(15, txtCiudad.getText());
						ps.setString(16, txtEstado.getText());
						ps.setString(17, txtEstadoCivil.getText());
						ps.setString(18, txtDeconomicos.getText());
						ps.setString(19, txtNombreEmergencia.getText());
						ps.setString(20, txtTelefonoEmergencia.getText());
			            int n = ps.executeUpdate();
				
				if (n > 0) {
					JOptionPane.showMessageDialog(null, "Registro modificado correctamente");
				}
			}	
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
		}
		
	}
	
}
