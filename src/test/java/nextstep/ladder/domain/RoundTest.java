package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RoundTest {

    @Test
    @DisplayName("Round 생성 테스트")
    void createRoundTest() {
        assertThat(Round.valueOf(Heights.from(5)))
                .isInstanceOf(Round.class);
    }

    @Test
    @DisplayName("Round 남았는지 테스트")
    void hasMoreRoundTest() {
        Round round = Round.valueOf(Heights.from(1));

        assertThat(round.hasMoreRound())
                .isTrue();
    }

}