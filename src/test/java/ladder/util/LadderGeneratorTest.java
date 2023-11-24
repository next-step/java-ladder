package ladder.util;

import nextstep.ladder.util.LadderGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderGeneratorTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 5, 10})
    @DisplayName("[LadderGenerator.generateRandomLine] 컬럼 개수를 지정해서 생성 요청하면 -> 그만큼의 컬럼을 가지는 라인 생성")
    public void lineColumnCountTest(int theNumberOfColumn) {
        assertThat(LadderGenerator
                .generateRandomLine(theNumberOfColumn)
                .howManyColumns())
                .isEqualTo(theNumberOfColumn);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    @DisplayName("[LadderGenerator.generateRandomLine] 컬럼 개수를 0개 이하로 지정하면 -> 예외 던짐")
    public void zeroColumnTest(int theNumberOfColumn) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    LadderGenerator.generateRandomLine(theNumberOfColumn);
                });
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 5, 10})
    @DisplayName("[LadderGenerator.generateRandomLadder] depth를 지정해서 요청하면 -> 지정된 depth를 가진 Ladder 생성")
    public void ladderDepthTest(int depth) {
        assertThat(LadderGenerator
                .generateRandomLadder(5, depth)
                .howLongDepth())
                .isEqualTo(depth);
    }
}
