package ladder.domain;

import java.util.Arrays;

public enum LineEnum {
    FALSE(false, "     "),
    TRUE(true, "-----");

    private boolean isPoint;
    private String line;

    LineEnum(boolean isPoint, String line) {
        this.isPoint = isPoint;
        this.line = line;
    }

    public static String ofLine(Boolean isPoint) {
        return Arrays.stream(values())
                .filter(line -> line.isPoint == isPoint)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException())
                .line;
    }
}
