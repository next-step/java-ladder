package ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    @Test
    void 플레이어는_이름으로_생성한다() {
        String testName = "test";
        Player player = Player.from(testName);

        assertThat(player.getName()).isEqualTo(testName);
    }
}
