package reladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    private Ladder ladder;

    @BeforeEach
    void setUp() {
        // give
        ladder = new DefaultLadderGenerator().generate(5, 4);
    }

    @Test
    @DisplayName("사다리 객체 사이즈 테스트")
    void checkSizeOfLadder() {
        // when
        int size = ladder.getLadderLines().size();
        // then
        assertThat(size).isEqualTo(5);
    }
}
