package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LadderTest {

    @Test
    @DisplayName("특정 위치에서 사다리를 쭉 따라 갔을 때 최종 위치를 반환한다.")
    void getResultPosition() {
        Ladder ladder = TestLadder.ladder();

        assertAll(
            () -> assertThat(ladder.passThrough(Lane.wrap(0))).isEqualTo(Lane.wrap(0)),
            () -> assertThat(ladder.passThrough(Lane.wrap(1))).isEqualTo(Lane.wrap(3)),
            () -> assertThat(ladder.passThrough(Lane.wrap(2))).isEqualTo(Lane.wrap(2)),
            () -> assertThat(ladder.passThrough(Lane.wrap(3))).isEqualTo(Lane.wrap(1))
        );
    }

}
