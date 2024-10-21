package nextstep.ladder.dto;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.MatchResult;

import java.util.List;

public class ViewDto {

    private final List<String> playerNames;
    private final List<String> resultItems;
    private final Ladder ladder;
    private final MatchResult matchResult;

    public ViewDto(List<String> playerNames, List<String> resultItems, Ladder ladder, MatchResult matchResult) {
        this.playerNames = playerNames;
        this.resultItems = resultItems;
        this.ladder = ladder;
        this.matchResult = matchResult;
    }

    public List<String> getPlayerNames() {
        return playerNames;
    }

    public List<String> getResultItems() {
        return resultItems;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public MatchResult getLadderResult() {
        return matchResult;
    }
}
