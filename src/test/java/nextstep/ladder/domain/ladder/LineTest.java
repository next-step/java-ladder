package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

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

    @MethodSource("ladderLine_argument_create")
    @ParameterizedTest
    void init(Points points, int sizeOfPerson) {
        Line line = Line.init(sizeOfPerson);
        assertThat(line).isEqualTo(new Line(points));
    }

    @ValueSource(ints = {2, 3, 4, 5, 6})
    @ParameterizedTest
    public void move(int initValue) {
        int value = 3;
        Line line = Line.init(initValue);
        assertThat(line.move(value)).isEqualTo(initValue + value);
    }


    private static Stream<Arguments> ladderLine_argument_create() {
        int sizeOfPerson = 5;
        return Stream.of(Arguments.of(
                Points.newInstance(sizeOfPerson, new DirectionRandomPredicate()), sizeOfPerson)
        );
    }

}
