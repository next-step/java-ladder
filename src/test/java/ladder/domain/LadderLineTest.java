package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LadderLineTest {

    private static final boolean BAR = true;
    private static final boolean LADDER = true;
    private static final boolean BLANK = false;

    @Test
    @DisplayName("입력받은 참가자 수에 맞는 길이를 가진 사다리를 생성한다.")
    void should_return_ladder() {
        //Given & When
        LadderLine ladderLine = new LadderLine(4, new RandomLadderGenerateStrategy());

        //Then
        assertThat(ladderLine.getPoints().size()).isEqualTo(7);
    }

    @Test
    @DisplayName("가로 사다리 생성 전략이 blank(false)가 들어가면, blank만 가진 사다리를 반환한다.")
    void should_return_false_points() {
        //Given & When
        LadderLine ladderLine = new LadderLine(3, () -> BLANK);

        //Then
        assertThat(ladderLine.getPoints()).containsAll(Arrays.asList(BAR, BLANK, BAR, BLANK, BAR));
    }

    @Test
    @DisplayName("가로 사다리 생성 전략이 ladder(true)가 들어가면, ladder만 가진 사다를 반환한다.")
    void should_return_true_points() {
        //Given & When
        LadderLine ladderLine = new LadderLine(3, () -> LADDER);

        //Then
        assertThat(ladderLine.getPoints()).containsAll(Arrays.asList(BAR, LADDER, BAR, LADDER, BAR));
    }

    @Test
    @DisplayName("연속되지 않는 사다리를 생성한다.")
    void should_return_non_continuous_points() {
        //Given & When
        LadderLine ladderLine = new LadderLine(3, new RandomLadderGenerateStrategy());

        //Then
        for (int index = 3; index < ladderLine.getPoints().size(); index += 2) {
            boolean previous = ladderLine.getPoints().get(index - 2);
            boolean current = ladderLine.getPoints().get(index);
            assertThat(previous).isNotEqualTo(current);
        }
    }


}
