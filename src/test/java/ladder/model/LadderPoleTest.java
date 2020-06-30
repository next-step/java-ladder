package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.*;

@DisplayName("사다리 세로라인 LadderPole 테스트")
public class LadderPoleTest {

    @DisplayName("생성 테스트")
    @Test
    public void generateLadderPoleTest() {
        assertThatCode(() -> LadderPole.create(2)).doesNotThrowAnyException();
    }

    @DisplayName("생성 비정상 테스트")
    @Test
    public void generateAbnormalLadderPoleTest() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderPole.create(-1))
                .withMessageContaining("사다라의 세로 라인은 0 이상이어야 합니다.");
    }

    @DisplayName("생성 (복수) 테스트")
    @Test
    public void generateLadderPolesTest() {
        assertThatCode(() -> LadderPoles.create(Arrays.asList(LadderPole.create(1), LadderPole.create(3))))
                .doesNotThrowAnyException();
    }

    @DisplayName("생성 (복수) 비정상 테스트")
    @Test
    public void generateAbnormalLadderPolesTest() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderPoles.create(Collections.emptyList()))
                .withMessageContaining("사다리 세로 기둥은 반드시 존재해야 합니다.");
    }

    @DisplayName("결과 매핑 테스트")
    @Test
    public void convertToGameRewordsTest() {
        LadderPoles ladderPoles = LadderPoles.create(0, 2, 1);
        LadderGameRewords ladderGameRewords = LadderGameRewords.create("1000,2000,3000");
        LadderGameRewords expectedLadderGameRewords = LadderGameRewords.create("1000,3000,2000");

        assertThat(ladderPoles.convertToGameRewords(ladderGameRewords)).isEqualTo(expectedLadderGameRewords);
    }

    @DisplayName("결과 매핑 비정상 테스트")
    @Test
    public void convertToGameRewordsAbnormalTest() {
        LadderPoles ladderPoles = LadderPoles.create(0, 2, 1, 3);
        LadderGameRewords ladderGameRewords = LadderGameRewords.create("1000,2000,3000");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> ladderPoles.convertToGameRewords(ladderGameRewords))
                .withMessageContaining("세로 기둥의 크기와 결과값으 갯수는 동일해야 합니다.");
    }
}