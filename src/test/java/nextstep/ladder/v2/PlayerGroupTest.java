package nextstep.ladder.v2;

import nextstep.ladder.v2.model.Player;
import nextstep.ladder.v2.model.PlayerGroup;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

public class PlayerGroupTest {
    @Test
    @DisplayName("player group class 생성")
    void createPlayerGroupTest() {
        //given
        List<String> names = List.of("pobi", "honux", "crong", "jk");
        //when
        PlayerGroup group = new PlayerGroup(names);
        //then
        List<Player> expectedPlayers = names.stream().map(Player::new).collect(Collectors.toList());
        Assertions.assertThat(group.getPlayers()).hasSameElementsAs(expectedPlayers);
    }
}
