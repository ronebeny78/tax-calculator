package com.creditagricole.taxcalcuator.service;

import com.creditagricole.taxcalcuator.entity.Invoice;
import com.creditagricole.taxcalcuator.repository.InvoiceReposirory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InvoiceServiceImp implements InvoiceService{

    private InvoiceReposirory invoiceReposirory;
    @Override
    public Invoice createInvoice(Invoice invoice) {
        return invoiceReposirory.save(invoice);
    }

    @Override
    public void printInvoice(Invoice invoice) {

        System.out.println(invoice);

    }
}
