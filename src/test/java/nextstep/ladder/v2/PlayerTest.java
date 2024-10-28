package nextstep.ladder.v2;

import nextstep.ladder.v2.model.Player;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    @Test
    @DisplayName("player class 생성")
    void createPlayerTest() {
        //given
        String name = "pobi";

        //when
        Player player = new Player(name);

        //then
        Assertions.assertThat(player.getName()).isEqualTo(name);
    }

    @Test
    @DisplayName("player class 생성 - 이름 5자 초과")
    void createPlayerTest_NameIsLongerThan5() {
        //given
        String name = "pobiii";

        //when
        ThrowableAssert.ThrowingCallable callable = () -> new Player(name);

        //then
        Assertions.assertThatThrownBy(
                callable
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
