package laddergameplay.domain.ladder;

import laddergameplay.exception.CustomException;
import laddergameplay.strategy.LineStrategy;
import laddergameplay.strategy.RandomLineStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LineTest {

    @Test
    @DisplayName("Line 생성")
    void create() {
        // given
        int widthOfLadder = 4;
        LineStrategy lineStrategy = new RandomLineStrategy(){
            @Override
            protected boolean currentPoint() {
                return true;
            }
        };

        // when
        Line line = new Line(widthOfLadder, lineStrategy);

        // then
        assertThat(line).isEqualTo(new Line(widthOfLadder, lineStrategy));
        assertThat(line.getPoints().get(0))
                .isInstanceOf(Boolean.class);
    }

    @Test
    @DisplayName("Line 생성 실패 : true,true 입력")
    void check_true_repetition() {
        // given
        int countOfPeople = 4;
        LineStrategy lineStrategy = () -> true;

        // when, then
        assertThatThrownBy(() -> new Line(countOfPeople, lineStrategy))
                .isInstanceOf(CustomException.class)
                .hasMessageContaining(Line.EXIST_TRUE_REPETITION);
    }
}