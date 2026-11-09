package com.elpris.elprisapi.client;

import com.elpris.elprisapi.model.Price;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class ElectricityApiClient {

    public Price[] getExternalApi() {
        RestClient client = RestClient.create();
       return client.get()
                .uri("https://www.elprisetjustnu.se/api/v1/prices/2026/11-09_SE3.json")
                .retrieve()
                .body(Price[].class);

    }
}
