package ladder.util;

import ladder.Line;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGameUtil {
    public static final String FORMAT = "%6s";
    public static final String VERTICAL_LINE = "|";
    public static final char HORIZONTAL_LINE = '-';
    public static final char EMPTY_SPACE = ' ';

    private LadderGameUtil() {

    }

    public static List<Boolean> autoLineValue(int width) {
        List<Boolean> lineInfo = new ArrayList<>();

        for (int i = 0; i < width; i++) {
            lineInfo.add(getLineInfoElement(i, lineInfo));
        }

        return lineInfo;
    }

    private static Boolean getLineInfoElement(int index, List<Boolean> result) {
        if (index == 0) {
            return Boolean.FALSE;
        }

        if (result.get(index - 1)) {
            return Boolean.FALSE;
        }

        if (new Random().nextInt() % 2 == 0) {
            return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }

    public static List<Line> autoLadderValue(int width, int height) {
        return IntStream.range(0, height)
                .mapToObj((i) -> new Line(width))
                .collect(Collectors.toList());
    }

    public static String booleanToLineString(boolean value) {
        String raw = String.format(FORMAT, VERTICAL_LINE);

        if (value) {
            return raw.replace(EMPTY_SPACE, HORIZONTAL_LINE);
        }
        return raw;
    }
}
