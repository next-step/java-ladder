package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineFactoryTest {

    @Test
    @DisplayName("성공 - 하나의 라인을 만든다.")
    void success_generate_line() {
        int countOfPerson = 4;
        int expectSize = 4;

        Line line = LineFactory.createLine(countOfPerson);

        assertThat(line.size()).isEqualTo(expectSize);
    }

    @Test
    @DisplayName("성공 - 사람이 한명이면 생성되는 라인은 STAY다.")
    void success_generate_person_single_line() {
        Line line = LineFactory.createLine(1);

        assertThat(line.directions()).hasSize(1)
                .extracting("value")
                .containsOnly(Direction.STAY.getValue());
    }


}
