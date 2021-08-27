package ladder;


import ladder.model.Ladder;
import ladder.model.LadderGame;
import ladder.model.Line;
import ladder.model.Prize;
import ladder.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {
    private static final String[] TEST_NAME_LIST = {"pobi", "crong", "test"};
    private static final int LADDER_HEIGHT = 1;
    private static final String[] PRIZE_LIST = {"꽝", "1등", "2등"};

    LadderGame ladderGame;
    Prize prize = new Prize(PRIZE_LIST);

    @BeforeEach
    void setting() {
        ladderGame = new LadderGame(TEST_NAME_LIST);
        // pobi : 1등 , crong : 꽝, test : 2등
        ladderGame.makeGame(LADDER_HEIGHT, () -> true);
        ladderGame.gameResult(prize);
    }

    @Test
    void 사람마다_결과매칭_체크() {
        List<String> resultList = ladderGame.getParticipant()
                .getParticipants()
                .stream()
                .map(user -> user.resultInfo())
                .collect(Collectors.toList());
        assertThat(resultList).contains(PRIZE_LIST);
    }

    @ParameterizedTest
    @CsvSource(value = {"pobi:1등", "crong:꽝", "test:2등"}, delimiter = ':')
    void 사람마다_결과_정확히_체크(String name, String result) {
        User user = ladderGame.getParticipant()
                .getParticipants()
                .stream()
                .filter(participants -> participants.nameInfo().equals(name))
                .findFirst().get();
        assertThat(user.resultInfo())
                .isEqualTo(result);
    }



}
