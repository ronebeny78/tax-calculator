package com.creditagricole.taxcalcuator.service.decorator;


import com.creditagricole.taxcalcuator.entity.Product;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor @Setter @ToString
public class ImportTax extends TaxDecorator {

    public static final float IMPORT_TAX = 0.05f;

    public ImportTax(Product product) {
        super(product);
    }

    @Override
    public String getDescription() {

        if (product.getImported())
            return product.getDescription() + " [Importé]";
        return product.getDescription();
    }

    @Override
    public Double getPrice() {
        return product.getPrice();
    }

    @Override
    public Double getTax() {
        if (product.getImported()){
            return IMPORT_TAX * product.getTax();
        }
        return 0d;
    }

}
