package nextstep.ladder.step3.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.ArrayList;
import java.util.Arrays;

import nextstep.ladder.step3.domain.Line;
import nextstep.ladder.step3.exception.NotEnoughWidthException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LineTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("생성 성공")
    void create(int size) {
        assertThat(Line.of(size, () -> true)).isInstanceOf(Line.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    @DisplayName("width 길이 예외처리")
    void width_길이_예외처리(int size) {
        assertThatExceptionOfType(NotEnoughWidthException.class)
            .isThrownBy(() -> Line.of(size, () -> true));
    }

    @ParameterizedTest
    @ValueSource(ints = 6)
    @DisplayName("중복라인 없는지 확인")
    void notDoubleLine(int width) {
        assertThat(Line.of(width, () -> true).getLine()).isEqualTo(new ArrayList<>(Arrays.asList(true, false, true, false, true, false)));
    }

}
