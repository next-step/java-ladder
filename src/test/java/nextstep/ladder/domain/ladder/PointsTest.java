package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

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

    @MethodSource("points_list_create")
    @ParameterizedTest
    @DisplayName("points move 결과 테스트")
    void move(List<Point> pointList) {
        int position = 1;
        Points points = Points.newInstance(pointList);
        assertThat(points.move(position)).isEqualTo(0);
    }


    private static Stream<Arguments> points_list_create() {
        List<Point> pointList = Arrays.asList(new Point(Direction.RIGHT), new Point(Direction.LEFT));
        return Stream.of(Arguments.of(pointList));
    }
}
