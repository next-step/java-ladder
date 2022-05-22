package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LadderTest {

    @ParameterizedTest
    @CsvSource(value = {"3, 5", "2, 8", "5, 5"})
    @DisplayName("높이만큼 line 개수와 너비만큼의 point 개수를 가진 사다리 생성 ")
    void createLadderTest(int height, int width) {
        // given
        Ladder ladder = Ladder.createLadder(width, height, () -> true);
        // when
        List<Line> lines = ladder.getLines();
        // then
        assertThat(lines).hasSize(height);
        for (Line line : lines) {
            assertThat(line.numberOfPoints()).isEqualTo(width);
        }
    }
    

}