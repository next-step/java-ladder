package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomLadderPointGeneratorTest {

    @Test
    @DisplayName("랜덤 사다리 생성 테스트")
    void generate() {
        Ladder targetLadder = new Ladder(5, 2, (ladder, lineCount) -> {});

        new RandomLadderPointGenerator().generate(targetLadder, 4);

        assertThat(targetLadder.getLine(0).emptyPoints()).hasSize(1);
    }
}
