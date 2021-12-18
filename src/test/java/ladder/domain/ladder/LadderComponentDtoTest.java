package ladder.domain.ladder;

import ladder.domain.user.LadderPlayers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class LadderComponentDtoTest {

    @Test
    @DisplayName("높이, 넓이를 가지는 객체 생성")
    void create() {
        LadderPlayers players = new LadderPlayers(Arrays.asList("pobi", "honux", "crong", "jk"));
        LadderHeight height = new LadderHeight(4);
        LadderComponentDto component = new LadderComponentDto(players, height);
        Assertions.assertThat(component).isEqualTo(new LadderComponentDto(players, height));
    }

}