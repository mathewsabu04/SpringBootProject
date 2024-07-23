package com.example.FinalExamProject.Product;

import com.example.FinalExamProject.Command;
import com.example.FinalExamProject.Exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteProductCommandHandler implements Command<String,Void> {


    public ProductRepository productRepository;

    public DeleteProductCommandHandler(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<Void> excutes(String id) {
        Optional<Product> product = productRepository.findById(id);
        // see if the product is present
        if(product.isEmpty())
        {
            throw new ProductNotFoundException();


        }
        productRepository.delete(product.get());
        System.out.println("Product has been deleted");
        return ResponseEntity.ok().build();

    }
}
