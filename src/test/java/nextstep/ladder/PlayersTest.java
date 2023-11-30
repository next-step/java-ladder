package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.List;
import nextstep.ladder.model.Player;
import nextstep.ladder.model.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayersTest {

    @DisplayName("player 이름들을 입력 받고 players를 생성")
    @Test
    void playersCreatedByListOfStrings() {
        List<String> playerList = List.of("pobi", "honux", "crong", "jk");
        assertThatNoException().isThrownBy(() -> Players.from(playerList));
    }

    @DisplayName("players는 player의 목록")
    @Test
    void playersReturnPlayer() {
        List<String> strings = List.of("pobi", "honux");
        assertThat(Players.from(strings).list()).containsExactlyInAnyOrder(Player.from("pobi"),
            Player.from("honux"));
    }
}
