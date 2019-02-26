package com.sparkdan.grocer.products;

import com.sparkdan.grocer.Product;
import com.sparkdan.grocer.ProductCategory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class RestProductsController {
    @RequestMapping(method = POST, value="/listRegisteredProducts")
    public RestProductsPage listRegisteredProducts(
            @RequestParam(value = "current", required = false) Integer current,
            @RequestParam(value = "rowCount", required = false) Integer rowCount,
            @RequestParam(value = "sort", required = false) String sort,
            @RequestParam(value = "searchPhrase", required = false) String searchPhase) {
        RestProductsPage result = new RestProductsPage();
        result.current = current == null ? 1 : current;
        result.total = 100500;
        result.rows = new ArrayList<>();
        result.rows.add(new Product("огурец", Arrays.asList(new ProductCategory("1", "основное"), new ProductCategory("2", "лето")), "кг", 0.2));
        result.rows.add(new Product("помидор", Arrays.asList(new ProductCategory("1", "основное"), new ProductCategory("2", "лето")), "кг", 0.2));
        result.rows.add(new Product("зубная паста", Arrays.asList(new ProductCategory("1", "основное")), "шт", 1.0));
        result.rows.add(new Product("молоко", Arrays.asList(new ProductCategory("1", "основное"), new ProductCategory("3", "для Вики")), "л", 1.0));
        result.rows.add(new Product("хлеб", Arrays.asList(new ProductCategory("1", "основное"), new ProductCategory("3", "для Вики")), "шт", 1.0));

        result.rowCount = result.rows.size();
        return result;
    }
}
