package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LadderGameInfoTest {
    private LadderGameInfo ladderGameInfo;

    @BeforeEach
    void setUp() {
        User userA = new User("userA");
        User userB = new User("userB");
        LadderReward ggang = new LadderReward("꽝");
        LadderReward lucky = new LadderReward("당첨");
        ladderGameInfo = new LadderGameInfo(new Users(Arrays.asList(userA, userB)),
                new LadderRewards(Arrays.asList(ggang, lucky)));
    }

    @Test
    void create() {
        assertThat(ladderGameInfo).isNotNull();
    }

    @Test
    void exceptionByCreation() {
        User userA = new User("userA");
        User userB = new User("userB");
        LadderReward ggang = new LadderReward("꽝");
        LadderReward ggang2 = new LadderReward("꽝");
        LadderReward lucky = new LadderReward("당첨");
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LadderGameInfo(new Users(Arrays.asList(userA, userB)),
                    new LadderRewards(Arrays.asList(ggang, ggang2, lucky)));
        }).withMessage("참여할 사람과 실행 결과의 수는 같아야 한다.");

    }

    @Test
    void match() {
        Map<Position, Position> ladderResults = new HashMap<>();
        ladderResults.put(new Position(0), new Position(1));
        ladderResults.put(new Position(1), new Position(0));
        Map<User, LadderReward> expected = new HashMap<>();
        expected.put(new User("userA"), new LadderReward("당첨"));
        expected.put(new User("userB"), new LadderReward("꽝"));

        assertThat(ladderGameInfo.match(ladderResults)).isEqualTo(expected);
    }
}
