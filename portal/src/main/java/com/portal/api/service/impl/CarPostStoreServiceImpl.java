package com.portal.api.service.impl;

import com.portal.api.client.CarPostStoreClient;
import com.portal.api.dto.CarPostDTO;
import com.portal.api.service.CarPostStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarPostStoreServiceImpl implements CarPostStoreService {

    private final CarPostStoreClient carPostStoreClient;

    @Autowired
    CarPostStoreServiceImpl(CarPostStoreClient carPostStoreClient) {
        this.carPostStoreClient = carPostStoreClient;
    }

    @Override
    public List<CarPostDTO> getCarsForSale() {
        return carPostStoreClient.getCarsForSaleClient();
    }

    @Override
    public void changeCarForSale(CarPostDTO carPost, Long id) {
        carPostStoreClient.changeCarForSaleClient(carPost, id);
    }

    @Override
    public void removeCarForSale(Long id) {
        carPostStoreClient.deleteCarForSaleClient(id);
    }
}
