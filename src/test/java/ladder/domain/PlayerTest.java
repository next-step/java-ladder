package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class PlayerTest {

    @Test
    @DisplayName("이름 입력 5자 테스트")
    void inputName() {
        String name = "Going";
        Player player = new Player(name, Position.first());
        assertThat(player.getName()).isEqualTo(name);
    }

    @Test
    @DisplayName("이름 입력 6자 Exception 테스트")
    void inputNotName() {
        String name = "SoLong";
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Player(name, Position.first());
        });
    }
}
