package nextstep.ladder.domain.player;

import java.util.Arrays;

public class TestPlayers {

    private TestPlayers() {}

    public static Players players() {
        return Players.of(Arrays.asList("pobi", "honux", "crong", "jk"));
    }

}
