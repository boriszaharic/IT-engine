package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Company {
	@Id
	@GeneratedValue
	private long id;
	private String companyName;
	private String companyAddress;
	private String licenceTill;
	private String contactPerson;
	
	@Override
	public String toString() {
		return "Company [id=" + id + ", companyName=" + companyName + ", companyAddress=" + companyAddress
				+ ", licenceTill=" + licenceTill + ", contactPerson=" + contactPerson + "]";
	}
	public Company() {
	}
	public Company(String companyName, String companyAddress, String licenceTill, String contactPerson) {
		this.companyName = companyName;
		this.companyAddress = companyAddress;
		this.licenceTill = licenceTill;
		this.contactPerson = contactPerson;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public String getLicenceTill() {
		return licenceTill;
	}
	public void setLicenceTill(String licenceTill) {
		this.licenceTill = licenceTill;
	}
	public String getContactPerson() {
		return contactPerson;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
}
