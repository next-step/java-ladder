package step2;

import java.util.List;

public abstract class Line implements Printable {
    protected final List<Dot> dots;

    Line(final List<Dot> dots) {
        this.dots = dots;
    }
}
