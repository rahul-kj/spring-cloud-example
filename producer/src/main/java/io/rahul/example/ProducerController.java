package io.rahul.example;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

	AtomicInteger counter = new AtomicInteger();

	@Value("${log.counter.message}")
	String logCounterMessage;

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	public String getCounter() {
		int value = counter.getAndIncrement();
		System.out.println(logCounterMessage + " " + value);
		return String.format("{\"value\":%d}", value);
	}
}