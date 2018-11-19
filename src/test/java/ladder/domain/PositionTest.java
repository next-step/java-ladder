package ladder.domain;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {

    Position position;

    @Before
    public void setUp() {
        position = new Position(1, false, true);
    }
    @Test
    public void 라인이_겹치는_경우_테스트() {
        boolean result = position.isOverlapped(true);
        assertThat(result).isEqualTo(true);
    }

    @Test
    public void 라인이_안겹치는_경우_테스트() {
        boolean result = position.isOverlapped(false);
        assertThat(result).isEqualTo(false);
    }

    @Test
    public void 왼쪽한칸_이동_테스트() {
        int result = position.moveLeft();
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void 오른쪽한칸_이동_테스트() {
        int result = position.moveRight();
        assertThat(result).isEqualTo(2);
    }

}