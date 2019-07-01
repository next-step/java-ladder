package nextstep.step2.domain;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {
    private final Players players;
    private final Integer ladderHeight;

    public LadderGame(final Players players, final int ladderHeight) {
        this.players = players;
        this.ladderHeight = ladderHeight;
    }

    public Ladder start() {
        final var playerCount = players.getPlayerCount();
        return new Ladder(IntStream.range(0, ladderHeight)
                                   .mapToObj(i -> Line.createByRandomPoint(playerCount))
                                   .collect(Collectors.toList()));
    }

}
