package nextstep.ladder;

import java.security.SecureRandom;

public class Point {

    private final boolean active;

    public Point(boolean active) {
        this.active = active;
    }

    public Point() {
        this.active = new SecureRandom().nextBoolean();
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
