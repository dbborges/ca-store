package com.portal.api.controller;


import com.portal.api.dto.CarPostDTO;
import com.portal.api.message.KafkaProducerMessage;
import com.portal.api.service.CarPostStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/car")
public class CarPostController {

    private final CarPostStoreService carPostStoreService;
    private final KafkaProducerMessage kafkaProducerMessage;

    @Autowired
    CarPostController(CarPostStoreService carPostStoreService, KafkaProducerMessage kafkaProducerMessage) {
        this.carPostStoreService = carPostStoreService;
        this.kafkaProducerMessage = kafkaProducerMessage;
    }

    @PostMapping("/post")
    public ResponseEntity<HttpStatus> postCarForSale(@RequestBody CarPostDTO carPostDTO) {
        kafkaProducerMessage.sendMessage(carPostDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/posts")
    public ResponseEntity<List<CarPostDTO>> getCarSales() {
        return ResponseEntity.status(HttpStatus.FOUND).body(carPostStoreService.getCarsForSale());
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> changeCarSale(@RequestBody CarPostDTO carPostDTO, @PathVariable("id") Long id){
        carPostStoreService.changeCarForSale(carPostDTO, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCarForSale(@PathVariable("id") Long id) {
        carPostStoreService.removeCarForSale(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
