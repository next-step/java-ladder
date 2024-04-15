package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PlayersTest {

    @Test
    @DisplayName("참가자는 최소 2명 이상이어야 한다.")
    void atLeast2Player() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Players(List.of(new Player("one")));
        });
    }


    @Test
    @DisplayName("참가자 이름이 주어지면 특정 참가자를 리턴한다.")
    void getPlayerByNameOrNull_one_player() {
        Players players = new Players(List.of(
                new Player("A"),
                new Player("B"))
        );

        Assertions.assertThat(players.getPlayerByNameOrNull("A")).isEqualTo(new Player("A"));
    }

    @Test
    @DisplayName("ALL로 주어지면 Null을 리턴한다.")
    void getPlayerByNameOrNull_null() {
        Players players = new Players(List.of(
                new Player("A"),
                new Player("B"))
        );

        Assertions.assertThat(players.getPlayerByNameOrNull("ALL")).isNull();
    }
}