package nextstep.ladder.domain.generator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;
import java.util.stream.Stream;

import static nextstep.ladder.domain.generator.LineGenerator.assertValidLine;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LineGeneratorTest {
    @Test
    public void 사람수를_입력하면_사람수보다_하나작은_계단이_만들어진다() {
        int countOfPeople = 10;

        List<Boolean> line = LineGenerator.generateLine(countOfPeople);

        assertThat(line.size()).isEqualTo(countOfPeople - 1);
    }

    @ParameterizedTest
    @MethodSource("invalidLines")
    public void 연속된_계단은_생성될수없다(List<Boolean> invalidLine) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            assertValidLine(invalidLine);
        });
    }
    static Stream<List<Boolean>> invalidLines() {
        return Stream.of(
                List.of(true, true),
                List.of(true, true, true),
                List.of(false, true, true),
                List.of(true, true, false)
        );
    }

    @ParameterizedTest
    @NullAndEmptySource
    public void 계단은_null이거나_빈값일수없다(List<Boolean> invalidLine) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            assertValidLine(invalidLine);
        });
    }

    @ParameterizedTest
    @MethodSource("validLines")
    public void 연속되지_않은_계단은_생성할수있다(List<Boolean> line) {
        assertDoesNotThrow(() -> {
            assertValidLine(line);
        });
    }
    static Stream<List<Boolean>> validLines() {
        return Stream.of(
                List.of(false, false),
                List.of(true, false),
                List.of(false, true),
                List.of(true, false, false),
                List.of(false, true, false),
                List.of(false, false, true)
        );
    }
}