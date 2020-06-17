package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("LadderGame 클래스 테스트")
class LadderGameTest {
    private final String name = "pobi";
    private final String names = name + ",honux,crong,jk";
    private final List<String> nameList = Arrays.stream(names.split(",")).collect(Collectors.toList());

    private final String rewardName = "꽝";
    private final String rewardNames = rewardName + ",5000,꽝,3000";
    private final List<String> rewards = Arrays.stream(rewardNames.split(",")).collect(Collectors.toList());

    private LadderGame ladderGame;

    @BeforeEach
    void setUp() {
        Players players = new Players(nameList);
        int height = 1;
        ladderGame = LadderGame.init(players
                , new Rewards(rewards, players.getPlayersCount())
                , new Height(height)
                , new AlwaysTruePointGenerationStrategy()
        );
    }

    @DisplayName("LadderGame 객체를 생성할 수 있다.")
    @Test
    void init() {
        assertThat(ladderGame.getLadder()).isNotNull();
    }

    @DisplayName("참가자 한명에 대한 사다리 게임 실행 결과를 반환할 수 있다.")
    @Test
    void playOne() {
        Reward reward = ladderGame.playOne(name);
        assertThat(reward.getReward()).isEqualTo("5000");
    }

    @DisplayName("참가자 전체에 대한 사다리 게임 실행 결과를 반환할 수 있다.")
    @Test
    void playAll() {
        Map<String, Reward> resultMap = ladderGame.playAll();
        assertThat(resultMap).hasSize(4);
    }
}
