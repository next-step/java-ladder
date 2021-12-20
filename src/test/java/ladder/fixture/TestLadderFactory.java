package ladder.fixture;

import ladder.domain.*;


public class TestLadderFactory {
    public static Players createPlayer(String names) {
        return Players.of(names);
    }

    public static Line createRandomLine(int countOfPlayers) {
        return Line.of(new RandomPoints(countOfPlayers));
    }

    public static Ladder createLadder(String names, int height) {
        return Ladder.of(createPlayer(names), Height.of(height));
    }

}
