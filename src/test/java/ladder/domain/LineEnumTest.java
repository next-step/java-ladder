package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LineEnumTest {

    @Test
    @DisplayName("해당 포인트에 중간다리 있으면 ----- 확인")
    public void trueStringTest() throws Exception {
        //given
        Boolean point = true;
        String result = "-----";

        //when
        String line = LineEnum.ofLine(point);

        //then
        assertThat(line).isEqualTo(result);
    }

    @Test
    @DisplayName("해당 포인트에 중간다리 없으면 '     ' 확인")
    public void falseStringTest() throws Exception {
        //given
        Boolean point = false;
        String result = "     ";

        //when
        String line = LineEnum.ofLine(point);

        //then
        assertThat(line).isEqualTo(result);
    }
}
