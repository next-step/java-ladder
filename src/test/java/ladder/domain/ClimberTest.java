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
        Climber climber = Climber.of("pobi,honux,crong,jk",4, crossRoadStrategy);
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

    @ParameterizedTest
    @CsvSource(value = {"pobi,honux,crong,jk pobi:0", "pobi,honux,crong crong:2", "pobi,honux pobi:0"}, delimiter = ':')
    void claimByUserTest(String input, String expected) {
        String[] inputs = input.split(" ");
        CrossRoadStrategy crossRoadStrategy = () -> true;
        Climber climber = Climber.of(inputs[0], 4, crossRoadStrategy);

        int result = climber.claimByUser(inputs[1]);

        assertThat(result).isEqualTo(Integer.parseInt(expected));
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,honux,crong,jk", "pobi,honux,crong", "pobi,honux"})
    void claimAllTest(String input) {
        CrossRoadStrategy crossRoadStrategy = () -> true;
        Climber climber = Climber.of(input, 4, crossRoadStrategy);

        Users claimAllUsers = climber.claimAll();

        List<Integer> result = claimAllUsers.toList().stream()
                .map(User::position)
                .collect(Collectors.toList());

        int resultSize = input.split(",").length;
        Integer[] expectedResultIndex = IntStream.range(0, resultSize).boxed().toArray(Integer[]::new);

        assertThat(result)
                .hasSize(resultSize)
                .containsOnlyOnce(expectedResultIndex);
    }
}
