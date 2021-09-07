package nextstep.ladder.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LineTest {
    private Line line;

    @BeforeAll
    public void init() {
        List<Point> pointList = Arrays.asList(new Point(1, Direction.left()), new Point(1, Direction.right()), new Point(1, Direction.straight()));
        line = new Line(pointList);
    }

    @DisplayName("라인 포인트 별 이동 테스트")
    @ParameterizedTest
    @CsvSource({"0,0", "1,2", "2,1"})
    public void moveLineTest(int y, int expected) {
        //when
        int actual = line.move(y);

        //then
        assertThat(actual).isEqualTo(expected);
    }
}
