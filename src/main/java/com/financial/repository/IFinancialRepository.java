package com.financial.repository;

import com.financial.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IFinancialRepository extends JpaRepository<Stock , Long> {

    // Cria um metodo para verificar se existe um strock com o valor do CODE informado.
    Stock findByCode(String code);

    Stock findByCnpj(String cnpj);

}
