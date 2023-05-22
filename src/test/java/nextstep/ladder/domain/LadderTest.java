package nextstep.ladder.domain;

import nextstep.ladder.domain.strategy.BridgeStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    private Participants participants;
    private Height height;
    private BridgeStrategy strategy;
    private LadderResult result;


    @BeforeEach
    void setUp() {
        List<String> participants = List.of("pobi", "honux", "crong", "jk");
        this.participants = new Participants(participants);
        this.height = new Height(5);
        this.strategy = () -> true;
        this.result = LadderResult.of(this.participants, List.of("꽝", "5000", "꽝", "3000"));
    }

    @DisplayName("참여자와 사다리 높이가 주어졌을 때 사다리 높이 만큼의 Line 리스트를 생성한다.")
    @Test
    void when_ParticipantsAndHeightOfLadderIsGiven_Expect_HeightSizeOfLineList() {
        Ladder ladder = Ladder.of(participants, height, strategy);
        assertThat(ladder.size()).isEqualTo(height.getHeight());
    }

    @DisplayName("pobi의 실행 결과는 5000이다")
    @Test
    void gameResultTest_1() {
        String expected = "5000";

        Ladder ladder = Ladder.of(participants, height, strategy);
        Map<String, String> gameResults = ladder.generateResult(participants, result);

        System.out.println(gameResults);


        assertThat(gameResults.get("pobi")).isEqualTo(expected);
    }

    @DisplayName("honux의 실행 결과는 꽝이다")
    @Test
    void gameResultTest_2() {
        String expected = "꽝";

        Ladder ladder = Ladder.of(participants, height, strategy);
        Map<String, String> gameResults = ladder.generateResult(participants, result);

        assertThat(gameResults.get("honux")).isEqualTo(expected);
    }

    @DisplayName("crong의 실행 결과는 3000이다")
    @Test
    void gameResultTest_3() {
        String expected = "3000";

        Ladder ladder = Ladder.of(participants, height, strategy);
        Map<String, String> gameResults = ladder.generateResult(participants, result);

        assertThat(gameResults.get("crong")).isEqualTo(expected);
    }

    @DisplayName("jk의 실행 결과는 꽝이다")
    @Test
    void gameResultTest_4() {
        String expected = "꽝";

        Ladder ladder = Ladder.of(participants, height, strategy);
        Map<String, String> gameResults = ladder.generateResult(participants, result);

        assertThat(gameResults.get("jk")).isEqualTo(expected);
    }
}
