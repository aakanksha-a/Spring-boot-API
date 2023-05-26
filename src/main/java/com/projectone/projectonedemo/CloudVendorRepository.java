package com.projectone.projectonedemo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface CloudVendorRepository extends JpaRepository<CloudVendor, String>{

	List<CloudVendor> findByVendorName(String vendorName);

}
