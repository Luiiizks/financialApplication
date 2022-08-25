package com.financial.service;


import com.financial.repository.IFinancialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class StockService {

    private final IFinancialRepository repository;




}
