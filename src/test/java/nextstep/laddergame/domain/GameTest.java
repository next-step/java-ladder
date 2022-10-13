package nextstep.laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {
    private static String POBI = "pobi";
    private static int POBI_INDEX = 0;
    private static List<Gamer> gamers = Arrays.asList(
            new Gamer(POBI, POBI_INDEX)
            , new Gamer("honux", 1)
            , new Gamer("crong", 2)
            , new Gamer("jk", 3)
    );
    private static RewardWrapper rewardWrapper = new RewardWrapper(Arrays.asList("꽝", "5000", "꽝", "3000"));
    private static Height height = new Height("5");
    Game game = new Game(gamers, height, DrawBridgeStrategy.DEFAULT_STRATEGY);

    @Test
    public void get_gamer_test() {
        assertThat(game.getGamer(POBI).getName()).isEqualTo(POBI);
    }

    @Test
    public void get_gamer_test2() {
        assertThat(game.getGamer(POBI_INDEX).getName()).isEqualTo(POBI);
    }

    @Test
    @DisplayName("[1명] 가로 사다리(Bridge)가 0개일 때 사다리 게임의 시작 위치와 종료 위치가 동일한지 테스트")
    public void getResultIndex() {
        int TEST_INDEX = 1;
        Game game = new Game(gamers, height, DrawBridgeStrategy.DRAW_ANY);
        assertThat(game.getResultIndex(TEST_INDEX)).isEqualTo(TEST_INDEX);
    }

    @Test
    @DisplayName("[전원] 가로 사다리(Bridge)가 0개일 때 사다리 게임의 시작 위치와 종료 위치가 동일한지 테스트")
    public void getResultAll() {
        List<Integer> rewards = game.getResultAll();
        List<Gamer> gamers = game.getGamers();
        for (int index = 0; index < game.getGamers().size(); index++) {
            Integer gamerIndex = gamers.get(index).getIndex();
            Integer rewardIndex = rewards.get(index);
            assertThat(gamerIndex).isEqualTo(rewards.get(rewardIndex));
        }
    }

    @Test
    @DisplayName("게이머들 각각의 종료 위치가 중복되지 않는지 테스트")
    public void getResultAll2() {
        List<Integer> resultAllList = game.getResultAll();
        Set<Integer> resultAllSet = new HashSet<>(resultAllList);
        assertThat(resultAllList.size()).isEqualTo(resultAllSet.size());
    }
}