package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultLineTest {
    @Test
    @DisplayName("실행 결과 중 5자리 초과인 문자열이 있으면 예외가 발생한다.")
    void validateLengthTest() {
        List<String> strings = List.of("123456");
        assertThatThrownBy(() -> new ResultLine(strings))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("결과 중 5자리 초과인 문자가 포함되어 있습니다.");
    }
}