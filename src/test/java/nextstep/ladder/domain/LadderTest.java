package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @DisplayName("사다리를 생성한다")
    @Test
    void initTest() {
        Height height = new Height("5");
        Ladder ladder = Ladder.of(height, Players.from(Arrays.asList("panda", "bao")));
        assertThat(ladder.height()).isEqualTo(height.value());
    }
}
