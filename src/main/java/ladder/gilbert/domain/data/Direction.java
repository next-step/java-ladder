package ladder.gilbert.domain.data;

import java.util.Arrays;

public enum Direction {

    VERTICAL("|", "세로"),
    HORIZONTAL("-", "가로"),
    NONE(" ", "없음");

    private final String character;
    private final String title;

    Direction(String character, String title) {
        this.character = character;
        this.title = title;
    }

    public static Direction valueOfCharacter(String character) {
        return Arrays.stream(values())
            .filter(direction -> direction.equals(character))
            .findFirst()
            .orElse(null);
    }

    private boolean equals(String character) {
        return this.character.equals(character);
    }

    public boolean isHorizontal() {
        return this == HORIZONTAL;
    }

    public boolean isNone() {
        return this == NONE;
    }

    public String character() {
        return character;
    }
}
