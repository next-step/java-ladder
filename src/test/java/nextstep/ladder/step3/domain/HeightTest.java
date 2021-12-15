package nextstep.ladder.step3.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import nextstep.ladder.step3.domain.Height;
import nextstep.ladder.step3.exception.LadderLengthException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class HeightTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("생성 성공")
    void create(int number) {
        assertThat(new Height(number)).isEqualTo(new Height(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    @DisplayName("최소길이 예외처리")
    void ladderLengthException(int number) {
        assertThatExceptionOfType(LadderLengthException.class)
            .isThrownBy(() -> new Height(number));
    }

}
