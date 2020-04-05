package ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderGameTest {

    private Players testPlayers;

    @BeforeEach
    void setUp() {
        this.testPlayers = new Players(Arrays.asList(Player.of("jojae"), Player.of("j"), Player.of("young")));
    }

    @Test
    @DisplayName("게임 생성 테스트")
    void createGameTest() {
        new LadderGame(this.testPlayers);
    }

    @Test
    @DisplayName("게임 생성 실패 테스트")
    void validateNamesTest() {
        assertThatThrownBy(
                () -> new LadderGame(new Players(Arrays.asList(Player.of("jojaeasdfasdf"), Player.of(""), Player.of("young"))))
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
