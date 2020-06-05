package ladder.step4.domain;

import ladder.step4.exception.LadderResultMaximumSizeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderResultTest {

    @DisplayName("사다리 결과의 값이 5글자 이상일 경우 LadderResultMaximumSizeException 발생")
    @ParameterizedTest
    @ValueSource(strings = {"123456", "abcdef", "aaaaaa"})
    void 결과_이름_검증(String result) {
        assertThatExceptionOfType(LadderResultMaximumSizeException.class)
            .isThrownBy(() -> LadderResult.valueOf(result));
    }

    @DisplayName("객체를 재사용하고 있는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"aa", "bb", "cc"})
    void 객체_재사용_검증(String result) {
        assertEquals(true, LadderResult.valueOf(result) == LadderResult.valueOf(result));
    }
}
