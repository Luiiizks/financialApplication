package com.financial.dto;


import lombok.AllArgsConstructor;
import lombok.Data;



import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Data
@AllArgsConstructor

public class PostStockDTO {


    @NotEmpty(message = "{stock.name.mandatory}")
    private String name;
    @NotEmpty(message = "{stock.code.mandatory}")
    @Size(min = 5, max = 5)
    private String code;
    @NotEmpty(message = "{stock.cnpj.mandatory}")
    private String cnpj;
    private String logo;
}
