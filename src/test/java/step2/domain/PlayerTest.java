package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.exception.NameLengthException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {

    @Test
    @DisplayName("네임이 5글자를 초과하는경우 익셉션 발생")
    void throwNameException() {
        assertThatThrownBy(() -> Player.of("abcedf", 0))
                .isInstanceOf(NameLengthException.class);
    }

    @Test
    @DisplayName("플레이어가 잘 생성되는지 확인")
    void create() {
        Player player = Player.of("a", 0);
        assertThat(player).usingRecursiveComparison().isEqualTo(Player.of("a", 0));
    }

    @Test
    @DisplayName("플레이어 이름 확인")
    void validName() {
        Player player = Player.of("a", 0);
        assertThat(player.getPlayerGameName()).isEqualTo("a");
    }

    @ParameterizedTest
    @DisplayName("입력 값을 바탕으로 플레이어 들이 잘 생성 되는지 확인")
    @CsvSource(value = {
            "player1,player2,player3,player4=4",
            "player1,player2,player3=3",
            "player1=1"
    }, delimiter = '=')
    void generate_player_test(String input, int result) {
        // given
        Players players = Players.of(NameSplitter.splitParticipationNames(input));
        // when & then
        assertThat(players.getPlayersCount()).isEqualTo(result);
    }
}