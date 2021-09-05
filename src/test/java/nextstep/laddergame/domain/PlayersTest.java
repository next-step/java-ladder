package nextstep.laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PlayersTest {

    @DisplayName("Players 생성 테스트")
    @Test
    public void createPlayersTest() {
        List<String> playerNames = Arrays.asList("abc", "def", "ghi");
        Players players = Players.of(playerNames);
        for (String playerName : playerNames) {
            assertThat(players).matches(p -> p.contains(playerName));
        }
    }

    @DisplayName("참여자 이름은 중복 될 수 없다.")
    @Test
    public void duplicatePlayerNameTest() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Players.of(Arrays.asList("abc", "abc")))
                .withMessageContaining("abc");
    }

}