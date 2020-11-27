package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.exception.NameLengthException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {

    @Test
    @DisplayName("네임이 5글자를 초과하는경우 익셉션 발생")
    void throwNameException() {
        assertThatThrownBy(() -> Player.of("abcedf"))
                .isInstanceOf(NameLengthException.class);
    }

    @Test
    @DisplayName("플레이어가 잘 생성되는지 확인")
    void create() {
        Player player = Player.of("a");
        assertThat(player).isEqualTo(Player.of("a"));
    }

    @Test
    @DisplayName("플레이어 이름 확인")
    void validName() {
        Player player = Player.of("a");
        assertThat(player.getName()).isEqualTo("a");
    }
}