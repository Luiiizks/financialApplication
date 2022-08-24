package com.financial.repository;

import com.financial.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFinancialRepository extends JpaRepository<Stock , Long> {
}
