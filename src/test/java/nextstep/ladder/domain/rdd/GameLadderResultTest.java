package nextstep.ladder.domain.rdd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameLadderResultTest {
    @Test
    void add() {
        GameLadderResult gameLadderResult = new GameLadderResult();
        gameLadderResult.add(1);
        gameLadderResult.add(0);
        gameLadderResult.add(2);

        assertThat(gameLadderResult.getResults()).containsExactly(1, 0, 2);
    }
}
