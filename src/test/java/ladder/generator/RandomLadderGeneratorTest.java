package ladder.generator;

import ladder.domain.Ladder;
import ladder.domain.generator.Generator;
import ladder.domain.generator.RandomLadderGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomLadderGeneratorTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 5, 10})
    @DisplayName("[LadderGenerator.generateRandomLadder] depth를 지정해서 요청하면 -> 지정된 depth를 가진 Ladder 생성")
    public void ladderDepthTest(int depth) {
        Generator<Ladder> generator = new RandomLadderGenerator(depth, 5);

        assertThat(generator.make().howLongDepth())
                .isEqualTo(depth);
    }
}
