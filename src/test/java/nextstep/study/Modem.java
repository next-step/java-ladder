package nextstep.study;

import java.util.Optional;

public class Modem {
    private Double price;

    public Modem(Double price) {
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public static boolean priceIsInRange1(Modem modem) {
        boolean isInRange = false;

        if (modem != null && modem.getPrice() != null
                && (modem.getPrice() >= 10
                && modem.getPrice() <= 15)) {

            isInRange = true;
        }
        return isInRange;
    }

    public static boolean priceIsInRange2(Modem modem) {
        return Optional.ofNullable(modem)
                .map(Modem::getPrice)
                .filter(price -> price >= 10)
                .filter(price -> price <= 15)
                .isPresent();
    }

}
