package seungjun.domain.generator;

import seungjun.generator.Generator;
import seungjun.generator.RandomLadderLineGenerator;
import seungjun.ladder.SeungjunLadderLine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RandomSeungjunLadderLineGeneratorTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 5, 10})
    @DisplayName("[RandomLadderLineGenerator.make] 컬럼 개수를 지정해서 생성 요청하면 -> 그만큼의 컬럼을 가지는 라인 생성")
    public void lineColumnCountTest(int theNumberOfColumn) {
        Generator<SeungjunLadderLine> generator = new RandomLadderLineGenerator(theNumberOfColumn);

        assertThat(generator.make().howManyColumns())
                .isEqualTo(theNumberOfColumn);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    @DisplayName("[RandomLadderLineGenerator.make] 컬럼 개수를 0개 이하로 지정하면 -> 예외 던짐")
    public void zeroColumnTest(int theNumberOfColumn) {
        Generator<SeungjunLadderLine> generator = new RandomLadderLineGenerator(theNumberOfColumn);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    generator.make();
                });
    }
}