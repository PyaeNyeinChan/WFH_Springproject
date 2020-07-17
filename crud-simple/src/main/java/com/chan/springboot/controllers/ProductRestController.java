package com.chan.springboot.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chan.springboot.domain.Product;
import com.chan.springboot.services.ProductService;

@Controller
@RequestMapping("/rest/product")
public class ProductRestController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Product> listAllProduct(){
		return productService.listAll();
	}
	
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Product lookupMemberById(@PathVariable("id") Long id) {
        return productService.getById(id);
    }

}
