package Controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import Beans.ProductType;
import Model.MdProductType;

@RequestScoped
@ManagedBean(name = "pt_controller")
@ViewScoped
public class ProductTypeController implements Serializable {

	private static final long serialVersionUID = 1L;

	List<ProductType> lstProductType = new ArrayList<ProductType>();

	MdProductType pt = new MdProductType();

	public List<ProductType> getLstProductType() {
		return lstProductType;
	}

	public void setLstProductType(List<ProductType> lstProductType) {
		this.lstProductType = lstProductType;
	}

	//Obtiene la lista de tipo producto
	public void getlistProductType() throws Exception {

		lstProductType = pt.ReadProductType();

	}

	@PostConstruct
	public void init() {
		try {
			getlistProductType();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void saveProductType(ProductType prtype)
	{
		try {
			pt.saveProducType(prtype);
			lstProductType = pt.ReadProductType();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteProductType (ProductType prtype)
	{
		try {
			pt.deleteProductType(prtype);
			lstProductType = pt.ReadProductType();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateProductType (ProductType prtype)
	{
		try {
			pt.updateProductType(prtype);
			lstProductType = pt.ReadProductType();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
