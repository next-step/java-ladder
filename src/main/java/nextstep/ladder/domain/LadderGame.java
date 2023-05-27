package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderGame {
    private final UserNames userNames;
    private final Lines lines;
    private final Map<String, Integer> gameResult;

    private LadderGame(LadderHeight ladderHeight, UserNames userNames) {
        this.userNames = userNames;
        this.lines = new Lines(ladderHeight, userNames.count());
        gameResult = new HashMap<>();
    }

    public static LadderGame create(LadderHeight ladderHeight, UserNames userNames) {
        return new LadderGame(ladderHeight, userNames);
    }

    public Lines getLines() {
        return lines;
    }

}
