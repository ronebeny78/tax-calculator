package com.creditagricole.taxcalcuator;

import com.creditagricole.taxcalcuator.entity.Category;
import com.creditagricole.taxcalcuator.entity.Invoice;
import com.creditagricole.taxcalcuator.entity.Order;
import com.creditagricole.taxcalcuator.entity.Product;
import com.creditagricole.taxcalcuator.model.ShoppingCart;
import com.creditagricole.taxcalcuator.service.ProductService;
import com.creditagricole.taxcalcuator.service.ShoppingCartService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootConfiguration
public class TaxCalculatorConfiguration {

    @Bean
    public CommandLineRunner init(ProductService productService,ShoppingCartService shoppingCartService){
        return args -> {

            // initialisation du catalogue produits
            List<Product> catalogue = init_DB(productService);

            // Création des paniers d'achat
            List<ShoppingCart> carts = createShoppingCarts(shoppingCartService,catalogue);

            // Validation des paniers et impression des factures
            validatePurchase(shoppingCartService,carts);
        };
    }

    private List<Product> init_DB(ProductService productService){

        List<Product> products = List.of(
                Product.builder()
                        .description("Livre")
                        .price(12.49)
                        .category(Category.BOOK)
                        .build(),
                Product.builder()
                        .description("CD musical")
                        .price(14.99)
                        .build(),
                Product.builder()
                        .description("Barre de chocolat")
                        .price(0.85)
                        .category(Category.VITAL)
                        .build(),
                Product.builder()
                        .description("Boîte de chocolats")
                        .price(10.0)
                        .imported(true)
                        .category(Category.VITAL)
                        .build(),
                Product.builder()
                        .description("Flacon de parfum")
                        .price(47.50)
                        .imported(true)
                        .build(),
                Product.builder()
                        .description("Flacon de parfum")
                        .price(27.99)
                        .imported(true)
                        .build(),
                Product.builder()
                        .description("Flacon de parfum")
                        .price(18.99)
                        .build(),
                Product.builder()
                        .description("boîte de pilules contre la migraine")
                        .price(9.75)
                        .category(Category.VITAL)
                        .build(),
                Product.builder()
                        .description("boîte de chocolats")
                        .price(11.25)
                        .category(Category.VITAL)
                        .imported(true)
                        .build()

        );

        return productService.createProductList(products);//.forEach(System.out::println);

    }

    private List<ShoppingCart> createShoppingCarts(ShoppingCartService shoppingCartService, List<Product> catalogue){

        //Panier 1
        ShoppingCart cart = shoppingCartService.createShoppingCart();
        shoppingCartService.addProduct(cart,catalogue.get(0),2);
        shoppingCartService.addProduct(cart,catalogue.get(1),1);
        shoppingCartService.addProduct(cart,catalogue.get(2),3);

        List<ShoppingCart> carts = new ArrayList<>();
        carts.add(cart);

        //Panier 2
        cart = shoppingCartService.createShoppingCart();
        shoppingCartService.addProduct(cart,catalogue.get(3),2);
        shoppingCartService.addProduct(cart,catalogue.get(4),3);
        carts.add(cart);


        //Panier 3
        cart = shoppingCartService.createShoppingCart();
        shoppingCartService.addProduct(cart,catalogue.get(5),2);
        shoppingCartService.addProduct(cart,catalogue.get(6),1);
        shoppingCartService.addProduct(cart,catalogue.get(7),3);
        shoppingCartService.addProduct(cart,catalogue.get(8),2);
        carts.add(cart);

        return carts;
    }

    private void validatePurchase(ShoppingCartService shoppingCartService,List<ShoppingCart> carts){

        carts.forEach(cart -> {

            Order validatedOrder = shoppingCartService.validate(cart);
            shoppingCartService.editInvoice(validatedOrder);

        });
    }
}
