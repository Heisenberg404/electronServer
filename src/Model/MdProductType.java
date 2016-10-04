package Model;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Beans.ProductType;
import Utils.Conection;
import oracle.jdbc.OracleTypes;

public class MdProductType implements Serializable {

	private static final long serialVersionUID = 1L;

	Conection conn = new Conection();

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

		return lstProductType;

	}
}
