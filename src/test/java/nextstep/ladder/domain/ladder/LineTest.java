package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.position.Position;
import nextstep.ladder.domain.rule.PointRule;
import nextstep.ladder.utils.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.Collections.nCopies;
import static java.util.Collections.singletonList;
import static nextstep.ladder.domain.factory.NoPointRule.noPointRule;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LineTest {

    @DisplayName("생성자에 empty points 가 들어오면 예외를 던진다.")
    @ParameterizedTest(name = "[{index}] points: {0}")
    @MethodSource("newEmptyPointsArguments")
    void new_emptyPoints_thrownException(List<Boolean> points) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Line(points))
                .withMessage(Line.NOT_POSITIVE_WIDTH_ERROR_MESSAGE);
    }

    public static Stream<Arguments> newEmptyPointsArguments() {
        return Stream.of(
                Arguments.of((Object) null),
                Arguments.of(Collections.emptyList())
        );
    }

    @DisplayName("입력 값이 null이면 예외를 던진다.")
    @ParameterizedTest
    @MethodSource("nullInputArguments")
    void create_nullInputs_thrownException(Positive width, PointRule pointRule) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Line.of(width, pointRule))
                .withMessage(Validator.NOT_NULL_ERROR_MESSAGE);
    }

    public static Stream<Arguments> nullInputArguments() {
        return Stream.of(
                Arguments.of(null, noPointRule()),
                Arguments.of(new Positive(1), null),
                Arguments.of(null, null)
        );
    }

    @DisplayName("정상적으로 생성하는지")
    @ParameterizedTest(name = "[{index}] width: {0}, pointRule: {1}, expectedLine: {2}")
    @MethodSource("createArguments")
    void create(Positive width, boolean pointRule, Line expectedLine) {
        assertThat(Line.of(width, () -> pointRule)).isEqualTo(expectedLine);
    }

    private static Stream<Arguments> createArguments() {
        return Stream.of(
                Arguments.of(new Positive(1), false, new Line(singletonList(false))),
                Arguments.of(new Positive(5), false, new Line(nCopies(5, false))),
                Arguments.of(new Positive(1), true, new Line(singletonList(true))),
                Arguments.of(new Positive(3), true, new Line(asList(true, false, true))),
                Arguments.of(new Positive(7), true, new Line(asList(true, false, true, false, true, false, true)))
        );
    }

    /**
     * 사다리 모양
     * 0     1     2     3
     * |-----|     |-----|
     */
    @DisplayName("points 개수가 홀수일 때 결과가 잘 나오는지")
    @ParameterizedTest(name = "[{index}] startPosition: {0}, expectedPosition: {1}")
    @CsvSource({
            "0, 1",
            "1, 0",
            "2, 3",
            "3, 2"
    })
    void play_oddPoints(int startPosition, int expectedPosition) {
        Line line = new Line(asList(true, false, true));
        verifyPlayResultEquals(startPosition, line, expectedPosition);
    }

    /**
     * 사다리 모양
     * 0     1     2     3     4
     * |     |-----|     |-----|
     */
    @DisplayName("points 개수가 짝수일 때 결과가 잘 나오는지")
    @ParameterizedTest(name = "[{index}] startPosition: {0}, expectedPosition: {1}")
    @CsvSource({
            "0, 0",
            "1, 2",
            "2, 1",
            "3, 4",
            "4, 3"
    })
    void play_evenPoints(int startPosition, int expectedPosition) {
        Line line = new Line(asList(false, true, false, true));
        verifyPlayResultEquals(startPosition, line, expectedPosition);
    }

    private void verifyPlayResultEquals(int startPosition, Line line, int expectedPosition) {
        Position position = line.play(new Position(startPosition));
        assertThat(position).isEqualTo(new Position(expectedPosition));
    }

}
