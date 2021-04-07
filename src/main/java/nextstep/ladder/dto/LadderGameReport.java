package nextstep.ladder.dto;

import nextstep.ladder.util.Pair;

import java.util.List;

public class LadderGameReport {

    private final List<Pair<PlayerDto, RewardDto>> results;

    public LadderGameReport(List<Pair<PlayerDto, RewardDto>> results) {
        this.results = results;
    }

    public List<Pair<PlayerDto, RewardDto>> getResults() {
        return results;
    }
}
