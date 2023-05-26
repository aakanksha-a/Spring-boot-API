package com.projectone.projectonedemo;
import com.projectone.projectonedemo.CloudVendor;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
public class CloudVendorRepositoryTest {
	
//	methodOne(input){
//		stat1;
//		stat2;
//		.....
//		output
//	}
//	
//	provided / given - when there is exe - then ans/ out ...
//	given - when - then
	
	
	@Autowired
	private CloudVendorRepository cloudVendorRepository;
	CloudVendor cloudVendor;
	
	@BeforeEach
	void setUp() {
		cloudVendor = new CloudVendor("1","Amazon","USA", "XXX");
		cloudVendorRepository.save(cloudVendor);
	}
	
	@AfterEach
	void tearDown() {
		cloudVendor = null;
		cloudVendorRepository.deleteAll();
		
	}
	// test cases success
	@Test
	void testFindbyVendorName_Found() {
		List<CloudVendor> cloudVendorList=cloudVendorRepository.findByVendorName("Amazon");
		Assertions.assertThat(cloudVendorList.get(0).getVendorId()).isEqualTo(cloudVendor.getVendorId());
		Assertions.assertThat(cloudVendorList.get(0).getVendorAddress())
                .isEqualTo(cloudVendor.getVendorAddress());
	}
	
	
	// test cases fail
	@Test
	void testFindbyVendorName_NotFound() {
		List<CloudVendor> cloudVendorList = cloudVendorRepository.findByVendorName("GCP");
		Assertions.assertThat(cloudVendorList.isEmpty()).isTrue();
		}
	

	
}
