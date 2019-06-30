package ladder.domain;

import ladder.exception.LineGeneratorException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGeneratorTest {

    @Test
    @DisplayName("입력한 숫자 만큼 사다리 라인 생성")
    void lineGeneratorTest() {
        int input = 5;
        Line line = LadderGenerator.lineGenerator(input);
        assertThat(line.size()).isEqualTo(input);
    }

    @Test
    @DisplayName("생성된 사다리 라인 겹침 테스트 ")
    void lineOverlapTest() {
        int input = 5;
        Line line = LadderGenerator.lineGenerator(input);
        for (int i = 1; i < input; i++) {
            assertThat(line.isLine(i - 1) && line.isLine(i)).isFalse();
        }
    }

}
