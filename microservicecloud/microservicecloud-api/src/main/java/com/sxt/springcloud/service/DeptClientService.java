package com.sxt.springcloud.service;

import java.util.List;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sxt.springcloud.entities.Dept;

//@FeignClient(value = "MICROSERVICECLOUD-DEPT")
@FeignClient(value = "MICROSERVICECLOUD-DEPT", fallbackFactory=DeptClientServiceFallbackFactory.class)
public interface DeptClientService {

	@RequestMapping(value="/dept/add", method = RequestMethod.POST)
	boolean add(@RequestBody Dept dept) ;
	
	@RequestMapping(value="/dept/get/{id}", method = RequestMethod.GET)
	Dept get(@PathVariable("id") Long id) ;
	
	@RequestMapping(value="/dept/list", method = RequestMethod.GET)
	List<Dept> list() ;
}
