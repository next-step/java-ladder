package laddergame.domain;

import laddergame.exception.CustomException;
import laddergame.strategy.LineStrategy;
import laddergame.strategy.RandomLineStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LineTest {

    @Test
    @DisplayName("Line 생성")
    void create() {
        // given
        int countOfPeople = 5;

        // when
        Line line = new Line(countOfPeople,new RandomLineStrategy());

        // then
        assertThat(line.stream().count()).isEqualTo(countOfPeople-1);
        assertThat(line.stream().findAny().orElse(null))
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