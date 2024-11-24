package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {
    public static final Player PLAYER1 = new Player("mina");
    public static final Player PLAYER2 = new Player("tori");

    @Test
    void create_성공() {
        assertThat(PLAYER1).isNotNull();
        assertThat(PLAYER1.getName()).isEqualTo("mina");
    }

    @Test
    @DisplayName("참가자 이름이 5글자를 초과할 경우 IllegalArgumentException이 발생한다")
    void create_실패_name_5글자_초과일_경우() {
        assertThatThrownBy(() -> {
            Player player1 = new Player("testPlayer");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
