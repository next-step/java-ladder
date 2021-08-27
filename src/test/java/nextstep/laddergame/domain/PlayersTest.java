package nextstep.laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

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

    private List<PlayerName> createPlayerNames(String... names) {
        return Arrays.stream(names)
                .map(PlayerName::of)
                .collect(Collectors.toList());
    }

    @ParameterizedTest(name = "참여자는 한 명 이상이다.")
    @NullAndEmptySource
    public void playerSizeTest(List<PlayerName> playerNames) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Players.of(playerNames));
    }

}