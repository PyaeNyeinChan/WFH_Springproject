package com.chan.springboot.converters;



import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.chan.springboot.commands.ProductForm;
import com.chan.springboot.domain.Product;

@Component
public class ProductToProductForm implements Converter<Product, ProductForm> {
    @Override
    public ProductForm convert(Product product) {
        ProductForm productForm = new ProductForm();
        productForm.setId(product.get_id());
        productForm.setName(product.getName());
        productForm.setCatagory(product.getCatagory());
        productForm.setPrice(product.getPrice());
        return productForm;
    }
}
