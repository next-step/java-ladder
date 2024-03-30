package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;


class LineTest {

    @ParameterizedTest
    @DisplayName("하나의 라인은 (참여자들 -1)개만큼의 boolean 값들이 존재(pobi,honux => 2/ pobi,hounx,koko => 3)")
    @CsvSource(value = {"pobi,honux:2", "pobi,hounx,koko:3"} , delimiter = ':')
    void line_size(String names, int size) {
        Line line = new Line(new Participant(names));
        assertThat(line.getSize()).isEqualTo(size);
    }
}
