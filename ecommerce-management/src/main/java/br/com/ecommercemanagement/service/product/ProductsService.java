package br.com.ecommercemanagement.service.product;

import br.com.ecommercemanagement.controller.product.ProductDTO;
import br.com.ecommercemanagement.infrastructure.ProductRepository;
import br.com.ecommercemanagement.model.ProductsEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductsService {

    private final ProductRepository productRepository;

    public Page<ProductDTO> findAllProducts(Pageable pageable){
         return productRepository.findAll(pageable).map(ProductsEntity::toDTO);
    }


}
