package br.com.ecommercemanagement.controller.product;

import br.com.ecommercemanagement.service.product.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ecommerce-management/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductsService productsService;

    @GetMapping
    public ResponseEntity<Page<ProductDTO>> findAllProducts(Pageable pageable){
        return new ResponseEntity<>(productsService.findAllProducts(pageable), HttpStatus.OK);
    }

}
