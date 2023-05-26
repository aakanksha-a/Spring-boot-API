package com.projectone.projectonedemo;

import java.util.List;

import org.springframework.stereotype.Service;

import com.projectone.projectonedemo.exception.CloudVendorNotFoundException;



@Service
public class CloudVendorServiceImpl implements CloudVendorService{
	
	CloudVendorRepository cloudVendorRepository;
	
	public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
		this.cloudVendorRepository = cloudVendorRepository;
	}

	@Override
	public String createCloudVendor(CloudVendor cloudVendor) {
		cloudVendorRepository.save(cloudVendor);
		return "Success";
	}

	@Override
	public String updateCloudVendor(CloudVendor cloudVendor) {
	
		cloudVendorRepository.save(cloudVendor);
		return "Success";
	}

	@Override
	public String deleteCloudVendor(String cloudVendorId) {
		
		cloudVendorRepository.deleteById(cloudVendorId);
		return "Success";
	}

	@Override
	public CloudVendor getCloudVendor(String cloudVendorId) {
		 
		 if(cloudVendorRepository.findById(cloudVendorId).isEmpty())
	            throw new CloudVendorNotFoundException("Requested Aakanksha's Cloud Vendor does not exist");
	        return cloudVendorRepository.findById(cloudVendorId).get();
		
	}
	
	@Override
	public List<CloudVendor> getAllCloudVendors() {
		
		return cloudVendorRepository.findAll();
	}

	@Override
	public List<CloudVendor> getByVendorName(String vendorName) {
		// TODO Auto-generated method stub
		return cloudVendorRepository.findByVendorName(vendorName);
	}

	

}
