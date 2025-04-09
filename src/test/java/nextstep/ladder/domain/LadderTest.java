package nextstep.ladder.domain;

import nextstep.ladder.domain.line.strategy.LineCreateStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LadderTest {

    private final LineCreateStrategy lineCreateStrategyStub = new LineCreateStrategy() {
        @Override
        public boolean createFirstPoint() {
            return true;
        }

        @Override
        public boolean createNextPoint(boolean prevPoint) {
            return !prevPoint;
        }
    };

    @DisplayName("Ladder 인스턴스 만들기")
    @Test
    public void testConstructor() {
        assertDoesNotThrow(() -> new Ladder("pobi,honux,crong,jk", 3, lineCreateStrategyStub));
    }

    @DisplayName("Ladder 출력 포멧")
    @Test
    public void testToString() {
        Ladder ladder = new Ladder("pobi,honux,crong,jk", 3, lineCreateStrategyStub);
        assertThat(ladder.toString())
            .isEqualTo(
                "pobi  honux crong  jk  \n" +
                    "  |-----|     |-----|\n" +
                    "  |-----|     |-----|\n" +
                    "  |-----|     |-----|"
            );
    }
}
