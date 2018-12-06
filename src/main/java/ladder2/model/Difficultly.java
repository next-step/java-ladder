package ladder2.model;

import java.util.Arrays;

public enum Difficultly {
    HARD("상", 0.8, 20),
    NORMAL("중", 0.5, 10),
    EASY("하", 0.2, 5);

    private final String name;
    private final double ratioOfLine;
    private final int heightOfLadderLine;

    Difficultly(String name, double ratioOfLine, int heightOfLadderLine) {
        this.name = name;
        this.ratioOfLine = ratioOfLine;
        this.heightOfLadderLine = heightOfLadderLine;
    }

    public static Difficultly from(String name) {
        return Arrays.stream(Difficultly.values())
                .filter((value) -> value.name.equals(name))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public boolean generateValue() {
        return Math.random() >= 1.0 - ratioOfLine;
    }

    public int getLineHeight() {
        return heightOfLadderLine;
    }
}
