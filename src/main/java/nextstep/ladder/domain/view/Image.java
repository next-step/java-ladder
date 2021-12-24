package nextstep.ladder.domain.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Image {
    TRUE(true, "|-----"),
    FALSE(false, "|     ");

    public static final String INVALID_VALUE_MESSAGE = "일치하는 값이 없습니다.";
    private final boolean value;
    private final String ladderStep;

    Image(boolean value, String ladderLine) {
        this.value = value;
        this.ladderStep = ladderLine;
    }

    public static String ladderLine(List<Boolean> points) {
        return points.stream()
                .map(point -> findBy(point).ladderStep)
                .collect(Collectors.joining());
    }

    private static Image findBy(boolean point) {
        return Arrays.stream(values())
                .filter(image -> image.value == point)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_VALUE_MESSAGE));
    }
}
