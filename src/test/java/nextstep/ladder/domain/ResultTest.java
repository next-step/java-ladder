package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class ResultTest {
    @Test
    @DisplayName(value = "사다리 결과 생성 예외")
    void resultArgumentException() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Result("", -1);
                }).withMessageMatching("결과 순번은 0보다 작게 지정할 수 없습니다.");
    }
}
