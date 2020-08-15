package com.daniel.coupons.beans;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.daniel.coupons.enums.Category;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "coupons")
public class Coupon {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	
	@Column(name = "company_id", unique = false, nullable = false)
	private long companyId;
	
	@Column(unique = false, nullable = false)
	private String title;
	
	@Enumerated(EnumType.STRING)
	@Column(unique = false, nullable = false)
	private Category category;
	
	@Column(unique = false, nullable = false)
	private String description;
	
	@Column(unique = false, nullable = false)
	private float price;
	
	@Column(unique = false, nullable = false)
	private int couponStock;
	
	@Column(name = "expirationDate", unique = false, nullable = true)
	private Date expirationDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", insertable = false, updatable = false)
	@JsonIgnore
	private Company company;
	
	@OneToMany(mappedBy = "coupon", cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<Purchase>purchases;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public int getCouponStock() {
		return couponStock;
	}

	public void setCouponStock(int couponStock) {
		this.couponStock = couponStock;
	}

	@Override
	public String toString() {
		return "Coupon [id=" + id + ", companyId=" + companyId + ", title=" + title + ", category=" + category
				+ ", description=" + description + ", price=" + price + ", couponStock=" + couponStock
				+ ", expirationDate=" + expirationDate + "]";
	}

}
