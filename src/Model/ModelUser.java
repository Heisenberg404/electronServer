package Model;

import java.sql.CallableStatement;
import java.sql.Connection;
import Beans.Users;
import Utils.Conection;

public class ModelUser {
	

	public ModelUser() {
		super();
	}

	Conection conn = new Conection();

	public void saveUser(Users ref) throws Exception {
		Connection con = conn.getConnection();
		CallableStatement cs = null;
		cs = con.prepareCall("{call PKG_Users.create_users(?,?,?,?,?,?,?)}");
		 // Parametros del procedimiento almacenado
		cs.setString(1, ref.getUsername());
		cs.setString(2, ref.getPass());
		cs.setString(3, ref.getComplete_name());
		cs.setString(4, ref.getLast_name());
		cs.setString(5, ref.getEmail());
		cs.setInt(6, ref.getNumber());
		// Definimos los tipos de los parametros de salida del procedimiento almacenado
        cs.registerOutParameter(7, java.sql.Types.VARCHAR);
		cs.execute();
		// Se obtienen la salida del procedimineto almacenado
        String back = cs.getString(7);
        System.out.println(back);

	}
}