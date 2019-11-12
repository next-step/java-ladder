package step2;

import java.util.Arrays;
import java.util.List;

public class LineFactory {
    public static Line vertical(final Dot... dots) {
        return vertical(Arrays.asList(dots));
    }

    public static Line vertical(final List<Dot> dots) {
        return new VerticalLine(dots);
    }

    public static Line horizontal(final Dot... dots) {
        return horizontal(Arrays.asList(dots));
    }

    public static Line horizontal(final List<Dot> dots) {
        return new HorizontalLine(dots);
    }
}
