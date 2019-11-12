package step2.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ladder implements Printable {
    private static final String EMPTY_1 = " ";
    private static final String EMPTY_0 = "";
    private static final String DELIMITER = "|";

    private final PositiveNumber maxWidth;
    private final PositiveNumber maxHeight;
    private final List<Printable> names;

    private final BooleanGenerator random;

    private Ladder(final int maxWidth, final int maxHeight,
                   final List<String> names,
                   final BooleanGenerator random) {
        this.maxWidth = PositiveNumber.of(maxWidth);
        this.maxHeight = PositiveNumber.of(maxHeight);
        this.names = names.stream()
                          .map(name -> new FormattedName(name, maxWidth))
                          .collect(Collectors.toList());
        this.random = random;
    }

    public static LadderBuilder builder() {
        return new LadderBuilder();
    }

    @Override
    public String print() {
        return String.format("%s\n%s", header(), body());
    }

    private String header() {
        return names.stream()
                    .map(Printable::print)
                    .collect(Collectors.joining(EMPTY_1, EMPTY_1, EMPTY_0));
    }

    private String body() {
        return IntStream.range(0, maxHeight.getNumber())
                        .boxed()
                        .map(i -> row())
                        .collect(Collectors.joining("\n"));
    }

    private String row() {
        final Stream<Line> leftPadding = Stream.of(LineFactory.emptyLine(maxHeight));
        final Stream<Line> row = IntStream.range(1, names.size()) // left padding 때문에 1부터 시작
                                          .boxed()
                                          .map(i -> makeLine());

        return Stream.concat(leftPadding, row)
                     .map(Printable::print)
                     .collect(Collectors.joining(DELIMITER, EMPTY_0, DELIMITER));
    }

    private Line makeLine() {
        if (random.next()) {
            return LineFactory.line(maxWidth);
        }
        return LineFactory.emptyLine(maxWidth);
    }

    public static final class LadderBuilder {
        private static final int DEFAULT_WIDTH = 5;
        private static final int DEFAULT_HEIGHT = 5;

        private int maxWidth = DEFAULT_WIDTH;
        private int maxHeight = DEFAULT_HEIGHT;
        private List<String> names;
        private BooleanGenerator random = new RandomBooleanGenerator();

        private LadderBuilder() {
        }

        public LadderBuilder maxWidth(final int maxWidth) {
            this.maxWidth = maxWidth;
            return this;
        }

        public LadderBuilder maxHeight(final int maxHeight) {
            this.maxHeight = maxHeight;
            return this;
        }

        public LadderBuilder names(final List<String> names) {
            this.names = names;
            return this;
        }

        public LadderBuilder booleanGenerator(final BooleanGenerator random) {
            this.random = random;
            return this;
        }

        public Ladder build() {
            return new Ladder(maxWidth, maxHeight, names, random);
        }
    }
}
