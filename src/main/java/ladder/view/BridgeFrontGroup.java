package ladder.view;

import ladder.domain.bridge.direction.Direction;

import java.util.Arrays;

public enum BridgeFrontGroup {
    LEFT("ㅓ"),
    DOWN("ㅣ"),
    RIGHT("ㅏ"),
    SIDE("-");

    private String frontValue;

    BridgeFrontGroup(String frontValue) {
        this.frontValue = frontValue;
    }

    public static BridgeFrontGroup findFrontByDirection(Direction direction) {
        return Arrays.stream(values())
                .filter(front -> isEquals(direction, front))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재 하지 않는 방향입니다."));
    }

    private static boolean isEquals(Direction direction, BridgeFrontGroup front) {
        return front.name().equals(direction.name());
    }

    public static String getSide(int length) {
        StringBuilder sides = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sides.append(SIDE.frontValue);
        }
        return sides.toString();
    }

    public String getFrontValue() {
        return frontValue;
    }
}
