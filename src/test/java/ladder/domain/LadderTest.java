package ladder.domain;

import ladder.domain.point.FakeDirectionGenerator;
import ladder.domain.line.BasicLadderLineGenerator;
import ladder.factory.FakeGeneratorFactoryBean;
import ladder.factory.GeneratorFactoryBean;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @BeforeAll
    public static void setUp() {
        // RIGHT-LEFT-EMPTY 순으로 반복해서 생성해주는 생성기로 교체
        new FakeGeneratorFactoryBean(
                new FakeDirectionGenerator(),
                new BasicLadderLineGenerator()
        ).changeInstance();
    }

    @CsvSource({"0,1", "1,0", "2,2", "3,4", "4,3", "5,5"})
    @DisplayName("3개의 라인과 6개의 포인트를 사용해 move 테스트")
    @ParameterizedTest
    void moveTest(int index, int correctIndex) {
        int lineSize = 3;
        int pointSize = 6;

        Ladder ladder = Ladder.generate(lineSize, pointSize);
        int expert = ladder.move(index);
        assertThat(expert)
                .isEqualTo(correctIndex);
    }
}
