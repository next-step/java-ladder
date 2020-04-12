package ladder;

import ladder.domain.Direction;
import ladder.domain.Line;
import ladder.domain.Point;
import ladder.drawable.RandomDraw;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LineTest {
    @Test
    @DisplayName("가로라인 생성 테스트")
    void createLineTest(){
        assertThatCode(
                () -> new Line(5, new RandomDraw())
        ).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("가로라인 생성 테스트")
    void drawlineTest(){
        Line line = new Line(2, () -> true);
        assertAll(
                () -> assertThat(line.getPoints().size()).isEqualTo(2),
                () -> assertThat(line.getPoints().get(0)).isEqualTo(new Point(0, Direction.RIGHT)),
                () -> assertThat(line.getPoints().get(1)).isEqualTo(new Point(1, Direction.LEFT))
        );
    }

    @Test
    @DisplayName("가로라인 생성 테스트2")
    void drawlineTest2(){
        Line line = new Line(2, () -> false);
        assertAll(
                () -> assertThat(line.getPoints().size()).isEqualTo(2),
                () -> assertThat(line.getPoints().get(0)).isEqualTo(new Point(0, Direction.NONE)),
                () -> assertThat(line.getPoints().get(1)).isEqualTo(new Point(1, Direction.NONE))
        );
    }

    @Test
    @DisplayName("다음 인덱스 테스트")
    void getNextIndexTest(){
        Line line = new Line(2, () -> true);
        assertAll(
                () -> assertThat(line.getNextIndex(0)).isEqualTo(1),
                () -> assertThat(line.getNextIndex(1)).isEqualTo(0)
        );
    }
}
