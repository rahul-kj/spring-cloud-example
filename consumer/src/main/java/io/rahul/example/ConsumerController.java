package io.rahul.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

//	@Value("${log.consumer.message}")
	String outputMessage = "Default message, cannot use config server for this demo";

	@Autowired
	ConsumerService consumerService;

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	public String getCounter() {
		return consumerService.getCounterValueFromProducer().toString();
	}
	
	@RequestMapping(value = "/message", method = RequestMethod.GET, produces = "application/json")
	public String getMessage() {
		return "String from config server: " + outputMessage;
	}

}
