package ladder;

import ladder.domain.Direction;
import ladder.domain.Position;
import ladder.domain.Line;
import ladder.domain.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LineTest {

    @Test
    @DisplayName("정해진 포인트로 라인 생성")
    void init() {
        int sizeOfPerson = 5;

        Line line = Line.init(sizeOfPerson);

        assertThat(line.pointListSize()).isEqualTo(sizeOfPerson);
    }

    @Test
    @DisplayName("빈포인트 리스트로 생성시 예외 발생 테스트")
    void create_with_empty_pointList() {
        List<Point> emptyPointList = new ArrayList<>();

        assertThatIllegalArgumentException().isThrownBy(() ->
                Line.ofPointList(emptyPointList)
        );
    }


    @Test
    @DisplayName("next시 왼쪽에 연결된 다음 point 있을시 이동 되는지 테스트")
    void next_to_left() {
        int number = 2;
        Position currentPosition = new Position(number);
        Line line = Line.ofDirectionList(Arrays.asList(Direction.of(false, false), Direction.of(false, true), Direction.of(true, false)));
        Position next = line.nextPosition(currentPosition);
        Position leftPosition = new Position(number - 1);

        assertThat(next).isEqualTo(leftPosition);
    }

    @Test
    @DisplayName("next시 오른쪽에 연결된 다음 point 있을시 이동 되는지 테스트")
    void next_to_right() {
        int number = 1;
        Position currentPosition = new Position(number);
        Line line = Line.ofDirectionList(Arrays.asList(Direction.of(false, false), Direction.of(false, true), Direction.of(true, false)));
        Position next = line.nextPosition(currentPosition);
        Position rightPosition = new Position(number + 1);

        assertThat(next).isEqualTo(rightPosition);
    }


    @Test
    @DisplayName("next시 연결된 point 없을시 그대로 인지 테스트")
    void next_same() {
        int number = 2;
        Position currentPosition = new Position(number);
        Line line = Line.ofDirectionList(Arrays.asList(Direction.of(false, false), Direction.of(false, false), Direction.of(false, false)));
        Position next = line.nextPosition(currentPosition);
        Position leftPosition = new Position(number);

        assertThat(next).isEqualTo(leftPosition);
    }


}
