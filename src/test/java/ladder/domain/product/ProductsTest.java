package ladder.domain.product;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductsTest {
    Products products;

    @BeforeEach
    void create() {
        products = new Products("1,2,3,4,5", 5);
    }

    @Test
    void validText() {
        Assertions.assertThatThrownBy(() -> {
            new Products("", 5);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validProductsCount() {
        Assertions.assertThatThrownBy(() -> {
            new Products("1,2,3,4,5", 4);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getProductByIndex() {
        Assertions.assertThat(products.getProductByIndex(1))
                .isEqualTo("2");
    }

    @Test
    void getProducts() {
        Assertions.assertThat(products.getProducts().size())
                .isEqualTo(5);
    }
}