package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class AwardsTest {
    private static Awards awards;

    @BeforeAll
    static void setUp() {
        awards = new Awards();
        awards.award(Members.of("pobi,honux,crong,jk"), Prizes.of("꽝,5000,꽝,3000"),
            Ladder.of(4, 1, new BooleanStrategy.OnlyTrueStrategy()));
    }

    @Test
    void award() {
        Winner winner = awards.winner(0);

        assertThat(winner.member()).isEqualTo(Member.of("pobi"));
        assertThat(winner.prize()).isEqualTo(Prize.of("5000"));
    }
}
