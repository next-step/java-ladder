package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LineFactoryTest {

    @Test
    @DisplayName("성공 - 하나의 라인을 만든다.")
    void success_generate_line() {
        int countOfPerson = 4;
        int expectSize = 3;

        Line line = LineFactory.createLine(countOfPerson);

        assertThat(line.size()).isEqualTo(expectSize);
    }

}
