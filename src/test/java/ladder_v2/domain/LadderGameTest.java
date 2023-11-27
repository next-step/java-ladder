package ladder_v2.domain;

import ladder.domain.Height;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {

    @Test
    @DisplayName("사다리 게임을 실행한다.")
    void testPlay() {
        assertThat(
                new LadderGame().play(
                        new Players(List.of(new Name("ryan"), new Name("mia"))),
                        new Rewards(List.of("1", "2")),
                        new Ladder(2, new Height(6))
                )
        ).isInstanceOf(GameResult.class);

    }


}
