package nextstep.ladder;

import nextstep.ladder.domain.Direction;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {
    @Test
    @DisplayName("ofString 메소드로 Line 이 잘 만들어지는지 테스트")
    public void ofString() {
        Line lineByStringA = Line.ofString("right,left,right,left,none,none");
        Line lineByStringB = Line.ofString("none,right,left,right,left,none");
        Line lineByStringC = Line.ofString("right,left,none,right,left");

        List<Point> lineA = Arrays.asList(Point.of(new Direction("right"), 0), Point.of(new Direction("left"), 1),
                Point.of(new Direction("right"), 2), Point.of(new Direction("left"), 3),
                Point.of(new Direction("none"), 4), Point.of(new Direction("none"), 5));

        List<Point> lineB = Arrays.asList(Point.of(new Direction("none"), 0), Point.of(new Direction("right"), 1),
                Point.of(new Direction("left"), 2), Point.of(new Direction("right"), 3),
                Point.of(new Direction("left"), 4), Point.of(new Direction("none"), 5));

        List<Point> lineC = Arrays.asList(Point.of(new Direction("right"), 0), Point.of(new Direction("left"), 1),
                Point.of(new Direction("none"), 2), Point.of(new Direction("right"), 3),
                Point.of(new Direction("left"), 4));

        assertThat(lineByStringA).isEqualTo(Line.of(lineA));
        assertThat(lineByStringB).isEqualTo(Line.of(lineB));
        assertThat(lineByStringC).isEqualTo(Line.of(lineC));
    }

    @Test
    @DisplayName("ofString 메소드 인풋으로, Point로 변환이 불가능한 문자열이 들어왔을 때 'Boolean 으로 변환될 수 없습니다.' 를 반환")
    public void checkCanBeBoolean() {
        assertThatThrownBy(() -> {
            Line.ofString("test,test,test");
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Point 로 변환될 수 없습니다.");
    }

    @Test
    @DisplayName("sizeOfPerson 에 맞는 크기의 points 를 가지고 있는 Line 을 반환")
    public void init() {
        int sizeOfPerson = 10;
        Line line = Line.init(sizeOfPerson);
        assertThat(line.getPoints().size()).isEqualTo(10);
    }

    @Test
    @DisplayName("init 시에 point 들의 index 가 잘 들어갔는지 테스트")
    public void init_point_index_check() {
        int sizeOfPerson = 10;
        Line line = Line.init(sizeOfPerson);
        for (int index = 0; index < 10; index++) {
            assertThat(line.getPoints().get(index).getIndex()).isEqualTo(index);
        }
    }

    @DisplayName("현재 position 에서 move 한 point 의 position 을 반환")
    @ParameterizedTest
    @CsvSource({
            "0,    1",
            "1,    0",
            "2,    3",
            "3,    2",
            "4,    4",
    })
    public void move_one(int position, int movedPosition) {
        Line line = Line.ofString("right,left,right,left,none");
        assertThat(line.move(position)).isEqualTo(movedPosition);

        line = Line.ofString("right,left,right,left,none,none");
        assertThat(line.move(0)).isEqualTo(1);
        assertThat(line.move(1)).isEqualTo(0);
        assertThat(line.move(4)).isEqualTo(4);
        assertThat(line.move(3)).isEqualTo(2);
        assertThat(line.move(5)).isEqualTo(5);

    }

    @DisplayName("현재 position 에서 move 한 point 의 position 을 반환")
    @ParameterizedTest
    @CsvSource({
            "0,    1",
            "1,    0",
            "2,    3",
            "3,    2",
            "4,    4",
            "5,    5",
    })
    public void move_two(int position, int movedPosition) {
        Line line = Line.ofString("right,left,right,left,none,none");
        assertThat(line.move(0)).isEqualTo(1);
        assertThat(line.move(1)).isEqualTo(0);
        assertThat(line.move(4)).isEqualTo(4);
        assertThat(line.move(3)).isEqualTo(2);
        assertThat(line.move(5)).isEqualTo(5);

    }
}
