package Beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "products")
public class Products implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id_product;

	private String product_name;

	public Products() {

	}

	public Products(int id_product, String product_name, int id_reference, int id_product_type, int quantity,
			int active) {
		super();
		this.id_product = id_product;
		this.product_name = product_name;
		this.id_reference = id_reference;
		this.id_product_type = id_product_type;
		this.quantity = quantity;
		this.active = active;
	}

	@Override
	public String toString() {
		return "Products [id_product=" + id_product + ", product_name=" + product_name + ", id_reference="
				+ id_reference + ", id_product_type=" + id_product_type + ", quantity=" + quantity + ", active="
				+ active + "]";
	}

	public int getId_product() {
		return id_product;
	}

	public void setId_product(int id_product) {
		this.id_product = id_product;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getId_reference() {
		return id_reference;
	}

	public void setId_reference(int id_reference) {
		this.id_reference = id_reference;
	}

	public int getId_product_type() {
		return id_product_type;
	}

	public void setId_product_type(int id_product_type) {
		this.id_product_type = id_product_type;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	private int id_reference;

	private int id_product_type;

	private int quantity;

	private int active;
}
