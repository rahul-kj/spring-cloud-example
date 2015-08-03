package io.rahul.example;

import io.pivotal.springcloud.ssl.CloudFoundryCertificateTruster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProducerStartupApplication {
	public static void main(String[] args) {
		CloudFoundryCertificateTruster.trustApiCertificate();
		SpringApplication.run(ProducerStartupApplication.class, args);
	}
}
