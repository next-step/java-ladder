package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@DisplayName("Player 클래스 테스트")
class PlayerTest {

    @DisplayName("참가자 이름을 가지는 Player를 생성할 수 있다.")
    @Test
    void create_player_have_name() {
        String name = "jun";
        Player player = new Player(name);

        assertThat(player.getName()).isEqualTo(name);
    }

    @DisplayName("참가자 이름이 5글자를 초과할 경우 예외를 반환한다.")
    @Test
    void validate_name_length() {
        String name = "sungjun";
        assertThatExceptionOfType(PlayerNameLengthException.class)
                .isThrownBy(() -> new Player(name))
                .withMessage(PlayerNameLengthException.MESSAGE);
    }
}
