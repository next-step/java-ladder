package ladder.domain.ladderline;

import ladder.domain.model.Index;
import ladder.domain.model.LadderLine;
import ladder.domain.model.LadderLines;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DefaultLadderLineFactoryTest {

    @Test
    @DisplayName("생성된 사다리의 높이를 확인한다")
    void createLadder() {
        LadderLineFactory ladderLineFactory = new DefaultLadderLineFactory(() -> true);
        LadderLines lines = ladderLineFactory.create(5 ,5);
        assertThat(lines.get().size()).isEqualTo(5);
    }

    @Test
    @DisplayName("생성된 사다리의 사이즈를 확인한다")
    void createLadder2() {
        LadderLineFactory ladderLineFactory = new DefaultLadderLineFactory(() -> true);
        LadderLines lines = ladderLineFactory.create(5 ,5);
        assertThat(lines.get().get(0).getLines().size()).isEqualTo(5);
    }

    @Test
    @DisplayName("첫번째 라인의 첫칸에 라인이 있는것을 확인한다")
    void createLine2() {
        LadderLineFactory ladderLineFactory = new DefaultLadderLineFactory(() -> true);
        LadderLine line = ladderLineFactory.create(5, 5).get().get(0);

        assertFalse(line.getPoint(Index.of(0)).isLeft());
        assertTrue(line.getPoint(Index.of(0)).isRight());
        assertTrue(line.getPoint(Index.of(1)).isLeft());
    }

    @Test
    @DisplayName("첫번째 라인의 마지막칸에 라인이 없는것을 확인한다")
    void createLine3() {
        LadderLineFactory ladderLineFactory = new DefaultLadderLineFactory(() -> true);
        LadderLine line = ladderLineFactory.create(5, 5).get().get(0);

        assertTrue(line.getPoint(Index.of(3)).isLeft());
        assertFalse(line.getPoint(Index.of(3)).isRight());
        assertFalse(line.getPoint(Index.of(4)).isLeft());
        assertFalse(line.getPoint(Index.of(4)).isRight());
    }
}
