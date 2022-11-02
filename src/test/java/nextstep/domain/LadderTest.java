package nextstep.domain;

import nextstep.strategy.RandomLineStrategy;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    private static final int HEIGHT_LENGTH = 6;

    @Test
    void test_Equals_size_If_create_ladder_with_same_height_length() {
        Players players = new Players(List.of("tobi", "pobi", "cao", "petty"));
        Ladder ladder = new Ladder(HEIGHT_LENGTH, players.getPlayersSize(), RandomLineStrategy.getInstance());

        assertThat(ladder.getLines().size()).isEqualTo(HEIGHT_LENGTH);
    }
}
