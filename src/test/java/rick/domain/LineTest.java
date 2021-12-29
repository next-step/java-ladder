package rick.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LineTest {

    @ParameterizedTest
    @DisplayName("라인을 통과한 뒤의 playerIndex 확인")
    @CsvSource(value = {
        "0:false:true:true:false:false:true:true:false:1",
        "1:false:true:true:false:false:true:true:false:0",
        "2:false:true:true:false:false:true:true:false:3",
        "3:false:true:true:false:false:true:true:false:2",
        "0:false:false:false:true:true:false:false:false:0",
        "1:false:false:false:true:true:false:false:false:2",
        "2:false:false:false:true:true:false:false:false:1",
        "3:false:false:false:true:true:false:false:false:3",
        "0:false:false:false:false:false:false:false:false:0",
        "1:false:false:false:false:false:false:false:false:1",
        "2:false:false:false:false:false:false:false:false:2",
        "3:false:false:false:false:false:false:false:false:3"}, delimiter = ':')
    void createWithLineCreationStrategy2(int currentPlayerIndex, boolean left1, boolean right1,
        boolean left2, boolean right2, boolean left3, boolean right3, boolean left4, boolean right4,
        int expectedNextPlayerIndex) {
        Points points = new Points(Arrays.asList(
            new Point(left1, right1), new Point(left2, right2), new Point(left3, right3), new Point(left4, right4)
        ));

        Line line = new Line(points);

        assertThat(line.nextPlayerIndex(currentPlayerIndex))
            .isEqualTo(expectedNextPlayerIndex);
    }
}
