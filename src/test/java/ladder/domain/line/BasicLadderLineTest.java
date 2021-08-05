package ladder.domain.line;

import ladder.core.LadderLine;
import ladder.core.LadderLineGenerator;
import ladder.domain.point.FakeDirectionGenerator;
import ladder.domain.line.BasicLadderLine;
import ladder.domain.line.BasicLadderLineGenerator;
import ladder.factory.FakeGeneratorFactoryBean;
import ladder.factory.GeneratorFactoryBean;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class BasicLadderLineTest {
    private static LadderLineGenerator ladderLineGenerator;

    @BeforeAll
    public static void setUp() {
        // RIGHT-LEFT-EMPTY 순으로 반복해서 생성해주는 생성기로 교체
        new FakeGeneratorFactoryBean(
                new FakeDirectionGenerator(),
                new BasicLadderLineGenerator()
        ).changeInstance();

        ladderLineGenerator = GeneratorFactoryBean.getInstance().ladderLineGenerator();
    }

    @ValueSource(ints = {
            10, 100, 1000
    })
    @DisplayName("generate 갯수 테스트")
    @ParameterizedTest
    public void generateTest(int size) {
        assertThat(
                ladderLineGenerator.generate(size).size()
        ).isEqualTo(size);
    }

    @CsvSource({"3,0,1", "3,1,0", "3,2,2"})
    @DisplayName("move가 정상적으로 움직였는지 테스트")
    @ParameterizedTest
    void moveTest(int pointSize, int index, int correctIndex) {
        LadderLine line = ladderLineGenerator.generate(pointSize);
        assertThat(
                line.move(index)
        ).isEqualTo(correctIndex);
    }
}
