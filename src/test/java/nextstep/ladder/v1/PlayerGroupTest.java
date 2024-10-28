package nextstep.ladder.v1;

import nextstep.ladder.v1.model.Player;
import nextstep.ladder.v1.model.PlayerGroup;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PlayerGroupTest {
    @Test
    @DisplayName("PlayerGroup 생성")
    void createPlayerGroup() {
        //given
        List<String> names = List.of("pobi", "honux", "crong", "jk");
        List<Player> players = List.of(new Player("pobi"), new Player("honux"), new Player("crong"), new Player("jk"));

        //when
        PlayerGroup playerGroup = PlayerGroup.of(names);

        //then
        Assertions.assertThat(playerGroup.getPlayers()).hasSameElementsAs(players);
    }
}
