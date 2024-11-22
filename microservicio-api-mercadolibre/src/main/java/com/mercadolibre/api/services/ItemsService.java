package com.mercadolibre.api.services;

import org.springframework.http.ResponseEntity;

import com.mercadolibre.api.models.dto.Calculus;
import com.mercadolibre.api.models.dto.CalculusResponse;

public interface ItemsService {

	public ResponseEntity<CalculusResponse> executeCalculation(Calculus calculo);

}
