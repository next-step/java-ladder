package ladder.domain.model;

import ladder.RandomTestUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DirectionTest {

    @Test
    @DisplayName("시작점 생성시 오른쪽에 선이 없는것을 확인한다")
    void createStartDirection() {
        Direction direction = Direction.ofStart(RandomTestUtils.FALSE);
        assertFalse(direction.isLeft());
        assertFalse(direction.isRight());
    }

    @Test
    @DisplayName("시작점 생성시 오른쪽에 선이 존재하는것을 확인한다")
    void createStartDirection2() {
        Direction direction = Direction.ofStart(RandomTestUtils.TRUE);
        assertFalse(direction.isLeft());
        assertTrue(direction.isRight());
    }

    @Test
    @DisplayName("중간점 생성시 오른쪽에 선이 없는것을 확인한다")
    void createMidDirection() {
        Direction direction = Direction.ofStart(RandomTestUtils.FALSE).next(RandomTestUtils.FALSE);
        assertFalse(direction.isLeft());
        assertFalse(direction.isRight());
    }

    @Test
    @DisplayName("중간점 생성시 오른쪽에 선이 존재하는것을 확인한다")
    void createMidDirection2() {
        Direction direction = Direction.ofStart(RandomTestUtils.FALSE).next(RandomTestUtils.TRUE);
        assertFalse(direction.isLeft());
        assertTrue(direction.isRight());
    }

    @Test
    @DisplayName("중간점 생성시 연속으로 선을 생성하지 못하는것을 확인한다")
    void createMidDirectionException() {
        Direction direction = Direction.ofStart(RandomTestUtils.TRUE).next(RandomTestUtils.TRUE);
        assertTrue(direction.isLeft());
        assertFalse(direction.isRight());
    }

    @Test
    @DisplayName("끝점 생성시 오른쪽에 선이 없는것을 확인한다")
    void createEndDirection() {
        Direction direction = Direction.ofStart(RandomTestUtils.FALSE).ofEnd();
        assertFalse(direction.isLeft());
        assertFalse(direction.isRight());
    }
}