package com.chan.springboot.converters;


import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.chan.springboot.commands.ProductForm;
import com.chan.springboot.domain.Product;

@Component
public class ProductFormToProduct implements Converter<ProductForm, Product> {

    @Override
    public Product convert(ProductForm productForm) {
        Product product = new Product();
        if (productForm.getId() != null  && !StringUtils.isEmpty(productForm.getId())) {
            product.set_id(new Long(productForm.getId()));
        }
        product.setName(productForm.getName());
        product.setCatagory(productForm.getCatagory());
        product.setPrice(productForm.getPrice());
        return product;
    }
}
