package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
}
