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

    public LadderGameResults playGame() {
        // 플레이어 수 만큼 순회하면서, 각 플레이어 별 결과를 만들고 그거를 리스트로 묶어내고, LadderGameResult로 만든다.
        return new LadderGameResults(
                IntStream.range(0, players.count())
                        .mapToObj(position -> new LadderGameResult(
                                players.getPlayerByPosition(position),
                                prizes.getPrizeByPosition(ladder.move(position))))
                        .collect(Collectors.toList()));

    }
}
