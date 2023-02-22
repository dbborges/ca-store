package com.portal.api.controller;

import com.portal.api.dto.OwnerPostDTO;
import com.portal.api.service.OwnerPostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/owner")
public class OwnerPostController {

    private final OwnerPostService ownerPostService;

    OwnerPostController(OwnerPostService ownerPostService) {
        this.ownerPostService = ownerPostService;
    }

    public ResponseEntity<HttpStatus> createOwnerCar(@RequestBody OwnerPostDTO ownerPostDTO) {
        ownerPostService.createOwnerCar(ownerPostDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
