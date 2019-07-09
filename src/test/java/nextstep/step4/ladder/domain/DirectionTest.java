package nextstep.step4.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-ladder
 * create date  : 2019-07-05 12:45
 */
public class DirectionTest {

    @DisplayName("현재 왼쪽 방향으로 열려있는지 확인")
    @Test
    void moveDirectionLeft() {
        Direction direction = new Direction(true, false);
        assertThat(direction.moveDirectionLeft()).isTrue();
    }

    @DisplayName("현재 오른쪽 방향으로 열려있는지 확인")
    @Test
    void moveDirectionRight() {
        Direction direction = new Direction(false, true);
        assertThat(direction.moveDirectionRight()).isTrue();
    }

    @DisplayName("이전 direction의 오른쪽 방향이 true일때 다음 Direction left가 flase인지 확인")
    @Test
    void next() {
        Direction direction = new Direction(false, true);
        assertThat(direction.next(true).moveDirectionRight()).isFalse();
    }
}
