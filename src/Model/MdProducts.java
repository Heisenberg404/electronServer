package Model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import Beans.Products;
import Utils.Conection;
import oracle.jdbc.OracleTypes;

public class MdProducts {

	Conection conn = new Conection();

	Products prod;

	public MdProducts() {
		super();
	}

	public void saveProducts(Products prod) throws Exception {
		Connection con = conn.getConnection();
		CallableStatement cs = null;
		cs = con.prepareCall("{call PKG_PRODUCTS.Create_PRODUCTS(?,?,?,?,?,?)}");
		// Parametros del procedimiento almacenado
		cs.setString(1, prod.getProduct_name());
		cs.setInt(2, prod.getId_reference());
		cs.setInt(3, prod.getId_product_type());
		cs.setInt(4, prod.getQuantity());
		cs.setInt(5, prod.getActive());
		// Definimos los tipos de los parametros de salida del procedimiento
		// almacenado
		cs.registerOutParameter(6, java.sql.Types.VARCHAR);
		cs.execute();
		// Se obtienen la salida del procedimineto almacenado
		String back = cs.getString(6);
		System.out.println(back);
		con.close();

		if (back.equals("PRODUCT CREATE")) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info!", "Product was created"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Info!", "Product exist"));
		}
	}

	public List<Products> ReadProduct() throws Exception {
		List<Products> lstProducts = new ArrayList<Products>();
		Connection con = conn.getConnection();
		CallableStatement cs = null;
		ResultSet rs = null;
		cs = con.prepareCall("{call PKG_PRODUCTS.Read_PRODUCTS(?)}");
		cs.registerOutParameter(1, OracleTypes.CURSOR);
		cs.execute();
		rs = (ResultSet) cs.getObject(1);

		while (rs.next()) {
			Products pr = new Products();

			pr.setId_product(rs.getInt("ID_PRODUCT"));
			pr.setProduct_name(rs.getString("PRODUCT_NAME"));
			pr.setId_reference(rs.getInt("ID_REFERENCE"));
			pr.setId_product_type(rs.getInt("ID_PRODUCT_TYPE"));
			pr.setQuantity(rs.getInt("QUANTITY"));
			pr.setActive(rs.getInt("ACTIVE"));

			lstProducts.add(pr);
		}
		con.close();
		return lstProducts;

	}

	public void updateProducts(Products prod) throws Exception {
		Connection con = conn.getConnection();
		CallableStatement cs = null;
		cs = con.prepareCall("{call PKG_PRODUCTS.Update_PRODUCTS(?,?,?,?,?,?,?)}");
		// Parametros del procedimiento almacenado
		cs.setInt(1, prod.getId_product());
		cs.setString(2, prod.getProduct_name());
		cs.setInt(3, prod.getId_reference());
		cs.setInt(4, prod.getId_product_type());
		cs.setInt(5, prod.getQuantity());
		cs.setInt(6, prod.getActive());
		// Definimos los tipos de los parametros de salida del procedimiento
		// almacenado
		cs.registerOutParameter(7, java.sql.Types.VARCHAR);
		cs.execute();
		// Se obtienen la salida del procedimineto almacenado
		String back = cs.getString(7);
		System.out.println(back);
		con.close();

		if (back.equals("PRODUCT UPDATE")) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info!", "Product was updated"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Warn!", "Product does not exist"));
		}
	}

	public void deleteProducts(Products prod) throws Exception {
		Connection con = conn.getConnection();
		CallableStatement cs = null;
		cs = con.prepareCall("{call PKG_PRODUCTS.Delete_PRODUCTS(?,?)}");
		// Parametros del procedimiento almacenado
		cs.setInt(1, prod.getId_product());
		// Definimos los tipos de los parametros de salida del procedimiento
		// almacenado
		cs.registerOutParameter(2, java.sql.Types.VARCHAR);
		cs.execute();
		// Se obtienen la salida del procedimineto almacenado
		String back = cs.getString(2);
		System.out.println(back);
		con.close();

		if (back.equals("")) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info!", "Product was deleted"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Warn!", "Product does not exist"));
		}
	}

	public void cancelar() throws Exception {
		prod = new Products();
	}
}
