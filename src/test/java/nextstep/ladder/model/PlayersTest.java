package nextstep.ladder.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.List;
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

    @DisplayName("player 이름을 이용해 Player를 찾을 수 있습니다.")
    @Test
    void canFindPlayerWithPlayerName(){
        String poby = "poby";
        Players players = Players.from(List.of(poby));
        Player playerPoby = players.findPlayer(poby);
        assertThat(playerPoby.name()).isEqualTo(poby);
    }

    @DisplayName("player 이름을 이용해 Player의 순서를 찾을 수 있습니다.")
    @Test
    void canFindIndexWithPlayerName(){
        String poby = "poby";
        Players players = Players.from(List.of(poby));
        int index = players.orderByPlayerName(poby);
        assertThat(index).isEqualTo(0);
    }

}
