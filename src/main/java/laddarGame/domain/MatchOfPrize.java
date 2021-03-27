package laddarGame.domain;

import laddarGame.dto.MatchOfPrizeDto;
import laddarGame.exception.NonMatchPlayerException;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class MatchOfPrize {

    private final Prizes prizes;
    private Map<String, String> resultPrizeResult;

    public MatchOfPrize(String prizeList) {
        this.prizes = new Prizes(prizeList);
    }

    public void match(List<String> playerList) {
        this.resultPrizeResult = prizes.match(playerList);
    }

    public MatchOfPrizeDto all() {
        return MatchOfPrizeDto.of(resultPrizeResult);
    }

    public MatchOfPrizeDto getPrizeResult(String player) {
        String prize = Optional.ofNullable(resultPrizeResult)
                .map(map -> map.get(player))
                .orElseThrow(() -> new NonMatchPlayerException(player + "는 없는 플레이어 입니다."));
        return MatchOfPrizeDto.of(player, prize);
    }

    public PrizesDto allPrize() {
        return prizes.toDto();
    }
}
