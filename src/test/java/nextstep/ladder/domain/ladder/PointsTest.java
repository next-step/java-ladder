package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PointsTest {

    @MethodSource("points_list_create")
    @ParameterizedTest
    @DisplayName("points 생성 테스트")
    void create(List<Point> pointList) {
        assertThatCode(() -> Points.newInstance(pointList)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("points 생성 에외 테스트 - 위치가 2보다 작으면 예외가 발생한다.")
    void exception() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Points.newInstance(Arrays.asList(new Point(Direction.RIGHT))));
    }

    private static Stream<Arguments> points_list_create() {
        List<Point> pointList = Arrays.asList(new Point(Direction.RIGHT), new Point(Direction.LEFT));
        return Stream.of(Arguments.of(pointList));
    }
}
