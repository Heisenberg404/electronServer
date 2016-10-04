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

public class MdRefProduct implements Serializable{

	private static final long serialVersionUID = 1L;
	
	Conection conn = new Conection();

	public List<ReferencesProduct> ReadReference()throws Exception{
		List<ReferencesProduct> lstReferenceProduct = new ArrayList<ReferencesProduct>();
		Connection con = conn.getConnection();
		CallableStatement cs = null;
		ResultSet rs = null;
		cs = con.prepareCall("{call PKG_REFERENCES_PRODUCT.Read_REFERENCES_PRODUCT(?)}");
		cs.registerOutParameter(1, OracleTypes.CURSOR);
		cs.execute();
		rs = (ResultSet) cs.getObject(1);
		
		while (rs.next()) 
		{
			ReferencesProduct rfprod = new ReferencesProduct();
			
			rfprod.setId_reference(rs.getInt("ID_REFERENCE"));
			rfprod.setBrand(rs.getString("BRAND"));
			rfprod.setPrice(rs.getFloat("PRICE"));
			rfprod.setDescription(rs.getString("DESCRIPTION"));
			
			lstReferenceProduct.add(rfprod);
		}
		
		return lstReferenceProduct;
		
	}
}
