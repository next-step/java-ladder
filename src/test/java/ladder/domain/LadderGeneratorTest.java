package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGeneratorTest {

    @Test
    @DisplayName("입력한 값 만큼 사다리 라인 생성")
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

    @Test
    @DisplayName("입력한 값(Height/Person)으로 사다리 생성 ")
    void ladderGeneratorTest() {
        int height = 5;
        int countOfPerson = 5;
        Ladder ladder = LadderGenerator.ladderGenerator(height, countOfPerson);

        assertThat(ladder.height()).isEqualTo(height);
        assertThat(ladder.sizeOfLine()).isEqualTo(countOfPerson - 1);
    }

}
