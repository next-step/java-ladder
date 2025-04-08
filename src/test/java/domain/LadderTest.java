package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    @Test
    @DisplayName("사다리 생성 시 높이만큼 라인이 생성된다.")
    void 사다리_생성_테스트() {
        int height = 5;
        int participantCount = 4;
        Ladder ladder = new Ladder(height, participantCount);

        List<Line> lines = ladder.getLines();
        assertThat(lines).hasSize(height);
    }
}