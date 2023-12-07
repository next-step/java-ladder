package ladder;

import ladder.domain.Player;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerTest {

    @Test
    public void 유저생성_실패테스트(){
        assertThatThrownBy(() -> {
            new Player("abcdef");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 유저생성_성공테스트(){
        Player player = new Player("abcde");
        assertThat(player).isEqualTo(new Player("abcde"));
    }
}
