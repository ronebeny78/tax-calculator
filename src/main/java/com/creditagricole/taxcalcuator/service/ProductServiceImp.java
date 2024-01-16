package com.creditagricole.taxcalcuator.service;


import com.creditagricole.taxcalcuator.entity.Product;
import com.creditagricole.taxcalcuator.repository.ProductRepository;
import com.creditagricole.taxcalcuator.service.decorator.ImportTax;
import com.creditagricole.taxcalcuator.service.decorator.RoundTax;
import com.creditagricole.taxcalcuator.service.decorator.VatTax;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductServiceImp implements ProductService{

    private ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {

        Product savedProduct = productRepository.save(product);
        calculateTax(savedProduct);
        calculateWithTaxPrice(savedProduct);
        return savedProduct;

    }

    @Override
    public List<Product> createProductList(List<Product> products) {
        List<Product> savedProducts = productRepository.saveAll(products);

        return savedProducts.stream()
                .map(p -> {
                    Product withTaxProduct =calculateTax(p);
                    return calculateWithTaxPrice(withTaxProduct);
                }).toList();

    }

    public Product calculateTax(Product product){

        double calculatedTax = new RoundTax(new VatTax(product)).getTax()
                               +  new RoundTax(new ImportTax(product)).getTax();

        //Ajout de la taxe calculée
        product.setTax(calculatedTax);

        //Ajout des du préfixe [importé] pour les produits importés
        product.setDescription(new ImportTax(product).getDescription());

        return product;
    }


    public Product calculateWithTaxPrice(Product product){

        product.setWithTaxPrice(product.getPrice() + product.getTax());
        return product;
    }

}
