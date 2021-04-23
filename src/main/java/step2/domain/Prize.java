package step2.domain;

public class Prize {

    private final Product product;

    public Prize(Product product) {
        this.product = product;
    }

    public Prize(String product) {
        this.product = new Product(product);
    }

    public Product product() {
        return this.product;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Prize) {
            return product.equals(((Prize) obj).product);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return product.hashCode();
    }
}
