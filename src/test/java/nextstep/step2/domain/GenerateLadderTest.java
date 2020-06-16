package nextstep.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("사다리 생성 테스트")
class GenerateLadderTest {

    private int userCount = 4;
    private int ladderHeight = 5;
    private GenerateLadder generateLadder = new GenerateLadder(userCount, ladderHeight);

    @DisplayName("생성자 테스트")
    @Test
    void generateLadder() {
        assertThat(generateLadder.getLadder().get(0)).isInstanceOf(Line.class);
    }
}
