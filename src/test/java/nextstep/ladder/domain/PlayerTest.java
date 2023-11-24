package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PlayerTest {

    @DisplayName("Player의 이름을 확인한다.")
    @Test
    void createPlayer() {
        // given
        String name = "홍길동";
        int widthPosition = 0;
        int heightPosition = 1;
        Player player = Player.PlayerBuilder.builder()
            .name(name)
            .widthPosition(widthPosition)
            .heightPosition(heightPosition)
            .build();

        // when & then
        assertThat(player.name()).isEqualTo("홍길동");
    }
}
