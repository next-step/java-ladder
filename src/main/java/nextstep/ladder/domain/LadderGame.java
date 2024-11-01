package nextstep.ladder.domain;

import java.util.List;
import java.util.ListIterator;

public class LadderGame {
    private final List<Player> players;
    private final List<Prize> prizes;
    private final Ladder ladder;
    private LadderGameResult result;

    public LadderGame(List<Player> players, List<Prize> prizes, Ladder ladder) {
        this.players = players;
        this.prizes = prizes;
        this.ladder = ladder;
    }

    public LadderGameResult play() {
        ladder.move();

        ListIterator<Player> playersIterator = players.listIterator();
        result = new OrderedLadderGameResult();

        playersIterator.forEachRemaining(player -> {
            result.add(player, prizes.get(ladder.getEndPoint(playersIterator.nextIndex())));
            playersIterator.next();
        });

        return result;
    }
}
