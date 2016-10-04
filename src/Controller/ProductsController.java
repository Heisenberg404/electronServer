package Controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import Beans.Products;
import Model.MdProducts;;

@RequestScoped
@ManagedBean(name = "productsController")
@ViewScoped
public class ProductsController implements Serializable {

	private static final long serialVersionUID = 1L;

	MdProducts mdproducts = new MdProducts();

	List<Products> lstProducts = new ArrayList<Products>();

	public List<Products> getLstProducts() {
		return lstProducts;
	}

	public void setLstProducts(List<Products> lstProducts) {
		this.lstProducts = lstProducts;
	}

	public void saveProduct(Products prod) {
		try {
			mdproducts.saveProducts(prod);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void getlistProducts() throws Exception {

		lstProducts = mdproducts.ReadProduct();
	}

	@PostConstruct
	public void init() {
		try {
			getlistProducts();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
