package Faltas;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Conexion.Conectar;

import com.mysql.jdbc.PreparedStatement;

public class AgregarFaltas {
	Conectar conex = new Conectar();
	java.sql.Connection con = conex.conexion(null);
	java.sql.Statement list;
	ResultSet rs;
	public void agregar(JTextField txtFolio,JTextField txtNumEmpleado, JTextField txtNombre, JTextField txtApaterno, 
			JTextField txtAmaterno, String fechaF, JTextField txtFaltas){
		try {
			Conectar cx=new Conectar();
			Connection cn=cx.conexion(null);
			JTextField hola = null;
			Statement comando;
			comando=(Statement) cn.createStatement();
			con = conex.conexion(hola);
			String existente="SELECT * FROM faltas_has_empleados WHERE folio='"+txtFolio.getText()+"'";
			ResultSet rs= ((java.sql.Statement) comando).executeQuery(existente);
			if(rs.next()){
				JOptionPane.showMessageDialog(null, "El Producto ya existe");
			}else{
				if(txtFaltas.getText().length()==0){
					txtFaltas.setText("0");
				}
				
					String sql = "insert into faltas_has_empleados (folio,num_empleado,nombre,apellido_paterno," +
							"apellido_materno,fecha,faltas) values (?,?,?,?,?,?,?)";
					PreparedStatement ps = (PreparedStatement) con.prepareCall(sql);
					ps.setString(1, txtFolio.getText());
					ps.setString(2, txtNumEmpleado.getText());
					ps.setString(3, txtNombre.getText());
					ps.setString(4, txtApaterno.getText());
					ps.setString(5, txtAmaterno.getText());
					ps.setString(6, fechaF);
					ps.setString(7, txtFaltas.getText());
					
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
	void actualizarProductos(JTextField txtFolio,JTextField txtNumEmpleado,
			JTextField txtNombre,JTextField txtApaterno,JTextField txtAmaterno,JTextField txtFaltas){
		try {
			String Folio1=txtFolio.getText();
			int FolioF = Integer.parseInt(Folio1);
			int ex=0;
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
							"apellido_materno,total_faltas) values (?,?,?,?,?,?)";
					PreparedStatement ps = (PreparedStatement) con.prepareCall(sql);
					ps.setString(1, txtFolio.getText());
					ps.setString(2, txtNumEmpleado.getText());
					ps.setString(3, txtNombre.getText());
					ps.setString(4, txtApaterno.getText());
					ps.setString(5, txtAmaterno.getText());
					ps.setLong(6, ncant);
					System.out.println(sql);
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
