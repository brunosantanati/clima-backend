package com.capgemini.clima.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.clima.dto.PrevisaoDoTempoDto;
import com.capgemini.clima.service.PrevisaoDoTempoService;

@RestController
@RequestMapping("/api")
public class PrevisaoDoTempoController {
	
	@Autowired
	PrevisaoDoTempoService previsaoDoTempoService;
	
	@GetMapping(value = "/previsao", produces = MediaType.APPLICATION_JSON_VALUE)
	public PrevisaoDoTempoDto getPrevisaoDoTempo(@RequestParam String endereco) {
		
		return previsaoDoTempoService.getPrevisaoDoTempo(endereco);
		
	}

}
