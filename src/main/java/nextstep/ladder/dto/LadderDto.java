package nextstep.ladder.dto;

import java.util.List;
import java.util.Map;

public class LadderDto {
    private final List<String> ladderUsers;
    private final List<List<Boolean>> ladder;
    private final List<String> ladderPrizes;
    private final Map<String, String> prizeResult;

    public LadderDto(
        List<String> ladderUsers,
        List<List<Boolean>> ladder,
        List<String> ladderPrizes,
        Map<String, String> prizeResult
    ) {
        this.ladderUsers = ladderUsers;
        this.ladder = ladder;
        this.ladderPrizes = ladderPrizes;
        this.prizeResult = prizeResult;
    }

    public List<String> getLadderUsers() {
        return ladderUsers;
    }

    public List<List<Boolean>> getLadder() {
        return ladder;
    }

    public List<String> getLadderPrizes() {
        return ladderPrizes;
    }

    public Map<String, String> getPrizeResult() {
        return prizeResult;
    }
}
