package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {
    @Test
    @DisplayName("인접 해서 사다리 바가 있을 수 없음")
    void adjacentTest() {
        assertThatThrownBy(() -> valueOfLine(Bar.IS_EXIST, Bar.IS_EXIST, Bar.NOT_EXIST, Bar.IS_EXIST))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("일반 정상 생성")
    void createBarsTest() {
        assertThat(valueOfLine(Bar.IS_EXIST, Bar.NOT_EXIST, Bar.IS_EXIST, Bar.NOT_EXIST).getBarExists())
                .hasSize(4);
    }

    @ParameterizedTest
    @DisplayName("움직임 테스트")
    @CsvSource(value = {
            "0,1",
            "1,0",
            "2,3",
            "3,2",
            "4,4"})
    void moveTest(int start, int end) {
        Line testLine = valueOfLine(Bar.IS_EXIST, Bar.NOT_EXIST, Bar.IS_EXIST, Bar.NOT_EXIST);
        assertThat(testLine.move(LadderNumber.of(start)))
                .isEqualTo(LadderNumber.of(end));
    }

    private Line valueOfLine(Bar... bars){
        return Line.of(Arrays.asList(bars));
    }
}
