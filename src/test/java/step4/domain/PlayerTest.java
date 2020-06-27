package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Player;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PlayerTest {

    @DisplayName("Player 개체 생성")
    @Test
    void setPlayerName() {
        Player player = new Player("일이삼사오");
        assertThat(player.getPlayerName()).isEqualTo("일이삼사오");
    }

    @DisplayName("Player 이름 5자이상 불가")
    @Test
    void setPlayerNameMore5char() {
        assertThatIllegalArgumentException().isThrownBy(() ->
                new Player("일이삼사오육")
        );
    }


}
