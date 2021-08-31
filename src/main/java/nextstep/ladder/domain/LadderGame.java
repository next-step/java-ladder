package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {
    private final List<Player> players;
    private final Ladder ladder;

    public LadderGame(final List<String> players, final int height, final PointCreator pointCreator) {
        this.players = Collections.unmodifiableList(
                players.stream()
                        .map(Player::new)
                        .collect(Collectors.toList())
        );
        this.ladder = new Ladder(players.size(), height, pointCreator);
    }

    public void climbLadder(List<String> results){

    }

    // todo
    public int doLadderGame(int index) {
        for (Line line : ladder.getLines()) {
            if (line.getPoints().get(index)) {
                --index;
            } else if (index + 1 != line.getPoints().size()) {
                if (line.getPoints().get(index + 1))
                    ++index;
            }
        }
        return index;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
