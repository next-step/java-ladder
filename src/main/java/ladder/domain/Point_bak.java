package ladder.domain;

import java.util.Objects;
import java.util.Random;

public class Point_bak {

    private final boolean exist;
    private static final Random random = new Random();

    public Point_bak() {
        this.exist = random.nextBoolean();
    }

    public Point_bak(boolean exist) {
        this.exist = exist;
    }

    public boolean isExist() {
        return exist;
    }

    Point_bak nextPoint() {
        if (isExist()) {
            return new Point_bak(false);
        }
        return new Point_bak();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point_bak point = (Point_bak) o;
        return exist == point.exist;
    }

    @Override
    public int hashCode() {
        return Objects.hash(exist);
    }
}
