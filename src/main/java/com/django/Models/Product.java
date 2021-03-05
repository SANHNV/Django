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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}

	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}
    
    //#endregion
    
}
