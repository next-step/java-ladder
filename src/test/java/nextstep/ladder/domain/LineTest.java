package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LineTest {
    @Test
    @DisplayName("생성 / 인원수를 넣음 / 성공")
    void create() {
        // expect
        assertThat(new Line(5)).isInstanceOf(Line.class);
    }

    @Test
    @DisplayName("생성 / 라인이 겹치게 생성 / IllegalArgumentException")
    void createOverlapLineFail() {
        // expect
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Line(Arrays.asList(Boolean.TRUE, Boolean.TRUE, Boolean.FALSE)));
    }
}