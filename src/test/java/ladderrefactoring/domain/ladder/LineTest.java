package ladderrefactoring.domain.ladder;

import ladderrefactoring.exception.CustomException;
import ladderrefactoring.strategy.LineStrategy;
import ladderrefactoring.strategy.RandomLineStrategy;
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

    @Test
    @DisplayName("point 이동")
    void move() {
        // given
        int widthOfLadder = 4;
        LineStrategy lineStrategy = new RandomLineStrategy(){
            @Override
            protected boolean currentPoint() {
                return true;
            }
        };
        Line line = new Line(widthOfLadder, lineStrategy);

        // when
        int movedPosition1 = line.movePosition(1);
        int movedPosition2 = line.movePosition(2);

        // then
        assertThat(movedPosition1).isEqualTo(0);
        assertThat(movedPosition2).isEqualTo(3);
    }
}