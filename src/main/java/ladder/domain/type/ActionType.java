package ladder.domain.type;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum ActionType {
    RIGHT(1),
    LEFT(-1),
    DOWN(0);

    private static final List<ActionType> ACTION_TYPES = Arrays.asList(ActionType.RIGHT, ActionType.DOWN);
    private static final int POINT_INDEX = 0;

    @Getter
    private int move;

    ActionType(int move) {
        this.move = move;
    }

    public static List<ActionType> listOf(int userCount) {
        Collections.shuffle(ACTION_TYPES);

        List<ActionType> actions = new ArrayList<>();
        actions.add(ACTION_TYPES.get(POINT_INDEX));

        for (int i = 1; i < userCount; i++) {
            actions.add(getPoint(userCount, i, actions));
        }

        return actions;
    }

    private static ActionType getPoint(int userCount, int index, List<ActionType> actions) {
        if (actions.get(index - 1) == ActionType.RIGHT) {
            return ActionType.LEFT;
        }

        if (index == userCount - 1) {
            return ActionType.DOWN;
        }

        Collections.shuffle(ACTION_TYPES);

        return ACTION_TYPES.get(POINT_INDEX);
    }
}
