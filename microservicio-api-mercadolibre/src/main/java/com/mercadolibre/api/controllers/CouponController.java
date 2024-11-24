package com.mercadolibre.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mercadolibre.api.models.dto.Calculus;
import com.mercadolibre.api.models.dto.CalculusResponse;
import com.mercadolibre.api.services.ItemsService;

@RestController
public class CouponController {

	@Autowired
	private ItemsService itemsService;

	@PostMapping("/coupon")
	public ResponseEntity<CalculusResponse> coupon(@RequestBody Calculus calculus) {
		return itemsService.executeCalculation(calculus);
	}

}
