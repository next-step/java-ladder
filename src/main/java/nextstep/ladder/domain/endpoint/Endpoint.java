package nextstep.ladder.domain.endpoint;

import java.util.Objects;

public class Endpoint {
    private final String name;

    private Endpoint(final String name) {
        this.name = name;
    }

    public static Endpoint from(final String name) {
        return new Endpoint(Objects.requireNonNull(name));
    }

    public String name() {
        return name;
    }
}
