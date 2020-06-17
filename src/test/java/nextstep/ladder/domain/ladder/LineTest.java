package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class LineTest {

    @ValueSource(ints = {2, 3, 4, 5, 6})
    @ParameterizedTest
    @DisplayName("라인 생성 테스트 추가")
    void create(int maxPosition) {
        assertThatCode(() -> Line.init(maxPosition, new DirectionRandomPredicate()));
    }

    @ValueSource(ints = {-1, 0, 1})
    @ParameterizedTest
    @DisplayName("라인 생성 예외 테스트 추가")
    void exception(int maxPosition) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Line.init(maxPosition, new DirectionRandomPredicate()));
    }

    @Test
    @DisplayName("init method 테스트")
    void init(int sizeOfPerson) {
        Line line = Line.init(sizeOfPerson, new DirectionRandomPredicate());
        assertThat(line).isEqualTo(new Line(Points.newInstance(line.getPoints())));
    }

    @ValueSource(ints = {2, 3, 4, 5, 6})
    @ParameterizedTest
    @DisplayName("move 메소드 테스트")
    public void move(int initValue) {
        int value = 3;
        Line line = Line.init(initValue, new DirectionRandomPredicate());
        assertThat(line.move(value)).isEqualTo(initValue + value);
    }
}
