package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LineEnumTest {

    @Test
    @DisplayName("해당 포인트에 중간다리 있으면 ----- 확인")
    public void trueStringTest() throws Exception {

        Boolean point = true;
        String result = "-----";
        String line = LineEnum.ofLine(point);
        assertThat(line).isEqualTo(result);
    }

    @Test
    @DisplayName("해당 포인트에 중간다리 없으면 '     ' 확인")
    public void falseStringTest() throws Exception {
        Boolean point = false;
        String result = "     ";
        String line = LineEnum.ofLine(point);
        assertThat(line).isEqualTo(result);
    }
}