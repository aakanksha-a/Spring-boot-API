package com.projectone.projectonedemo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="cloud_vendor_info")
@ApiModel(description = "This table contains Cloud Vendor information.")
public class CloudVendor {
	
	@Id
	@ApiModelProperty(notes="This id a Cloud Vendor Id. Keep it unique")
	private String vendorId;
	private String vendorName;
	private String vendorAddress;
	private String vendorPhoneNumber;
	
	public CloudVendor(String vendorId, String vendorName, String vendorAddress, String vendorPhoneNumber) {
		this.vendorId = vendorId;
		this.vendorName = vendorName;
		this.vendorAddress = vendorAddress;
		this.vendorPhoneNumber = vendorPhoneNumber;
	}

	public CloudVendor() {
		
	}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getVendorAddress() {
		return vendorAddress;
	}

	public void setVendorAddress(String vendorAddress) {
		this.vendorAddress = vendorAddress;
	}

	public String getVendorPhoneNumber() {
		return vendorPhoneNumber;
	}

	public void setVendorPhoneNumber(String vendorPhoneNumber) {
		this.vendorPhoneNumber = vendorPhoneNumber;
	}
	
	
	
	
}
