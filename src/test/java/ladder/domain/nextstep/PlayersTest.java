package ladder.domain.nextstep;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PlayersTest {

    @DisplayName("입력한 이름들로 Player 의 일급컬렉션을 생성할 수 있다.")
    @Test
    void createPlayersTest() {
        List<String> namesOfPeople = List.of("joe", "pobi", "kori");
        Players players = Players.of(namesOfPeople);

        List<Player> playersList = players.players();

        assertThat(playersList.size()).isEqualTo(namesOfPeople.size());
        assertThat(playersList.get(0).playerName()).isEqualTo(namesOfPeople.get(0));
    }
}