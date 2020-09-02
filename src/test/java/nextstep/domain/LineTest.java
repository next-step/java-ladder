package nextstep.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("선")
public class LineTest {

    @DisplayName("횡단선 그리기")
    @ParameterizedTest
    @MethodSource("drawTransverseBarMethodSource")
    public void drawTransverseBar(int coutOfPerson, TransverseBarStrategy transverseBarStrategy, Boolean[] result) {
        List<Boolean> line = Line.drawTransverseBar(coutOfPerson, transverseBarStrategy);
        assertThat(line).containsExactly(result);
    }

    private static Stream<Arguments> drawTransverseBarMethodSource() {
        return Stream.of(
                Arguments.of(5, new AllDrawTransverseBarStrategy(), new Boolean [] { true, true, true, true, true }),
                Arguments.of(5, new NotAllDrawTransverseBarStrategy(), new Boolean [] { false, false, false, false, false }),
                Arguments.of(5, new SwitchDrawTransverseBarStrategy(), new Boolean [] { true, false, true, false, true })
        );
    }

    @DisplayName("라인 밸리데이션 - 최소 하나의 횡단선을 가진다.")
    @ParameterizedTest
    @MethodSource("validateHasOneOrMoreTransverseBarMethodSource")
    public void validateHasOneOrMore(int coutOfPerson, TransverseBarStrategy transverseBarStrategy, boolean result) {
        List<Boolean> line = Line.drawTransverseBar(coutOfPerson, transverseBarStrategy);
        assertThat(Line.validateHasOneOrMoreTransverseBar(line)).isEqualTo(result);
    }

    private static Stream<Arguments> validateHasOneOrMoreTransverseBarMethodSource() {
        return Stream.of(
                Arguments.of(5, new AllDrawTransverseBarStrategy(), true),
                Arguments.of(5, new NotAllDrawTransverseBarStrategy(), false),
                Arguments.of(5, new SwitchDrawTransverseBarStrategy(), true)
        );
    }

    @DisplayName("라인 밸리데이션 - 횡단선이 서로 겹치지 않는다.")
    @ParameterizedTest
    @MethodSource("validateNotOverlapMethodSource")
    public void validateNotOverlap(int coutOfPerson, TransverseBarStrategy transverseBarStrategy, boolean result) {
        List<Boolean> line = Line.drawTransverseBar(coutOfPerson, transverseBarStrategy);
        assertThat(Line.validateNotOverlap(line)).isEqualTo(result);
    }

    private static Stream<Arguments> validateNotOverlapMethodSource() {
        return Stream.of(
                Arguments.of(5, new AllDrawTransverseBarStrategy(), false),
                Arguments.of(5, new NotAllDrawTransverseBarStrategy(), true),
                Arguments.of(5, new SwitchDrawTransverseBarStrategy(), true)
        );
    }

}
