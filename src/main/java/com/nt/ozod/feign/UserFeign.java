package com.nt.ozod.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "USER-SERVICE")
public interface UserFeign {
	
	@GetMapping("/user/msg")
	public String msg();

}
