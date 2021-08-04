package nextstep.ladder.domain.dto;

import nextstep.ladder.domain.GameElement;

import java.util.List;

public class LadderResult {
    private final List<String> playerNames;
    private final List<LadderFigure> ladderFigures;
    private final List<String> gameResults;

    private LadderResult(List<String> playerNames, List<LadderFigure> ladderFigures, List<String> gameResults) {
        this.playerNames = playerNames;
        this.ladderFigures = ladderFigures;
        this.gameResults = gameResults;
    }

    public static LadderResult of(GameElement gameElement, List<LadderFigure> planes) {
        return new LadderResult(
                gameElement.getPlayers().getNames(),
                planes,
                gameElement.getGameResults().getGameResultValues()
        );
    }

    public List<String> getPlayerNames() {
        return playerNames;
    }

    public List<LadderFigure> getLadderFigures() {
        return ladderFigures;
    }

    public List<String> getGameResults() {
        return gameResults;
    }
}
