package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("사다리 테스트")
public class LadderTest {
    @DisplayName("주어진 높이로 사다리 생성")
    @Test
    public void createLadderWithHeight() {
        int height = Ladder.of(4, 5).getHeight();

        assertThat(height).isEqualTo(5);
    }
}