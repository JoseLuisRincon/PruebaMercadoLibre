package com.mercadolibre.api.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mercadolibre.api.models.dto.Item;

@FeignClient(name = "mercadolibre", url = "${mercadolibre.api.url}")
public interface MercadoLibreClient {

	@GetMapping("items/{itemId}")
	public Item getItemById(@PathVariable String itemId);

}
