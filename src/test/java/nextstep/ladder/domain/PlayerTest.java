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

    @Test
    @DisplayName("5자 미만의 이름 뒤에 공백을 추가하여 5자리의 이름으로 반환한다.")
    public void addBlankInName() throws Exception {
        Player player = new Player("hi");
        assertThat(player.name()).isEqualTo("hi   ");
    }
}
