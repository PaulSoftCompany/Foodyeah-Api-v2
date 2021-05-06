package com.paulsoft.foodyeah.inventariocontext.repositories;

import com.paulsoft.foodyeah.inventariocontext.entities.Product;
import com.paulsoft.foodyeah.inventariocontext.entities.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Optional<Product> findByName(String name);
    List<Product> findBySellday(int SellDay);
    List<Product> findByProductCategory(ProductCategory category);

    @Query(value = "SELECT * FROM PRODUCTS u WHERE u.sellday <= 5 and u.product_category_id = 1 ",nativeQuery = true)
    List<Product>  menuSemanal();

    @Query(value = "SELECT * FROM PRODUCTS u WHERE  u.product_category_id > 1 ",nativeQuery = true)
    List<Product>  platosALaCarta();
    @Query(value = "SELECT * FROM PRODUCTS u WHERE  u.product_category_id > 1 AND u.product_category_id = ?1  ",nativeQuery = true)
    List<Product>  platosALaCartaByCategory(long categoryId);
}
