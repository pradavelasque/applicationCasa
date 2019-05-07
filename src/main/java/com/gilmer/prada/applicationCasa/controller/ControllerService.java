package com.gilmer.prada.applicationCasa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gilmer.prada.applicationCasa.objets.CasaMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api")
@ImportResource("classpath:context1.xml")
public class ControllerService {

	public static final Logger logger = LoggerFactory.getLogger(ControllerService.class);

	@Value("{service.instance.name}")
	public String instance;

	@PostMapping
	public void enregistrerMessage() {

	}

	@Autowired
	BeanA beanA;

	@GetMapping("obtenirMessage/{id}")
	public ResponseEntity<?> obtenirMessage() {

		CasaMessage message = new CasaMessage();// va chercher dans la bd
		message.setMessage("reveille toi je passe par " + instance);

		System.out.println("BeanA member: " + beanA.getMessage());

		return new ResponseEntity<CasaMessage>(message, HttpStatus.OK);

	}

}
