package com.financial.dto;

import com.financial.entity.Stock;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;


@Data

@AllArgsConstructor
@NoArgsConstructor
public class StockDTO {

    private Long id;

    private String name;
    private String code;
    private String cnpj;
    private String logo;


    public static StockDTO EntitytoDTO(ModelMapper mapper, Stock stock){
        StockDTO postDto = mapper.map(stock, StockDTO.class);
        return postDto;
    }


}
