package nextstep.ladder.domain.result;

import nextstep.ladder.domain.player.Player;
import nextstep.ladder.util.StringSplitter;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LadderResultGroup {

    private final List<String> ladderResults;

    public LadderResultGroup(List<String> ladderResults) {
        this.ladderResults = ladderResults;
    }

    public static LadderResultGroup of(String ladderResultsToSplit, int playerCount) {
        List<String> resultArray = new StringSplitter(ladderResultsToSplit).getSplit();

        if (resultArray.size() != playerCount) {
            throw new IllegalArgumentException("참가자 수와 사다리 결과 수가 일치하지 않습니다.");
        }

        return new LadderResultGroup(resultArray);
    }

    public MatchResult matchResult(List<Player> players) {
        return MatchResult.of(players, Collections.unmodifiableList(ladderResults));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LadderResultGroup that = (LadderResultGroup) o;
        return Objects.equals(ladderResults, that.ladderResults);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(ladderResults);
    }
}
