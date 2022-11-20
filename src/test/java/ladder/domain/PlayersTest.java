package ladder.domain;

import ladder.exception.NotFoundNameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayersTest {

    public static final Players players = new Players(List.of("이상원", "원상이"));

    @Test
    @DisplayName("플레이어 이름으로 찾기 - 성공")
    void findByName_success() {
        // given
        String name = "이상원";

        // when
        Player player = players.findByName(name);

        // then
        assertThat(player).isEqualTo(new Player("이상원", 0));
    }

    @Test
    @DisplayName("플레이어 이름으로 찾기 - 실패")
    void findByName_fail() {
        // given
        String name = "이상원1";

        // expected
        assertThatThrownBy(() -> players.findByName(name))
                .isInstanceOf(NotFoundNameException.class);
    }

}
