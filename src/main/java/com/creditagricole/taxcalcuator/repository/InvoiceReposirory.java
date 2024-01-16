package com.creditagricole.taxcalcuator.repository;

import com.creditagricole.taxcalcuator.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceReposirory extends JpaRepository<Invoice,Long> {
}
