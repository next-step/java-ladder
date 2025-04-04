package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderLineTest {
    @Test
    @DisplayName("2개의 생성자 동작 여부 확인")
    void create() {
        assertThat(new LadderLine(new Boolean[]{true, false})).isEqualTo(new LadderLine(List.of(new Boolean[]{true, false})));
    }

    @Test
    @DisplayName("숫자로 generate 호출 동작 여부 확인")
    void generate() {
        assertThat(LadderLine.generate(2)).isInstanceOf(LadderLine.class);
    }

    @Test
    @DisplayName("사다리 라인 생성 시 유효성 검사(true, true) - 실패")
    void true_true_case() {
        assertThatThrownBy(() -> new LadderLine(new Boolean[]{true, true}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LadderLine.INVALID_LINE_VALUE_MESSAGE);
    }

    @Test
    @DisplayName("사다리 라인 생성 시 유효성 검사(empty) - 실패")
    void empty_case() {
        assertThatThrownBy(() -> new LadderLine(new Boolean[]{}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LadderLine.INVALID_LINE_SIZE_MESSAGE);
    }
}
