package Controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import Beans.ReferencesProduct;
import Model.MdRefProduct;

@RequestScoped
@ManagedBean(name = "rfproductsController")
@ViewScoped
public class RefProductController implements Serializable{

	private static final long serialVersionUID = 1L;

	//instanciar un objeto de tipo MdRefProduct
	MdRefProduct rfp = new MdRefProduct();

	//Crear una lista de tipo referencia
	List<ReferencesProduct> lstReferenceProduct = new ArrayList<ReferencesProduct>();
	
	//llama al metodo que obtiene la lista
	public void getlistReferenceProduct() throws Exception
	{
		lstReferenceProduct = rfp.ReadReference();
		
	}
	@PostConstruct
	public void init ()
	{
		try {
			getlistReferenceProduct();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<ReferencesProduct> getLstReferenceProduct() {
		return lstReferenceProduct;
	}

	public void setLstReferenceProduct(List<ReferencesProduct> lstReferenceProduct) {
		this.lstReferenceProduct = lstReferenceProduct;
	}
}
