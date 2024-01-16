package com.creditagricole.taxcalcuator.service;

import com.creditagricole.taxcalcuator.entity.Invoice;

public interface InvoiceService {

    public Invoice createInvoice(Invoice invoice);

    public void printInvoice(Invoice invoice);
}
