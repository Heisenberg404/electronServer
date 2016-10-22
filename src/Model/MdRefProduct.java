package Model;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Beans.ReferencesProduct;
import Utils.Conection;
import oracle.jdbc.OracleTypes;

public class MdRefProduct implements Serializable {

	private static final long serialVersionUID = 1L;

	Conection conn = new Conection();

	ReferencesProduct ref;

	public List<ReferencesProduct> ReadReference() throws Exception {
		List<ReferencesProduct> lstReferenceProduct = new ArrayList<ReferencesProduct>();
		Connection con = conn.getConnection();
		CallableStatement cs = null;
		ResultSet rs = null;
		cs = con.prepareCall("{call PKG_REFERENCES_PRODUCT.Read_REFERENCES_PRODUCT(?)}");
		cs.registerOutParameter(1, OracleTypes.CURSOR);
		cs.execute();
		rs = (ResultSet) cs.getObject(1);

		while (rs.next()) {
			ReferencesProduct rfprod = new ReferencesProduct();

			rfprod.setId_reference(rs.getInt("ID_REFERENCE"));
			rfprod.setBrand(rs.getString("BRAND"));
			rfprod.setPrice(rs.getFloat("PRICE"));
			rfprod.setDescription(rs.getString("DESCRIPTION"));

			lstReferenceProduct.add(rfprod);
		}
		con.close();
		return lstReferenceProduct;

	}

	public void saveRefProduct(ReferencesProduct rp) throws Exception {
		Connection con = conn.getConnection();
		CallableStatement cs = null;
		cs = con.prepareCall("{call PKG_REFERENCES_PRODUCT.Create_REFERENCES_PRODUCT(?,?,?,?,?)}");
		// Parametros del procedimiento almacenado
		cs.setString(1, rp.getBrand());
		cs.setFloat(2, rp.getPrice());
		cs.setString(3, rp.getDescription());
		cs.setBinaryStream(4, rp.getFile().getInputstream());
		// Definimos los tipos de los parametros de salida del procedimiento
		// almacenado
		cs.registerOutParameter(5, java.sql.Types.VARCHAR);
		cs.execute();
		// Se obtienen la salida del procedimineto almacenado
		String back = cs.getString(5);
		System.out.println(back);
		con.close();
	}

	public void updateRefProduct(ReferencesProduct rp) throws Exception {
		Connection con = conn.getConnection();
		CallableStatement cs = null;
		cs = con.prepareCall("{call PKG_REFERENCES_PRODUCT.Update_REFERENCES_PRODUCT(?,?,?,?,?,?)}");
		// Parametros del procedimiento almacenado
		cs.setInt(1, rp.getId_reference());
		cs.setString(2, rp.getBrand());
		cs.setFloat(3, rp.getPrice());
		cs.setString(4, rp.getDescription());
		cs.setBinaryStream(5, rp.getFile().getInputstream());
		// Definimos los tipos de los parametros de salida del procedimiento
		// almacenado
		cs.registerOutParameter(6, java.sql.Types.VARCHAR);
		cs.execute();
		// Se obtienen la salida del procedimineto almacenado
		String back = cs.getString(6);
		System.out.println(back);
		con.close();
	}

	public void deleteRefProduct(ReferencesProduct rp) throws Exception {
		Connection con = conn.getConnection();
		CallableStatement cs = null;
		cs = con.prepareCall("{call PKG_REFERENCES_PRODUCT.Delete_REFERENCES_PRODUCT(?,?)}");
		// Parametros del procedimiento almacenado
		cs.setInt(1, rp.getId_reference());
		// Definimos los tipos de los parametros de salida del procedimiento
		// almacenado
		cs.registerOutParameter(2, java.sql.Types.VARCHAR);
		cs.execute();
		// Se obtienen la salida del procedimineto almacenado
		String back = cs.getString(2);
		System.out.println(back);
		con.close();
	}

	public void cancelar() throws Exception {
		ref = new ReferencesProduct();
	}
}
