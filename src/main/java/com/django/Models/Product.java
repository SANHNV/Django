package com.django.Models;

public class Product {

    //#region Private Properties
	
	private Integer idProduit;
    private String name;
    private String price;
    private String image;

    //#endregion
        
    //#region Constructor
    
	/**
	 * @param idProduit
	 * @param name
	 * @param price
	 * @param image
	 */
	public Product(Integer idProduit, String name, String price, String image) {
		super();
		this.idProduit = idProduit;
		this.name = name;
		this.price = price;
		this.image = image;
	}
	
    //#endregion

    //#region Getter & Setter

	/**
	 * @return the idProduit
	 */
	public Integer getIdProduit() {
		return idProduit;
	}
	/**
	 * @param idProduit the idProduit to set
	 */
	public void setIdProduit(Integer idProduit) {
		this.idProduit = idProduit;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}
	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}
	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}
    
    //#endregion
    
}
