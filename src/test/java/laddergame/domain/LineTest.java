package laddergame.domain;

import laddergame.strategy.RandomLineStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

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
    @DisplayName("true 이후 false 입력 여부 확인")
    void check_true_and_false() {
        // given
        int countOfPeople = 4;

        // when
        Line line = new Line(countOfPeople, () -> true);

        // then
        assertThat(line.stream().collect(Collectors.toList()))
                .containsExactly(true, false, true);
    }
}