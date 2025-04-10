package ladder.domain;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {
    private final Players players;
    private final Prizes prizes;
    private final Ladder ladder;

    public LadderGame(Players players, Prizes prizes, Ladder ladder) {
        this.players = players;
        this.prizes = prizes;
        this.ladder = ladder;
    }

    public LadderGameResult playGame() {
        return new LadderGameResult(IntStream.range(0, players.count())
                .boxed()
                .collect(Collectors.toMap(
                        position -> players.getPlayerByPosition(position),
                        position -> prizes.getPrizeByPosition(ladder.move(position))
                )));
    }
}
