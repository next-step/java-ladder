package ladder.domain.dto;

import ladder.domain.player.Player;
import ladder.domain.prize.Prize;
import ladder.exception.ErrorMessage;

import java.util.*;

public class LadderMatchResult {

    private final Map<Player, Prize> matchResult;

    private LadderMatchResult(final Map<Player, Prize> matchResult) {
        validate(matchResult);
        this.matchResult = matchResult;
    }

    private void validate(final Map<Player, Prize> matchResult) {
        if (Objects.isNull(matchResult)) {
            throw new IllegalArgumentException(ErrorMessage.NULL_VALUE);
        }
    }

    public static LadderMatchResult of(final Map<Player, Prize> matchResult) {
        return new LadderMatchResult(matchResult);
    }

    public List<Player> getPlayers() {
        return new ArrayList<>(matchResult.keySet());
    }
}
