package pl.ap.zadanie221;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class ProductRepository {
    public List<Product> productsList = new ArrayList<>();

    public List<Product> getAll(){
        return productsList;
   }

    public void add(Product product){
        productsList.add(product);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductRepository that = (ProductRepository) o;
        return Objects.equals(productsList, that.productsList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productsList);
    }
}
