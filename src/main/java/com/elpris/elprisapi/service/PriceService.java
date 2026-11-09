package com.elpris.elprisapi.service;

import com.elpris.elprisapi.client.ElectricityApiClient;
import com.elpris.elprisapi.model.Price;
import org.springframework.stereotype.Service;

@Service
public class PriceService {

    private final ElectricityApiClient electricityApiClient;
    public PriceService(ElectricityApiClient electricityApiClient){
        this.electricityApiClient = electricityApiClient;
    }
    public Price[] getTodayPrices(){
        return electricityApiClient.getExternalApi();
    }

    public double getAveragePrice() {
        Price[] prices = getTodayPrices();
        double sum = 0;
        for(Price price : prices) {
            sum += price.getSekPerKwh();
        }
        double avgPrice = sum / prices.length;
        return avgPrice;
    }
}
