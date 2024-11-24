package com.mercadolibre.api.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mercadolibre.api.clients.MercadoLibreClient;
import com.mercadolibre.api.models.dto.Calculus;
import com.mercadolibre.api.models.dto.CalculusResponse;
import com.mercadolibre.api.models.dto.Item;

@Service
public class ItemsServiceImpl implements ItemsService {

	private Float bestAmount = 0f;

	@Autowired
	private MercadoLibreClient mercadoLibreClient;

	@Override
	public ResponseEntity<CalculusResponse> executeCalculation(Calculus calculus) {
		Map<String, Float> itemsMap = getItems(calculus.getItems_ids());
		Map<String, Float> orderedItemsMap = orderItems(itemsMap);
		List<String> finalItemsList = calculate(orderedItemsMap, calculus.getAmount());
		CalculusResponse response = new CalculusResponse();
		response.setItems_ids(finalItemsList);
		response.setTotal(bestAmount);
		if (finalItemsList.size() > 0) {
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

	private Map<String, Float> getItems(List<String> itemsList) {
		Map<String, Float> items = new HashMap<>();
		for (String itemId : itemsList) {
			Item item = mercadoLibreClient.getItemById(itemId);
			if (!items.containsKey(item.getId()) && item != null) {
				items.put(item.getId(), item.getPrice());
			}
		}
		return items;
	}

	private Map<String, Float> orderItems(Map<String, Float> itemsMap) {
		List<Entry<String, Float>> orderedItemsList = new ArrayList<>(itemsMap.entrySet());
		orderedItemsList.sort(Entry.comparingByValue());
		Map<String, Float> orderedItemsMap = new LinkedHashMap<>();
		for (Entry<String, Float> entry : orderedItemsList) {
			orderedItemsMap.put(entry.getKey(), entry.getValue());
		}
		return orderedItemsMap;
	}

	private List<String> calculate(Map<String, Float> items, Float amount) {
		this.bestAmount = 0f;
		List<String> idsToReturn = new ArrayList<>();
		for (String key : items.keySet()) {
			Float miminumPrice = items.get(key);
			if (miminumPrice <= items.get(key) && (this.bestAmount + miminumPrice) <= amount
					&& !idsToReturn.contains(key)) {
				idsToReturn.add(key);
				this.bestAmount = this.bestAmount + miminumPrice;
			}
		}
		return idsToReturn;
	}

}
