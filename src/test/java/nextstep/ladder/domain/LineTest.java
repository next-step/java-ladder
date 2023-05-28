package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LineTest {

    @ParameterizedTest
    @ValueSource(ints = {3, 5, 6, 10})
    public void Line_생성_테스트(int countOfPerson) throws Exception {
        Line line = Line.of(countOfPerson);
        List<Boolean> booleans = line.toList();
        booleans.stream()
                .forEach(point -> assertThat(point).isInstanceOf(Boolean.class));
    }

    @DisplayName("가로 라인 겹칠 수 없다. ex. |-----|-----|")
    @Test
    public void Line_예외_테스트() throws Exception {
        List<Boolean> booleans = Arrays.asList(true, true);
        assertThatIllegalArgumentException().isThrownBy(() -> Line.of(booleans));
    }

    @DisplayName("Line 초기값은 양수여야 한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, -12, -22, 0})
    public void Line_예외_테스트(int countOfPerson) throws Exception {
        assertThatIllegalArgumentException().isThrownBy(() -> Line.of(countOfPerson));
    }

    @Test
    public void 오른쪽_이동_테스트() throws Exception {
        Line line = Line.of(Arrays.asList(true, false));
        assertThat(line.movePin(0)).isEqualTo(1);
    }

    @Test
    public void 왼쪽_이동_테스트() throws Exception {
        Line line = Line.of(Arrays.asList(true, false));
        assertThat(line.movePin(1)).isEqualTo(0);
    }

    @ParameterizedTest
    @MethodSource("moveTest")
    public void 라인_이동_테스트(List<Boolean> points, int start, int end) throws Exception {
        Line line = Line.of(points);
        assertThat(line.movePin(start)).isEqualTo(end);
    }

    static Stream<Arguments> moveTest() throws Throwable {
        return Stream.of(
                Arguments.of(Arrays.asList(true, false, false), 0, 1),
                Arguments.of(Arrays.asList(true, false, false), 1, 0),
                Arguments.of(Arrays.asList(true, false, false), 2, 2),
                Arguments.of(Arrays.asList(false, true, false), 2, 1)
        );
    }
}
