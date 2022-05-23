package ladder.domain;

import ladder.view.Input;

import java.util.Optional;

public class Height {
    private final int height;

    public Height(int height) {
        this.height = Optional.ofNullable(height)
                .filter(h -> h <= 10)
                .orElseThrow(()-> new IllegalArgumentException("height should be less than 10 but, : " + height));
    }

    public static Height parse(String scannedHeight) {
        return new Height(Integer.parseInt(scannedHeight));
    }
}
