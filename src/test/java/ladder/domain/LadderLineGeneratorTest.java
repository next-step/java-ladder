package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.IntStream;

public class LadderLineGeneratorTest {

    @DisplayName("List 생성 시 true가 연속되면 안됨")
    @ValueSource(ints = {1, 3, 5})
    @ParameterizedTest
    void generateLadderLine(int size) {
        // when
        LadderLine generatedLine = LadderLineGenerator.generateLadderLine(size);

        // then
        Assertions.assertThat(IntStream.range(0, generatedLine.size() - 1)
                .anyMatch(i -> generatedLine.getPoint(i) && generatedLine.getPoint(i + 1)))
                .as("연속된 true가 발생하면 안 됩니다")
                .isFalse();
    }

}
