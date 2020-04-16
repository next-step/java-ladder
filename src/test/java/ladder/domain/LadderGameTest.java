package ladder.domain;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {

    @ParameterizedTest
    @CsvSource(value = {"pobi,honux,crong,jk pobi:0", "pobi,honux,crong crong:2", "pobi,honux pobi:0"}, delimiter = ':')
    void claimByUserTest(String input, String expected) {
        String[] inputs = input.split(" ");
        Users users = Users.of(inputs[0]);
        LadderMap ladderMap = LadderMap.of(users, 4, () -> true);

        LadderGame ladderGame = LadderGame.of(users, ladderMap);
        int result = ladderGame.claimByUser(inputs[1]);

        assertThat(result).isEqualTo(Integer.parseInt(expected));
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,honux,crong,jk", "pobi,honux,crong", "pobi,honux"})
    void claimAllTest(String input) {
        Users users = Users.of(input);
        LadderMap ladderMap = LadderMap.of(users, 4, () -> true);

        LadderGame ladderGame = LadderGame.of(users, ladderMap);
        Users claimAllUsers = ladderGame.claimAll();

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
