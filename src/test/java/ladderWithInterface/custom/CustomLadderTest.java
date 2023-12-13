package ladderWithInterface.custom;

import ladderWithInterface.engin.CoordinateGenerator;
import ladderWithInterface.engin.Ladder;
import ladderWithInterface.engin.LadderResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomLadderTest {

    private static final CustomLineCreator CUSTOM_LINE_CREATOR = new CustomLineCreator();
    private static final CoordinateGenerator COORDINATE_GENERATION = new ManualCoordinateGenerator();

    @Test
    @DisplayName("사다리 결과 확인")
    void 사다리_결과_확인() {
        CustomLadderCreator customLadderCreator = new CustomLadderCreator(CUSTOM_LINE_CREATOR);
        Ladder ladder = customLadderCreator.create(4, 5, COORDINATE_GENERATION);
        LadderResult ladderResult = ladder.play();

        assertThat(ladderResult.getTarget(0)).isEqualTo(1);
        assertThat(ladderResult.getTarget(1)).isEqualTo(0);
        assertThat(ladderResult.getTarget(2)).isEqualTo(3);
        assertThat(ladderResult.getTarget(3)).isEqualTo(2);
    }
}
