package nextstep.ladder.model;

import java.util.Objects;

public final class Bar {
    private final boolean isActivate;

    public Bar(boolean isActivate) {
        this.isActivate = isActivate;
    }

    public boolean isActivate() {
        return isActivate;
    }
}
