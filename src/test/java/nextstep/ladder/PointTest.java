package nextstep.ladder;

import nextstep.ladder.model.LineGenerator;
import nextstep.ladder.model.Point;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PointTest {
    @Test
    @DisplayName("Point 생성")
    void createPointTest() {
        //given

        //when
        Point point = new Point();

        //then
        Assertions.assertThat(point).isNotNull();
        Assertions.assertThat(point.getValue()).isEqualTo(false);
    }

    @Test
    @DisplayName("Point 다음 값 생성")
    void createPointValue() {
        //given
        LineGenerator lineGenerator = new MockLineGenerator();
        Point point = new Point();

        //when
        point.next(false, lineGenerator.generate());

        //then
        Assertions.assertThat(point.getValue()).isEqualTo(true);
    }
}
