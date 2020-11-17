package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("사다리 테스트")
public class LadderTest {
    @DisplayName("주어진 높이로 사다리 생성")
    @Test
    public void createLadderWithHeight() {
        int height = Ladder.of(4, 5).getHeight();

        assertThat(height).isEqualTo(5);
    }

    @DisplayName("사다리 따라가기")
    @ParameterizedTest
    @CsvSource(value = {"0:0", "1:3", "2:2", "3:1"}, delimiter = ':')
    public void followLadder(int startPoint, int expectedEndPoint) {
        Ladder ladder = Ladder.of(Arrays.asList(Line.of(Arrays.asList(false, true, false, true)),
                Line.of(Arrays.asList(false, false, true, false)),
                Line.of(Arrays.asList(false, true, false, false)),
                Line.of(Arrays.asList(false, false, true, false)),
                Line.of(Arrays.asList(false, true, false, true))
        ));

        int endPoint = ladder.followFrom(startPoint);

        assertThat(endPoint).isEqualTo(expectedEndPoint);
    }

    @DisplayName("입력한 사다리 결과로 변환")
    @ParameterizedTest
    @CsvSource(value = {"0:꽝", "1:5000", "2:꽝", "3:5000"}, delimiter = ':')
    public void convertToEndPointResult(int startPoint, String expectedResult) {
        Ladder ladder = Ladder.of(Arrays.asList(Line.of(Arrays.asList(false, true, false, true)),
                Line.of(Arrays.asList(false, false, true, false)),
                Line.of(Arrays.asList(false, true, false, false)),
                Line.of(Arrays.asList(false, false, true, false)),
                Line.of(Arrays.asList(false, true, false, true))
        ));

        List<String> endPointResult = ladder.followAllLinesToEndPoint(Arrays.asList("꽝", "5000", "꽝", "5000"));

        assertThat(endPointResult.get(startPoint)).isEqualTo(expectedResult);
    }

}