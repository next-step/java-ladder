package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PlayerTest {

    @Test
    @DisplayName("이름을 인자로 받아 플레이어를 생성한다.")
    public void create() throws Exception {
        Player player = new Player("pobi");
        assertThat(player).isEqualTo(new Player("pobi"));
    }

    @Test
    @DisplayName("이름 5자 초과 시 예외가 발생한다.")
    public void checkNameLength() throws Exception {
        assertThatIllegalArgumentException().isThrownBy(() -> new Player("myname"));
    }
}
