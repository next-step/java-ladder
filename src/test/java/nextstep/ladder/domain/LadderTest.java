package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LadderTest {

    @DisplayName("Ladder 인스턴스 만들기")
    @Test
    public void testConstructor() {
        assertDoesNotThrow(() -> new Ladder("pobi,honux,crong,jk", 3, prevPoint -> !prevPoint));
    }

    @DisplayName("Ladder 출력 포멧")
    @Test
    public void testToString() {
        Ladder ladder = new Ladder("pobi,honux,crong,jk", 3, prevPoint -> !prevPoint);
        assertThat(ladder.toString())
            .isEqualTo(
                "pobi  honux crong  jk  \n" +
                    "  |-----|     |-----|\n" +
                    "  |-----|     |-----|\n" +
                    "  |-----|     |-----|"
            );
    }
}
