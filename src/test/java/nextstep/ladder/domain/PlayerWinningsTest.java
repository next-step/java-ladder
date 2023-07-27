package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerWinningsTest {

    private PlayerWinnings playerWinnings;

    @BeforeEach
    void init() {
        playerWinnings = new PlayerWinnings(Player.of("test"), new WinningItem("꽝"));
    }

    @Test
    void toString_테스트() {
        String result = playerWinnings.toString();

        assertThat(result).isEqualTo("test: 꽝");
    }

    @Test
    void 당첨_항목명_테스트() {
        String result = playerWinnings.winningItemName();

        assertThat(result).isEqualTo("꽝");
    }
}
