package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

class AwardsTest {
    private static Awards awards = new Awards();

    @Test
    @Order(1)
    void award() {
        assertThatCode(() -> awards.award(Members.of("pobi,honux,crong,jk"), Prizes.of("꽝,5000,꽝,3000"),
            Ladder.of(4, 1, new BooleanStrategy.OnlyTrueStrategy()))).doesNotThrowAnyException();
    }

    @Test
    @Order(2)
    void findWinnerByName() {
        Winner winner = awards.findWinnerByName("pobi");

        assertThat(winner.member()).isEqualTo(Member.of("pobi"));
        assertThat(winner.prize()).isEqualTo(Prize.of("5000"));
    }
}
