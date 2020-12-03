package nextstep.ladder2;

import org.junit.jupiter.api.Test;

/**
 * Point 요구사항
 *
 * * 포인트는 위치와 이동가능여부(Direction) 을 가진다.
 * * 이동 함수를 제공하며 위치값을 반환한다
 */
public class PointTest {
    @Test
    void create() {
        new Point(0, Direction.of(false, true));
    }
}
