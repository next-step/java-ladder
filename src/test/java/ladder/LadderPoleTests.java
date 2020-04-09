package ladder;

import ladder.model.LadderGameRewords;
import ladder.model.LadderPole;
import ladder.model.LadderPoles;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.*;

@DisplayName("사다리 세로라인 LadderPole 테스트")
public class LadderPoleTests {

    @DisplayName("생성 테스트")
    @Test
    public void generateLadderPoleTest() {
        assertThatCode(() -> LadderPole.of(2)).doesNotThrowAnyException();
    }

    @DisplayName("생성 비정상 테스트")
    @Test
    public void generateAbnormalLadderPoleTest() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderPole.of(-1))
                .withMessageContaining("Ladder pole must be greater than zero.");
    }

    @DisplayName("생성 (복수) 테스트")
    @Test
    public void generateLadderPolesTest() {
        assertThatCode(() -> LadderPoles.newInstance(Arrays.asList(LadderPole.of(1), LadderPole.of(3)))).doesNotThrowAnyException();
    }

    @DisplayName("생성 (복수) 비정상 테스트")
    @Test
    public void generateAbnormalLadderPolesTest() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderPoles.newInstance(Collections.emptyList()))
                .withMessageContaining("ladderPoles must be existed.");
    }

    @DisplayName("결과 매핑 테스트")
    @Test
    public void convertToGameRewordsTest() {
        LadderPoles ladderPoles = LadderPoles.newInstance(0, 2, 1);
        LadderGameRewords ladderGameRewords = LadderGameRewords.newInstance("1000,2000,3000");
        LadderGameRewords expectedLadderGameRewords = LadderGameRewords.newInstance("1000,3000,2000");

        assertThat(ladderPoles.convertToGameRewords(ladderGameRewords)).isEqualTo(expectedLadderGameRewords);
    }

    @DisplayName("결과 매핑 비정상 테스트")
    @Test
    public void convertToGameRewordsAbnormalTest() {
        LadderPoles ladderPoles = LadderPoles.newInstance(0, 2, 1, 3);
        LadderGameRewords ladderGameRewords = LadderGameRewords.newInstance("1000,2000,3000");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> ladderPoles.convertToGameRewords(ladderGameRewords))
                .withMessageContaining("ladderGameRewords count must be same as ladderPoles count to map ths game rewords result.");
    }
}
