package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LineTest {

    @Test
    @DisplayName("사람 수 만큼 라인 생성")
    void tdd() {
        //given
        int countOfPerson = 3;

        //when
        List<Line> lines = new Line(3);

        //then
        assertThat(lines.size()).isEqual(countOfPerson);
    }
}
