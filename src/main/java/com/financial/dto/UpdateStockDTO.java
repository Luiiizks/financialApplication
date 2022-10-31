package com.financial.dto;


import com.financial.entity.Stock;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Data
@AllArgsConstructor

public class UpdateStockDTO {

    @NotEmpty(message = "{stock.id.mandatory}")
    private Long id;
    private String name;
    private String logo;


    public Stock DTOtoEntity(ModelMapper mapper){
        Stock stock = mapper.map(this, Stock.class);
        return stock;
    }



}
