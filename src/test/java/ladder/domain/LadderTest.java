package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    @DisplayName("높이를 가지는 사다리 객체 생성")
    @Test
    void createLadder() {
        Height height = Height.of("1");

        Ladder actual = new Ladder(height);

        assertThat(actual.height()).isEqualTo(height);
    }
}