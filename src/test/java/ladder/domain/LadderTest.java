package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class LadderTest {

    @ParameterizedTest
    @CsvSource(value = {"3:5", "4:7", "5:4"}, delimiter = ':')
    @DisplayName("높이만큼 line 개수와 참가자 수 만큼의 point 개수를 가진 사다리 생성 ")
    void createLadderTest(int width, int height) {
        // given
        LadderGenerator ladderGenerator = new LadderGenerator(() -> true);
        Ladder ladder = ladderGenerator.createLadder(width, height);
        // when
        List<Line> lines = ladder.getLines();
        // then
        assertThat(lines).hasSize(height);
        for (Line line : lines) {
            assertThat(line.getPoints().size()).isEqualTo(width);
        }
    }
    

}