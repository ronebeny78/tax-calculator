package com.creditagricole.taxcalcuator.service.decorator;


import com.creditagricole.taxcalcuator.entity.Category;
import com.creditagricole.taxcalcuator.entity.Product;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor @Setter @ToString
public class VatTax extends TaxDecorator {

    public static final float BOOK_PRODUCT_TAX = 0.1f;
    public static final float NORMAL_PRODUCT_TAX = 0.2f;
    public VatTax(Product product){
        super(product);
    }

    @Override
    public Double getPrice() {
        return product.getPrice();
    }

    @Override
    public Double getTax() {

        if(product.getCategory() == Category.VITAL){
            return  0d;
        }else if(product.getCategory() == Category.BOOK){
            return BOOK_PRODUCT_TAX * product.getTax();
        }else{
            return NORMAL_PRODUCT_TAX *  product.getTax();
        }

    }

}
