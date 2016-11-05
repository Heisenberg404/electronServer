package Model;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import Beans.ProductType;
import Utils.Conection;
import oracle.jdbc.OracleTypes;

public class MdProductType implements Serializable {

	private static final long serialVersionUID = 1L;

	Conection conn = new Conection();

	ProductType produd;

	public List<ProductType> ReadProductType() throws Exception {

		List<ProductType> lstProductType = new ArrayList<ProductType>();

		Connection con = conn.getConnection();
		CallableStatement cs = null;
		ResultSet rs = null;

		cs = con.prepareCall("{call PKG_PRODUCTS_TYPE.Read_PRODUCTS_TYPE(?)}");
		cs.registerOutParameter(1, OracleTypes.CURSOR);
		cs.execute();

		rs = (ResultSet) cs.getObject(1);

		while (rs.next()) {
			ProductType rfpt = new ProductType();

			rfpt.setId_product_type(rs.getInt("ID_PRODUCT_TYPE"));
			rfpt.setType_name(rs.getString("TYPE_NAME"));

			lstProductType.add(rfpt);
		}
		con.close();
		return lstProductType;

	}

	public void saveProducType(ProductType pt) throws Exception {
		Connection con = conn.getConnection();
		CallableStatement cs = null;
		cs = con.prepareCall("{call PKG_PRODUCTS_TYPE.Create_PRODUCTS_TYPE(?,?)}");
		// Parametros del procedimiento almacenado
		cs.setString(1, pt.getType_name());
		// Definimos los tipos de los parametros de salida del procedimiento
		// almacenado
		cs.registerOutParameter(2, java.sql.Types.VARCHAR);
		cs.execute();
		// Se obtienen la salida del procedimineto almacenado
		String back = cs.getString(2);
		System.out.println(back);
		con.close();

		if (back.equals("TYPE PRODUCT CREATE")) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info!", "Product Type was created"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Warn!", "Product Type does not exist"));
		}
	}

	public void updateProductType(ProductType pt) throws Exception {
		Connection con = conn.getConnection();
		CallableStatement cs = null;
		cs = con.prepareCall("{call PKG_PRODUCTS_TYPE.Update_PRODUCTS_TYPE(?,?,?)}");
		// Parametros del procedimiento almacenado
		cs.setInt(1, pt.getId_product_type());
		cs.setString(2, pt.getType_name());
		// Definimos los tipos de los parametros de salida del procedimiento
		// almacenado
		cs.registerOutParameter(3, java.sql.Types.VARCHAR);
		cs.execute();
		// Se obtienen la salida del procedimineto almacenado
		String back = cs.getString(3);
		System.out.println(back);
		con.close();

		if (back.equals("TYPE PRODUCT UPDATE")) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info!", "Product Type was updated"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Warn!", "Product Type does not exist"));
		}
	}

	public void deleteProductType(ProductType pt) throws Exception {
		Connection con = conn.getConnection();
		CallableStatement cs = null;
		cs = con.prepareCall("{call PKG_PRODUCTS_TYPE.Delete_PRODUCTS_TYPE(?,?)}");
		// Parametros del procedimiento almacenado
		cs.setInt(1, pt.getId_product_type());
		// Definimos los tipos de los parametros de salida del procedimiento
		// almacenado
		cs.registerOutParameter(2, java.sql.Types.VARCHAR);
		cs.execute();
		// Se obtienen la salida del procedimineto almacenado
		String back = cs.getString(2);
		System.out.println(back);
		con.close();

		if (back.equals("TYPE PRODUCT DELETE")) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info!", "Product Type was deleted"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Warn!", "Product Type does not exist"));
		}
	}

	public void cancelar() throws Exception {
		produd = new ProductType();
	}
}
