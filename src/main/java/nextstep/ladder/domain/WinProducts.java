package nextstep.ladder.domain;

import java.util.List;

public class WinProducts {

    private final List<String> winProducts;

    private WinProducts(List<String> winProducts) {
        this.winProducts = winProducts;
    }

    public static WinProducts of(List<String> winProducts) {
        return new WinProducts(winProducts);
    }

    public String getWinProductOf(int index) {
        return winProducts.get(index);
    }

    public int countOfWinProducts() {
        return this.winProducts.size();
    }
}
