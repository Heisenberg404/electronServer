package Beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

import org.primefaces.model.UploadedFile;

@ManagedBean(name = "references_product")
public class ReferencesProduct implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id_reference;
	private String brand;
	private float price;
	private String description;
	private UploadedFile file;
	
	

	public ReferencesProduct(int id_reference, String brand, float price, String description, UploadedFile file) {
		super();
		this.id_reference = id_reference;
		this.brand = brand;
		this.price = price;
		this.description = description;
		this.file = file;
	}

	public ReferencesProduct() {
	}

	@Override
	public String toString() {
		return "ReferencesProduct [id_reference=" + id_reference + ", brand=" + brand + ", price=" + price
				+ ", description=" + description + "]";
	}

	public int getId_reference() {
		return id_reference;
	}

	public void setId_reference(int id_reference) {
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
	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	
}
