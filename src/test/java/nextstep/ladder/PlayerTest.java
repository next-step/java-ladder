package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerTest {

    @Test
    @DisplayName("play 이름 5글자를 초과하면 예외를 발생한다")
    void playNameOverFiveException() {

        assertThatThrownBy(
                () -> Player.of("kkkkkk")
        ).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("play 이름 5글자이하면 패스한다")
    void playNameIsFivePass() {
        assertThat(Player.of("kkkkk").getPlayerNameSize()).isEqualTo(5);
    }
}
