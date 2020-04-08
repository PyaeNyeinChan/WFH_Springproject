package com.chan.springboot.services;


import java.util.List;

import com.chan.springboot.commands.ProductForm;
import com.chan.springboot.domain.Product;

public interface ProductService {

    List<Product> listAll();

    Product getById(Long id);

    Product saveOrUpdate(Product product);

    void delete(Long id);

    Product saveOrUpdateProductForm(ProductForm productForm);
}
