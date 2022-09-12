package com.financial.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;





@Data

@AllArgsConstructor
@NoArgsConstructor
public class StockDTO {

    private Long id;

    private String name;
    private String code;
    private String cnpj;
    private String logo;

    



}
