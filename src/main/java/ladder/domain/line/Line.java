package ladder.domain.line;

import java.util.Arrays;

public enum Line {
    LINE(0, "|"),
    LINE_WIDTH_DASH(1, "-----|");

    private int value;
    private String ladder;

    public String draw() {
        return ladder;
    }

    public int lineValue() {
        return value;
    }

    Line(int value, String ladder) {
        this.value = value;
        this.ladder = ladder;
    }

    public static Line createByNumber(int number) {
        return Arrays.stream(Line.values())
                .filter(mark -> mark.value == number)
                .findFirst()
                .orElse(null);
    }

    public static String ofLadder(int value) {
        return Arrays.stream(Line.values())
                .filter(v -> v.value == value)
                .map(Line::draw)
                .findFirst()
                .orElse(null);
    }

}
