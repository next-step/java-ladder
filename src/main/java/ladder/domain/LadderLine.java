package ladder.domain;

import ladder.domain.type.ActionType;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class LadderLine {
    @Getter
    private List<ActionType> actions;

    public LadderLine(List<ActionType> actions) {
        this.actions = actions;
    }

    public static List<LadderLine> listOf(int userCount, int lineHeight) {
        List<LadderLine> ladderLines = new ArrayList<>();

        for (int i = 0; i < lineHeight; i++) {
            ladderLines.add(new LadderLine(ActionType.listOf(userCount)));
        }

        return ladderLines;
    }

    public int getActionsSize() {
        return this.actions.size();
    }

    public int getMovePoint(int index) {
        return this.actions.get(index).getMove();
    }
}
