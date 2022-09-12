package com.financial.controller;


import com.financial.dto.PostStockDTO;
import com.financial.entity.Stock;
import com.financial.service.StockService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping(value = "/stock")
@RestController
@AllArgsConstructor
public class StockController {


    private final StockService stockService;


    private final ModelMapper modelMapper;

    @PostMapping("/save")
    public ResponseEntity<Stock> save(@Valid @RequestBody PostStockDTO postStockDTO){
            System.out.println();
        return null;
    }
}
