package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @Test
    @DisplayName("point의 오른쪽 사다리가 존재하면, index는 1 증가한다.")
    void should_plus_index() {
        //Given
        Point point = new Point(0, new Direction(false, true));

        //When
        int move = point.move();

        //Then
        assertThat(move).isOne();
    }

    @Test
    @DisplayName("point의 왼쪽 사다리가 존재하면, index는 1 감한다.")
    void should_minus_index() {
        //Given
        Point point = new Point(1, new Direction(true, false));

        //When
        int move = point.move();

        //Then
        assertThat(move).isZero();
    }


    @Test
    @DisplayName("양쪽 사다리가 존재하지 않으면, 현재 index를 반환한다.")
    void should_return_current_index() {
        //Given
        int currentIndex = 2;
        Point point = new Point(currentIndex, new Direction(false, false));

        //When
        int move = point.move();

        //Then
        assertThat(move).isEqualTo(currentIndex);
    }

    @Test
    @DisplayName("마지막 이전 사다리가 존재하지 않으면, 마지막 사다리의 index를 반환한다.")
    void should_return_last_point() {

        //Given
        Point previous = new Point(10, new Direction(false, false));
        Point point = previous.lastOf();

        //When
        int move = point.move();

        //Then
        assertThat(move).isEqualTo(11);
    }

    @Test
    @DisplayName("마지막 이전 사다리가 존재하면, 마지막 이전 사다리의 index를 반환한다.")
    void should_return_previous_last_point() {

        //Given
        int index = 10;
        Point previous = new Point(index, new Direction(false, true));
        Point point = previous.lastOf();

        //When
        int move = point.move();

        //Then
        assertThat(move).isEqualTo(index);
    }

}
