package com.portal.api.service.impl;

import com.portal.api.client.CarPostStoreClient;
import com.portal.api.dto.OwnerPostDTO;
import com.portal.api.service.OwnerPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerPostServiceImpl implements OwnerPostService {

    private final CarPostStoreClient carPostStoreClient;

    @Autowired
    OwnerPostServiceImpl(CarPostStoreClient carPostStoreClient) {
        this.carPostStoreClient = carPostStoreClient;
    }

    @Override
    public void createOwnerCar(OwnerPostDTO ownerPostDTO) {
        this.carPostStoreClient.ownerPostsClient(ownerPostDTO);
    }
}
