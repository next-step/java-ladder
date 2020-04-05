package ladder.domain;

import java.util.Random;

public enum LadderLink {
    CONNECT("-----"),
    DIS_CONNECT("     ");

    private static final Random random = new Random();

    private String value;

    LadderLink(String value) {
        this.value = value;
    }

    public static LadderLink of(LadderLink preLadderLink) {
        if (preLadderLink == CONNECT) {
            return DIS_CONNECT;
        }
        return randomCreate();
    }

    private static LadderLink randomCreate() {
        return random.nextBoolean() ? CONNECT : DIS_CONNECT;
    }

    public String getValue() {
        return value;
    }
}
