package com.projectone.projectonedemo;

import java.util.List;

import com.projectone.projectonedemo.CloudVendor;
import com.projectone.projectonedemo.CloudVendorService;
import com.projectone.projectonedemo.response.ResponseHandler;

import io.swagger.annotations.ApiOperation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/cloudvendor")
public class CloudAPIService {
	CloudVendorService cloudVendorService;
	
	public CloudAPIService(CloudVendorService cloudVendorService) {
		this.cloudVendorService = cloudVendorService;
	}
	
	@GetMapping("{vendorId}")
	@ApiOperation(value ="Cloud Vendor id", notes="Provide cloud vendor details",
					response = ResponseEntity.class)
	public ResponseEntity<Object> getCloudVendorDetails(@PathVariable("vendorId") String vendorId) {
		return ResponseHandler.responseBuilder("Requested vendor details are given here",
				HttpStatus.OK, cloudVendorService.getCloudVendor(vendorId));
		//return cloudVendorService.getCloudVendor(vendorId);
			
	}
	
	@GetMapping()
	public List<CloudVendor> getAllCloudVendorDetails() {
		
		return cloudVendorService.getAllCloudVendors();
			
	}
	
	@PostMapping
	public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
		cloudVendorService.createCloudVendor(cloudVendor);
		return "Aakanksha's Cloud Vendor Created Successfully";
	}
	
	@PutMapping()
	public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
		cloudVendorService.updateCloudVendor(cloudVendor);
		return "Aakanksha's Cloud Vendor updated Successfully";
	}
	
	@DeleteMapping("{vendorId}")
	public String deleteCloudVendorDetails(@PathVariable("vendorId") String vendorId) {
		cloudVendorService.deleteCloudVendor(vendorId);
		return "Aakanksha's Cloud Vendor deleted Successfully";
	}

}
