package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LineTest {

    @ValueSource(ints = {2, 3, 4, 5, 6})
    @ParameterizedTest
    @DisplayName("라인 생성 테스트 추가")
    void create(int maxPosition) {
        assertThatCode(() -> Line.newInstance(maxPosition, new DirectionRandomPredicate()));
    }

    @ValueSource(ints = {-1, 0, 1})
    @ParameterizedTest
    @DisplayName("라인 생성 예외 테스트 추가")
    void exception(int maxPosition) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Line.newInstance(maxPosition, new DirectionRandomPredicate()));
    }

}
