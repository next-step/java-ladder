package ladder.domain;

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

}
