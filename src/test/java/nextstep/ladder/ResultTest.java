package nextstep.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ResultTest {
    @Test
    void result_invalid() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Result.of("result", -1);
                })
                .withMessage("결과 순번은 0보다 작게 지정할 수 없습니다.");
    }
}