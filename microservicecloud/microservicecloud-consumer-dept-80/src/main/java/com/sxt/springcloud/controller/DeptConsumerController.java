package com.sxt.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sxt.springcloud.entities.Dept;

@RestController(value="/consumer/dept")
public class DeptConsumerController {

//	public static final String REST_URL_PREFIX = "http://localhost:8001";
	public static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT";
	/**
	 * 使用restTemplate访问restful接口非常的简单粗暴无脑
	 * url，requestMap, ResponseBean.class 这三个参数分别代表：
	 * url：请求地址
	 * requestMap: 请求参数
	 * ResponseBean.class: http响应转换被转换成的对象类型
	 */
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(value="/add")
	public boolean add(Dept dept) {
		return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
	}
	
	@RequestMapping(value="/get/{id}")
	public Dept get(@PathVariable("id") Long id) {
		return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/list")
	public List<Dept> list() {
		return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
	}
	
	// 测试 @EnableDiscoveryClient，消费者可以调用服务发现
	@RequestMapping(value="/discovery")
	public Object discovery() {
		return restTemplate.getForObject(REST_URL_PREFIX + "/dept/discovery", Object.class);
	}
	
}
