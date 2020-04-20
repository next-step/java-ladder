package ladder;

import ladder.domain.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PlayerTest {
    @Test
    @DisplayName("이름이 같으면 같은 객체다")
    public void equalTest() {
        assertThat(new Player("test", 0)).isEqualTo(new Player("test", 1));
    }

    @Test
    @DisplayName("이름은 5자 이내여야 한다.")
    public void nameLengthTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Player("666666", 1));
        assertThatIllegalArgumentException().isThrownBy(() -> new Player(" ", 0));
    }

    @Test
    @DisplayName("이름 매칭 테스트")
    public void matchByNameTest() {
        Player player = new Player("test", 1);

        assertThat(player.matchByName("test")).isTrue();
        assertThat(player.matchByName("testt")).isFalse();
    }
}
