package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @Test
    @DisplayName("right가 true일때 현재 index에 1을 더한 값을 반환한다.")
    void should_returns_the_current_index_plus_1_when_right_is_true() {
        //Given
        Point point = new Point(0, false, true);

        //When
        int index = point.move();

        //Then
        assertThat(index).isOne();
    }

    @Test
    @DisplayName("left가 true일때 현재 index에 1을 뺀 값을 반환한다.")
    void should_returns_the_current_index_minus_1_when_left_is_true() {
        //Given
        Point point = new Point(1, false, true);

        //When
        int index = point.move();

        //Then
        assertThat(index).isZero();
    }


    @Test
    @DisplayName("right, left가 모두 false이면, 현재 index를 반환한다.")
    void should_returns_the_current_index_when_left_and_right_are_false() {
        //Given
        Point point = new Point(0, false, false);

        //When
        int index = point.move();

        //Then
        assertThat(index).isZero();
    }

    @Test
    @DisplayName("right, left가 모두 true이면, exception을 던진다.")
    void should_throw_exception_when_left_and_right_are_true() {
        //Given
        Point point = new Point(0, true, true);

        //When & Then
//        assertThat(mov)

        //When
        int index = point.move();

    }


//    @Test
//    @DisplayName("가로 사다리 생성 전략이 blank(false)가 들어가면, blank만 가진 사다리를 반환한다.")
//    void should_return_false_points() {
//        //Given & When
//        LadderLine ladderLine = new LadderLine(3);
//
//        //Then
//        assertThat(ladderLine.getPoints()).containsAll(Arrays.asList(BLANK, BLANK));
//    }
//
//    @Test
//    @DisplayName("가로 사다리 생성 전략이 ladder(true)가 들어가면, ladder만 가진 사다를 반환한다.")
//    void should_return_true_points() {
//        //Given & When
//        LadderLine ladderLine = new LadderLine(3, () -> LADDER);
//
//        //Then
//        assertThat(ladderLine.getPoints()).containsAll(Arrays.asList(LADDER, LADDER));
//    }



//    @Test
//    @DisplayName("index가 0일때, left는 false, index가 length일때, right는 false인 List<Point>를 반환한다.")
//    void should_return_points() {
//        //Given
//        LadderLine ladderLine = new LadderLine(4, () -> true);
//
//        //When
//        List<Point> points = ladderLine.getPoints();
//
//        //Then
//        assertThat(points.get(0).left()).isFalse();
//        assertThat(points.get(points.size()).right()).isFalse();
//
//    }
}
