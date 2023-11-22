package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PlayerTest {

    @DisplayName("이름을 가진 Player를 생성하고, x,y축 값을 초기화 한다.")
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
        assertThat(player).isEqualTo(Player.PlayerBuilder.builder()
            .name(name)
            .widthPosition(widthPosition)
            .heightPosition(heightPosition)
            .build());
    }
}
