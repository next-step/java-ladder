package nextstep.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

@DisplayName("사다리 생성 테스트")
class LadderGeneratorTest {

    private int userCount = 4;
    private int ladderHeight = 5;
    private LadderGenerator ladderGenerator = new LadderGenerator(userCount, ladderHeight);

    @DisplayName("생성자 테스트")
    @Test
    void generateLadder() {
        assertThatCode(() -> {
            new LadderGenerator(userCount, ladderHeight);
        }).doesNotThrowAnyException();
        assertThat(ladderGenerator.getLadder().get(0)).isInstanceOf(Line.class);
    }

    @DisplayName("사다리 높이 확인")
    @Test
    void getLadderHeight() {
        assertThat(ladderGenerator.getLadder().size()).isEqualTo(ladderHeight);
    }
}
