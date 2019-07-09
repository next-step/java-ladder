package nextstep.step2.domain;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

public class PlayerTest {

    @Test
    @DisplayName("게임 플레이어 생성")
    void create_player() {
        final var player = new Player(0, "choe");
        assertAll(
            () -> assertThat(player).isEqualTo(new Player(0, "choe")),
            () -> assertThat(player).hasSameHashCodeAs(new Player(0, "choe"))
        );
    }

    @Test
    @DisplayName("name 인자로 공백이 들어가는 경우")
    void create_player_name_length_0() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Player(0, ""));
    }

    @Test
    @DisplayName("시작 지점이 음수인 경우")
    void start_point_is_negative_number() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Player(-1, "aaa"));
    }

    @Test
    @DisplayName("name 이 5자 초과")
    void create_player_name_length_6() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Player(0, "choebk"));
    }

    @Test
    @DisplayName("player 의 reward 조회")
    void get_player_reward() {
        Players players = Players.create(List.of("a", "b", "c", "d"));
        GameResults results = GameResults.create(List.of("1000", "1000", "1000", "1000"));
        LadderGame game = new LadderGame(players, 5);
        Ladder ladder = game.start();

        Map<Player, Result> playerResultMap = players.getPlayerRewards(results, ladder);
        assertAll(
            () -> assertThat(playerResultMap.size()).isEqualTo(4),
            () -> assertThat(playerResultMap.get(players.findByName("a")).getReward()).isEqualTo("1000")
        );
    }
}
