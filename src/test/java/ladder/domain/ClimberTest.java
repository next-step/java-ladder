package ladder.domain;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ClimberTest {

    @ParameterizedTest
    @CsvSource(value = {"pobi,honux,crong,jk:4", "pobi,honux,crong:3", "pobi,honux:2"}, delimiter = ':')
    void createLadderMapTest(String input, String expected) {
        Climber climber = Climber.of(input, 4);
        LadderMap ladderMap = climber.targetLadder();

        assertThat(ladderMap.toList()).hasSize(4);
    }

    @Test
    void offerPrizeTest() {
        Climber climber = Climber.of("pobi,honux,crong,jk", 4);
        Reward reward = climber.offerPrize("꽝,5000,꽝,3000");

        assertThat(reward.toList()).hasSize(4);
    }


    @Test
    void getUserNameTest() {
        Climber climber = Climber.of("pobi,honux,crong,jk", 4);

        assertThat(climber.getUserNames()).hasSize(4);
    }

    @Test
    void getLadderMapListTest() {
        Climber climber = Climber.of("pobi,honux,crong,jk", 4);
        LadderMap ladderMap = climber.targetLadder();

        assertThat(ladderMap.toList()).isInstanceOf(List.class);

        climber.getLadderMapList(ladderMap).stream()
                .flatMap(Collection::stream)
                .forEach(item -> {
                    assertThat(item).isInstanceOf(Boolean.class);
                });
    }

    @Test
    void getRewardTest() {
        Climber climber = Climber.of("pobi,honux,crong,jk", 4);
        Reward reward = climber.offerPrize("꽝,5000,꽝,3000");

        assertThat(climber.getRewards(reward)).hasSize(4);
    }
}
