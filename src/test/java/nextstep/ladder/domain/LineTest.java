package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @DisplayName("사다리의 행을 생성한다.")
    @Test
    public void init() {
        int sizeOfPerson = 5;
        Line line = Line.init(sizeOfPerson);
        assertThat(line.size()).isEqualTo(sizeOfPerson);
    }
}
