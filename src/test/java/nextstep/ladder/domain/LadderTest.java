package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import nextstep.ladder.generator.PositionGenerator;
import nextstep.ladder.generator.RandomProductionGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class LadderTest {
    @Test
    @DisplayName("입력된 사다리 높이만큼 라인이 생성되었는지 확인한다.")
    void checkLadderHeightProduction() {
        // given
        int height = 5;
        int countOfPosition = 3;
        PositionGenerator productionGenerator = new RandomProductionGenerator();

        // when
        Ladder ladder = new Ladder(productionGenerator, height, countOfPosition);

        // then
        assertThat(ladder.getLines()).hasSize(height);
    }

    @ParameterizedTest(name = "사다리의 라인들이 비어있는 경우, 예외처리를 한다.")
    @NullAndEmptySource
    void exceptionLadderLinesNullOrEmpty(List<Line> lines) {
        // when & then
        assertThatThrownBy(() -> new Ladder(lines))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
