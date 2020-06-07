package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGeneratorTest {

    @Test
    @DisplayName("사다리 생성 테스트")
    void generate() {
        LadderGenerator ladderGenerator = new LadderGenerator(3, Height.of(3));
        Ladder ladder = ladderGenerator.generate(new DirectionRandomPredicate());
        assertThat(ladder).isNotNull();
        assertThat(ladder.getHeight()).isEqualTo(Height.of(3));
        assertThat(ladder.getPositions()).hasSize(3 * 3);
    }
}
