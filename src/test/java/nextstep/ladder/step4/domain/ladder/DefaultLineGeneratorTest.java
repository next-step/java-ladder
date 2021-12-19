package nextstep.ladder.step4.domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import nextstep.ladder.step4.domain.ladder.engine.Line;
import nextstep.ladder.step4.domain.ladder.strategy.RandomLineStrategy;
import nextstep.ladder.step4.exception.LineMinimumLengthException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class DefaultLineGeneratorTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 4, 5})
    @DisplayName("생성성공")
    void create(int width) {
        assertThat(new DefaultLineGenerator(new RandomLineStrategy()).generate(width)).isInstanceOf(Line.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1})
    @DisplayName("최소 길이 예외처리")
    void minimumLengthException(int width) {
        assertThatExceptionOfType(LineMinimumLengthException.class)
            .isThrownBy(() -> new DefaultLineGenerator(new RandomLineStrategy()).generate(width));
    }

}
