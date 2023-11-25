package nextstep.ladder.domain;

import nextstep.ladder.controller.dto.GameInfo;

import java.util.List;
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

    public Players play() {
        List<Player> finished = IntStream.range(0, players.numOfPlayers())
            .mapToObj(i -> players.moveOne(i, ladder))
            .collect(Collectors.toUnmodifiableList());

        return new Players(finished);
    }

    public String findReusltBy(String name) {
        Player player = players.findPlayerBy(name);
        return winningPrize.findWinningPrizeBy(player);
    }
}
