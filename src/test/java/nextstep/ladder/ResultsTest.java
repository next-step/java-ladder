package nextstep.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class ResultsTest {
    @Test
    void result_invalid() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Results.from("AAA");
                })
                .withMessage("최소 결과 개수는 2개 이상이어야 합니다.");
    }
}