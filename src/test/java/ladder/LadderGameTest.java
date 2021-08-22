package ladder;


import ladder.model.LadderGame;
import ladder.model.Line;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {
    private static final String[] TEST_NAME_LIST = {"pobi", "crong", "test"};
    private static final int LADDER_HEIGHT = 5;

    LadderGame ladderGame;

    @BeforeEach
    void setting() {
        ladderGame = new LadderGame(TEST_NAME_LIST);
        ladderGame.game(LADDER_HEIGHT);
    }

    @Test
    void 참여자수_체크() {
        assertThat(ladderGame.getParticipant().participantsSize())
                .isEqualTo(TEST_NAME_LIST.length);

    }

    @Test
    void 사람수_만큼_라인포인트_체크() {
        for (Line line : ladderGame.getLines().getLineList()) {
            assertThat(line.getPoints().size())
                    .isEqualTo(TEST_NAME_LIST.length);
        }
    }

    @Test
    void 라인에_TRUE가_들어가면_TRUE_TRUE_FALSE() {
        LadderGame ladderGame1 = new LadderGame(TEST_NAME_LIST);
        ladderGame1.game(1);
        List<Boolean> pointList = ladderGame1.makeLine(() -> true);
        assertThat(pointList.get(0))
                .isTrue();
        assertThat(pointList.get(1))
                .isTrue();
        assertThat(pointList.get(2))
                .isFalse();
    }

    @Test
    void 라인에_FALSE가_들어가면_FALSE() {
        LadderGame ladderGame1 = new LadderGame(TEST_NAME_LIST);
        ladderGame1.game(1);
        List<Boolean> pointList = ladderGame1.makeLine(() -> false);
        assertThat(pointList.get(0))
                .isFalse();
    }


}
