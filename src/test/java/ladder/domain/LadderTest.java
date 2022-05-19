package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    @DisplayName("사다리 높이만큼 라인이 생성된다.")
    void totalLines() {
        assertThat(new Ladder(5, new People("tom", "paul", "anna")).totalLines()).isEqualTo(5);
    }

}