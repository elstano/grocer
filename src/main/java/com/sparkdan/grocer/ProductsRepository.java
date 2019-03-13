package com.sparkdan.grocer;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "products", path = "products")
public interface ProductsRepository extends PagingAndSortingRepository<Product, String> {
//    @Query("select id from product offset :startWith rows fetch first :rowCount rows only order by name asc")
//    public List<Product> listRegisteredProducts(@Param("startWith") int startWith, @Param("rowCount") int rsowCount);
}
