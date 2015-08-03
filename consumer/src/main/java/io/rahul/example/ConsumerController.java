package io.rahul.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

	// @Value("${output.message}")
	String outputMessage;

	@Autowired
	ConsumerService consumerService;

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	public String getController() {

		return consumerService.getValueFromProducer().toString();
	}

}
