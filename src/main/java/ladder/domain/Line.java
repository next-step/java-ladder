package ladder.domain;

import ladder.domain.type.ActionType;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Line {
    private static final List<ActionType> ACTION_TYPES = Arrays.asList(ActionType.RIGHT, ActionType.DOWN);
    private static final int POINT_INDEX = 0;

    @Getter
    private List<ActionType> actions;

    private Line(int userCount) {
        Collections.shuffle(ACTION_TYPES);

        actions = new ArrayList<>();
        actions.add(ACTION_TYPES.get(POINT_INDEX));

        for (int i = 1; i < userCount; i++) {
            actions.add(getPoint(userCount, i));
        }
    }

    public static List<Line> listOf(int userCount, int lineHeight) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < lineHeight; i++) {
            lines.add(new Line(userCount));
        }

        return lines;
    }

    private ActionType getPoint(int userCount, int index) {
        if (this.actions.get(index - 1) == ActionType.RIGHT) {
            return ActionType.LEFT;
        }

        if (index == userCount - 1) {
            return ActionType.DOWN;
        }

        Collections.shuffle(ACTION_TYPES);

        return ACTION_TYPES.get(POINT_INDEX);
    }
}
