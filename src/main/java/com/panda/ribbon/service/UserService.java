package com.panda.ribbon.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class UserService {

	@Autowired
	RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "findAllFallBack")
    public Map findAll() {
        return restTemplate.getForObject("http://PANDA-FRAME/user/findAll",Map.class);
    }
    
	public Map findAllFallBack() {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("rtn", false);
		map.put("info", "获取接口数据失败！");
		return map;
	}
	
}
