package com.elpris.elprisapi.service;

import com.elpris.elprisapi.client.ElectricityApiClient;
import com.elpris.elprisapi.model.Price;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PriceServiceTest {

    @Test
    void getAveragePrice() {
        ElectricityApiClient mockClient = mock(ElectricityApiClient.class);
        Price price1 = mock(Price.class);
        Price price2 = mock(Price.class);
        Price price3 = mock(Price.class);

        when(price1.getSekPerKwh()).thenReturn(0.50);
        when(price2.getSekPerKwh()).thenReturn(1.00);
        when(price3.getSekPerKwh()).thenReturn(1.50);
        when(mockClient.getExternalApi())
                .thenReturn(new Price[]{price1, price2, price3});

        PriceService priceService = new PriceService(mockClient);
        double result = priceService.getAveragePrice();

        assertEquals(1.0, result);
    }
}