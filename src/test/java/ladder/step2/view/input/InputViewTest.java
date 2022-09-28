package ladder.step2.view.input;

import ladder.step2.domain.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {
    
    @Test
    @DisplayName("입력한 플레이어들의 객체를 반환받는다.")
    void inputPlayerNames() {
        List<Player> players = InputView.inputPlayerNames("pobi, jun, honux, jk");
        assertThat(players).isEqualTo(Arrays.asList(new Player("pobi"), new Player("jun"), new Player("honux"), new Player("jk")));
    }
}