package ladder;

import ladder.domain.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PlayerTest {

    @Test
    @DisplayName("player 생성 테스트")
    void create() {
        String name = "tests";
        Player test = new Player(name);
        assertThat(test).isEqualTo(new Player(name));
    }

    @Test
    @DisplayName("player 생성시 이름이 다섯자 초과이면 예외 발생 테스트")
   void create_with_name_more_than_5() {
        String name = "testss";
        assertThatIllegalArgumentException().isThrownBy(() ->
                new Player(name));
    }
}
