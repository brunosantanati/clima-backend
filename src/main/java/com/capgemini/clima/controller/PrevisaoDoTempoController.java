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
import com.capgemini.clima.domain.PrevisaoDoTempoDados;
import com.capgemini.clima.dto.PrevisaoDoTempoDto;
import com.capgemini.clima.service.HttpRequestService;

@RestController
@RequestMapping("/api")
public class PrevisaoDoTempoController {
	
	@Autowired
	@Qualifier("geolocalizacao")
	HttpRequestService geolocalizacaoService;
	
	@Autowired
	@Qualifier("previsaoDoTempo")
	HttpRequestService previsaoDoTempoService;
	
	@GetMapping(value = "/previsao", produces = MediaType.APPLICATION_JSON_VALUE)
	public PrevisaoDoTempoDto getPrevisaoDoTempo(@RequestParam String endereco) {
		
		String urlServicoGeolocalizacao = "https://api.mapbox.com/geocoding/v5/mapbox.places/" + endereco + ".json?access_token=pk.eyJ1IjoiYnJ1bm9zYW50YW5hdGkiLCJhIjoiY2s4ODFmMHB4MDBkeDNnbXNxOHhqYjBjaiJ9.mj3Dg_SMDKGbiOJ2oyT4Cw&limit=1";
		
		HttpResponseDados dadosRespostaGeo = geolocalizacaoService.executarRequest(urlServicoGeolocalizacao, new HttpRequestDados());
		
		GeolocalizacaoDados objetoRetornoApiGeo = (GeolocalizacaoDados) dadosRespostaGeo.getItem("objetoRetornoApiGeo");
		
		Float latitude = objetoRetornoApiGeo.getFeatures().get(0).getCenter().get(1);
		Float longitude = objetoRetornoApiGeo.getFeatures().get(0).getCenter().get(0);
		String localizacao = objetoRetornoApiGeo.getFeatures().get(0).getPlace_name();
		
		String urlServicoPrevisaoDoTempo = "https://api.darksky.net/forecast/70ff7c58595674b62c6cb99468310588/" + latitude + "," + longitude + "?units=si&lang=pt";
		
		HttpResponseDados dadosRespostaPrevisao = previsaoDoTempoService.executarRequest(urlServicoPrevisaoDoTempo, new HttpRequestDados());
		
		PrevisaoDoTempoDados objetoRetornoApiPrevisao = (PrevisaoDoTempoDados) dadosRespostaPrevisao.getItem("objetoRetornoApiPrevisao");
		
		System.out.println(objetoRetornoApiPrevisao);
		String resumo = objetoRetornoApiPrevisao.getDaily().getData().get(0).getSummary();
		float humidade = objetoRetornoApiPrevisao.getDaily().getData().get(0).getHumidity();
		float temperatura = objetoRetornoApiPrevisao.getCurrently().getTemperature();
		short chancesDeChover = objetoRetornoApiPrevisao.getCurrently().getPrecipProbability();
		
		PrevisaoDoTempoDto previsaoDoTempoDto = new PrevisaoDoTempoDto();
		previsaoDoTempoDto.setLocalizacao(localizacao);
		previsaoDoTempoDto.setResumo(resumo);
		previsaoDoTempoDto.setEndereco(endereco);
		previsaoDoTempoDto.setHumidade("Humidade: " + humidade);
		previsaoDoTempoDto.setTemperaturaAtual("Temperatura Atual: " + temperatura);
		previsaoDoTempoDto.setChancesDeChover("Existe " + chancesDeChover + " chances de chover");
		
		return previsaoDoTempoDto;
	}

}
