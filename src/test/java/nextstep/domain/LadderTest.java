package nextstep.domain;

import nextstep.strategy.RandomLineStrategy;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    void create_ladder() {
        Players players = new Players(List.of("tobi", "pobi", "cao", "petty"));
        Ladder ladder = new Ladder(6, players.getPlayers().size(), RandomLineStrategy.getInstance());

        assertThat(ladder.getLines().size()).isEqualTo(6);
    }
}
