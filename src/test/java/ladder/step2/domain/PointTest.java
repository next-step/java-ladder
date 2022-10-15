package ladder.step2.domain;

import ladder.step2.domain.partlinestrategy.RandomPartLineCreateStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class PointTest {
    public static final Point ZERO_PASS = Point.createFirst(() -> PartLineTest.FALSE);
    public static final Point ZERO_RIGHT = Point.createFirst(() -> PartLineTest.TRUE);
    public static final Point ONE_LEFT = ZERO_RIGHT.createNext(() -> PartLineTest.FALSE);
    public static final Point ONE_PASS = ZERO_PASS.createNext(() -> PartLineTest.FALSE);
    
    @Test
    @DisplayName("패스")
    void pass() {
        assertThat(ONE_PASS.move()).isEqualTo(1);
    }
    
    @Test
    @DisplayName("왼쪽 이동")
    void move_left() {
        assertThat(ONE_LEFT.move()).isEqualTo(0);
    }
    
    @Test
    @DisplayName("오른쪽 이동")
    void move_right() {
        assertThat(ZERO_RIGHT.move()).isEqualTo(1);
    }
    
    @Test
    @DisplayName("처음 부분라인은 존재하지 않는다")
    void create_first() {
        final Point zeroRight = Point.createFirst(() -> PartLineTest.TRUE);
        assertAll(
                () -> assertThat(zeroRight.move()).isNotEqualTo(-1),
                () -> assertThat(zeroRight.move()).isNotEqualTo(0),
                () -> assertThat(zeroRight.move()).isEqualTo(1)
        );
    }
    
    @Test
    @DisplayName("마지막 부분라인은 존재하지 않는다")
    void create_last() {
        final Point onePass = ZERO_PASS.createLast();
        assertAll(
                () -> assertThat(onePass.move()).isNotEqualTo(2),
                () -> assertThat(onePass.move()).isNotEqualTo(0),
                () -> assertThat(onePass.move()).isEqualTo(1)
        );
    }
    
    @Nested
    @DisplayName("이전 부분라인과 겹치지 않는다.")
    class CreateNext {
        @RepeatedTest(100)
        void create_next() {
            final Point oneLeft = ZERO_RIGHT.createNext(new RandomPartLineCreateStrategy());
            assertAll(
                    () -> assertThat(oneLeft.move()).isNotEqualTo(2),
                    () -> assertThat(oneLeft.move()).isNotEqualTo(1),
                    () -> assertThat(oneLeft.move()).isEqualTo(0)
            );
        }
    }
}
