package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class DirectionTest {

    @Test
    @DisplayName("0번 인덱스 Point 의 Direction 생성시 left 는 false")
    void create_zero_index() {
        Direction first = Direction.first(PointGenerator.generatePoint());
        assertThat(first.isLeft()).isEqualTo(Boolean.FALSE);
    }

    @Test
    @DisplayName("Point 에서 next() 시 리턴된 Point 의 left 는 호출한 Point 의 right 와 동일")
    void nextTest() {
        Direction first = Direction.first(PointGenerator.generatePoint());
        Direction next = first.next();

        assertThat(first.isRight()).isEqualTo(next.isLeft());
    }

    @RepeatedTest(10)
    @DisplayName("last() 로 생성된 Direction 의 right 는 항상 false")
    void lastTest() {
        Direction first = Direction.first(PointGenerator.generatePoint());
        Direction last = first.last();
        assertThat(last.isRight()).isEqualTo(Boolean.FALSE);
    }
}