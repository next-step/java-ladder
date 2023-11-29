package nextstep.ladder.domain;

import nextstep.ladder.controller.dto.GameInfo;
import nextstep.ladder.controller.dto.GameResult;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

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
        Map<String, Integer> pointAfterClimbing = climbLadder();
        Map<String, String> prizeByName = winningPrize.convertPointToPrize(pointAfterClimbing);

        return new GameResult(prizeByName);
    }

    private LinkedHashMap<String, Integer> climbLadder() {
        return IntStream.range(0, players.numOfPlayers())
            .boxed()
            .collect(toMap(
                players::name,
                ladder::climb,
                (oldVal, newVal) -> newVal,
                LinkedHashMap::new
            ));
    }
}
