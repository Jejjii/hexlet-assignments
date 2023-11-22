package exercise.controller;

import java.util.List;

import exercise.dto.ProductCreateDTO;
import exercise.dto.ProductDTO;
import exercise.dto.ProductUpdateDTO;
import exercise.mapper.ProductMapper;
import exercise.model.Product;
import exercise.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import exercise.exception.ResourceNotFoundException;
import exercise.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    // BEGIN
    @GetMapping(path = "")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDTO> showall() {
        var products = productRepository.findAll();

        return products.stream()
                .map(productMapper::map)
                .toList();
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDTO show(@PathVariable Long id) {
        var product = productRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Not found"));

        return productMapper.map(product);
    }


    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED) // Устанавливаем статус CREATED для успешного ответа
    public ProductDTO createProduct(@RequestBody ProductCreateDTO productCreateDTO) {

        // Проверяем, существует ли категория
        // Преобразование DTO в сущность и сохранение
        Product product = productMapper.map(productCreateDTO);
        productRepository.save(product);

        // Преобразование сохраненной сущности обратно в DTO для ответа
        return productMapper.map(product);
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDTO update(@RequestBody @Valid ProductUpdateDTO productData,@PathVariable Long id) {
        var product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found"));
        productMapper.update(productData,product);
        productRepository.save(product);
        var productDTO = productMapper.map(product);
        return productDTO;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void destroy(@PathVariable Long id) {
        productRepository.deleteById(id);
    }




    // END
}
