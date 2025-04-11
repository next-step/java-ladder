package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderLineTest {
    @Test
    @DisplayName("생성자 동작 확인")
    void create() {
        List<Bridge> bridges = List.of(new Bridge(true), new Bridge(false));
        assertThat(new LadderLine(bridges)).isInstanceOf(LadderLine.class);
    }

    @Test
    @DisplayName("숫자로 LadderLine.generate 메소드 동작 확인")
    void generate() {
        assertThat(LadderLine.generate(2)).isInstanceOf(LadderLine.class);
    }

    @Test
    @DisplayName("사다리 라인 생성 시 가로선(true)이 2번 연속 나올 수 없음 - 실패")
    void true_true_case() {
        assertThatThrownBy(() -> new LadderLine(List.of(new Bridge(true), new Bridge(true))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LadderLine.INVALID_LINE_VALUE_MESSAGE);
    }

    @Test
    @DisplayName("사다리 라인 생성 시 비어 있는 값이 올 수 없음(empty) - 실패")
    void empty_case() {
        assertThatThrownBy(() -> new LadderLine(List.of()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LadderLine.INVALID_LINE_SIZE_MESSAGE);
    }
}
