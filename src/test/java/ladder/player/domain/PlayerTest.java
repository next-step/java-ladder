package ladder.player.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {

    @DisplayName("사다리 게임 참여자를 생성할 수 있다.")
    @Test
    public void newPlayerTest() {
        Player player = Player.of("jayden");
        Player anotherPlayer = Player.of("jayden");

        assertThat(player).isEqualTo(anotherPlayer);
    }

    @DisplayName("'all' 이란 이름의 참여자를 생성 할 수 없다.")
    @Test
    public void bannedPlayerNameAllTest() {
        assertThatThrownBy(() -> Player.of("all"))
                .isInstanceOf(BannedNameException.class)
                .hasMessageContaining("'all'은 참여자로 등록 할 수 없습니다.");
    }

    @DisplayName("5자 이상의 참여자 이름은 5자로 다듬는다.")
    @Test
    public void test() {
        Player player = Player.of("abcdefg");

        String name = player.getName();

        assertThat(name.length()).isEqualTo(5);
    }

}
