package ladder.step2.domain;

import ladder.step2.domain.partlinestrategy.RandomPartLineCreateStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class DirectionTest {
    public static final Direction PASS = new Direction(PartLineTest.FALSE, PartLineTest.FALSE);
    public static final Direction LEFT = new Direction(PartLineTest.TRUE, PartLineTest.FALSE);
    public static final Direction RIGHT = new Direction(PartLineTest.FALSE, PartLineTest.TRUE);
    
    @Test
    @DisplayName("오른쪽 이동")
    void move_right() {
        assertAll(
                () -> assertThat(RIGHT.isRight()).isTrue(),
                () -> assertThat(RIGHT.isLeft()).isFalse()
        );
    }
    
    @Test
    @DisplayName("왼쪽 이동")
    void move_left() {
        assertAll(
                () -> assertThat(LEFT.isLeft()).isTrue(),
                () -> assertThat(LEFT.isRight()).isFalse()
        );
    }
    
    @Test
    @DisplayName("처음 부분 라인은 존재하지 않는다.")
    void create_first() {
        Direction first = Direction.createFirst(() -> PartLineTest.TRUE);
        assertThat(first.isLeft()).isFalse();
        assertThat(first.isRight()).isTrue();
    }
    
    @Test
    @DisplayName("마지막 부분 라인은 존재하지 않는다.")
    void create_last() {
        assertThat(RIGHT.createLast().isRight()).isFalse();
    }
    
    @Nested
    @DisplayName("이전 부분라인과 겹치지 않는다.")
    class CreateNext {
        @RepeatedTest(100)
        void create_next() {
            final Direction next = RIGHT.createNext(new RandomPartLineCreateStrategy());
            assertThat(next.isRight()).isFalse();
        }
    }
}
