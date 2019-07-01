package nextstep.ladder.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {
    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player("Jack");
    }

    @DisplayName("입력한 이름에 LPAD(6자리 공백)")
    @Test
    void getNameFormattedTest() {
        assertThat(player.getNameFormatted()).isEqualTo("  Jack");
    }

    @DisplayName("단순 이름 출력")
    @Test
    void getNameTest() {
        assertThat(player.getName()).isEqualTo("Jack");
    }
}
