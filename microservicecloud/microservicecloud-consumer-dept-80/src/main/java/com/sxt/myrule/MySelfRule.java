package com.sxt.myrule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;

/**
 * 这个类，不能与主启动类在同一个包，也不能在主启动类所在包的子包
 * @author Administrator
 *
 */
@Configuration
public class MySelfRule {

	@Bean
	public IRule myRule() {
//		return new RoundRobinRule();
		return new RandomRule_HXM();
	}
}
