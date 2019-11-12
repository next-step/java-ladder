package step2.domain;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LineFactory {
    public static Line line(final Dot... dots) {
        return line(Arrays.asList(dots));
    }

    public static Line emptyLine(final PositiveNumber number) {
        return line(number, () -> new SingleDot(" "));
    }

    public static Line line(final PositiveNumber number) {
        return line(number, SingleDot::new);
    }

    public static Line line(final PositiveNumber number, final Supplier<Dot> dotSupplier) {
        return line(IntStream.range(0, number.getNumber())
                             .mapToObj(i -> dotSupplier.get())
                             .collect(Collectors.toList()));
    }

    public static Line line(final List<Dot> dots) {
        return new HorizontalLine(dots);
    }
}
