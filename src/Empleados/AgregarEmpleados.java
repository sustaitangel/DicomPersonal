package Empleados;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Conexion.Conectar;

import com.mysql.jdbc.PreparedStatement;

public class AgregarEmpleados {
	Conectar conex = new Conectar();
	java.sql.Connection con = conex.conexion(null);
	java.sql.Statement list;
	ResultSet rs;
	public void agregar(JTextField txtNumEmpleado, JTextField txtClaveMinera, JTextField txtNombre, JTextField txtApaterno, 
			JTextField txtAmaterno, int tipo, JTextField txtPuesto,JTextField txtTelefono, String Fecha, JTextField txtEdad , 
			JTextField txtEscolaridad, JTextField txtNoimss, JTextField txtRfc, JTextField txtCurp, int tipoS, 
			JTextField txtCalle, JTextField txtColonia, JTextField txtCiudad, JTextField txtEstado, JTextField txtEstadoCivil,
			JTextField txtDeconomicos, int tipoSa, String Fecha1, String Fecha2, JTextField txtNombreEmergencia, int tipoP,
			JTextField txtTelefonoEmergencia, String pathArchivo){
		try {
			Conectar cx=new Conectar();
			Connection cn=cx.conexion(null);
			JTextField hola = null;
			Statement comando;
			comando=(Statement) cn.createStatement();
			con = conex.conexion(hola);
			String existente="SELECT * FROM empleados WHERE num_empleado='"+txtNumEmpleado.getText()+"'";
			ResultSet rs= ((java.sql.Statement) comando).executeQuery(existente);
			if(rs.next()){
				JOptionPane.showMessageDialog(null, "El Producto ya existe");
			}else{
				if(txtClaveMinera.getText().length()==0){
					txtClaveMinera.setText("0");
				}
				
					String sql = "insert into empleados (num_empleado,clave_minera,nombre,apellido_paterno,apellido_materno,area_id_area," +
							"puesto,telefono,fecha_nacimiento,edad,escolaridad,no_imss,rfc,curp,sexo_id_sexo,calle,colonia,ciudad,estado,estado_civil,dependientes_economicos,sangre_id_sangre,fecha_inicio,fecha_termino,nombre_emergencia,parentesco_id_parentesco,telefono_parentesco,foto) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement ps = (PreparedStatement) con.prepareCall(sql);
					ps.setString(1, txtNumEmpleado.getText());
					ps.setString(2, txtClaveMinera.getText());
					ps.setString(3, txtNombre.getText());
					ps.setString(4, txtApaterno.getText());
					ps.setString(5, txtAmaterno.getText());
					ps.setLong(6, tipo);
					ps.setString(7, txtPuesto.getText());
					ps.setString(8, txtTelefono.getText());
					ps.setString(9, Fecha);
					ps.setString(10, txtEdad.getText());
					ps.setString(11, txtEscolaridad.getText());
					ps.setString(12, txtNoimss.getText());
					ps.setString(13, txtRfc.getText());
					ps.setString(14, txtCurp.getText());
					ps.setLong(15, tipoS);
					ps.setString(16, txtCalle.getText());
					ps.setString(17, txtColonia.getText());
					ps.setString(18, txtCiudad.getText());
					ps.setString(19, txtEstado.getText());
					ps.setString(20, txtEstadoCivil.getText());
					ps.setString(21, txtDeconomicos.getText());
					ps.setLong(22, tipoSa);
					ps.setString(23, Fecha1);
					ps.setString(24, Fecha2);
					ps.setString(25, txtNombreEmergencia.getText());
					ps.setLong(26, tipoP);
					ps.setString(27, txtTelefonoEmergencia.getText());
					ps.setString(28, pathArchivo);

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
