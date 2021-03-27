package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LineTest {

    @Test
    @DisplayName("참여자 만큼 라인 생성")
    void tdd() {
        //given
        int countOfPerson = 3;

        //when
        Line line = new Line(3);
        int size = line.readOnlyPoints().size();

        //then
        assertThat(size).isEqualTo(countOfPerson);
    }
}
