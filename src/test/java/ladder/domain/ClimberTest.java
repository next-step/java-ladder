package ladder.domain;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class ClimberTest {

    @ParameterizedTest
    @CsvSource(value = {"pobi,honux,crong,jk:4", "pobi,honux,crong:3", "pobi,honux:2"}, delimiter = ':')
    void createLadderMapTest(String input, String expected) {
        CrossRoadStrategy crossRoadStrategy = () -> true;
        Climber climber = Climber.of(input, 4, crossRoadStrategy);
        LadderMap ladderMap = climber.targetLadder();

        assertThat(ladderMap.toList()).hasSize(4);
    }

    @Test
    void offerPrizeTest() {
        CrossRoadStrategy crossRoadStrategy = () -> true;
        Climber climber = Climber.of("pobi,honux,crong,jk", crossRoadStrategy);
        Reward reward = climber.offerPrize("꽝,5000,꽝,3000");

        assertThat(reward.toList()).hasSize(4);
    }

    @Test
    void participantNamesTest() {
        CrossRoadStrategy crossRoadStrategy = () -> true;
        Climber climber = Climber.of("pobi,honux,crong,jk", 4, crossRoadStrategy);

        assertThat(climber.participantNames()).hasSize(4);
    }

    @Test
    void getLadderMapListTest() {
        CrossRoadStrategy crossRoadStrategy = () -> true;
        Climber climber = Climber.of("pobi,honux,crong,jk", 4, crossRoadStrategy);
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
        CrossRoadStrategy crossRoadStrategy = () -> true;
        Climber climber = Climber.of("pobi,honux,crong,jk", 4, crossRoadStrategy);
        Reward reward = climber.offerPrize("꽝,5000,꽝,3000");

        assertThat(climber.getRewards(reward)).hasSize(4);
    }
}
