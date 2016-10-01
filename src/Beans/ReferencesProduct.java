package Beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "references_product")
public class ReferencesProduct implements Serializable {

	public ReferencesProduct(Integer id_reference, String brand, float price, String description) {
		super();
		this.id_reference = id_reference;
		this.brand = brand;
		this.price = price;
		this.description = description;
	}

	public ReferencesProduct() {
	}

	@Override
	public String toString() {
		return "ReferencesProduct [id_reference=" + id_reference + ", brand=" + brand + ", price=" + price
				+ ", description=" + description + "]";
	}

	public Integer getId_reference() {
		return id_reference;
	}

	public void setId_reference(Integer id_reference) {
		this.id_reference = id_reference;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private Integer id_reference;

	private String brand;

	private float price;

	private String description;
}
