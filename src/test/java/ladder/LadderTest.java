package ladder;


import ladder.model.Ladder;
import ladder.model.LadderGame;
import ladder.model.Line;
import ladder.model.RandomLineStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    private static final String[] TEST_NAME_LIST = {"pobi", "crong", "test"};
    private static final int LADDER_HEIGHT = 5;

    Ladder ladder;
    @BeforeEach
    void setting() {
        ladder = new Ladder(TEST_NAME_LIST.length);
        ladder.makeLadder(LADDER_HEIGHT, new RandomLineStrategy());
    }

    @Test
    void 사람수_만큼_라인포인트_체크() {
        for (Line line : ladder.getLines().getLineList()) {
            assertThat(line.getPoints().size())
                    .isEqualTo(TEST_NAME_LIST.length);
        }
    }

    @Test
    void 라인에_TRUE가_들어가면_TRUE_TRUE_FALSE() {
        List<Boolean> pointList = ladder.makeLine(() -> true);
        assertThat(pointList.get(0))
                .isTrue();
        assertThat(pointList.get(1))
                .isTrue();
        assertThat(pointList.get(2))
                .isFalse();
    }

    @Test
    void 라인에_FALSE가_들어가면_FALSE() {
        List<Boolean> pointList = ladder.makeLine(() -> false);
        assertThat(pointList.get(0))
                .isFalse();
    }


}
