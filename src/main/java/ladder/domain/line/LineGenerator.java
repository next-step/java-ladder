package ladder.domain.line;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LineGenerator {

    public static final int MIN_LINE_COUNT = 1;

    private boolean bool;

    private LineGenerator() {
    }

    public static List<Boolean> generate(int count) {
        validateLineCount(count);
        LineGenerator lineGenerator = new LineGenerator();
        return IntStream.range(0, count)
                .mapToObj(i -> lineGenerator.next())
                .collect(Collectors.toList());
    }

    private static void validateLineCount(int count) {
        if (count < MIN_LINE_COUNT) {
            throw new LineCountException();
        }
    }

    private boolean next() {
        bool = generateLine();
        return bool;
    }

    private boolean generateLine() {
        if (bool) {
            return false;
        }
        return RandomBoolGenerator.generate();
    }

}
