package com.financial.service;


import com.financial.dto.PostStockDTO;
import com.financial.dto.StockDTO;
import com.financial.dto.UpdateStockDTO;
import com.financial.entity.Stock;
import com.financial.exception.BusinessException;
import com.financial.repository.IFinancialRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.events.Event;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class StockService {

    private final IFinancialRepository repository;


    public Stock save(Stock stock) {

        // Criar um metodo para validar as seguintes regras:
        // Nao pode ter outra entidade com o mesmo CODE e o CNPJ
        // Para isso, tem que antes criar essas consultas no Repositorio. IFinancialRepository
        // Agora chamar o metodo validar.
        validate(stock);
        // Salvar a entidade utilizando o respositorio, e retornar o estoque atualizado. Stock
        Stock entity = repository.save(stock);

        return entity;
    }

    private void validate(Stock stock) {
        // Fazer as seguintes validacoes?
        // Nao pode ter outra entidade com o mesmo CODE e o CNPJ
        Stock stockDup = repository.findByCode(stock.getCode());
        if (stockDup != null) {
            throw new BusinessException("#{dup.code} " + stock.getCode());
        }
        stockDup = repository.findByCnpj(stock.getCnpj());
        if (stockDup != null) {
            throw new BusinessException("#{dup.cnpj} " + stock.getCnpj());
        }
        // Caso a validacao nao passe, levantar uma exception do tipo BusinessException.
        // para cada um dos erros e utilizar internacionalizacao para as mensagens de erro dentro do exception.
        return;
    }

    public List<Stock> list() {
        return repository.findAll();

    }

    public void deleteStock(Long id) {
        repository.deleteById(id);
    }


    private void validateUpdate( UpdateStockDTO dto, Stock stock) {

        if ( !Objects.isNull(dto.getName()) || !dto.getName().isBlank() ){
            stock.setName(dto.getName());

        }
        if ( !Objects.isNull(dto.getLogo()) || !dto.getLogo().isBlank() ){
            stock.setLogo(dto.getLogo());

        }





    }

    private Stock validateIfExist( UpdateStockDTO dto){

        Optional<Stock> stock = repository.findById(dto.getId());
        if (!stock.isPresent()){
            throw new BusinessException("#{stock.not.found.by.id} " + dto.getId());
        }
        return stock.get();
    }

    @Transactional
    public Stock updateById(UpdateStockDTO dto) {
        Stock stock = validateIfExist(dto);

        validateUpdate(dto,stock);


        return repository.save(stock);
    }

}


