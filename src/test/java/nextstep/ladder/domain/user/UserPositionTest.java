package nextstep.ladder.domain.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import nextstep.ladder.domain.line.Point;
import nextstep.ladder.error.exception.UserPositionZeroException;
import org.junit.jupiter.api.Test;

public class UserPositionTest {

    @Test
    void UserPosition은_오른쪽으로_이동할_때_전달받은_Point가_True일_경우_1증가한다(){
        UserPosition userPosition = new UserPosition(1);

        assertThat(userPosition.canMoveRight(new Point(true))).isEqualTo(1);
    }

    @Test
    void UserPosition은_왼쪽으로_이동할_때_전달받은_Point가_False일_경우_1감소한다(){
        UserPosition userPosition = new UserPosition(1);

        assertThat(userPosition.canMoveLeft(new Point(true))).isEqualTo(1);
    }

    @Test
    void UserPosition은_왼쪽으로_이동할_때_전달받은_Point가_True인데_현재_위치가_0인_경우_예외가_발생한다(){
        UserPosition userPosition = new UserPosition(0);

        assertThatThrownBy(() -> userPosition.canMoveLeft(new Point(true)))
            .isInstanceOf(UserPositionZeroException.class)
            .hasMessage("현재 위치가 0인 경우 왼쪽으로 이동할 수 없습니다. 입력값: 0");
    }
}
