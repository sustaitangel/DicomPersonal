package Faltas;

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
				String sql = "delete from faltas_has_empleados where folio=" + tableVerEmpleados.getValueAt(tableVerEmpleados.getSelectedRow(), 0);
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
	void actualizarProductos(JTextField txtFolio,JTextField txtNumEmpleado,
			JTextField txtNombre,JTextField txtApaterno,JTextField txtAmaterno,String fechaF,JTextField txtFaltas){
		try {
			Conectar cx=new Conectar();
			Connection cn=cx.conexion(null);
			JTextField hola = null;
			Statement comando;
			comando=(Statement) cn.createStatement();
			con = conex.conexion(hola);
			String existente="SELECT * FROM faltas WHERE folio='"+txtFolio.getText()+"'";
			ResultSet rs= ((java.sql.Statement) comando).executeQuery(existente);
			if(rs.next()){
			
			
				String cantidadDtb=rs.getString("total_faltas");
				int cantidad=Integer.parseInt(cantidadDtb);
				String cantidadT= txtFaltas.getText();
				int cantidadTexto=Integer.parseInt(cantidadT);
				int ncant=cantidad+cantidadTexto;
					String sql = "insert into faltas (folio,num_empleado,nombre,apellido_paterno," +
							"apellido_materno,fecha,total_faltas) values (?,?,?,?,?,?,?)";
					PreparedStatement ps = (PreparedStatement) con.prepareCall(sql);
					ps.setString(1, txtFolio.getText());
					ps.setString(2, txtNumEmpleado.getText());
					ps.setString(3, txtNombre.getText());
					ps.setString(4, txtApaterno.getText());
					ps.setString(5, txtAmaterno.getText());
					ps.setString(6, fechaF);
					ps.setLong(7, ncant);
					
					int n = ps.executeUpdate();
					if (n > 0) {
						JOptionPane.showMessageDialog(null, "Registro agregado correctamente");
					}
			}
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
		}
		
	}
	
}
