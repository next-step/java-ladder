package ladder.domain;

import ladder.domain.ladderlinegenerator.RandomLadderLineGenerator;
import ladder.domain.ladderlinegenerator.TrueLadderLineGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

public class LadderLineGeneratorTest {

    @DisplayName("RandomLadderLineGenerator 테스트")
    @ValueSource(ints = {1, 3, 5})
    @ParameterizedTest
    void generateLadderLine(int size) {
        // when
        LadderLineGenerator ladderLineGenerator = new RandomLadderLineGenerator();
        List<Boolean> generatedLine = ladderLineGenerator.generateLadderLine(size);

        // then
        Assertions.assertThat(generatedLine.size()).isEqualTo(size);
    }

    @DisplayName("사다리 라인 생성 검증")
    @ValueSource(ints = {1, 3, 5})
    @ParameterizedTest
    void generateLadderLineWithTrue(int size) {
        // given
        LadderLineGenerator ladderLineGenerator = new TrueLadderLineGenerator();

        // when
        List<Boolean> generatedLine = ladderLineGenerator.generateLadderLine(size);

        // then
        Assertions.assertThat(generatedLine)
                .hasSize(size)
                .containsOnly(true);
    }


}
