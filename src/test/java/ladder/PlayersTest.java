package ladder;

import ladder.domain.Player;
import ladder.domain.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayersTest {

    @DisplayName("참여하는 사람이 0명이면 IllegalArgumentException")
    @Test
    void emptyPlayerNames() {
        assertThatThrownBy(() -> Players.of(Collections.emptyList()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("사람의 수");
    }

    @DisplayName("참여하는 사람의 이름이 중복되면 IllegalArgumentException")
    @Test
    void duplicatePlayerNames() {
        List<Player> players = Arrays.asList(Player.of("name1"), Player.of("name2"), Player.of("name1"));

        assertThatThrownBy(() -> Players.of(players))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("사람의 이름");
    }

    @DisplayName("이름으로 몇번째 사람인지 찾는다")
    @Test
    void findIndexByName() {
        Players players = Players.of(Arrays.asList(Player.of("name1"), Player.of("name2"), Player.of("name3")));
        int index = players.findIndexByName("name2");

        assertThat(index).isEqualTo(1);
    }

    @DisplayName("찾는 이름의 사람이 없으면 IllegalArgumentException")
    @Test
    void findIndexByName_notMatch() {
        Players players = Players.of(Arrays.asList(Player.of("name1"), Player.of("name2"), Player.of("name3")));

        assertThatThrownBy(() -> players.findIndexByName("name4"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("해당 이름의 사람이 없습니다");
    }
}
