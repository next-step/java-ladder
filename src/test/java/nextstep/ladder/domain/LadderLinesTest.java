package nextstep.ladder.domain;

import nextstep.ladder.domain.line.LadderLines;
import nextstep.ladder.domain.line.LadderLineGenerator;
import nextstep.ladder.domain.result.LadderResult;
import nextstep.ladder.domain.user.User;
import nextstep.ladder.domain.user.UserGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LadderLinesTest {

    private int countOfUser;
    private int height;
    private LadderResult ladderResult;
    private List<User> users;
    private LadderLines ladderLines;


    @BeforeEach
    void setUp() {
        countOfUser = 4;
        height = 5;
        users = UserGenerator.generateUsers("pobi,honux");
        ladderResult = new LadderResult(users);
    }

    @Test
    @DisplayName("사다리 라인 생성")
    void createLadderLine() {
        ladderLines = LadderLineGenerator.generateLadderLine(height, countOfUser, () -> false);
        assertThat(ladderLines.size()).isEqualTo(5);
    }

    @Test
    @DisplayName("User 2명 사다리 진행")
    void playLadder() {
        ladderLines = LadderLineGenerator.generateLadderLine(3,2, () -> true);
        Map<User, Integer> result = ladderLines.goDownALadder(ladderResult.getLadderResult());
        User user = users.get(0);
        assertThat(result.get(user)).isEqualTo(1);
    }

}
