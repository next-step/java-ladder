package ladder.fixture;

import ladder.domain.Players;

public class TestLadderFactory {
    public static Players createPlayer(String names) {
        return Players.of(names);
    }

}
