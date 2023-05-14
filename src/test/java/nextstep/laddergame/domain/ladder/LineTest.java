package nextstep.laddergame.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    @DisplayName("라인 생성 테스트")
    void create() {
        assertThat(new Line(3))
                .extracting("points")
                .asList()
                .hasSize(3);
    }

    @ParameterizedTest(name = "현재 좌표 확인 테스트")
    @CsvSource(value = {"0,false", "1,true", "2,false"})
    void checkCurrentPoint(int index, boolean result) {
        final Line line = new Line(List.of(false, true, false));

        assertThat(line.currentPoint(index))
                .isEqualTo(result);
    }

    @ParameterizedTest(name = "다음 좌표 확인 테스트")
    @CsvSource(value = {"0,true", "1,false", "2,false"})
    void checkNextPoint(int index, boolean result) {
        final Line line = new Line(List.of(false, true));

        assertThat(line.nextPoint(index))
                .isEqualTo(result);
    }
}
