package nextstep.ladder.domain;

import java.util.List;

public class LadderJackpots {
    List<LadderJackpot> jackpots;

    private LadderJackpots(List<LadderJackpot> jackpots) {
        this.jackpots = jackpots;
    }

    public static LadderJackpots of(List<LadderJackpot> jackpots) {
        return new LadderJackpots(jackpots);
    }

}
