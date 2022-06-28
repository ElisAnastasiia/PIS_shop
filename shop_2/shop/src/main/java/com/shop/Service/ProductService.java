package com.shop.Service;

import com.shop.Model.Dao.BucketDao;
import com.shop.Model.Dao.CategoryDao;
import com.shop.Model.Dao.ProductDao;
import com.shop.Model.DaoFactory;
import com.shop.Model.Entities.Bucket;
import com.shop.Model.Entities.Product;
import com.shop.Service.Dto.ProductDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ProductService {
    BucketDao bucketDao = DaoFactory.createBucketDao();
    ProductDao productDao = DaoFactory.createProductDao();
    CategoryDao categoryDao = DaoFactory.createCategoryDao();
    public ArrayList<ProductDto> getAll(){
        ArrayList<ProductDto> productsList= new ArrayList<>();
        for(Product product: productDao.findAll()){
            productsList.add(new ProductDto(
                    product.id(),
                    product.name(),
                    product.price(),
                    categoryDao.findById(product.category()).name()
            ));
        }
        return productsList;
    }

    public void addProduct(Product product){
        productDao.add(product);
    }
    public void deleteProduct(Integer id){
        productDao.delete(id);
    }

    public List<ProductDto> getUserBucket(Integer id){
        return bucketDao.findAll()
                .stream()
                .filter(bucket -> bucket.user_id().equals(id))
                .map(bucket -> {
                    Product product = productDao.findById(bucket.product_id());
                    return new ProductDto(
                        product.id(),
                        product.name(),
                        product.price(),
                        categoryDao.findById(product.category()).name()
                );})
                .collect(Collectors.toList());
    }
    public void addInBucket(Integer user_id, Integer product_id){
        bucketDao.add(new Bucket(user_id, product_id));
    }

    public Product getProductById(Integer id){
        return productDao.findById(id);
    }

    public List<Product> getProductsByCategory(Integer id){
        return productDao.findAll().stream().filter(product -> product.category().equals(id)).collect(Collectors.toList());
    }
}
