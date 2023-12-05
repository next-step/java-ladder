package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PlayersTest {

    @Test
    @DisplayName("이름으로 참가자를 생성한다. 각 플레이어의 위치값은 1씩 증가한다")
    public void create() {
        List<Player> players = Players.of("a", "b", "c").values();
        assertThat(players.get(0).position()).isEqualTo(0);
        assertThat(players.get(1).position()).isEqualTo(1);
        assertThat(players.get(2).position()).isEqualTo(2);
    }

    @Test
    @DisplayName("참가자 중에 가장 이름이 긴 값을 가져온다")
    public void name_length_max() {
        assertThat(Players.of(List.of("a", "abc", "abcde")).lengthMax()).isEqualTo(5);
    }
}
