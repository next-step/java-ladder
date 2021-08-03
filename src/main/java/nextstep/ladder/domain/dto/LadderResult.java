package nextstep.ladder.domain.dto;

import java.util.List;

public class LadderResult {
    private final List<String> playerNames;
    private final List<LadderFigure> ladderFigures;

    private LadderResult(List<String> playerNames, List<LadderFigure> ladderFigures) {
        this.playerNames = playerNames;
        this.ladderFigures = ladderFigures;
    }

    public static LadderResult of(List<String> playerNames, List<LadderFigure> planes) {
        return new LadderResult(playerNames, planes);
    }

    public List<String> getPlayerNames() {
        return playerNames;
    }

    public List<LadderFigure> getLadderFigures() {
        return ladderFigures;
    }
}
