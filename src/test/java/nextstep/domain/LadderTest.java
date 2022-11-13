package nextstep.domain;

import nextstep.strategy.RandomLineStrategy;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    private static final int HEIGHT_LENGTH = 6;
    private static final int PLAYER_COUNT = 5;
    private Ladder ladder;

    @Test
    void 같은_길이로_ladder_생성시_같은_길이가_반환된다() {
        Players players = new Players(List.of("tobi", "pobi", "cao", "petty"));
        Ladder ladder = new Ladder(HEIGHT_LENGTH, players.getPlayersSize(), RandomLineStrategy.getInstance());

        assertThat(ladder.getLines().size()).isEqualTo(HEIGHT_LENGTH);
    }

    @Test
    void true_로_시작하는_Ladder_객체_생성시_사다리_이동한_만큼_숫자가_반환된다() {
        Ladder ladder = new Ladder(HEIGHT_LENGTH, PLAYER_COUNT, () -> true);
        assertThat(ladder.move(1)).isEqualTo(1);
    }
}
