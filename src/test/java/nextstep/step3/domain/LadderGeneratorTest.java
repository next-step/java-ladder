package nextstep.step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("사다리 생성 테스트")
class LadderGeneratorTest {

    private int userCount = 4;
    private int ladderHeight = 5;

    private LadderGenerator ladderGenerator = new LadderGenerator(userCount, ladderHeight);

    @DisplayName("사다리 높이 확인")
    @Test
    void checkLadderHeight() {
        assertThat(ladderGenerator.getLadder().getLines().size()).isEqualTo(ladderHeight);
    }

    @DisplayName("사다리 너비 확인")
    @Test
    void checkLadderBreath() {
        assertThat(ladderGenerator.getLadder().getLines().get(0).getPoints().size()).isEqualTo(userCount - 1);
    }
}
