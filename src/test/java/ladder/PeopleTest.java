package ladder;

import ladder.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PeopleTest {

    private People people;

    @BeforeEach
    void setUp() {
        // give
        people = new People("iron,black,pink,des");
    }

    @Test
    @DisplayName("결과값 도출 테스트")
    void resultValueTest() {
        // give
        List<Point> points1 = Arrays.asList(new Point(Boolean.TRUE), new Point(Boolean.FALSE),
                new Point(Boolean.TRUE), new Point(Boolean.FALSE));

        List<Point> points2 = Arrays.asList(new Point(Boolean.FALSE), new Point(Boolean.TRUE),
                new Point(Boolean.FALSE), new Point(Boolean.FALSE));

        List<Point> points3 = Arrays.asList(new Point(Boolean.TRUE), new Point(Boolean.FALSE),
                new Point(Boolean.FALSE), new Point(Boolean.FALSE));

        List<Line> lines = Arrays.asList(new Line(points1), new Line(points2), new Line(points3));

        // when
        people.matchResult(lines);

        // then
        assertThat(people.getPeople().get(0).getPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("글자수 초과시 익셉션 테스트")
    void overLengthExceptionTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            People people = new People("iron_man_mk2");
        });
    }
}
