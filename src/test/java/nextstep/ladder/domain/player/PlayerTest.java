package nextstep.ladder.domain.player;

import nextstep.ladder.domain.ladder.FakeLadder;
import nextstep.ladder.domain.ladder.Ladder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {

    @Test
    @DisplayName("다섯 글자보다 긴 이름은 예외 처리한다.")
    void throwExceptionIfLengthOfNameExceedFive() {
        assertThatThrownBy(() -> new Player("banana", 0)).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("참가자가 사다리를 탄다.")
    void passThroughLadder() {
        Ladder ladder = FakeLadder.ladder();

        Player player = new Player("tdd", 0);

        assertThat(player.passThrough(ladder)).isZero();
    }
}
