package nextstep.ladder.domain;

import java.util.Objects;

public class Player {
    private final static int MAX_NAME_LENGTH = 5;

    private final String name;
    private final int assignBridgeIndex;

    public Player(String name, int assignBridgeIndex) {
        this.validateName(name);
        this.validateBridgeIndex(assignBridgeIndex);
        this.assignBridgeIndex = assignBridgeIndex;
        this.name = name;
    }

    private void validateName(String name) {
        if (Objects.isNull(name) || name.trim().isEmpty()) {
            throw new IllegalArgumentException("name is required");
        }

        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format("name length must be less than %d", MAX_NAME_LENGTH));
        }
    }

    private void validateBridgeIndex(int assignBridgeIndex) {
        if (assignBridgeIndex < 0) {
            throw new IllegalArgumentException("player is not assign negative Number");
        }
    }

    public String getName() {
        return this.name;
    }

    public int getAssignBridgeIndex() {
        return this.assignBridgeIndex;
    }
}
