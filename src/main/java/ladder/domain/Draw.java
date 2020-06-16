package ladder.domain;

import java.util.Objects;

public class Draw {

    private boolean drawable;

    public Draw(boolean drawable) {
        this.drawable = drawable;
    }

    public static Draw of(boolean drawable) {
        return new Draw(drawable);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Draw draw = (Draw) o;
        return drawable == draw.drawable;
    }

    @Override
    public int hashCode() {
        return Objects.hash(drawable);
    }
}
