package nextstep.ladder.domain;

import java.security.SecureRandom;

public class Point {

    private static final SecureRandom secureRandom = new SecureRandom();

    private final boolean active;

    public Point(boolean active) {
        this.active = active;
    }

    public Point() {
        this.active = secureRandom.nextBoolean();
    }

    public boolean isActive() {
        return this.active;
    }

    public Point nextPoint() {
        if (active) {
            return new Point(false);
        }

        return new Point();
    }
}
