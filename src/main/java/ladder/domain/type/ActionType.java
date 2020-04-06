package ladder.domain.type;

import lombok.Getter;

public enum ActionType {
    RIGHT(1),
    LEFT(-1),
    DOWN(0);

    @Getter
    private int move;

    ActionType(int move) {
        this.move = move;
    }
}
