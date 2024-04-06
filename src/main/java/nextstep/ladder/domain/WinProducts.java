package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class WinProducts {

    private final List<WinProduct> winProducts;

    private WinProducts(List<String> winProducts) {
        this.winProducts = winProducts.stream()
                .map(WinProduct::of)
                .collect(Collectors.toList());
    }

    public static WinProducts from(List<String> winProducts) {
        return new WinProducts(winProducts);
    }

    public String getWinProductOf(int index) {
        return winProducts.get(index).getProductName();
    }

    public int countOfWinProducts() {
        return this.winProducts.size();
    }
}
