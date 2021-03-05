package com.django.Models;

import java.sql.Timestamp;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Product")
public class Product {

    //#region Private Properties
	@Id
	private Integer idProduct;
    @Basic(optional = false)
    private String name;
    @Basic(optional = false)
    private String price;
    @Basic(optional = false)
    private String image;
    @Basic(optional = false)
    private Timestamp limitDate;
    @Basic(optional = false)
    private double quantity;

    //#endregion
        
    //#region Constructor
    
	/**
     * Constructor
     * @param idProduct
     * @param name
     * @param price
     * @param image
     * @param limitDate
     * @param quantity
     */
	public Product(Integer idProduct, String name, String price, String image, Timestamp limitDate, double quantity) {
		super();
		this.idProduct = idProduct;
		this.name = name;
		this.price = price;
		this.image = image;
        this.limitDate = limitDate;
        this.quantity = quantity;
	}
	
    //#endregion

    //#region Getter & Setter

	/**
	 * @return the idProduct
	 */
    @Column(name = "idProduct", nullable = false)
	public Integer getIdProduct() {
		return idProduct;
	}

	/**
	 * @return the name
	 */
    @Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}

	/**
	 * @return the price
	 */
    @Column(name = "price", nullable = false)
	public String getPrice() {
		return price;
	}

	/**
	 * @return the image
	 */
    // SI CA PLANTE C'EST LA
    @Column(name = "image", nullable = false, columnDefinition = "String default placeholder.png")
	public String getImage() {
		return image;
	}

    /**
	 * @return the limit date
	 */
    @Column(name = "limitDate", nullable = false)
	public Timestamp getLimitDate() {
		return limitDate;
	}

    /**
	 * @return the quantity
	 */
    @Column(name = "quantity", nullable = false)
	public double getQuantity() {
		return quantity;
	}
    
    //#endregion
    
}
