package com.poly.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Customes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "address")
	private String address;

	@Column(name = "status")
	private int status;

	@Column(name = "categoryid")
	private int categoryid;
	
	@ManyToOne
	@JoinColumn(name = "categoryid", referencedColumnName = "id", insertable = false, updatable = false)
	categoryid category;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	public categoryid getCategory() {
		return category;
	}

	public void setCategory(categoryid category) {
		this.category = category;
	}

	public Customes(Long id, String name, String address, int status, int categoryid,
			com.poly.model.categoryid category) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.status = status;
		this.categoryid = categoryid;
		this.category = category;
	}

	public Customes() {
		super();
	}



}
