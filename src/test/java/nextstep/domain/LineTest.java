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
        List<Boolean> points = transverseBarStrategy.draw(coutOfPerson);
        assertThat(points).containsExactly(result);
    }

    private static Stream<Arguments> drawTransverseBarMethodSource() {
        return Stream.of(
                Arguments.of(5, new AllDrawTransverseBarStrategy(), new Boolean [] { true, true, true, true }),
                Arguments.of(5, new NotAllDrawTransverseBarStrategy(), new Boolean [] { false, false, false, false }),
                Arguments.of(5, new SwitchDrawTransverseBarStrategy(), new Boolean [] { true, false, true, false })
        );
    }


    @DisplayName("라인 생성")
    @ParameterizedTest
    @MethodSource("createMethod")
    public void create(int coutOfPerson, TransverseBarStrategy transverseBarStrategy) {
        Line expect = new Line(coutOfPerson, transverseBarStrategy);
        Line actual = new Line(coutOfPerson, transverseBarStrategy);
        assertThat(actual).isEqualTo(expect);
    }

    private static Stream<Arguments> createMethod() {
        return Stream.of(
                Arguments.of(5, new SwitchDrawTransverseBarStrategy(), true)
        );
    }


}
