package nextstep.ladder.domain;

import nextstep.ladder.utils.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.Collections.nCopies;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LineTest {

    @DisplayName("생성자에 empty points 가 들어오면 예외를 던진다.")
    @ParameterizedTest(name = "[{index}] points: {0}")
    @MethodSource("newEmptyPointsArguments")
    void new_emptyPoints_thrownException(List<Boolean> points) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Line(points))
                .withMessage(Line.NOT_POSITIVE_ERROR_MESSAGE);
    }

    public static Stream<Arguments> newEmptyPointsArguments() {
        return Stream.of(
                Arguments.of((Object) null),
                Arguments.of(Collections.emptyList())
        );
    }

    @DisplayName("너비가 양수가 아니라면 예외를 던진다.")
    @ParameterizedTest(name = "[{index}] width: {0}")
    @ValueSource(ints = {-1, 0})
    void create_notPositive_thrownException(int width) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Line.of(width, neverPointRule()))
                .withMessage(Line.NOT_POSITIVE_ERROR_MESSAGE);
    }

    @DisplayName("입력 값이 null이면 예외를 던진다.")
    @Test
    void create_nullStrategy_thrownException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Line.of(1, null))
                .withMessage(Validator.NOT_NULL_ERROR_MESSAGE);
    }

    @DisplayName("정상적으로 생성하는지")
    @ParameterizedTest(name = "[{index}] width: {0}, pointRule: {1}, expectedLine: {2}")
    @MethodSource("createArguments")
    void create(int width, boolean pointRule, Line expectedLine) {
        assertThat(Line.of(width, () -> pointRule)).isEqualTo(expectedLine);
    }

    private static Stream<Arguments> createArguments() {
        return Stream.of(
                Arguments.of(1, false, new Line(singletonList(false))),
                Arguments.of(5, false, new Line(nCopies(5, false))),
                Arguments.of(1, true, new Line(singletonList(true))),
                Arguments.of(3, true, new Line(asList(true, false, true))),
                Arguments.of(7, true, new Line(asList(true, false, true, false, true, false, true)))

        );
    }

    private static PointRule neverPointRule() {
        return () -> false;
    }

}
