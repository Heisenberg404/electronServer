package Model;

import java.sql.CallableStatement;
import java.sql.Connection;
import Beans.Products;
import Utils.Conection;


public class MdProducts {

	Conection conn = new Conection();
	
	public MdProducts()
	{
		super();
	}

	public void saveReference(Products prod) throws Exception {
		Connection con = conn.getConnection();
		CallableStatement cs = null;
		cs = con.prepareCall("{call PKG_PRODUCTS.create_PRODUCTS(?,?,?,?,?,?)}");
		 // Parametros del procedimiento almacenado
		cs.setString(1, prod.getProduct_name());
		cs.setInt(2, prod.getId_reference());
		cs.setInt(3, prod.getId_product_type());
		cs.setInt(4, prod.getQuantity());
		cs.setInt(5, prod.getActive());
		// Definimos los tipos de los parametros de salida del procedimiento almacenado
        cs.registerOutParameter(6, java.sql.Types.VARCHAR);
		cs.execute();
		// Se obtienen la salida del procedimineto almacenado
        String back = cs.getString(6);
        System.out.println(back);

	}
	
}
