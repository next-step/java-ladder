package ladder.domain.result;

import ladder.domain.result.factory.GameResultFactory;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultFactoryTest {

    @Test
    void create_rewards() {
        String item0 = "item0";
        String item1 = "item1";
        String item2 = "item2";
        String[] items = new String[]{item0, item1, item2};

        List<Reward> rewards = GameResultFactory.createRewards(items);
        assertThat(rewards)
                .isEqualTo(List.of(
                                new Reward(item0, 0),
                                new Reward(item1, 1),
                                new Reward(item2, 2)
                        )
                );
    }
}