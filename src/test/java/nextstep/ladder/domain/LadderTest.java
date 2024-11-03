package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LadderTest {

    @DisplayName("2명이면 선은 1개, 선은 그리는 것으로 하기")
    @Test
    void 전략패턴_검증() {
        Ladder ladder = new Ladder(1, () -> true);

        assertAll(
                () -> assertThat(ladder.getLines()).hasSize(1),
                () -> assertThat(ladder.getLines().get(0)).isTrue()
        );
    }
}
