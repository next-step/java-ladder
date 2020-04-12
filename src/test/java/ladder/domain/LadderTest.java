package ladder.domain;

import ladder.dto.GameInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatCode;

public class LadderTest {
    private GameInfo gameInfo;

    @BeforeEach
    void setUp() {
        gameInfo = new GameInfo(
                new Players(Arrays.asList("jo", "jae", "young")),
                new Prizes(Arrays.asList("꽝", "승", "굿"))
        );
    }

    @Test
    @DisplayName("사다리 생성 테스트")
    void createLadder() {
        assertThatCode(
                () -> new Ladder(gameInfo, 5)
        ).doesNotThrowAnyException();
    }
}
