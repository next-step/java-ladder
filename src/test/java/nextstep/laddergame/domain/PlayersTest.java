package nextstep.laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PlayersTest {

    @DisplayName("Players 생성 테스트")
    @Test
    public void createPlayersTest() {
        List<PlayerName> playerNames = createPlayerNames("abc", "def", "ghi");
        Players players = Players.of(playerNames);
        for (PlayerName playerName : playerNames) {
            assertThat(players).matches(p -> p.contains(playerName));
        }
    }

    @DisplayName("참여자 이름은 중복 될 수 없다.")
    @Test
    public void duplicatePlayerNameTest() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Players.of(createPlayerNames("abc", "abc")))
                .withMessageContaining("abc");
    }

    private List<PlayerName> createPlayerNames(String... names) {
        return Arrays.stream(names)
                .map(PlayerName::of)
                .collect(Collectors.toList());
    }

}