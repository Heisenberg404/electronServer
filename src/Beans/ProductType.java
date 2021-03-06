package Beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="product_type")
public class ProductType implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private int id_product_type;
	
	private String type_name;

	public int getId_product_type() {
		return id_product_type;
	}

	public void setId_product_type(int id_product_type) {
		this.id_product_type = id_product_type;
	}

	public String getType_name() {
		return type_name;
	}

	public void setType_name(String type_name) {
		this.type_name = type_name;
	}

	public ProductType(int id_product_type, String type_name) {
		super();
		this.id_product_type = id_product_type;
		this.type_name = type_name;
	}
	
	public ProductType()
	{
		
	}

	@Override
	public String toString() {
		return "ProductType [id_product_type=" + id_product_type + ", type_name=" + type_name + "]";
	}

}
