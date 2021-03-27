package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LineTest {

    @Test
    @DisplayName("참여자 만큼 라인 포인트 생성")
    public void createLinePointTest() throws Exception {
        //given
        int countOfPerson = 3;

        //when
        Line line = new Line(3);
        int size = line.readOnlyPoints().size();

        //then
        assertThat(size).isEqualTo(countOfPerson);
    }

    @Test
    @DisplayName("참여자 2명 미만 일시 에러")
    public void personTwoUnderException() throws Exception {
        //given
        int countOfPersion = 1;

        //when
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Line(countOfPersion);
        });

        //then

    }
}
