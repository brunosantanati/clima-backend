package com.capgemini.clima.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.clima.domain.GeolocalizacaoDados;
import com.capgemini.clima.domain.HttpRequestDados;
import com.capgemini.clima.domain.HttpResponseDados;
import com.capgemini.clima.dto.PrevisaoDoTempoDto;
import com.capgemini.clima.service.HttpRequestService;

@RestController
@RequestMapping("/api")
public class PrevisaoDoTempoController {
	
	@Autowired
	@Qualifier("geolocalizacao")
	HttpRequestService httpRequestService;
	
	@GetMapping(value = "/previsao", produces = MediaType.APPLICATION_JSON_VALUE)
	public PrevisaoDoTempoDto getPrevisaoDoTempo(@RequestParam String endereco) {
		
		String urlServicoGeolocalizacao = "https://api.mapbox.com/geocoding/v5/mapbox.places/" + endereco + ".json?access_token=pk.eyJ1IjoiYnJ1bm9zYW50YW5hdGkiLCJhIjoiY2s4ODFmMHB4MDBkeDNnbXNxOHhqYjBjaiJ9.mj3Dg_SMDKGbiOJ2oyT4Cw&limit=1";
		
		HttpResponseDados responseDto = httpRequestService.executarRequest(urlServicoGeolocalizacao, new HttpRequestDados());
		
		GeolocalizacaoDados objetoRetornoApi = (GeolocalizacaoDados) responseDto.getItem("objetoRetornoApi");
		
		System.out.println(objetoRetornoApi);
		System.out.println(objetoRetornoApi.getFeatures().get(0).getCenter().get(0));
		System.out.println(objetoRetornoApi.getFeatures().get(0).getCenter().get(1));
		System.out.println(objetoRetornoApi.getFeatures().get(0).getPlace_name());
		
		return new PrevisaoDoTempoDto();
	}

}
