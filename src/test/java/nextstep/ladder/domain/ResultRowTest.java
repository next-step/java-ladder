package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ResultRowTest {
    @Test
    @DisplayName("실행 결과 중 5자리 초과인 문자열이 있으면 예외가 발생한다.")
    void validateLengthTest() {
        List<String> strings = List.of("123456");
        assertThatThrownBy(() -> new ResultRow(strings))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("결과 중 5자리 초과인 문자가 포함되어 있습니다.");
    }
}