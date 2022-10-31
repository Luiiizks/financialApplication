package com.financial.controller;


import com.financial.dto.PostStockDTO;
import com.financial.dto.StockDTO;
import com.financial.dto.UpdateStockDTO;
import com.financial.entity.Stock;
import com.financial.exception.BusinessException;
import com.financial.repository.IFinancialRepository;
import com.financial.service.StockService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(value = "/stock")
@RestController
@AllArgsConstructor
public class StockController {


    private final StockService stockService;


    private final ModelMapper modelMapper;


    @PostMapping("/save")
    public ResponseEntity<StockDTO> save(@Valid @RequestBody PostStockDTO postStockDTO){

        Stock stock = postStockDTO.DTOtoEntity(modelMapper);
        // Chamar o service para salvar a entidade estoque -> Stock.
        stock = stockService.save(stock);


        // Depois que salvar, converter de volta da entidade Stock para StockDTO
        StockDTO dto = StockDTO.EntitytoDTO(modelMapper,stock);
        // Criar o objeto ResponseEntity passar o StockDTO no conteudo e retornar o STATUS.200

        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public List<Stock> listar(Stock stock){
        return stockService.list();

    }

    @DeleteMapping("delete-Stock/{id}")
    public ResponseEntity deleteStock(@PathVariable Long id) {
        stockService.deleteStock(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("updateStock")
    public ResponseEntity<StockDTO> updateStock( @RequestBody UpdateStockDTO updateDto){

        Stock stock = stockService.updateById(updateDto);


        StockDTO dto = StockDTO.EntitytoDTO(modelMapper,stock);



        return new ResponseEntity<>(dto, HttpStatus.OK);

    }


}
