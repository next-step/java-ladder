package nextstep.step2;

import java.util.Objects;
import java.util.Random;

import static java.lang.Boolean.*;

public final class Line {

    private static final Random RANDOM = new Random();
    private final boolean line;

    public static Line of(boolean line) {
        return new Line(line);
    }

    public static Line first() {
        return random();
    }

    public static Line random() {
        return of(RANDOM.nextBoolean());
    }

    public Line next() {
        if(isTrue()) {
            return of(FALSE);
        }
        return random();
    }

    private boolean isTrue() {
        return line == true;
    }

    private Line(boolean line) {
        this.line = line;
    }

    public boolean isLine() {
        return line;
    }

    @Override
    public String toString() {
        return "Line{" +
                "line=" + line +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line1 = (Line) o;
        return line == line1.line;
    }

    @Override
    public int hashCode() {
        return Objects.hash(line);
    }
}
