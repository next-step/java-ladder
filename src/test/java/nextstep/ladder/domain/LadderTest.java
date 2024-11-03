package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LadderTest {

    @DisplayName("2명이면 선은 1개, 선은 그리는 것으로 하기")
    @Test
    void 전략패턴_검증() {
        Ladder ladder = new Ladder(1, (index) -> true);

        assertAll(
                () -> assertThat(ladder.getLines()).hasSize(1),
                () -> assertThat(ladder.getLines().get(0)).isTrue()
        );
    }

    @DisplayName("현재 index로 가야될 index 값 반환")
    @Test
    void search_position() {
        // 0      1      2     3     4      5      6
        //   true, false, false, true, false, false
        Ladder ladder = new Ladder(6, (index) -> index == 0 || index == 3);
        assertAll(
                () -> assertThat(ladder.decide(0)).isEqualTo(1)
                , () -> assertThat(ladder.decide(1)).isEqualTo(0)
                , () -> assertThat(ladder.decide(2)).isEqualTo(2)
                , () -> assertThat(ladder.decide(3)).isEqualTo(4)
                , () -> assertThat(ladder.decide(4)).isEqualTo(3)
                , () -> assertThat(ladder.decide(5)).isEqualTo(5)
                , () -> assertThat(ladder.decide(6)).isEqualTo(6)
        );
    }
}
