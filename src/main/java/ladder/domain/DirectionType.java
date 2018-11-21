package ladder.domain;

import ladder.utils.PointGenerator;

import java.util.Arrays;


public enum DirectionType {

    TRUE_FALSE(Boolean.TRUE, Boolean.FALSE),
    FALSE_FALSE(Boolean.FALSE, Boolean.FALSE),
    FALSE_TRUE(Boolean.FALSE, Boolean.TRUE);

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

    public static DirectionType matchDirectionType(boolean left, boolean right) {
        return Arrays.stream(DirectionType.values())
                .filter(type -> type.left == left && type.right == right)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static DirectionType isOverLapped(boolean right, PointGenerator generator) {
        if(right) {
            return DirectionType.matchDirectionType(right, Boolean.FALSE);
        }
        return DirectionType.matchDirectionType(right, generator.generatePoint());
    }
}
