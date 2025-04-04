package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderLineGeneratorTest {

    @DisplayName("List 생성 시 true가 연속되면 안됨")
    @ValueSource(ints = {1, 3, 5})
    @ParameterizedTest
    void generateLadderLine(int size) {
        // when
        List<Boolean> generatedLine = LadderLineGenerator.generateLadderLine(size);

        // then
        // "List<Boolean>"에서 true가 연속 발생하지 않음을 확인
        for (int i = 0; i < generatedLine.size() - 1; i++) {
            assertThat(generatedLine.get(i) && generatedLine.get(i + 1))
                    .as("연속된 true가 발생하면 안 됩니다 (인덱스: %d, %d)", i, i + 1)
                    .isFalse();
        }
    }

}
