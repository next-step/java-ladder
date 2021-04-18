package ladder;

import ladder.domain.Player;
import ladder.domain.Players;
import ladder.domain.PrizePlayer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PrizePlayerTest {
    @DisplayName("입력한 사람이 참가자에 없을 경우 예외를 반환한다.")
    @Test
    void validate() {
        Players allPlayers = Players.of(Arrays.asList("blue", "red", "black"));

        assertThatThrownBy(() -> new PrizePlayer(allPlayers, new Player("apple")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("실행결과 대상자 인스턴스를 생성한다.")
    @Test
    void create() {
        Players allPlayers = Players.of(Arrays.asList("blue", "red", "black"));
        PrizePlayer prizePlayer = new PrizePlayer(allPlayers, new Player("black"));
        assertThat(prizePlayer).isEqualTo(new PrizePlayer(allPlayers, new Player("black")));
    }

    @DisplayName("실행결과 모든 대상자 인스턴스를 생성한다.")
    @Test
    void createAll() {
        Players allPlayers = Players.of(Arrays.asList("blue", "red", "black"));
        PrizePlayer prizePlayer = new PrizePlayer(allPlayers);
        assertThat(prizePlayer).isEqualTo(new PrizePlayer(allPlayers));
    }
}
