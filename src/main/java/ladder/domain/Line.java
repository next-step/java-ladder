package ladder.domain;

import ladder.domain.type.ActionType;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Line {
    @Getter
    private List<ActionType> actions;

    public Line(List<ActionType> actions) {
        this.actions = actions;
    }

    public static List<Line> listOf(int userCount, int lineHeight) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < lineHeight; i++) {
            lines.add(new Line(ActionType.listOf(userCount)));
        }

        return lines;
    }

    public int getMovePoint(int index) {
        return this.actions.get(index).getMove();
    }
}
