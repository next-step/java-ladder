package laddarGame.domain;

import laddarGame.dto.MatchOfPrizeDto;

import java.util.List;
import java.util.Map;

public class MatchOfPrize {

    private final Prizes prizes;
    private Map<String, String> resultPrizeResult;

    public MatchOfPrize(String prizeList) {
        this.prizes = new Prizes(prizeList);
    }

    public void match(List<String> resultPlayerList) {
        this.resultPrizeResult = prizes.match(resultPlayerList);
    }

    public MatchOfPrizeDto all() {
        return MatchOfPrizeDto.of(resultPrizeResult);
    }

    public MatchOfPrizeDto getPrizeResult(String player) {
        return MatchOfPrizeDto.of(player, resultPrizeResult.get(player));
    }
}
