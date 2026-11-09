package com.elpris.elprisapi.controller;

import com.elpris.elprisapi.model.Price;
import com.elpris.elprisapi.service.PriceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

@RestController
@RequestMapping("/api/prices")
public class PriceController {

    private final PriceService priceService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping("/today")
    public Price[] getToday() {
        return priceService.getTodayPrices();
    }

    @GetMapping("/avg")
    public double getAvg() {
        return priceService.getAveragePrice();
    }

    @ExceptionHandler(RestClientException.class)
    public ResponseEntity<String> handleApiError(RestClientException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_GATEWAY)
                .body("Kunde inte hämta elpriser från det externa API:et");
    }
}
