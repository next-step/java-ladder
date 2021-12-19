package ladder.fixture;

import ladder.domain.Line;
import ladder.domain.Players;
import ladder.domain.RandomPoints;

public class TestLadderFactory {
    public static Players createPlayer(String names) {
        return Players.of(names);
    }

    public static Line createRandomLine(int countOfPlayers) {
        return new Line(new RandomPoints(countOfPlayers));
    }

}
