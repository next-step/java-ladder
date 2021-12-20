package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    public static final String INVALID_WIDTH_HEIGHT_MESSAGE = "width와 height는 양수여야 합니다.";

    private static final int MIN_HEIGHT = 1;
    private static final int INDEX_ZERO = 0;
    private static final int CONVERT_INDEX_NUMBER = 2;

    private final List<Line> lines;

    public Ladder(String names, int height) {
        this(new Names(names), height);
    }

    public Ladder(LadderStrings<Name> names, int height) {
        this(widthFromNames(names), height);
    }

    private static int widthFromNames(LadderStrings<Name> names) {
        return names.count() * 2 - 1;
    }

    public Ladder(int width, int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException(INVALID_WIDTH_HEIGHT_MESSAGE);
        }

        this.lines = IntStream.range(INDEX_ZERO, height)
                .mapToObj(index -> new Line(width))
                .collect(Collectors.toList());
    }

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public int findRewardIndex(int number) {
        AtomicInteger result = new AtomicInteger(calculateStartIndex(number));
        lines.stream()
                .forEach(line -> result.set(line.move(result.get())));
        return calculateRewardIndex(result.get());
    }

    private int calculateStartIndex(int index) {
        return index * CONVERT_INDEX_NUMBER;
    }

    private int calculateRewardIndex(int index) {
        return index / CONVERT_INDEX_NUMBER;
    }

    public int height() {
        return lines.size();
    }

    public int width() {
        return lines.get(INDEX_ZERO).width();
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

}
