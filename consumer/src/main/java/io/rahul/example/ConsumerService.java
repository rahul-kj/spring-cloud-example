package io.rahul.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class ConsumerService {

	@Autowired
	@LoadBalanced
	RestTemplate restTemplate;

	@Autowired
	DiscoveryClient discoveryClient;

	@HystrixCommand(fallbackMethod = "getDefaultValue")
	public Counter getValueFromProducer() {
		InstanceInfo instanceInfo = discoveryClient.getNextServerFromEureka(
		        "PRODUCER", false);
		RestTemplate restTemplate = new RestTemplate();
		Counter counter = restTemplate.getForObject(
		        instanceInfo.getHomePageUrl(), Counter.class);

		System.out.println("Response from Producer : " + counter.getValue());
		return counter;
	}

	Counter getDefaultValue() {
		Counter counter = new Counter();
		counter.setValue(-1);
		return counter;
	}
}
