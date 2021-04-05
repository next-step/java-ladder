package step4_ladderGame.domain;

import step4_ladderGame.dto.MatchOfPrizeDto;
import step4_ladderGame.dto.PrizesDto;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class MatchOfPrize {

    private final Prizes prizes;
    private Map<String, String> matchResult;

    private MatchOfPrize(Prizes prizes) {
        this.prizes = prizes;
    }

    public static MatchOfPrize of(String[] prizeName, int playerCount) {
        Prizes prizes = Arrays.stream(prizeName)
                .map(Prize::of)
                .collect(collectingAndThen(toList(), prize -> Prizes.of(prizeName, playerCount)));
        return new MatchOfPrize(prizes);
    }

    public PrizesDto prizesDto() {
        return prizes.toDto();
    }

    public void match(Players players) {
        this.matchResult = prizes.match(players);
    }

    public MatchOfPrizeDto all() {
        return MatchOfPrizeDto.of(matchResult);
    }

    public MatchOfPrizeDto getPrizeResult(String player) {
        String prize = Optional.ofNullable(matchResult)
                .map(map -> map.get(player))
                .orElseThrow(() -> new IllegalArgumentException(player + "는 없는 플레이어 입니다."));
        return MatchOfPrizeDto.of(player, prize);
    }
}
