package ladder.domain;

import java.util.Arrays;

public enum DirectionType {

    TRUE_FALSE(true, false),
    FALSE_FALSE(false, false),
    FALSE_TRUE(false, true);

    private boolean left;
    private boolean right;

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    DirectionType(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    public static DirectionType mathDirectionType(boolean left, boolean right) {
        return Arrays.stream(DirectionType.values())
                .filter(type -> type.left == left && type.right == right)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
