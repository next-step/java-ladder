package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LinesTest {

    @DisplayName("2명이면 선은 1개, 선은 그리는 것으로 하기")
    @Test
    void 전략패턴_검증() {
        Lines lines = new Lines(1, () -> true);

        assertAll(
                () -> assertThat(lines.getLines()).hasSize(1),
                () -> assertThat(lines.getLines().get(0)).isTrue()
        );
    }
}
