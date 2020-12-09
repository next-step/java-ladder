package ladder.domain.product;

import ladder.context.ErrorMessage;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Products {
    public static final String REGEX = ",";

    private final List<String> products;

    public Products(String text, int playerCount) {
        validText(text);
        validProductsCount(text, playerCount);
        products = initProducts(text);
    }

    private void validText(String text) {
        if (Objects.isNull(text) || text.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.PRODUCTS_NULL.getMessage());
        }
    }

    private void validProductsCount(String text, int playerCount) {
        if (initProducts(text).size() != playerCount) {
            throw new IllegalArgumentException(ErrorMessage.PRODUCTS_COUNT.getMessage());
        }
    }

    private List<String> initProducts(String text) {
        return Arrays.stream(text.split(REGEX))
                .collect(Collectors.toList());
    }

    public String getProductByIndex(int index) {
        return products.get(index);
    }

    public List<String> getProducts() {
        return Collections.unmodifiableList(products);
    }
}
