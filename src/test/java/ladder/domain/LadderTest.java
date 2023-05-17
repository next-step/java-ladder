package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @DisplayName("사다리(lines) 생성 테스트")
    @ParameterizedTest
    @CsvSource(value = {"5:4", "8:6", "7:4"}, delimiter = ':')
    public void 사다리_생성_테스트(int height, int width) {
        Ladder ladder = new Ladder(height, width);

        assertThat(ladder.getLines()).hasSize(height);

        ladder.getLines().forEach(line -> {
            assertThat(line.getPoints()).hasSize(width-1);
        });
    }

    @DisplayName("사다리(lines) 생성 후 라인(Line) 길이 테스트")
    @ParameterizedTest
    @CsvSource(value = {"5:4:3", "8:6:5", "7:4:3"}, delimiter = ':')
    public void 사다리_라인_길이_테스트(int height, int width, int pointSize) {
        Ladder ladder = new Ladder(height, width);

        ladder.getLines().forEach(line -> {
            assertThat(line.getPoints()).hasSize(pointSize);
        });
    }
}
