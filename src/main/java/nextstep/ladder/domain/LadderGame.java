package nextstep.ladder.domain;

import nextstep.ladder.controller.dto.GameInfo;
import nextstep.ladder.controller.dto.GameResult;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {

    private final Players players;
    private final Ladder ladder;
    private final WinningPrize winningPrize;

    public LadderGame(Players players, Ladder ladder, WinningPrize winningPrize) {
        this.players = players;
        this.ladder = ladder;
        this.winningPrize = winningPrize;
    }

    public LadderGame(GameInfo gameInfo) {
        this(gameInfo.players(), gameInfo.ladder(), gameInfo.winningPrize());
    }

    public String playersName() {
        return players.names();
    }

    public String ladder() {
        return ladder.toString();
    }

    public String prizes() {
        return winningPrize.toString();
    }

    public GameResult play() {
        Map<String, String> result = IntStream.range(0, players.numOfPlayers())
            .boxed()
            .collect(Collectors.toMap(players::name, i -> winningPrize.prize(ladder.climb(i))));

        return new GameResult(result);
    }
}
