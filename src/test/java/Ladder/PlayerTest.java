package Ladder;

import Ladder.domain.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerTest {
    @Test
    @DisplayName("Player 객체 이름 5자가 초과할 경우 에러 발생")
    void errorOnPlayerName() {
        assertThatThrownBy(() -> new Player("Jinwoo"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
