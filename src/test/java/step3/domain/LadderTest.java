package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderTest {
    
    @DisplayName("입력 갯수에 맞는 라인 수 리턴 확인")
    @Test
    void getLines() {
        Ladder ladder = new Ladder(5, true);
        assertThat(ladder.getLines().size()).isEqualTo(5);
    }

    @DisplayName("입력 갯수에 맞는 라인 수 리턴 확인")
    @Test
    void getLineCount() {
        Ladder ladder = new Ladder(5, true);
        assertThat(ladder.getLineCount()).isEqualTo(5);
    }
}
