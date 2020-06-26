package nextstep.step4.domain;

import nextstep.step4.strategy.TestDrawLineStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Ladder 테스트")
class LadderTest {

    private int userCount = 4;
    private int ladderHeight = 3;
    private List<Boolean> points1 = Arrays.asList(true, false, true, false);
    private Ladder ladder = new Ladder(userCount, ladderHeight, new TestDrawLineStrategy(points1));

    @DisplayName("Ladder 생성자 체크")
    @Test
    void Ladder() {
        assertThat(ladder.getLines().size()).isEqualTo(ladderHeight);
        assertThat(ladder.getLines().get(0)).isInstanceOf(LadderLine.class);
    }

    @DisplayName("사다리 게임 결과 확인")
    @Test
    void getLadderGameResult() {
        List<String> userNames = Arrays.asList("name1", "name2", "name3", "name4");
        List<String> playResult = Arrays.asList("1등","꽝","2등","3등");

        Map<String, User> expectResult = new HashMap<>();
        expectResult.put("name1", new User("name1", "3등"));
        expectResult.put("name2", new User("name2", "꽝"));
        expectResult.put("name3", new User("name3", "2등"));
        expectResult.put("name4", new User("name4", "1등"));

        Map<String, User> actual = ladder.getLadderGameResult(userNames, playResult);

        assertThat(actual).isEqualTo(expectResult);
    }
}
