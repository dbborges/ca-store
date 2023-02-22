package com.portal.api.service;

import com.portal.api.dto.CarPostDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarPostStoreService {
    List<CarPostDTO> getCarsForSale();
    void changeCarForSale(CarPostDTO carPost, Long id);
    void removeCarForSale(Long id);

}
