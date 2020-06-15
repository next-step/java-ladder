package nextstep.ladder.domain.user;

import nextstep.ladder.domain.game.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class UserTest {

    @Test
    @DisplayName("유저 생성 테스트")
    void create(){
        User user = User.newInstance("ray", Order.from(1));
        assertThat(user).isEqualTo(User.newInstance("ray", Order.from(1)));
    }
}
