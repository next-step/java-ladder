package nextstep.ladder.domain;

public class WinProduct {

    private final String winProduct;

    private WinProduct(String winProduct) {
        this.winProduct = winProduct;
    }

    public static WinProduct of(String winProduct) {
        return new WinProduct(winProduct);
    }

    public String getProductName() {
        return this.winProduct;
    }
}
