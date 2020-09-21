package nextstep.ladder.domain.ladderGame;

import nextstep.ladder.domain.ladder.LadderResult;
import nextstep.ladder.domain.ladder.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
        Player plyaerA = new Player("A");
        Player plyaerB = new Player("B");
        LadderReward ggang = LadderReward.from("꽝");
        LadderReward lucky = LadderReward.from("당첨");
        ladderGameInfo = new LadderGameInfo(new Players(Arrays.asList(plyaerA, plyaerB)),
                new LadderRewards(Arrays.asList(ggang, lucky)));
    }

    @Test
    @DisplayName("create")
    void create() {
        assertThat(ladderGameInfo).isNotNull();
    }

    @Test
    @DisplayName("참여할 사람과 실행 결과의 수는 같아야 한다.")
    void exceptionByCreation() {
        Player plyaerA = new Player("A");
        Player plyaerB = new Player("B");
        LadderReward ggang = LadderReward.from("꽝");
        LadderReward ggang2 = LadderReward.from("꽝");
        LadderReward lucky = LadderReward.from("당첨");

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LadderGameInfo(new Players(Arrays.asList(plyaerA, plyaerB)),
                    new LadderRewards(Arrays.asList(ggang, ggang2, lucky)));
        }).withMessage("참여할 사람과 실행 결과의 수는 같아야 한다.");
    }

    @Test
    @DisplayName("사다리 게임 정보에 사다리 결과를 반영하면 사다리 게임 결과가 나온다")
    void apply() {
        Map<Location, Location> locationResult = new HashMap<>();
        locationResult.put(Location.from(0), Location.from(1));
        locationResult.put(Location.from(1), Location.from(0));
        LadderResult ladderResult = new LadderResult(locationResult);

        Map<Player,LadderReward> expectedResult = new HashMap<>();
        expectedResult.put(new Player("A"), LadderReward.from("당첨"));
        expectedResult.put(new Player("B"), LadderReward.from("꽝"));
        LadderGameResult expected = LadderGameResult.from(expectedResult);

        assertThat(ladderGameInfo.apply(ladderResult)).isEqualTo(expected);
    }
}
