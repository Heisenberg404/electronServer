package Controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import Beans.Products;
import Model.MdProducts;;

@RequestScoped
@ManagedBean(name = "productsController")
@ViewScoped
public class ProductsController implements Serializable{

	private static final long serialVersionUID = 1L;
	
}
