package ladder2.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LadderColumnTest {

    @ParameterizedTest
    @CsvSource(value = {"NO_LINK;1", "LEFT_LINK;0", "RIGHT_LINK;2"}, delimiter = ';')
    @DisplayName("연결되어 있는 열로 가는 인덱스를 반환한다")
    void nextPosition(String linkName, int expected) {
        LadderColumn column = new LadderColumn(1, Link.valueOf(linkName));
        Position result = column.nextPosition();
        assertThat(result.value()).isEqualTo(expected);
    }
}
