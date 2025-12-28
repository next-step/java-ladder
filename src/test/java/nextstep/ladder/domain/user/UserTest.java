package nextstep.ladder.domain.user;

import nextstep.ladder.domain.ladder.Position;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * 사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야한다.(너비를 따로 관리해야할 것 같다)
 */
class UserTest {

    @Test
    void 참여자_생성() {
        User user = new User("pobi", 1);
        assertThat(user.getName()).isEqualTo(new UserName("pobi"));
        assertThat(user.getPosition()).isEqualTo(new Position(1));
    }


}