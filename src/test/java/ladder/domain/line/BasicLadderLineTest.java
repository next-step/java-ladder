package ladder.domain.line;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class BasicLadderLineTest {
    @ValueSource(ints = {
            10, 100, 1000
    })
    @DisplayName("generate 갯수 테스트")
    @ParameterizedTest
    void generateTest(int size) {
        assertThat(
                LadderLine.generate(size).size()
        ).isEqualTo(size);
    }

    @CsvSource({"3,0,1", "3,1,0", "3,2,2"})
    @DisplayName("move가 정상적으로 움직였는지 테스트")
    @ParameterizedTest
    void moveTest(int pointSize, int index, int correctIndex) {
        LadderLine line = LadderLine.generate(pointSize);
        assertThat(
                line.move(index)
        ).isEqualTo(correctIndex);
    }
}
