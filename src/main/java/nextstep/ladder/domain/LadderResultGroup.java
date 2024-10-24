package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static nextstep.ladder.util.StringUtil.toStringArray;

public class LadderResultGroup {

    private final List<String> ladderResults;

    public LadderResultGroup(List<String> ladderResults) {
        this.ladderResults = ladderResults;
    }

    public static LadderResultGroup of(String resultStrings, int playerCount) {
        String[] resultArray = toStringArray(resultStrings);

        if (resultArray.length != playerCount) {
            throw new IllegalArgumentException("참가자 수와 사다리 결과 수가 일치하지 않습니다.");
        }

        return new LadderResultGroup(
                Stream.of(resultArray)
                        .map(String::trim)
                        .collect(Collectors.toList()));
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
