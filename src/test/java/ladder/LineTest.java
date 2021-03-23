package ladder;

import ladder.domain.LadderNumber;
import ladder.domain.Line;
import ladder.domain.Point;
import org.assertj.core.api.AssertionsForClassTypes;
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
    void create_of() {
        Point samplePoint1 = new Point(false);
        Point samplePoint2 = new Point(true);
        List<Point> expectedPointList = Arrays.asList(samplePoint1,samplePoint2);
        Line line = Line.of(expectedPointList);
        List<Point> result = line.pointList();

        assertThat(result.size()).isEqualTo(expectedPointList.size());
        for (int i = 0; i < result.size(); i++) {
            assertThat(result.get(i).isFilled()).isEqualTo(expectedPointList.get(i).isFilled());
        }
    }

    @Test
    @DisplayName("가로줄이 겹치는 포인트로 라인 생성시 예외 발생 테스트")
    void create_with_overlapping_pointList() {
        Point samplePoint1 = new Point(true);
        Point samplePoint2 = new Point(true);
        List<Point> overlappingPointList = Arrays.asList(samplePoint1,samplePoint2);

        assertThatIllegalArgumentException().isThrownBy(() ->
                Line.of(overlappingPointList)
        );
    }

    @Test
    @DisplayName("빈포인트 리스트로 생성시 예외 발생 테스트")
    void create_with_empty_pointList() {
        List<Point> emptyPointList = new ArrayList<>();

        assertThatIllegalArgumentException().isThrownBy(() ->
                Line.of(emptyPointList)
        );
    }

    @Test
    @DisplayName("램던 라인 생성후 가로줄 겹치느지 여부 테스트")
    void create_random() {
        int countOfPerson = 5;
        Line line = Line.random(5);

        assertThat(line.pointListSize()).isEqualTo(countOfPerson);
        assertThat(isOverlapping(line)).isFalse();
    }

    private boolean isOverlapping(Line line) {
        for (int i = 1; i < line.pointListSize(); i++) {
            boolean previousPointIsFilled = line.isFilledAt(i - 1);
            if (previousPointIsFilled && line.isFilledAt(i)) {
                return true;
            }
        }
        return false;
    }


    @Test
    @DisplayName("next시 왼쪽에 연결된 다음 사다리 있을시 이동 되는지 테스트")
    void next_to_left() {
        int number = 2;
        LadderNumber currentLadderNumber = new LadderNumber(number);
        Line line = Line.of(Arrays.asList(new Point(false), new Point(false), new Point(true)));
        LadderNumber next = line.nextLadderNumber(currentLadderNumber);
        LadderNumber leftLadderNumber = new LadderNumber(number -1);

        AssertionsForClassTypes.assertThat(next).isEqualTo(leftLadderNumber);
    }

    @Test
    @DisplayName("next시 오른쪽에 연결된 다음 사다리 있을시 이동 되는지 테스트")
    void next_to_right() {
        int number = 1;
        LadderNumber currentLadderNumber = new LadderNumber(number);
        Line line = Line.of(Arrays.asList(new Point(false), new Point(false), new Point(true)));
        LadderNumber next = line.nextLadderNumber(currentLadderNumber);
        LadderNumber rightLadderNumber = new LadderNumber(number + 1);

        AssertionsForClassTypes.assertThat(next).isEqualTo(rightLadderNumber);
    }


    @Test
    @DisplayName("next시 연결된 라인이 없을시 그대로 인지 테스트")
    void next_same() {
        int number = 2;
        LadderNumber currentLadderNumber = new LadderNumber(number);
        Line line = Line.of(Arrays.asList(new Point(false), new Point(false), new Point(false)));
        LadderNumber next = line.nextLadderNumber(currentLadderNumber);
        LadderNumber leftLadderNumber = new LadderNumber(number);

        AssertionsForClassTypes.assertThat(next).isEqualTo(leftLadderNumber);
    }

}
