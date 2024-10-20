package nextstep.ladder;

import nextstep.ladder.model.Player;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    @Test
    @DisplayName("player 생성 테스트")
    void createPlayerTest_Name() {
        //given
        String name = "pobi";

        //when
        Player player = new Player(name);

        //then
        Assertions.assertThat(player.getName()).isEqualTo(name);
    }

    @Test
    @DisplayName("player 이름 제한 테스트")
    void createPlayerNameConstraintTest() {
        //given
        String name = "pobiii";

        //when
        ThrowableAssert.ThrowingCallable callable = () -> {
            Player player = new Player(name);
        };


        //then
        Assertions.assertThatThrownBy(callable)
                .isInstanceOf(IllegalArgumentException.class);
    }
}
