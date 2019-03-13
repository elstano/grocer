package com.sparkdan.grocer.products;

import com.sparkdan.grocer.Product;
import com.sparkdan.grocer.ProductCategory;
import com.sparkdan.grocer.ProductsRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class RestProductsController {
    private ProductsRepository productsRepository;

    public RestProductsController(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @RequestMapping(method = POST, value="/listRegisteredProducts")
    public RestProductsPage listRegisteredProducts(
            @RequestParam(value = "current", required = false, defaultValue = "1") Integer current,
            @RequestParam(value = "rowCount", required = false, defaultValue = "10") Integer rowCount,
            @RequestParam Map<String, String> requestParams,
            @RequestParam(value = "searchPhrase", required = false) String searchPhase) {
        RestProductsPage result = new RestProductsPage();
        result.rows = new ArrayList<>();

        Sort[] sort = new Sort[1];
        requestParams.forEach((key, value) -> {
            if(key.startsWith("sort[")) {
                String sortBy = key.substring(5, key.length()-1);
                sort[0] = Sort.by(Sort.Order.by(sortBy).with(Sort.Direction.fromString(value)));
            }
        });

        Pageable pageDesc = null;
        if(rowCount > 0) {
            pageDesc = PageRequest.of(current, rowCount, sort[0]);
        }

        Iterable<Product> fetched = null;
        if(pageDesc != null) {
            Page<Product> productsPage = productsRepository.findAll(pageDesc);
            result.total = productsPage.getTotalElements();
            fetched = productsPage;
        } else if(sort[0] != null){
            fetched = productsRepository.findAll(sort[0]);
        } else {
            fetched = productsRepository.findAll();
        }
        fetched.forEach(product -> result.rows.add(product));

        result.rowCount = result.rows.size();
        if(result.getTotal() == null) {
            result.setTotal((long)result.getRows().size());
        }
        result.current = current;
        return result;
    }
}
