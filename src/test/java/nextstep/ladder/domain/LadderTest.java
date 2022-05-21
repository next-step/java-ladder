package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import nextstep.ladder.dto.LadderStandardDto;
import nextstep.ladder.generator.FixedProductionGenerator;
import nextstep.ladder.generator.PositionGenerator;
import nextstep.ladder.generator.RandomProductionGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class LadderTest {
    @Test
    @DisplayName("입력된 사다리 높이만큼 라인이 생성되었는지 확인한다.")
    void checkLadderHeightProduction() {
        // given
        LadderStandardDto ladderStandardDto = new LadderStandardDto(new Height(5), 3);
        PositionGenerator productionGenerator = new RandomProductionGenerator();

        // when
        Ladder ladder = new Ladder(productionGenerator, ladderStandardDto);

        // then
        assertThat(ladder.getLines()).hasSize(5);
    }

    @ParameterizedTest(name = "사다리의 라인들이 비어있는 경우, 예외처리를 한다.")
    @NullAndEmptySource
    void exceptionLadderLinesNullOrEmpty(List<Line> lines) {
        // when & then
        assertThatThrownBy(() -> new Ladder(lines))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "{0}번째 참가자가 사다리를 탄 결과는 {1}이다")
    @CsvSource({"0,1", "1,0"})
    void checkedLadderRideResultPosition(int position, int expected) {
        // given
        LadderStandardDto ladderStandardDto = new LadderStandardDto(new Height(3), 2);
        Ladder ladder = new Ladder(new FixedProductionGenerator(), ladderStandardDto);

        // when
        int result = ladder.ride(position);

        // then
        assertThat(result).isEqualTo(expected);
    }
}
