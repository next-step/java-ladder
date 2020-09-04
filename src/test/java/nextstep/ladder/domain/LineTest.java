package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @ParameterizedTest
    @CsvSource(value = {"4,3"}, delimiter = ',')
    @DisplayName("사다리사이의 브릿지 갯수 테스트")
    void bridgeCountBetweenLadderTest(int userCount, int bridgeCount) {

        Line line = new Line(userCount);

        assertThat(line.getPoints().size()).isEqualTo(bridgeCount);
    }

}
