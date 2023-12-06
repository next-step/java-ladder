package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import nextstep.ladder.model.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @DisplayName("사용자는 이름을 통해 생성")
    @Test
    void playerCreatedByName() {
        String pobi = "pobi";
        Player player = Player.from(pobi);
        assertThat(player.name()).isEqualTo(pobi);
    }

    @DisplayName("사용자의 이름이 5글자를 넘어가면 예외")
    @Test
    void nameExceeds5CharactersThenException() {
        String michael = "Michael Jackson";
        assertThatThrownBy(() -> Player.from(michael)).isInstanceOf(IllegalArgumentException.class);
    }

}
